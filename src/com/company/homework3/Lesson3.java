package com.company.homework3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        playGames();
    }

    private static void playGames() {
        System.out.println("Привет!");

        // Задание 1.
        guessingNumberGame();

        // Задание 2.
        guessingWordGame();

        System.out.println("Пока!");

        sc.close();
    }

    //    1. Написать программу, которая загадывает случайное число от 0 до 9
//    и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
//    больше ли указанное пользователем число, чем загаданное, или меньше.
//    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    private static void guessingNumberGame() {
        int hiddenBound = 10;
        int attemptsCount = 3;
        int answer;

        System.out.println("Давай сыграем в \"Угадай Число\"!");

        do {
            playOneRound(hiddenBound, attemptsCount);

            System.out.println("Сыграем еще раз? (1 – повторить, 0 – нет)");
            answer = sc.nextInt();
            System.out.println();
        }while(answer != 0);
    }

    private static void playOneRound(int hiddenBound, int attemptsCount) {
        int hiddenNumber = rand.nextInt(hiddenBound);
        boolean isVictory = false;
        System.out.printf("Угадай число от 0 до %d. У тебя %d попыток.\n", hiddenBound-1, attemptsCount);
        for (int attempt = 0; attempt < attemptsCount; attempt++) {
            System.out.printf("Попытка №%d. Введи число: ", attempt+1);
            int number = sc.nextInt();

            if (number == hiddenNumber) {
                isVictory = true;
                break;
            } else if (number > hiddenNumber){
                System.out.println("Твое число больше загаданного.");
            } else {
                System.out.println("Твое число меньше загаданного.");
            }
        }

        if (isVictory) {
            System.out.println("Победа! Ты молодец!");
        } else {
            System.out.printf("Проигрыш! Загаданное число %d. В следующий раз обязательно получится!\n\n", hiddenNumber);
        }
    }


    //    2. * Создать массив из слов
//    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
//    "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
//    "pepper", "pineapple", "pumpkin", "potato"}.
//    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//    сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
//    Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
//    apple – загаданное
//    apricot - ответ игрока
//    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//    Для сравнения двух слов посимвольно можно пользоваться:
//    String str = "apple";
//    char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
//    Играем до тех пор, пока игрок не отгадает слово.
//    Используем только маленькие буквы.
    private static void guessingWordGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String hiddenWord = words[rand.nextInt(words.length)];
        StringBuffer gameLine = new StringBuffer("###############");

        String answer;



        System.out.println("Давай сыграем в \"Угадай слово\"!");

        do {
            System.out.println(gameLine);
            answer = sc.next();

            for (int i = 0; i < hiddenWord.length() && i < answer.length(); i++) {
                if (gameLine.charAt(i) == '#' && answer.charAt(i) == hiddenWord.charAt(i)) {
                    gameLine.replace(i,i+1, hiddenWord.substring(i,i+1));
                }
            }
        } while (!hiddenWord.equals(answer));

        System.out.println("Победа! Ты молодец!");

        System.out.println();
    }
}
