package ru.geekbrains.lesson;

import ru.geekbrains.lesson.controller.GameController;
import ru.geekbrains.lesson.model.GameModel;
import ru.geekbrains.lesson.view.GameView;
import ru.geekbrains.lesson.view.ViewMainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(gameModel);
        GameView gameView = new GameView(gameController);

        SwingUtilities.invokeLater(() -> {
            ViewMainWindow viewMainWindow = new ViewMainWindow();
        });
    }
}

