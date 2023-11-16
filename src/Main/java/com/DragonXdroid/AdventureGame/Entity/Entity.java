package com.DragonXdroid.AdventureGame.Entity;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {

    private int speed;
    private int worldXPosition;
    private int worldYPosition;

    private boolean isIdle = true;
    private int spriteCounter = 0;
    private int spriteNumber = 0;

    private Map<String, List<BufferedImage>> animations = new HashMap<>();

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
}
