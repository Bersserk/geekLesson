package ru.geekbrains.lesson;/*

Домашнее задание
1.  Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
2.  Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3.  Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4.  Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
5.  ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6.  ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если
    в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
    checkBalance([1, 1, 1, || 2, 1]) → true,
    checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 1, 2, 3, 4]) → true.
    Абстрактная граница показана символами ||, эти символы в массив не входят.
7.  *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен циклически сместить все элементы массива на n позиций.
    [1,2,3,4,5], -2 => [3,4,5,1,2]
    [1,2,3,4,5], 2 => [4,5,1,2,3]
8.  *** Не пользоваться вспомогательным массивом при решении задачи 7.

 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        returnArray (new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0}); // Задача 1;
        arraySize8 (new int[8]);  // Задача 2;
        returnArray2 (new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}); // Задача 3;
        squareArray (8);  // Задача 4;
        arrayMinMax (new int[]{7, 5, 3, 2, 11, 4, 5, 1, 4, 8, 9, 10});  // Задача 5;
        System.out.println (equalityInArray (new int[]{7, 5, 9, 2, 11, 4, 8}));  // Задача 6;
        offsetElemenets (new int[]{1, 2, 3, 4, 5}, 8);  // Задача 7 решена с учетом условия 8;

    }

    private static void returnArray (int [] m){

        for(int i = 0; i < m.length; i++){
            if(m[i] == 1)
                m[i] = 0;
            else
                m[i] = 1;
        }

        System.out.println(Arrays.toString(m));
    }

    private static void arraySize8(int[] ints) {

        for (int i = 0, k = 0; k < ints.length; i += 3, k++){
            ints[k] = i;
        }

        System.out.println(Arrays.toString(ints));
    }

    private static void returnArray2(int[] ints) {

        for (int i = 0; i < ints.length; i++){
            if(ints[i] < 6)
                ints[i] *=2;
        }

        System.out.println(Arrays.toString(ints));
    }

    private static void squareArray(int i) {
        int mas [][] = new int [i][i];
        int t = i-1;

        for(int k = 0; k < i; k++){
            for (int z = 0; z < i; z++){
                if(k == z || t == z){
                    mas[k][z] = 1;
                }
                System.out.print(mas[k][z] + " ");
            }
            t--;
            System.out.println();
        }
    }

    private static void arrayMinMax(int[] ints) {
        int min = ints[0];
        int max = ints[0];
        int indexMin = 0;
        int indexMax = 0;

        for(int i: ints){
            if(ints[i] < min) {
                min = ints[i];
                indexMin = i;
            } else if (ints[i] > max) {
                max = ints[i];
                indexMax = i;
            }
        }

        System.out.println("минимальное значение массива - " + min + ", индекс этого элемента - " + indexMin);
        System.out.println("максимальное значение массива - " + max + ", индекс этого элемента - " + indexMax);
    }

    private static boolean equalityInArray(int[] ints) {
        boolean res = false;
        int sumNumArray = 0;

        for (int i: ints){              // суммируем все элементы массива
            sumNumArray += i;
        }

        if(sumNumArray%2 == 0){         // проверяем сумму числе массива на четность. Если нет, то равности быть не может!
            int i = 0;
            int k = sumNumArray/2;

            while (k > 0){              // Берем половинное значение суммы и отнимаем от него элемент за элементом.
                k = k - ints[i];
                i++;
            }

            if(k == 0)                 // Если приходим к нулю, значит условие true, если уходим в отрицательное значение, false
                res = true;
        }

        return res;
    }

    private static void offsetElemenets (int[] ints, int step) {
        int tmp;
        int i = 0;
        int k = 0;

        int resultStep = step % ints.length;

        if(step > 0) {
            while (i < resultStep) {
                k = ints.length - 1;
                tmp = ints[k];

                while (k > 0) {
                    ints[k] = ints[k - 1];
                    k--;
                }

                ints[0] = tmp;
                i++;
            }

        } else if (step < 0) {
            while (i > resultStep) {
                tmp = ints[k];

                while (k < ints.length - 1) {
                    ints[k] = ints[k + 1];
                    k++;
                }

                ints[ints.length - 1] = tmp;
                i--;
            }
        }

        System.out.println(Arrays.toString(ints));
    }
}
