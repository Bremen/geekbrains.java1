package com.company.homework7;

//1. Расширить задачу про котов и тарелки с едой.
//2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного
// количества еды
// (например, в миске 10 еды, а кот пытается покушать 15-20).
//3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
// Если коту удалось покушать
// (хватило еды), сытость = true.
//4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
// то есть не может быть наполовину сыт
// (это сделано для упрощения логики программы).
//5. Создать массив котов и тарелку с едой, попросить всех котов покушать
// из этой тарелки и потом вывести информацию
// о сытости котов в консоль.
//6. Добавить в тарелку метод, с помощью которого можно было бы добавлять
// еду в тарелку.

import com.company.homework7.catsandplates.Cat;
import com.company.homework7.catsandplates.Eatable;
import com.company.homework7.catsandplates.FoodContainable;
import com.company.homework7.catsandplates.Plate;

import java.util.Random;

class HomeWork7 {
    private static int CATS_COUNT = 30;
    private static int PLATE_VOLUME = 50;
    private static Cat[] cats = new Cat[CATS_COUNT];
    private static final Random RND = new Random();
    private static Plate plate = new Plate(PLATE_VOLUME);

    static void demonstrate() {
        initCats();
        feedEaters(cats, plate);
        printHowDidCatsFeed();
    }

    private static void initCats() {
        for (int i = 0; i < CATS_COUNT; i++) {
            String name = "Cat" + (i + 1);
            int appetite = RND.nextInt(Cat.MAX_APPETITE - Cat.MIN_APPETITE) + Cat.MIN_APPETITE;
            cats[i] = new Cat(name, appetite);
        }
    }

    private static void feedEaters(Eatable[] eaters, FoodContainable foodContainer) {
        for (int i = 0; i < eaters.length; i++) {
            Eatable eater = eaters[i];

            if (foodContainer.isNotFoodEnough(eater.getAppetite())) {
                foodContainer.refill();
            }

            if (eater.isHungry()) {
                eater.eat(foodContainer);
            }
        }
    }

    private static void printHowDidCatsFeed() {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        System.out.println();
        System.out.println(plate);
    }
}
