package com.AdventureGame.Tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile {

    private BufferedImage image;
    private boolean collision = false;

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void setImage(String str) {
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getImage() {
        return image;
    }

}
