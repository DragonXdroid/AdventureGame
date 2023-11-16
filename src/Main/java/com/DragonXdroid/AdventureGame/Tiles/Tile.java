package com.DragonXdroid.AdventureGame.Tiles;

import com.DragonXdroid.AdventureGame.GamePanel;

import java.awt.image.BufferedImage;

public class Tile {

    private String name;
    private BufferedImage image;
    private boolean collision = false;
    private int tileWidth = GamePanel.ORGINAL_TILE_SIZE;
    private int tileHeight = GamePanel.ORGINAL_TILE_SIZE;

    public int getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void setImage(BufferedImage image) {
            this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
