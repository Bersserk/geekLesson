package ru.geekbrains.lesson;

import javax.swing.*;
import java.awt.*;

class ShapeXO extends JComponent {
    private static final int DOT_PADDING = 5;
    int x;
    int y;
    int cellWidth;
    int cellHeight;



    public ShapeXO(int x, int y, int cellWidth, int cellHeight) {
        //draw();

        this.x = x;
        this.y = y;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
    }

//    void draw(){
//        setColor(Color.BLACK);
//        g.fillOval(x * cellWidth + DOT_PADDING,
//                y * cellHeight + DOT_PADDING,
//                cellWidth - DOT_PADDING * 2,
//                cellHeight - DOT_PADDING * 2);
//    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillOval(x * cellWidth + DOT_PADDING,
                y * cellHeight + DOT_PADDING,
                cellWidth - DOT_PADDING * 2,
                cellHeight - DOT_PADDING * 2);
    }
}
