package com.company.homework6.animals;

public class Cat extends Animal {
    private static int catsCount = 0;

    public Cat(int runningLimit) {
        super(runningLimit, 0);


        catsCount++;
        name = "Cat" + catsCount;
    }

    @Override
    public void swim(int difficultyLength) {
        System.out.println("плавание: кот не умеет плавать.");
    }

    public static void consolePrintCatsCount() {
        System.out.println("Количество созданных объектов класса Cat: " + catsCount);
    }
}
