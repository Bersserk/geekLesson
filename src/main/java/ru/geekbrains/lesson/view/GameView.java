package ru.geekbrains.lesson.view;

import ru.geekbrains.lesson.GameLogics;

import ru.geekbrains.lesson.controller.SettingController;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private boolean gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;

    int width = 500;
    int height = 500;

    int cellWidth;
    int cellHeight;

    public GameView(SettingController settingController, ViewMainWindow viewMainWindow) {
        System.out.println("конструктор GameView...");

        this.gameMode = settingController.isGameMode();
        this.fieldSizeX = settingController.getFieldSizeX();
        this.fieldSizeY = settingController.getFieldSizeY();
        this.winLength = settingController.getWinLength();
    }


    public void startNewGame() {
        System.out.println("метод startNewGame");
//
//        GameLogics.board = new int[fieldSizeX][fieldSizeY];
//        GameLogics.boardXO = new ShapeXO[fieldSizeX][fieldSizeY];
//
//
//        arrX = new int[sum(fieldSizeX * fieldSizeY)];
//        arrO = new int[sum(fieldSizeX * fieldSizeY)];

        int width = 500;
        int height = 500;

        repaint();
    }



    private void drawGameBoard(Graphics g) {
        System.out.println("метод drawGameBoard");
        int width = getWidth();   // получаем значение ширины нашей панели
        int height = getHeight();   // получаем значение высоты нашей панели

        if (fieldSizeX != 0 && fieldSizeY != 0) {
            cellWidth = width / fieldSizeX;
            cellHeight = height / fieldSizeY;
        }

        for (int i = 1; i < fieldSizeX; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 1; i < fieldSizeY; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

//        for (int i = 0; i < GameLogics.boardXO.length; i++) {
//            for (int j = 0; j < GameLogics.boardXO.length; j++) {
//                if (GameLogics.boardXO[i][j] != null)
//                    GameLogics.boardXO[i][j].paint(g);
//            }
//        }

//        if (stopGame) {
//
//            g.setColor(Color.BLACK);
//            g.drawLine((int) ((startPointX - 1) * cellWidth + cellWidth * 0.5),
//                    (int) ((startPointY - 1) * cellHeight + cellHeight * 0.5 + cellWidth * 0.25),
//                    (int) ((finishPointX - 1) * cellWidth + cellWidth * 0.5),
//                    (int) ((finishPointY - 1) * cellHeight + cellHeight * 0.5 - cellWidth * 0.25));
//
//            System.out.println("_x1 = " + startPointX);
//            System.out.println("_y1 = " + startPointY);
//            System.out.println("_x2 = " + finishPointX);
//            System.out.println("_y2 = " + finishPointY);
//
//            System.out.println("x1 = " + startPointX * cellWidth);
//            System.out.println("y1 = " + startPointY * cellHeight);
//            System.out.println("x2 = " + finishPointX * cellWidth);
//            System.out.println("y2 = " + finishPointY * cellHeight);
//
//            System.out.println("нарисована победная линия");
//        }
    }
}
