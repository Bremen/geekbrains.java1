package com.company.homework1;

public class Lesson1 {

//    1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {

//        2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        boolean booleanVar = true;//false
        byte byteVar = 127;//-128
        short shortVar = 32767;//-32768
        int intVar = -2147483648;//2147483647
        long longVar = -9223372036854775808L; //9223372036854775807
        float floatVar = 3.1415926535f;
        double doubleVar = 1.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911374847540880753868917521266338622235369317931800607667263544333890865959395829056383226613199282902678806752087668925017116962070322210432162695486262963;
        char charVar = 'x';
        String stringVar = "Hello, World!";

        //    3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        //    где a, b, c, d – аргументы этого метода, имеющие тип float.
        float result = calculateExpression(1,1,1,0);
        System.out.println(result);

        //    4. Написать метод, принимающий на вход два целых числа и проверяющий,
        //    что их сумма лежит в пределах от 10 до 20 (включительно),
        //    если да – вернуть true, в противном случае – false.
        System.out.println(checkSumFrom10To20(6, 4));
        System.out.println(checkSumFrom10To20(11, 9));
        System.out.println(checkSumFrom10To20(10, 5));
        System.out.println(checkSumFrom10To20(4, 4));
        System.out.println(checkSumFrom10To20(20, 10));

        //    5. Написать метод, которому в качестве параметра передается целое число,
//    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
//    Замечание: ноль считаем положительным числом.
        printWhatNumberSign(-1);
        printWhatNumberSign(0);
        printWhatNumberSign(1);

//    6. Написать метод, которому в качестве параметра передается целое число.
//    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        System.out.println(isNumberNegative(-1));
        System.out.println(isNumberNegative(0));
        System.out.println(isNumberNegative(1));

//    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
//    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
        printGreeting("Андрей");

//    8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println(isYearLeap(2020));
        System.out.println(isYearLeap(2021));
        System.out.println(isYearLeap(2000));
        System.out.println(isYearLeap(2100));
    }

//    3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//    где a, b, c, d – аргументы этого метода, имеющие тип float.
    static private float calculateExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

//    4. Написать метод, принимающий на вход два целых числа и проверяющий,
//    что их сумма лежит в пределах от 10 до 20 (включительно),
//    если да – вернуть true, в противном случае – false.
    static private boolean checkSumFrom10To20(int num1, int num2) {
        int sum = num1 + num2;
        return 10 <= sum && sum <= 20;
    }

//    5. Написать метод, которому в качестве параметра передается целое число,
//    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
//    Замечание: ноль считаем положительным числом.
    static private void printWhatNumberSign(int num) {
        if (num >= 0) {
            System.out.println("Число " + num + " положительное.");
        }else{
            System.out.println("Число " + num + " отрицательное.");
        }
    }

//    6. Написать метод, которому в качестве параметра передается целое число.
//    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    static private boolean isNumberNegative(int num) {
        return num < 0;
    }

//    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
//    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    static private void printGreeting(String name) {
        System.out.println("Привет, " + name + '!');
    }

//    8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static private boolean isYearLeap(int year) {
        return (year % 4 == 0)&&(year % 100 != 0 || year % 400 == 0);
    }
}
