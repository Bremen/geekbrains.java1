package com.company.homework7.catsandplates;

public interface Eatable {
    int getAppetite();
    boolean isHungry();
    void eat(FoodContainable foodContainer);
}
