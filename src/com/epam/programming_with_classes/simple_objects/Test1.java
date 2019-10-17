package com.epam.programming_with_classes.simple_objects;
/*
Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
наибольшее значение из этих двух переменных.
 */
public class Test1 {
    private int var1;
    private int var2;

    public static void main(String[] args) {

    }
//метод вывода на экран
   public void print() {
        System.out.println(var1);
        System.out.println(var2);
    }
//методы изменения этих переменных
   public void changeVar1(int newVar1) {
        var1 = newVar1;
    }

   public void changeVar2(int newVar2) {
        var2 = newVar2;
    }
//метод, который находит сумму значений этих переменных
   public int findSum() {
        return var1 + var2;
    }
//метод, который находит наибольшее значение из этих двух переменных
   public int findGreatest() {
        return Math.max(var1, var2);
    }
}
