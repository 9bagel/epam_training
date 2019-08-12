package com.epam.strings_and_basics_of_text_processing.regex.task2;


/*
Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
нельзя.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String xml = "<notes>\n" +
                " <note id = \"1\">\n" +
                " <to>Вася</to>\n" +
                " <from>Света</from>\n" +
                " <heading>Напоминание</heading>\n" +
                " <body>Позвони мне завтра!</body>\n" +
                " </note>\n" +
                " <note id = \"2\">\n" +
                " <to>Петя</to>\n" +
                " <from>Маша</from>\n" +
                " <heading>Важное напоминание</heading>\n" +
                " <body/>\n" +
                " </note>\n" +
                "</notes>";
        System.out.println(xml);

        Pattern pattern = Pattern.compile("" +
                "((?<openTag><[^/>]+?>)(?<body>.+?)(?<close></.+?>))" +
                "|(?<openOnly><[^/>]+?>)" +
                "|(?<closeOnly></.+?>)" +
                "|(?<noBody><.+? />)|");
        Matcher matcher = pattern.matcher(xml);

        while (matcher.find()) {
            if (matcher.group("openTag") != null && matcher.group("close") != null) {
                System.out.println(" Открывающий тег: " + matcher.group("openTag") + "\n тело тега: " + matcher.group("body") + "\n закрывающий тег: " + matcher.group("close"));

            } else if (matcher.group("close") == null && matcher.group("openOnly") != null) {
                System.out.println("Открывающий тег(only): " + matcher.group("openOnly"));
            } else if (matcher.group("openTag") == null && matcher.group("closeOnly") != null) {
                System.out.println("Закрывающий тег: " + matcher.group("closeOnly"));
            } else if (matcher.group("noBody") != null) {
                System.out.println("Tег без тела: " + matcher.group("noBody"));
            }
        }

    }
}

