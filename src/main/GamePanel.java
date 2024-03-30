package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta= 100,yDelta=100;
    private BufferedImage img;
    private BufferedImage[] idleAnimation;



    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        importImage();
        loadAnimations();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        idleAnimation = new BufferedImage[5];

//        for (int i = 0; i < idleAnimation.length; i++){
//
//
//        }
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/idle/Armature_idle_01.png");
        try {

            if (is == null) {
                throw new FileNotFoundException("FILE IMAGE NOT FOUND");
            }
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;

    }


    public void changeYDelta(int value) {
        this.yDelta += value;

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,(int)xDelta,(int)yDelta,120,120,null);

    }

}

