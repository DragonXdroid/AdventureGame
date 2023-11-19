package com.DragonXdroid.AdventureGame.Entity;

import com.DragonXdroid.AdventureGame.Layer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entity {

    private int speed;
    private int worldXPosition;
    private int worldYPosition;
    private int height;
    private int width;
    private String direction;

    private boolean isIdle = true;
    private int spriteCounter = 0;
    private int spriteNumber = 0;

    private Rectangle collisionArea;
    private List<Layer> mapData;
    private boolean collision = false;

    private Map<String, List<BufferedImage>> animations = new HashMap<>();

    public Rectangle getCollisionArea() {
        return collisionArea;
    }

    public void setCollisionArea(Rectangle collisionArea) {
        this.collisionArea = collisionArea;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWorldXPosition() {
        return worldXPosition;
    }

    public void setWorldXPosition(int worldXPosition) {
        this.worldXPosition = worldXPosition;
    }

    public int getWorldYPosition() {
        return worldYPosition;
    }

    public void setWorldYPosition(int worldYPosition) {
        this.worldYPosition = worldYPosition;
    }

    public Map<String, List<BufferedImage>> getAnimations() {
        return animations;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNumber() {
        return spriteNumber;
    }

    public void setSpriteNumber(int spriteNumber) {
        this.spriteNumber = spriteNumber;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean idle) {
        isIdle = idle;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public List<Layer> getMapData() {
        return mapData;
    }

    public void setMapData(List<Layer> mapData) {
        this.mapData = mapData;
    }
}
