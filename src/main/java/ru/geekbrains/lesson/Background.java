package ru.geekbrains.lesson;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel implements Runnable{

    int time;
    GameCanvas gameCanvas;

    public Background(GameCanvas gameCanvas, int time) {
        super();
        this.time = time;
        this.gameCanvas = gameCanvas;
    }

    public void run(){

        while (true) {
            try {
                Thread.sleep(time);
                gameCanvas.setBackground(new Color(
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255)
                ));
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }

}
