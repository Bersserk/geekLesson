package ru.geekbrains.lesson.view;

import ru.geekbrains.lesson.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMainWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;  // задаем стартовый размер окна по ширине
    private static final int WINDOW_HEIGHT = 555;  // задаем стартовый размер окна по высоте
    private static final int WINDOW_POSX = 650;   // задаем начальную координату по Х, расположения нашего окна в окне Windows
    private static final int WINDOW_POSY = 270;   // задаем начальную координату по Y, расположения нашего окна в окне Windows

    private SettingView settingView;
    private GameMap gameMap;
    //private ControllerMainWindow controllerMainWindow;
    //private SettingController settingController;

    public ViewMainWindow() {  // конструктор класса
        System.out.println("конструктор ViewMainWindow...");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   // устанавливаем команду на кнопку закрытия окна - закрытие программы
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);   // вызываем метод задающий размер нашего окна по константным значениям
        setLocation(WINDOW_POSX, WINDOW_POSY);   // вызываем метод задающий начальное расположение нашего окна, по константным координатам.
        setTitle("Игра: Крестики-нолики");   // метод, задающий название нашего окна

        //settingController = new SettingController();

        settingView = new SettingView(this);
        //gameMap = new GameMap();

        JButton btnStart = new JButton("Create new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingView.setVisible(true);
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
        //add(gameMap);

        setResizable(false);
        setVisible(true);

    }

//    public void startNewGame() {
//        System.out.println("ViewMainWindow.startNewGame()");
//        //gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
//        //viewSettingWindow.dispose();  // закрываем окно настроек
//        //controllerMainWindow.startGame();
//
//
//
//        //setVisible(true);
//
//
//    }
//
//    public JButton setBut (String t){
//        JButton jb = new JButton(t);
//        jb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                System.out.println(e.getID());
//
//
//            }
//        });
//      return jb;
//    }

}
