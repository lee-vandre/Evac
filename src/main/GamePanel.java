package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta= 100,yDelta=100;
    private float xDir = 0.05f,yDir = 0.05f;
    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(150,20,90);
    private Random random;

    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;

    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }
    public void changeYDelta(int value) {
        this.yDelta += value;

    }

    //Paint method handles the repainting of the game window/panel and handles the movement with updateRectangle method
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();

        g.setColor(color);
        g.fillRect((int)xDelta,(int)yDelta,200,50);
        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: "+ frames);
        }
        repaint();
    }

    //moves rectangle position
    public void updateRectangle() {
        xDelta += xDir;
        if (xDelta > 200 || xDelta <0){
            xDir *=-1;
            color = getRandomColor();
        }

        yDelta += yDir;
        if (yDelta> 150 || yDelta < 0) {
            yDir *= -1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,b,g);
    }
}

