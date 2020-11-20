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
    //private int[][] arr;   // размер игрового поля
    //private int[][] field;

    static int win, win10, win11, win9;


    private int cellWidth;
    private int cellHeight;
    GameLogics gameLogics;

    ShapeXO shapeXO;

    static int[] arrX;  // массив ходов первого игрока
    static int[] arrO;  // массив ходов второго игрока
    private boolean flag = true;

    GameMap() {
        System.out.println("конструктор GameMap");
        setBackground(Color.WHITE);
        gameLogics = new GameLogics();
        GameLogics.board = new int[10][10];
        GameLogics.boardXO = new ShapeXO[10][10];


        arrX = new int[sum(100)];
        arrO = new int[sum(100)];

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                update(e);
            }
        });

        System.out.println("game");


    }

    private void update(MouseEvent e) {
        System.out.println("метод update");

        turnPlayers(turn(DOT_H, e), arrX);
        turnPlayers(turn(DOT_H, e), arrO);


//        turn (DOT_H, e);
//        turn (DOT_H, e);

        for (int i = 0; i < gameLogics.board.length; i++) {
            for (int j = 0; j < gameLogics.board[i].length; j++) {
                System.out.print(gameLogics.board[i][j] + "\t");
            }
            System.out.println();
        }


        repaint();
    }

    public boolean turnPlayers(int turn, int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {  // заполняет ближайшую не занятую ячейку массива
            if (arr[i] == 0) {
                arr[i] = turn;
                break;
            }
        }

        return isWin(sortArr(arr));
    }

    private int turn(boolean dotH, MouseEvent e) {
        System.out.println("метод turnX");
        int cellX;
        int cellY;
        int value;
        DOT_H = dotH;


        do {
            //flag = true;

            if (DOT_H) {
                cellX = e.getX() / cellWidth + 1;
                cellY = e.getY() / cellHeight + 1;

                System.out.println("Чел: \ncellX = " + cellX);
                System.out.println("cellY = " + cellY);
            } else {
                cellX = (int) (Math.random() * (fieldSizeX)) + 1;
                cellY = (int) (Math.random() * (fieldSizeY)) + 1;

                System.out.println("Комп: \ncellX = " + cellX);
                System.out.println("cellY = " + cellY);
            }

            value = cellX * 10 + cellY;


            if (emptyCell(cellX, cellY)) {

                GameLogics.board[cellY - 1][cellX - 1] = value;
                if (DOT_H) {
                    GameLogics.boardXO[cellX-1][cellY-1] = new ShapeXO(cellX-1, cellY-1, cellWidth, cellHeight, RED);
                    DOT_H = false;
                    break;
                } else {
                    GameLogics.boardXO[cellX-1][cellY-1] = new ShapeXO(cellX-1, cellY-1, cellWidth, cellHeight, BLUE);
                    DOT_H = true;
                    break;
                }


            } else {
                if (DOT_H) {
                    //printGameBoard(board);
                    System.out.println("Ячейка занята! Выберите другую...");
                }
                //flag = false;
            }

        } while (true);

        return value;
    }

    public int[] sortArr(int[] _arrTurn) {
        int j;

        for (int i = _arrTurn.length - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (_arrTurn[j] > _arrTurn[j + 1]) {
                    int tmp = _arrTurn[j];
                    _arrTurn[j] = _arrTurn[j + 1];
                    _arrTurn[j + 1] = tmp;
                }
            }
        }
        return _arrTurn;
    }

    public boolean isWin(int[] arr) {

        boolean playerWin = false;
        win = 1;
        win10 = 1;
        win11 = 1;
        win9 = 1;

        for (int i = arr.length - 1; i > 0; i--) {
            win = 1;

            for (int k = i - 1; k >= 0; k--) {

                if (arr[i] - arr[k] == 1) {
                    win++;
                    i--;
                }
            }

            if (win == winLength) {
                playerWin = true;
                break;
            }
        }

        if (playerWin == false) {
            for (int i = arr.length - 1; i > 0; i--) {
                win10 = 1;

                for (int k = i - 1; k >= 0; k--) {

                    if (arr[i] - arr[k] == 10 && arr[k] != 0) {
                        win10++;
                        i--;
                    }
                }

                if (win10 == winLength) {
                    playerWin = true;
                    break;
                }
            }
        }

        if (playerWin == false) {
            for (int i = arr.length - 1; i > 0; i--) {
                win11 = 1;

                for (int k = i - 1; k >= 0; k--) {

                    if (arr[i] - arr[k] == 11 && arr[k] != 0) {
                        win11++;
                        i--;
                    }
                }

                if (win11 == winLength) {
                    playerWin = true;
                    break;
                }
            }
        }

        if (playerWin == false) {
            for (int i = arr.length - 1; i > 0; i--) {
                win9 = 1;

                for (int k = i - 1; k >= 0; k--) {

                    if (arr[i] - arr[k] == 9 && arr[k] != 0) {
                        win9++;
                        i--;
                    }
                }

                if (win9 == winLength) {
                    playerWin = true;
                    break;
                }
            }
        }


        return playerWin;

    }

    public boolean emptyCell(int cellX, int cellY) {
        return GameLogics.board[cellY - 1][cellX - 1] == 0;
    }


    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println("метод startNewGame");

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        //field = new int[fieldSizeY][fieldSizeX];

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
                if (GameLogics.boardXO[i][j] != null)
                    GameLogics.boardXO[i][j].paint(g);
            }
        }
    }

    private static int sum(int sizeBoard) {  // высчитывает максимально возможное кол-во ходов
        int t = 0;
        if (sizeBoard % 2 != 0) {
            t = (3 * 3 + 1) / 2;
        } else {
            t = 3 * 3 / 2;
        }
        return t;
    }
}
