package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animations {
    private BufferedImage[] playerImages, enemyImages;
    public Animations() {

    }

    public BufferedImage[] playerAnimationsArray() {

        try {
            playerImages = new BufferedImage[5];

            playerImages[0] = ImageIO.read(new File("/idle/PlayerIdle.png"));
            playerImages[1] = ImageIO.read(new File("/run/PlayerRun.png"));
            playerImages[2] = ImageIO.read(new File("/jump/PlayerJump.png"));
            playerImages[3] = ImageIO.read(new File("/crouch/PlayerCrouch.png"));
            playerImages[4] = ImageIO.read(new File("/death/PlayerDeath.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image file was not loaded");
        }
     return playerImages;
    }

    public void enemyAnimationsArray() {

    }
}
