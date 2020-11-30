package ru.geekbrains.lesson.controller;

import ru.geekbrains.lesson.model.GameModel;
import ru.geekbrains.lesson.view.GameView;
import ru.geekbrains.lesson.view.SettingView;
import ru.geekbrains.lesson.view.ViewMainWindow;

public class SettingController {



    private GameView gameView;



    private SettingView settingView;
    ViewMainWindow viewMainWindow;

    private boolean gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;

    public void setGameMode(boolean gameMode) {
        this.gameMode = gameMode;
    }

    public void setFieldSizeX(int fieldSizeX) {
        this.fieldSizeX = fieldSizeX;
    }

    public void setFieldSizeY(int fieldSizeY) {
        this.fieldSizeY = fieldSizeY;
    }

    public void setWinLength(int winLength) {
        this.winLength = winLength;
    }



    public SettingController(ViewMainWindow viewMainWindow) {

        settingView = new SettingView(this, viewMainWindow);

//        this.gameMode = gameMode;
//        this.fieldSizeX = fieldSizeX;
//        this.fieldSizeY = fieldSizeY;
//        this.winLength = winLength;

        System.out.println("конструктор SettingController...");


        //GameModel gameModel = new GameModel(this);
        GameView gameView = new GameView(this, viewMainWindow);
        this.gameView = gameView;
        //GameController gameController = new GameController(gameModel, gameView);

    }

    public SettingView getSettingView() {
        return settingView;
    }

    public GameView getGameView() {
        return gameView;
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
