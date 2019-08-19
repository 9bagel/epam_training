package com.epam.programming_with_classes.simple_objects;

public class Student {
    private String lastName;
    private int groupNumber;
    private int[] grades = new int[5];

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

        }
    }

    static Student[] createStudents(int count) {
        Student[] students = new Student[count];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }

        return students;
    }

    void printGoodStudents(Student[] students) {
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
