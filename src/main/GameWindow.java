package main;

import javax.swing.*;

public class GameWindow extends JFrame{
    public GameWindow(GamePanel gamePanel) {
        setTitle("GameWindow");


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gamePanel);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        setVisible(true);
    }
}
