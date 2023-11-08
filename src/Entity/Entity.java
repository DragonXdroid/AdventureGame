package Entity;

import java.awt.image.BufferedImage;
import java.util.List;

public class Entity {

    private int speed;

    private int XPosition;
    private int YPosition;

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

    public int getXPosition() {
        return XPosition;
    }

    public void setXPosition(int XPosition) {
        this.XPosition = XPosition;
    }

    public int getYPosition() {
        return YPosition;
    }

    public void setYPosition(int YPosition) {
        this.YPosition = YPosition;
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
