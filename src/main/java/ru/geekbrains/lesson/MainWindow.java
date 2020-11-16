package ru.geekbrains.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;  // задаем стартовый размер окна по ширине
    private static final int WINDOW_HEIGHT = 555;  // задаем стартовый размер окна по высоте
    private static final int WINDOW_POSX = 650;   // задаем начальную координату по Х, расположения нашего окна в окне Windows
    private static final int WINDOW_POSY = 270;   // задаем начальную координату по Y, расположения нашего окна в окне Windows

    private Setting settingWindow;
    private GameMap gameMap;

    MainWindow() {  // конструктор класса
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   // устанавливаем команду на кнопку закрытия окна - закрытие программы
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);   // вызываем метод задающий размер нашего окна по константным значениям
        setLocation(WINDOW_POSX, WINDOW_POSY);   // вызываем метод задающий начальное расположение нашего окна, по константным координатам.
        setTitle("Игра: Крестики-нолики");   // метод, задающий название нашего окна

        settingWindow = new Setting(this);
        gameMap = new GameMap();

        JButton btnStart = new JButton("Create new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });

        JButton btnExitGame = new JButton("<html><body><b>Close</b></body></html>");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExitGame);

        add(panelBottom, BorderLayout.SOUTH);
        add(gameMap);

        setResizable(false);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
        settingWindow.dispose();  // закрываем окно настроек



        setVisible(true);


    }

    public JButton setBut (String t){
        JButton jb = new JButton(t);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(e.getID());


            }
        });
      return jb;
    }

}
