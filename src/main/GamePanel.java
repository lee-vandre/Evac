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



    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        importImage();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/Armature_idle_01.png");
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

        g.drawImage(img.getSubimage(0,0,64,64),0,0,120,120,null);

    }

}

