package com.epam.programming_with_classes.simple_objects.student;

/*
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 или 10.

 */
public class Main {

    public static void main(String[] args) {
        StudentHandler studentHandler = new StudentHandler();

        Student[] students = studentHandler.createStudents(100000);

        studentHandler.printGoodStudents(students);
    }


}
