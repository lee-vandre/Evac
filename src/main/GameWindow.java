package main;

import javax.swing.*;

public class GameWindow extends JFrame{
    public GameWindow(GamePanel gamePanel) {
        setTitle("GameWindow");

        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gamePanel);
        setVisible(true);
    }
}
