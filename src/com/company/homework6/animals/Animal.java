package com.company.homework6.animals;

public abstract class Animal {
    private static int animalsCount = 0;
    protected String name;
    protected int runningLimit;
    protected int swimmingLimit;

    Animal(int runningLimit, int swimmingLimit) {
        this.runningLimit = runningLimit;
        this.swimmingLimit = swimmingLimit;

        animalsCount++;
    }

    public void run(int difficultyLength) {
        if (difficultyLength <= runningLimit) {
            System.out.printf("бег: пробежал %d м.\n", difficultyLength);
        } else {
            System.out.printf("бег: смог пробежать %d м из %d м.\n", runningLimit, difficultyLength);
        }
    }

    public void swim(int difficultyLength) {
        if (difficultyLength <= swimmingLimit) {
            System.out.printf("плавание: проплыл все %d м.\n", difficultyLength);
        } else {
            System.out.printf("плавание: смог проплыть %d м из %d м.\n", swimmingLimit, difficultyLength);
        }
    }

    public static void consolePrintAnimalCount() {
        System.out.println("Количество созданных объектов класса Animal: " + animalsCount);
    }

    public String getName() {
        return name;
    }
}
