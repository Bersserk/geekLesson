package ru.geekbrains.lesson.view;

import ru.geekbrains.lesson.controller.SettingController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingView extends JFrame {

    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 270;

    private final int MIN_WIN_LENGTH = 3;
    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;
    private final String FIELD_SIZE_PREFIX = "Field size is: ";
    private final String WIN_LENGTH_PREFIX = "Win length is: ";

    private JRadioButton humVSAI;
    private JRadioButton humVSHum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    JButton btnPlay;
    SettingController settingController;

    public SettingView(ViewMainWindow viewMainWindow) {
        System.out.println("Конструктор SettingView...");

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

        boolean gameMode = (humVSHum.isSelected()) ? false: true;

        int fieldSizeX = slideFieldSize.getValue();
        int fieldSizeY = slideFieldSize.getValue();
        int winLength = slideWinLen.getValue();

        settingController = new SettingController(gameMode, fieldSizeX, fieldSizeY, winLength);
    }

}
