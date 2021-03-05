package com.company.homework4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char[][] map;
    public static final int SIZE = 4;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);

    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        boolean isNotAiMadeBlockTurn = !blockingAiTurn();

        if (isNotAiMadeBlockTurn) { //если блокировать было нечего, то делаем рандомный ход
            randomAiTurn();
        }
    }

    private static boolean blockingAiTurn() {
        int x, y;
        boolean isWinPossible = false;
        for (y = 0; y < SIZE; y++) {
            for (x = 0; x < SIZE; x++) {
                if (map[y][x] == DOT_EMPTY) {
                    map[y][x] = DOT_X;
                    isWinPossible = checkWin(DOT_X);

                    if (isWinPossible) {
                        makeAiTurn(x, y);
                        y = x = SIZE; // для выхода из двух циклов
                    } else {
                        map[y][x] = DOT_EMPTY;
                    }
                }
            }
        }
        return isWinPossible;
    }

    private static void randomAiTurn() {
        int x;
        int y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        makeAiTurn(x, y);
    }

    private static void makeAiTurn(int x, int y) {
        map[y][x] = DOT_O;
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
    }

    private static boolean isEnoughForWin(int... counters) {
        for (int counter : counters) {
            if (counter >= DOTS_TO_WIN) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkWin(char symb) {
        for (int j = 0; j < SIZE; j++) {

            //счетчик подряд идущих одинаковых символов
            int revDiagUp = 0; // для обратных диагоналей ВЫШЕ центральной обратной
            int revDiagDown = 0; // для центральной обратной и тех, что НИЖЕ нее
            int mainDiagUp = 0; // для главных диагоналей ВЫШЕ центральной главной
            int mainDiagDown = 0; // для центральной главной и тех, что НИЖЕ нее
            int horCount = 0; // для горизонталей
            int verCount = 0; // для верхтикалей

            for (int i = 0; i < SIZE; i++) {
                horCount = (map[j][i] == symb) ? ++horCount : 0;
                verCount = (map[i][j] == symb) ? ++verCount : 0;

                if (j+i < SIZE && SIZE - j >= DOTS_TO_WIN) {
                    mainDiagDown = (map[j+i][i] == symb) ? ++mainDiagDown : 0;
                    revDiagDown = (map[j+i][SIZE-1-j-i] == symb) ? ++revDiagDown : 0;

                    if (j != 0) { //Исключаем дублирование расчета главной диагонали
                        mainDiagUp = (map[i][j+i] == symb) ? ++mainDiagUp : 0;
                        revDiagUp = (map[SIZE-1-j-i][j+i] == symb) ? ++revDiagUp : 0;
                    }
                }

                if (isEnoughForWin(horCount, verCount, mainDiagUp, mainDiagDown, revDiagUp, revDiagDown)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

}
