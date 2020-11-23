package ru.geekbrains.lesson.view;

import ru.geekbrains.lesson.controller.ControllerSettingWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSetting extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private boolean gameMode = true;
    ///private int fieldSize;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;


    //private ViewMainWindow viewMainWindow;

    private JRadioButton humVSAI;
    private JRadioButton humVSHum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    JButton btnPlay;
    ControllerSettingWindow controllerSettingWindow;


    public ViewSetting(ViewMainWindow viewMainWindow) {
        System.out.println("Конструктор ViewSetting...");

        //this.viewMainWindow = viewMainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = viewMainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Settings new game");
        setLayout(new GridLayout(10, 1));

        addGameModeSetup();
        addFieldMapControl();



        btnPlay = new JButton("Play new game!!");
        add(btnPlay);

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                System.out.println(e.getID());
                //isGameModeSetup();
                //controllerSettingWindow = new ControllerSettingWindow(gameMode, fieldSizeX, fieldSizeY, winLength);
                System.out.println("ViewSetting.actionPerformed...");
                System.out.println("gameMode: " + gameMode);
                System.out.println("fieldSizeX: " + fieldSizeX);
                System.out.println("fieldSizeY: " + fieldSizeY);
                System.out.println("winLength: " + winLength);

                btnPlayGameClick();


                dispose();


            }
        });

        setVisible(false);
    }

    private void addGameModeSetup() {
        add(new JLabel("Choose game mode:"));
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVSHum = new JRadioButton("Human vs. Human");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(humVSAI);
        buttonGroup.add(humVSHum);
        add(humVSAI);
        add(humVSHum);


    }



    private void addFieldMapControl() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });

        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        add(new JLabel("Choose field map size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);


    }

    private void btnPlayGameClick() {


        if(humVSHum.isSelected()){
            gameMode = false;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }

        fieldSizeX = slideFieldSize.getValue();
        fieldSizeY = slideFieldSize.getValue();

        winLength = slideWinLen.getValue();

        controllerSettingWindow = new ControllerSettingWindow(gameMode, fieldSizeX, fieldSizeY, winLength);

    }

}
