package com.AdventureGame.Entity;

import java.awt.image.BufferedImage;
import java.util.List;

public class Entity {

    private int speed;
    private int worldXPosition;
    private int worldYPosition;

    private boolean isIdle = true;
    private int spriteCounter = 0;
    private int spriteNumber = 0;

    private List<BufferedImage> upAnimation;
    private List<BufferedImage> downAnimation;
    private List<BufferedImage> rightAnimation;
    private List<BufferedImage> leftAnimation;


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

    public void setUpAnimation(List<BufferedImage> upAnimation) {
        this.upAnimation = upAnimation;
    }

    public void setDownAnimation(List<BufferedImage> downAnimation) {
        this.downAnimation = downAnimation;
    }

    public void setRightAnimation(List<BufferedImage> rightAnimation) {
        this.rightAnimation = rightAnimation;
    }

    public void setLeftAnimation(List<BufferedImage> leftAnimation) {
        this.leftAnimation = leftAnimation;
    }

    public List<BufferedImage> getUpAnimation() {
        return upAnimation;
    }

    public List<BufferedImage> getDownAnimation() {
        return downAnimation;
    }

    public List<BufferedImage> getRightAnimation() {
        return rightAnimation;
    }

    public List<BufferedImage> getLeftAnimation() {
        return leftAnimation;
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
