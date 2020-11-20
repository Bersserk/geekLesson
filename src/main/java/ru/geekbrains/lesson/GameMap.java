package ru.geekbrains.lesson;

import org.w3c.dom.ls.LSOutput;

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

    private boolean stopGame = false;

    //int win, win10, win11, win9;


    private int cellWidth;
    private int cellHeight;
    GameLogics gameLogics;

    ShapeXO shapeXO;

    static int[] arrX;  // массив ходов первого игрока
    static int[] arrO;  // массив ходов второго игрока
    private int startPointX;
    private int finishPointX;
    private int startPointY;
    private int finishPointY;


    GameMap() {
        System.out.println("конструктор GameMap");
        setBackground(Color.WHITE);
        gameLogics = new GameLogics();


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (!stopGame)
                    update(e);
            }
        });

        System.out.println("game");


    }

    private void update(MouseEvent e) {
        System.out.println("метод update");
        // if(!stopGame) {
        if (turnPlayers(turn(DOT_H, e), arrX)) {
            System.out.println("Чел выиграл!");
            repaint();
            stopGame = true;
            return;
        } else if (isNobodyWon()) {
            System.out.println("Ничья");
            repaint();
            stopGame = true;
            return;
        } else if (turnPlayers(turn(DOT_H, e), arrO)) {
            System.out.println("Чел выиграл!");
            repaint();
            stopGame = true;
            return;
        } else if (isNobodyWon()) {
            System.out.println("Ничья");
            repaint();
            stopGame = true;
            return;
        }
        //  }


        for (int i = 0; i < gameLogics.board.length; i++) {
            for (int j = 0; j < gameLogics.board[i].length; j++) {
                System.out.print(gameLogics.board[i][j] + "\t");
            }
            System.out.println();
        }

        repaint();
    }

    private static boolean isNobodyWon() {

        boolean nobodyWon = true;

        for (int[] k : GameLogics.board) {
            for (int i : k) {
                if (i == 0)
                    nobodyWon = false;
            }
        }

        return nobodyWon;
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


            if (DOT_H) {
                cellX = e.getX() / cellWidth + 1;
                cellY = e.getY() / cellHeight + 1;

                System.out.println("Чел: \ncellX = " + cellX);
            } else {
                cellX = (int) (Math.random() * (fieldSizeX)) + 1;
                cellY = (int) (Math.random() * (fieldSizeY)) + 1;

                System.out.println("Комп: \ncellX = " + cellX);
            }
            System.out.println("cellY = " + cellY);

            value = cellX * 10 + cellY;


            if (emptyCell(cellX, cellY)) {

                GameLogics.board[cellY - 1][cellX - 1] = value;
                if (DOT_H) {
                    GameLogics.boardXO[cellX - 1][cellY - 1] = new ShapeXO(cellX - 1, cellY - 1, cellWidth, cellHeight, RED);
                    DOT_H = false;
                } else {
                    GameLogics.boardXO[cellX - 1][cellY - 1] = new ShapeXO(cellX - 1, cellY - 1, cellWidth, cellHeight, BLUE);
                    DOT_H = true;
                }
                break;
            } else {
                if (DOT_H) {
                    System.out.println("Ячейка занята! Выберите другую...");
                }
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
        int win = 1;
        int win10 = 1;
        int win11 = 1;
        int win9 = 1;
        int[] winArr = new int[winLength];
        System.out.println("длина временного массива" + winArr.length);

        for (int i = arr.length - 1; i > 0; i--) {
            win = 1;
            winArr[0] = arr[i];
            System.out.println("значение в нулевой ячейке = " + winArr[0]);

            for (int k = i - 1; k >= 0; k--) {

                if (arr[i] - arr[k] == 1) {
                    winArr[win] = arr[k];
                    System.out.println("индекс ячейки = " + win + ", значение = " + winArr[win]);

                    win++;
                    i--;
                }
            }

            if (win == winLength) {
                playerWin = true;
                this.startPointX = winArr[0] / 10;
                this.finishPointX = winArr[winLength - 1] / 10;
                this.startPointY = winArr[0] % 10;
                this.finishPointY = winArr[winLength - 1] % 10;

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

        GameLogics.board = new int[fieldSizeX][fieldSizeY];
        GameLogics.boardXO = new ShapeXO[fieldSizeX][fieldSizeY];


        arrX = new int[sum(fieldSizeX * fieldSizeY)];
        arrO = new int[sum(fieldSizeX * fieldSizeY)];

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

        if (stopGame) {

            g.setColor(Color.BLACK);
            g.drawLine((int) ((startPointX-1) * cellWidth + cellWidth*0.5),
                    (int)((startPointY-1) * cellHeight + cellHeight*0.5 + cellWidth * 0.25),
                    (int)((finishPointX-1) * cellWidth + cellWidth*0.5),
                    (int)((finishPointY-1) * cellHeight + cellHeight*0.5 - cellWidth * 0.25));

            System.out.println("_x1 = " + startPointX);
            System.out.println("_y1 = " + startPointY);
            System.out.println("_x2 = " + finishPointX);
            System.out.println("_y2 = " + finishPointY);

            System.out.println("x1 = " + startPointX * cellWidth);
            System.out.println("y1 = " + startPointY * cellHeight);
            System.out.println("x2 = " + finishPointX * cellWidth);
            System.out.println("y2 = " + finishPointY * cellHeight);

            System.out.println("нарисована победная линия");
        }
    }

    private int sum(int sizeBoard) {  // высчитывает максимально возможное кол-во ходов
        int t = 0;
        if (sizeBoard % 2 != 0) {
            t = (fieldSizeX * fieldSizeY + 1) / 2;
        } else {
            t = fieldSizeX * fieldSizeY / 2;
        }
        return t;
    }
}
