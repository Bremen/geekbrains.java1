package com.company.homework7.catsandplates;

public class Cat implements Eatable{
    public static final int MAX_APPETITE = 10;
    public static final int MIN_APPETITE = 1;
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite > MAX_APPETITE ? MAX_APPETITE : appetite;
    }

    @Override
    public int getAppetite() {
        return appetite;
    }

    @Override
    public boolean isHungry() {
        return !satiety;
    }

    @Override
    public void eat(FoodContainable foodContainer) {
        if (foodContainer.isFoodEnough(appetite)) {
            foodContainer.reduceFood(appetite);
            satiety = true;
        }
    }

    @Override
    public String toString() {
        return name + ": satiety - " + satiety + ", appetite - " + appetite;
    }
}