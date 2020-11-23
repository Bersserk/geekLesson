package ru.geekbrains.lesson.controller;

import ru.geekbrains.lesson.view.ViewMainWindow;

public class ControllerSettingWindow {

    boolean gameMode;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    public ControllerSettingWindow(boolean gameMode, int fieldSizeX, int fieldSizeY, int winLength) {

        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;



        System.out.println("конструктор ControllerSettingWindow...");
        System.out.println("gameMode: " + this.gameMode);
        System.out.println("fieldSizeX: " + this.fieldSizeX);
        System.out.println("fieldSizeY: " + this.fieldSizeY);
        System.out.println("winLength: " + this.winLength);
    }

    public boolean isGameMode() {
        return gameMode;
    }

    public void setGameMode(boolean gameMode) {
        this.gameMode = gameMode;
    }

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
