package ru.geekbrains.lesson.model;

import ru.geekbrains.lesson.controller.SettingController;

public class GameModel {

    SettingController settingController;

    public GameModel(SettingController settingController) {
        System.out.println("конструктор GameModel...");

        this.settingController = settingController;

        System.out.println("gameMode: " + settingController.isGameMode());
        System.out.println("fieldSizeX: " + settingController.getFieldSizeX());
        System.out.println("fieldSizeY: " + settingController.getFieldSizeY());
        System.out.println("winLength: " + settingController.getWinLength());
    }
}
