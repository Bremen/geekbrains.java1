package com.company.homework6.animals;

public class Dog extends Animal {
    private static int dogsCount = 0;

    public Dog(int runningLimit, int swimmingLimit) {
        super(runningLimit, swimmingLimit);

        dogsCount++;
        name = "Dog" + dogsCount;
    }

    public static void consolePrintDogsCount() {
        System.out.println("Количество созданных объектов класса Dog: " + dogsCount);
    }
}
