package com.epam.basic_of_oop.text_file;

/*
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить.

 */
public class Main {

    public static void main(String[] args) {

        Directory directory = new Directory("Directory_name", "c://pictures/");
        File file = new File("FleName.txt", directory);
        TextFile text = new TextFile(directory, file, "Content of the file");

        text.renameFile("New name");

        text.printContent();

        text.addContent("Adding content");

        text.printContent();

        text.removeFile();
    }

}
