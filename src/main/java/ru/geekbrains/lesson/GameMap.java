package ru.geekbrains.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

public class GameMap extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_PADDING = 5;
    private static boolean DOT_H = true;


    private int stateGameOver;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private int fieldSizeX;  // размер клеток поля по Х
    private int fieldSizeY;   // размер клеток поля по Y
    private int winLength;   // длина выиграшной линии
    private int[][] arr;   // размер игрового поля
    private int[][] field;


    private int cellWidth;
    private int cellHeight;
    GameLogics gameLogics;

    ShapeXO shapeXO;

    static int[] arrX;  // массив ходов первого игрока
    static int[] arrO;  // массив ходов второго игрока

    GameMap() {
        System.out.println("конструктор GameMap");
        setBackground(Color.WHITE);
        gameLogics = new GameLogics();
        GameLogics.board = new int[3][3];
        GameLogics.boardXO = new ShapeXO[3][3];


        arrX = new int[sum(9)];
        arrO = new int[sum(9)];

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                update(e);
            }
        });


    }

    private void update(MouseEvent e) {
        System.out.println("метод update");
        int cellX;
        int cellY;

        if (DOT_H) {
            cellX = e.getX() / cellWidth;
            cellY = e.getY() / cellHeight;
        } else {
//            cellX = 1;  // сюда вписать рандом от Пк
//            cellY = 1;  // сюда вписать рандом от ПК

            cellX = e.getX() / cellWidth;
            cellY = e.getY() / cellHeight;
        }

//        System.out.println(cellX);
//        System.out.println(cellY);

        int value = (cellX + 1) * 10 + (cellY + 1);

        if (GameLogics.board[cellY][cellX] == 0) {
            GameLogics.board[cellY][cellX] = value;
            if (DOT_H) {
                GameLogics.boardXO[cellY][cellX] = new ShapeXO(cellX, cellY, cellWidth, cellHeight, RED);
                DOT_H = false;
            } else {
                GameLogics.boardXO[cellY][cellX] = new ShapeXO(cellX, cellY, cellWidth, cellHeight, BLUE);
                DOT_H = true;
            }
        }

        for (int i = 0; i < gameLogics.board.length; i++) {
            for (int j = 0; j < gameLogics.board[i].length; j++) {
                System.out.print(gameLogics.board[i][j] + "\t");
            }
            System.out.println();
        }


        repaint();


    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println("метод startNewGame");

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeY][fieldSizeX];

        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("метод paintComponent");
        super.paintComponent(g);
        render(g);

    }

    private void render(Graphics g) {
        System.out.println("метод render");
        g.setColor(Color.BLACK);

        drawGameBoard(g);
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

        for (int i = 0; i < GameLogics.boardXO.length; i++) {
            for (int j = 0; j < GameLogics.boardXO.length; j++) {
                //System.out.println("объект" + shapeXO);
                if (GameLogics.boardXO[i][j] != null)
                    GameLogics.boardXO[i][j].paint(g);
                //new ShapeXO(1,1,cellWidth,cellHeight).paint(g);
            }
        }

//                int y;
//                int x;
//
//
//                if (DOT_H) {
//
//                    for (int i = 0; i < arrX.length; i++) {
//                        if(arrX[i] != 0){
//                            x = arrX[i]/10 - 1;
//                            y = arrX[i]%10 - 1;
//                            g.setColor(new Color(1, 1, 255));
//                            g.fillOval(x * cellWidth + DOT_PADDING,
//                                    y * cellHeight + DOT_PADDING,
//                                    cellWidth - DOT_PADDING * 2,
//                                    cellHeight - DOT_PADDING * 2);
//                            DOT_H = false;
//                        }
//                    }
//                } else if (DOT_H == false) {
//                    for (int i = 0; i < arrO.length; i++) {
//                        if(arrO[i] != 0){
//                            x = arrO[i]/10-1;
//                            y = arrO[i]%10-1;
//                            g.setColor(Color.RED);
//                            g.fillOval(x * cellWidth + DOT_PADDING,
//                                    y * cellHeight + DOT_PADDING,
//                                    cellWidth - DOT_PADDING * 2,
//                                    cellHeight - DOT_PADDING * 2);
//                            DOT_H = true;
//                        }
//                    }
//                } else {
//                   // throw new RuntimeException(String.format("Can't repaint cell field[%d][%d]: %d", y, x, field[y][x]));
//                }


    }

    public boolean isEmptyCell(int x, int y) {
        //System.out.println("метод isEmptyCell");
        return field[y][x] == DOT_EMPTY;
    }

    private static int sum(int sizeBoard) {  // высчитывает максимально возможное кол-во ходов
        int t = 0;
        if (sizeBoard % 2 != 0) {
            t = (sizeBoard * sizeBoard + 1) / 2;
        } else {
            t = sizeBoard * sizeBoard / 2;
        }
        return t;
    }
}
