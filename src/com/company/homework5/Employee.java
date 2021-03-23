package com.company.homework5;

//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//2. Конструктор класса должен заполнять эти поля при создании объекта.
//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;

    public int getAge() {
        return age;
    }

    private int age;

    Employee(String name, String position, String email, String phoneNumber, float salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Employee:");
        System.out.println("name: " + name);
        System.out.println("position: " + position);
        System.out.println("email: " + email);
        System.out.println("phoneNumber: " + phoneNumber);
        System.out.println("salary: " + salary);
        System.out.println("age: " + age);
    }
}
