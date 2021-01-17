package ru.geekbrains.lesson.task_1_2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String [] str = {"a", "b", "c"};

        // task 1
        System.out.println("Замена элементов массива без дженериков");
        System.out.println("первый элемент в массиве, до изменений = " + str[0]);
        replacementElements(str, 0, 2);
        System.out.println("первый элемент в массиве, после изменений = " + str[0]);

        System.out.println("Замена элементов массива с использованием дженериков");
        System.out.println("первый элемент в массиве, до изменений = " + str[0]);
        replacementElementsViaGenerics(str, 0, 2);
        System.out.println("первый элемент в массиве, после изменений = " + str[0]);

        // task 2
        System.out.println("массив до преобразования: " + str.getClass().getSimpleName());
        ArrayList arrayList = arrayToArrayList(str);
        System.out.println("массив после преобразования: " + arrayList.getClass().getSimpleName());

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

    public static ArrayList arrayToArrayList (Object [] array){
        ArrayList arrayList = new ArrayList();
        arrayList.toArray(array);
        return arrayList;
    }
}
