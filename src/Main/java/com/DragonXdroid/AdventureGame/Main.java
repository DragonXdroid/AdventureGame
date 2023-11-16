package com.DragonXdroid.AdventureGame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setTitle("AdventureGame");

        var gamePanel = new GamePanel();
        gameWindow.add(gamePanel);

        gameWindow.pack();

        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);




        gamePanel.startGameThread();
    }
}