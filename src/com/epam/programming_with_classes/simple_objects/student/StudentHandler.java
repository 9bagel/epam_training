package com.epam.programming_with_classes.simple_objects.student;

import java.util.Random;

public class StudentHandler {

    public Student[] createStudents(int count) {

        Student[] students = new Student[count];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();

            setRandomMarks(students[i]);
        }

        return students;
    }

    public void setRandomMarks(Student student) {
        int[] grades = student.getGrades();
        for (int i = 0; i < grades.length; i++) {
            grades[i] = new Random().nextInt(10);
        }
    }

    public void printGoodStudents(Student[] students) {
        // Перебираем студентов
        for (Student student : students) {

            boolean isGood = true;
            //Перебираем оценки
            for (int grade : student.getGrades()) {

                if (grade < 9) {
                    isGood = false;
                }
            }
            //Если оценки не ниже 9, то печатаем фамилию + номер группы
            if (isGood) {
                System.out.println(student.getLastName() + " из группы " + student.getGroupNumber());

            }
        }

    }
}
