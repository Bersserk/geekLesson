package ru.geekbrains.lesson;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String [] str = {"a", "b", "c"};

        System.out.println("Замена элементов массива без дженериков");
        System.out.println("первый элемент в массиве, до изменений = " + str[0]);
        replacementElements(str, 0, 2);
        System.out.println("первый элемент в массиве, после изменений = " + str[0]);

        System.out.println("Замена элементов массива с использованием дженериков");
        System.out.println("первый элемент в массиве, до изменений = " + str[0]);
        replacementElementsViaGenerics(str, 0, 2);
        System.out.println("первый элемент в массиве, после изменений = " + str[0]);


    }

    public static Object [] replacementElements (Object [] arrays, int elementOne, int elementTwo){

        Object tmp = arrays[elementOne];
        arrays[elementOne] = arrays[elementTwo];
        arrays[elementTwo] = tmp;
        return arrays;
    }

    public static <T> T[] replacementElementsViaGenerics (T [] arrays, int elementOne, int elementTwo){

        T tmp = arrays[elementOne];
        arrays[elementOne] = arrays[elementTwo];
        arrays[elementTwo] = tmp;
        return arrays;
    }
}
