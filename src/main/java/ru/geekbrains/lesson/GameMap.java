package ru.geekbrains.lesson;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMap extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_PADDING = 5;

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
    private int[][]arr;   // размер игрового поля
    private int[][] field;


    private int cellWidth;
    private int cellHeight;
    GameLogics gameLogics;

    GameMap() {
        System.out.println("конструктор GameMap");
        setBackground(Color.WHITE);
        gameLogics = new GameLogics();
        GameLogics.board = new int[3][3];

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

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        System.out.println(cellX);
        System.out.println(cellY);

        if (GameLogics.board[cellY][cellX] == 0) {
            GameLogics.board[cellY][cellX] = (cellX+1) * 10 + (cellY+1);
        }

        for (int i = 0; i < gameLogics.board.length; i++) {
            for (int j = 0; j < gameLogics.board[i].length; j++) {
                System.out.print(gameLogics.board[i][j] + "\t");
            }
            System.out.println();
        }

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

//        if (!initializedMap) {
//            return;
//        }
//        int width = getWidth();
//        int height = getHeight();
//        cellWidth = width / fieldSizeX;
//        cellHeight = height / fieldSizeY;
//        g.setColor(Color.BLACK);
//        for (int i = 0; i < fieldSizeY; i++) {
//            int y = i * cellHeight;
//            g.drawLine(0, y, width, y);
//        }
//
//        for (int i = 0; i < fieldSizeX; i++) {
//            int x = i * cellWidth;
//            g.drawLine(x, 0, x, height);
//        }
//
//        for (int y = 0; y < fieldSizeY; y++) {
//            for (int x = 0; x < fieldSizeX; x++) {
//                if (isEmptyCell(x, y)) {
//                    continue;
//                }
//                if (field[y][x] == DOT_HUMAN) {
//                    g.setColor(new Color(1, 1, 255));
//                    g.fillOval(x * cellWidth + DOT_PADDING,
//                            y * cellHeight + DOT_PADDING,
//                            cellWidth - DOT_PADDING * 2,
//                            cellHeight - DOT_PADDING * 2);
//                } else if (field[y][x] == DOT_AI) {
//                    g.setColor(Color.RED);
//                    g.fillOval(x * cellWidth + DOT_PADDING,
//                            y * cellHeight + DOT_PADDING,
//                            cellWidth - DOT_PADDING * 2,
//                            cellHeight - DOT_PADDING * 2);
//                } else {
//                    throw new RuntimeException(String.format("Can't repaint cell field[%d][%d]: %d", y, x, field[y][x]));
//                }
//            }
//        }
//        if (isGameOver) {
//            showMessageGameOver(g);
//        }



    }

    private void drawGameBoard(Graphics g) {
        System.out.println("метод drawGameBoard");
        int width = getWidth();   // получаем значение ширины нашей панели
        int height = getHeight();   // получаем значение высоты нашей панели

        if(fieldSizeX!=0 && fieldSizeY!=0) {
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

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) {
                    continue;
                }
                if (field[y][x] == DOT_HUMAN) {
                    g.setColor(new Color(1, 1, 255));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == DOT_AI) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException(String.format("Can't repaint cell field[%d][%d]: %d", y, x, field[y][x]));
                }
            }
        }
    }

    public boolean isEmptyCell(int x, int y) {
        System.out.println("метод isEmptyCell");
        return field[y][x] == DOT_EMPTY;
    }
}
