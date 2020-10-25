package ru.geekbrains.lesson;

public class Main {
    byte b = 1;
    short s = 2;
    int i = 3;
    long l = 4L;

    float f = 1.0f;
    double d = 2.0;

    char c = 'c';
    boolean bol = true;

    String str = "text";

    public static void main(String[] args) {
        System.out.println("вернули результат = " + returnNumber(1.2f, 2.4f, 3.6f, 4.8f));
        System.out.println("вернули результат = " + returnSum(5, 5));
        System.out.println("число: " + positiveOrNegativeNumber(-5));
        System.out.println("число положительное??? - " + trueOrFalse(15));
        System.out.println("Hello, " + name("Oleg") + "!");
        year(2020);
        year(2021);
        backNumber(834);
    }

    public static float returnNumber (float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    public static boolean returnSum(int a, int b) {
        return ((a + b) > 9 && (a + b) < 21);
    }

    public static String positiveOrNegativeNumber (int i) {
        return i >= 0 ? "положительное" : "отрицательное";
    }

    public static boolean trueOrFalse(int a) {
        return (a >= 0);
    }

    public static void backNumber (int a) {
        if(a > 99 && a < 1000) {
            int b = a / 100;
            int c = (a - b*100)/10;
            int d = a - b*100 - c*10;

            System.out.println("Число " + a + " в обратном чтении: " + (d*100+c*10+b));
        }
    }

    public static String name (String s) {
        return s;
    }

    public static void year (int a){
        if(a%400 == 0 || a%4 == 0 && a%100 != 0)
            System.out.println("год " + a + " является высокосным!");
        else
            System.out.println("год " + a + " является невысокосным!");
    }
}
