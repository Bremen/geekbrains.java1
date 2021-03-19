package com.company.homework7.catsandplates;

public interface FoodContainable {
    void reduceFood(int food);
    boolean isFoodEnough(int food);
    void refill();
}
