package com.company.homework5;

public class HomeWork5 {
    private static final int EMPLOYEE_COUNT = 5;
    private static final int AGE_THRESHOLD = 40;

    public static void createEmployeeArrayAndPrintEmploeeInfoWhoOlderAgeThreshold() {
        Employee[] employees = new Employee[EMPLOYEE_COUNT];

        employees[0] = new Employee("Karl", "SEO", "karlthebest@gb.com", "77-77", 1_000_000, 48);
        employees[1] = new Employee("Mark", "Teamlead", "mark@gb.com", "77-76", 600_000, 42);
        employees[2] = new Employee("Stive", "Senior", "stive@gb.com", "77-75", 450_000, 40);
        employees[3] = new Employee("Lary", "Middle", "lary@gb.com", "77-74", 300_000, 30);
        employees[4] = new Employee("Bill", "Junior", "bill@gb.com", "77-73", 100_000, 20);

        for (Employee employee : employees) {
            if (employee.getAge() > AGE_THRESHOLD) {
                employee.printInfo();
                System.out.println();
            }
        }
    }
}

//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//        2. Конструктор класса должен заполнять эти поля при создании объекта.
//        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//        4. Создать массив из 5 сотрудников.
//        Пример:
//        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
// потом для каждой ячейки массива задаем объект
//        persArray[1] = new Person(...);
//        ...
//        persArray[4] = new Person(...);
//
//        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.