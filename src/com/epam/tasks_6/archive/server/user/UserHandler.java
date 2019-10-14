package com.epam.tasks_6.archive.server.user;

import javax.xml.stream.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserHandler {

    private static UserHandler instance = new UserHandler();
    private String fileName = "src\\com\\epam\\tasks_6\\archive\\server\\data\\Users.xml";
    private List<User> userList = new ArrayList<>();

    /**
     * Map of usernames to their password hashes.
     */
    public static UserHandler getInstance() throws IOException, XMLStreamException {
        instance.readUserData();
        return instance;
    }

    // This class is a singleton. Call getInstance() instead.
    private UserHandler() {
    }

    //Читаем данные пользователей и заполняем данными userList
    private void readUserData() throws IOException, XMLStreamException {
        String userName;
        int passwordHash;
        boolean isAdmin;

        File file = new File(fileName);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(new FileInputStream(file));

        while (parser.hasNext()) {
            int event = parser.next();

            if (event == XMLStreamConstants.START_ELEMENT) {
                if ("user".equals(parser.getLocalName())) {
                    userName = parser.getAttributeValue(0);
                    passwordHash = Integer.parseInt(parser.getAttributeValue(1));
                    isAdmin = Boolean.parseBoolean(parser.getAttributeValue(2));

                    userList.add(new User(userName, passwordHash, isAdmin));
                }
            }

        }
    }

    public void writeUserData() throws FileNotFoundException, XMLStreamException {

        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileOutputStream(fileName, false));

        writer.writeStartDocument();
        writer.writeCharacters("\n");

        writer.writeStartElement("users");

        for (User user : userList) {
            writer.writeCharacters("\n");
            writer.writeEmptyElement("user");

            writer.writeAttribute("userName", user.getUserName());
            writer.writeAttribute("passwordHash", String.valueOf(user.getPasswordHash()));
            writer.writeAttribute("isAdmin", String.valueOf(user.isAdmin()));
        }

        writer.writeCharacters("\n");
        writer.writeEndDocument();
    }

    public boolean isUsernameTaken(String username) {
        for (User user : userList) {

            if (user.getUserName().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public User registerUser(String userName, String password, boolean isAdmin) throws FileNotFoundException, XMLStreamException {
        int passwordHash = getSimpleHash(password);
        User user = new User(userName, passwordHash, isAdmin);

        userList.add(user);
        writeUserData();
        return user;
    }

    public User isLoginCorrect(String username, String password) {

        // username isn't registered
        User tmpUser = null;
        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                tmpUser = user;
            }
        }
        if (tmpUser == null) {
            return null;
        }

        int passwordHash = getSimpleHash(password);
        int storedPasswordHash = tmpUser.getPasswordHash();

        if (passwordHash == storedPasswordHash) {
            return tmpUser;

        } else return null;
    }

    private int getSimpleHash(String password) {
        return password.hashCode();
    }
}
