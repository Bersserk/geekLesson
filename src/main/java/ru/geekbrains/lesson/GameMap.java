package ru.geekbrains.lesson;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMap extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private int fieldSizeX;  // размер клеток поля по Х
    private int fieldSizeY;   // размер клеток поля по Y
    private int winLength;   // длина выиграшной линии
    private int[][]arr;   // размер игрового поля

    private int sellWidth;
    private int sellHeight;

    GameMap() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                int cellX = e.getX() / sellWidth;
                int cellY = e.getY() / sellHeight;

                System.out.println("X = " + cellX + "; Y = " + cellY);
            }
        });



    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {

        this.fieldSizeX = fieldSizeX;   //
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        arr = new int[fieldSizeX][fieldSizeY];

        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);

    }

    private void render(Graphics g) {
        g.setColor(Color.BLACK);

        drawGameBoard(g);


    }

    private void drawGameBoard(Graphics g) {
        int width = getWidth();   // получаем значение ширины нашей панели
        int height = getHeight();   // получаем значение высоты нашей панели

        if(fieldSizeX!=0 && fieldSizeY!=0) {
            sellWidth = width / fieldSizeX;
            sellHeight = height / fieldSizeY;
        }

        for (int i = 1; i < fieldSizeX; i++) {
            int y = i * sellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 1; i < fieldSizeY; i++) {
            int x = i * sellWidth;
            g.drawLine(x, 0, x, height);
        }
    }
}
