package com.epam.basic_of_oop.text_file;

/*
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить.

 */
public class TextFile {
    private Directory directory;
    private File file;
    private String content;

    //Конструктор, в качестве метода для создания файла
    TextFile(Directory directory, File file, String content) {
        this.directory = directory;
        this.file = file;
        this.content = content;
    }

    //Метод для переименования
    void renameFile(String newName) {
        file.setName(newName);
    }

    //Вывести на консоль содержимое
    void printContent() {
        System.out.println(content);
    }

    //Дополнить содержимое (можно поменять на StringBuilder, если будет часто использоваться)
    void addContent(String content) {
        this.content += " " + content;
    }

    //Удалить файл
    void removeFile() {
        directory = null;
        file = null;
        content = null;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
