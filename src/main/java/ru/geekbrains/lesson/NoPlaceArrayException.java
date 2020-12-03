package ru.geekbrains.lesson;

public class NoPlaceArrayException extends Exception {

    public NoPlaceArrayException() {
        super();
    }

    public void setMessage(String s) {
        System.out.println("Значение " + s + " не помещается в массив и в расчете учтено не будет");
    }
}
