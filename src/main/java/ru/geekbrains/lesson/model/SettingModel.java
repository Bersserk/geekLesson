package ru.geekbrains.lesson.model;

public class SettingModel {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private int fieldSizeX;  // размер клеток поля по Х
    private int fieldSizeY;   // размер клеток поля по Y
    private int winLength;   // длина выиграшной линии

    public int getFieldSizeX() {
        return fieldSizeX;
    }

    public void setFieldSizeX(int fieldSizeX) {
        this.fieldSizeX = fieldSizeX;
    }

    public int getFieldSizeY() {
        return fieldSizeY;
    }

    public void setFieldSizeY(int fieldSizeY) {
        this.fieldSizeY = fieldSizeY;
    }

    public int getWinLength() {
        return winLength;
    }

    public void setWinLength(int winLength) {
        this.winLength = winLength;
    }
}
