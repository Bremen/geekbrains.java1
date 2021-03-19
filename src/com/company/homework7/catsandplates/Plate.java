package com.company.homework7.catsandplates;

public class Plate implements FoodContainable{
    private final int VOLUME;
    private int food;

    public Plate(int volume, int food) {
        VOLUME = volume;
        this.food = food;
    }

    public Plate(int volume) {
        VOLUME = volume;
        this.food = volume;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    @Override
    public void reduceFood(int neededFood) {
        if (isFoodEnough(neededFood)) {
            food -= neededFood;
        } else {
            food = 0;
        }
    }

    @Override
    public boolean isFoodEnough(int neededFood) {
        return this.food <= neededFood;
    }

    @Override
    public void refill() {
        food = VOLUME;
    }
}
