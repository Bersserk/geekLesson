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

    public int getFieldSizeX() {
        return fieldSizeX;
    }

    public int getFieldSizeY() {
        return fieldSizeY;
    }

    public int getWinLength() {
        return winLength;
    }
}
