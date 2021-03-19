package com.company.homework6;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать,
// собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.

import com.company.homework6.animals.*;

import java.util.Random;

public class HomeWork6 {
    private static final Random RAND = new Random();
    private static final int ANIMALS_COUNT = 10;
    private static Animal[] animals = new Animal[ANIMALS_COUNT];

    enum AnimalType {
        CAT,
        DOG;

        public static AnimalType getRandom() {
            int x = RAND.nextInt(values().length);
            return values()[x];
        }
    }

    public static void demonstrate() {
        fillArrayWithRandomAnimals();
        testingAnimalsWithRandomDifficulties();
        consolePrintAnimalCountAllAndByTypes();
    }

    private static void fillArrayWithRandomAnimals() {
        for (int i = 0; i < ANIMALS_COUNT; i++) {
            int swimLimit = RAND.nextInt(10) * 10 + 10;
            int runLimit = RAND.nextInt(10) * 10 + 10;

            animals[i] = createRandomTypeAnimal(swimLimit, runLimit);
        }
    }

    private static void testingAnimalsWithRandomDifficulties() {
        for (Animal animal : animals) {
            int swimDifficulty = RAND.nextInt(10) * 10;
            int runDifficulty = RAND.nextInt(10) * 10;

            System.out.println(animal.getName() + ":");
            animal.run(runDifficulty);
            animal.swim(swimDifficulty);

            System.out.println();
        }

        System.out.println();
    }

    private static void consolePrintAnimalCountAllAndByTypes() {
        Animal.consolePrintAnimalCount();
        Cat.consolePrintCatsCount();
        Dog.consolePrintDogsCount();
    }

    private static Animal createRandomTypeAnimal(int swimLimit, int runLimit) {
        Animal animal = null;

        AnimalType animalType = AnimalType.getRandom();

        switch (animalType) {
            case CAT:
                animal = new Cat(runLimit);
                break;
            case DOG:
                animal = new Dog(runLimit, swimLimit);
        }

        return animal;
    }
}
