package com.company.homework2;

public class Lesson2 {
    public static void main(String[] args) {
//    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Задание 1.");
        System.out.print("Входной массив:  ");
        printArray(arr1);
        System.out.print("Выходной массив: ");
        printArray(inverseArray(arr1));
        System.out.println();
        System.out.println();

//    2. Задать пустой целочисленный массив размером 8.
//    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание 2.");
        System.out.print("Арифметическая прогрессия: ");
        printArray(arithmeticProgressionArray(8, 3, 0));
        System.out.println();
        System.out.println();

//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//    пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание 3.");
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.print("Входной массив:  ");
        printArray(arr3);
        System.out.print("Выходной массив: ");
        printArray(multiplySmallerElements(arr3, 6, 2));
        System.out.println();
        System.out.println();

//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание 4.");
        int squareMatrixSize = 5;
        int[][] squareMatrix = identityDiagonalsMatrix(squareMatrixSize);
        for (int i = 0; i < squareMatrixSize; i++) {
            printArray(squareMatrix[i]);
        }
        System.out.println();
        System.out.println();

//    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("Задание 5.");
        int[] arr5 = { -1, -5, -3, -2, -11, -4, -5, -2, -4, -8, -9, -1 };
        System.out.print("Входной массив:  ");
        printArray(arr5);
        printMinAndMaxElements(arr5);
        System.out.println();
        System.out.println();

//    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
//    части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
//    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        System.out.println("Задание 6.");
        int[] arr6_1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arr6_2 = {1, 1};

        System.out.print("Входной массив 1:  ");
        printArray(arr6_1);
        System.out.println("Есть ли баланс? " + (checkBalance(arr6_1) ? "да" : "нет"));

        System.out.println();

        System.out.print("Входной массив 2:  ");
        printArray(arr6_2);
        System.out.println("Есть ли баланс? " + (checkBalance(arr6_2) ? "да" : "нет"));

        System.out.println();
        System.out.println();

//    7. **** Написать метод, которому на вход подается одномерный массив и число n
//    (может быть положительным, или отрицательным), при этом метод должен сместить
//    все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
//    задачи нельзя пользоваться вспомогательными массивами.
//    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
//    [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//    При каком n в какую сторону сдвиг можете выбирать сами.
        System.out.println("Задание 7.");
        int[] arr7_1 = { 1, 2, 3, 4, 5, 6};
        int shift_1 = -2;

        int[] arr7_2 = {3, 5, 6, 1};
        int shift_2 = 1;

        System.out.print("Входной массив 1:  ");
        printArray(arr7_1);
        System.out.print("Сдвиг: " + shift_1 + ". ");
        System.out.print("Сдвинутый массив 1:  ");
        printArray(shiftElements(arr7_1, shift_1));

        System.out.println();

        System.out.print("Входной массив 2:  ");
        printArray(arr7_2);
        System.out.print("Сдвиг: " + shift_2 + ". ");
        System.out.print("Сдвинутый массив 2:  " + ". ");
        printArray(shiftElements(arr7_2, shift_2));

        int x = 0;
        x -=- 1;
        System.out.println(x);
    }
    
    private static void printArray(int[] arr) {
        System.out.print('[');
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(']');
    }

//    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static int[] inverseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }


//    2. Задать пустой целочисленный массив размером 8.
//    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static int[] arithmeticProgressionArray(int arrSize, int progressStep, int firstElement) {
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = firstElement + i * progressStep;
        }

        return arr;
    }

//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//    пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static int[] multiplySmallerElements(int[] arr, int bar, int multiplier) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < bar) {
                arr[i] *= multiplier;
            }
        }
        return arr;
    }

//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    private static int[][] identityDiagonalsMatrix(int size) {
        int[][] identityMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                identityMatrix[i][j] = (i == j || (size - 1 - i == j)) ? 1 : 0;
            }
        }

        return identityMatrix;
    }

//    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    private static void printMinAndMaxElements(int[] arr) {
        int iMax = 0;
        int iMin = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[iMax]) {
                iMax = i;
            }

            if (arr[i] < arr[iMin]) {
                iMin = i;
            }
        }

        System.out.println("Минимальный элемент массива:  " + arr[iMin] + " индекс: " + iMin);
        System.out.println("Максимальный элемент массива: " + arr[iMax] + " индекс: " + iMax);
    }

//    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
//    части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
//    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    private static boolean checkBalance(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean isHasBalance = false;
        int sumHalf = 0;
        for (int i = 0; i < arr.length && sum/2 > sumHalf; i++) {
            sumHalf += arr[i];

            if (sum/2 == sumHalf) {
                isHasBalance = true;
                printBalancedArray(arr, i);
                break;
            }
        }

        return isHasBalance;
    }

    private static void printBalancedArray(int[] arr, int iBalance) {
        System.out.print("Сбалансированный массив: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
            if (i == iBalance) {
                System.out.print("|| ");
            }
        }
        System.out.println(']');
    }

//    7. **** Написать метод, которому на вход подается одномерный массив и число n
//    (может быть положительным, или отрицательным), при этом метод должен сместить
//    все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
//    задачи нельзя пользоваться вспомогательными массивами.
//    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
//    при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    private static int[] shiftElements(int[] arr, int shift) {
        int size = arr.length;

        //Убираем все полные сдвиги
        shift %= size;

        //Если сдвига нет, то возвращаем исходный массив
        if (shift == 0) {
            return arr;
        }

        //Если сдвига влево, то делаем равносильный вправо
        if (shift < 0) {
            shift = size + shift; //складываем потому shift отрицательный
        }

        int iStart = 0;
        int shiftElement = arr[iStart];
        int buf;
        for (int i = 0; i < size; i++) {
            int iShift = (iStart + i*shift) % size;

            //Учитываем случай если сдвиг кратен размеру массива
            if (iStart == iShift) {
                arr[iStart] = shiftElement;
                iStart++;
                shiftElement = arr[iStart];
                iShift = (iStart + i*shift) % size;
            }

            buf = arr[iShift];
            arr[iShift] = shiftElement;
            shiftElement = buf;
        }
        arr[iStart] = shiftElement;

        return arr;
    }
}
