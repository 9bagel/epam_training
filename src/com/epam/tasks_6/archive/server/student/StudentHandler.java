package com.epam.tasks_6.archive.server.student;

import com.epam.tasks_6.archive.server.console.Console;

import javax.xml.stream.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHandler {
    private static StudentHandler instance = new StudentHandler();
    private List<Student> students = new ArrayList<>();
    private Console console = Console.getInstance();
    private String fileName = "src\\com\\epam\\tasks_6\\archive\\server\\data\\Students.xml";

    public static StudentHandler getInstance() {
        try {
            instance.readStudentsData();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addNewStudent(Student student) throws FileNotFoundException, XMLStreamException {
        students.add(student);
        writeStudentsData();
    }

    public void showAllStudents() throws IOException {
        for (Student student : students) {
            console.sendCommand(student.toString());
        }
    }

    public Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    private void readStudentsData() throws IOException, XMLStreamException {
        String name;
        int averageMark;

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
                if ("student".equals(parser.getLocalName())) {
                    name = parser.getAttributeValue(0);
                    averageMark = Integer.parseInt(parser.getAttributeValue(1));

                    students.add(new Student(name, averageMark));
                }
            }

        }
    }

    private void writeStudentsData() throws FileNotFoundException, XMLStreamException {

        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileOutputStream(fileName, false));

        writer.writeStartDocument();
        writer.writeCharacters("\n");

        writer.writeStartElement("students");

        for (Student student : students) {
            writer.writeCharacters("\n");
            writer.writeEmptyElement("student");

            writer.writeAttribute("name", student.getName());
            writer.writeAttribute("averageMark", String.valueOf(student.getAverageMark()));
        }

        writer.writeCharacters("\n");
        writer.writeEndDocument();
    }

    public void editStudent() throws IOException, XMLStreamException {

        String name = console.sendCommandWithResponse("Type student name");
        Student student = findStudent(name);

        if (student != null) {
            console.sendCommand("Student found:");
            console.sendCommand(student.toString());

            String newName = console.sendCommandWithResponse("Type new name");
            int newAvgMark = Integer.parseInt(console.sendCommandWithResponse("Type new average mark"));

            student.setName(newName);
            student.setAverageMark(newAvgMark);

        } else console.sendCommand("Student  didn't found");

        writeStudentsData();
    }

}
