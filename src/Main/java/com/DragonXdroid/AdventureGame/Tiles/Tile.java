package com.DragonXdroid.AdventureGame.Tiles;

import com.DragonXdroid.AdventureGame.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    private String name;
    private BufferedImage image;
    private boolean collision = false;
    private int originalTileWidth = GamePanel.ORGINAL_TILE_SIZE;
    private int originalTileHeight = GamePanel.ORGINAL_TILE_SIZE;
    private Rectangle collisionArea;
    private int collisionHeight;
    private int collisionWidth;

    private int collisionXOffset = 0;
    private int collisionYOffset = 0;

    public int getOriginalTileWidth() {
        return originalTileWidth;
    }

    public void setOriginalTileWidth(int originalTileWidth) {
        this.originalTileWidth = originalTileWidth;
    }

    public int getOriginalTileHeight() {
        return originalTileHeight;
    }

    public void setOriginalTileHeight(int originalTileHeight) {
        this.originalTileHeight = originalTileHeight;
    }

    public int getModifiedTileHeight() {
        return originalTileHeight * GamePanel.SCALE;
    }

    public int getModifiedTileWidth() {
        return originalTileWidth * GamePanel.SCALE;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isCollision() {
        return collision;
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


    public Rectangle getCollisionArea() {
        return collisionArea;
    }

    public void setCollisionArea(Rectangle collisionArea) {
        this.collisionArea = collisionArea;
    }

    public int getCollisionHeight() {
        return collisionHeight;
    }

    public void setCollisionHeight(int collisionHeight) {
        this.collisionHeight = collisionHeight * GamePanel.SCALE;
    }

    public int getCollisionWidth() {
        return collisionWidth;
    }

    public void setCollisionWidth(int collisionWidth) {
        this.collisionWidth = collisionWidth * GamePanel.SCALE;
    }

    public int getCollisionXOffset() {
        return collisionXOffset;
    }

    public void setCollisionXOffset(int collisionXOffset) {
        this.collisionXOffset = collisionXOffset * GamePanel.SCALE;
    }

    public int getCollisionYOffset() {
        return collisionYOffset;
    }

    public void setCollisionYOffset(int collisionYOffset) {
        this.collisionYOffset = collisionYOffset * GamePanel.SCALE;
    }
}
