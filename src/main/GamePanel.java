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
    private Animations animations;
    private int animationTick,animationIndex,animationSpeed = 15;



    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        importImage();
        loadAnimations();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


//    private void loadAnimations() {
//        animations = new BufferedImage[6];
//
//        for (int i = 0; i< animations.length; i++){
//            animations[i] = img.getSubimage(i*48,0,48,48);
//        }
//    }

    private void loadAnimations() {

        animations = new Animations();
        BufferedImage[] playerAnimations = animations.playerAnimationsArray();
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/run/PlayerRun.png");
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
    private void updateAnimationTick() {
        animationTick++;
        if(animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= animations.length) {
                animationIndex = 0;
            }
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateAnimationTick();
        g.drawImage(animations[animationIndex],(int)xDelta,(int)yDelta,80,80,null);

    }


}

