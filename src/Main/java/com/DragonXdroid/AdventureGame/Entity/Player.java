package com.DragonXdroid.AdventureGame.Entity;
import com.DragonXdroid.AdventureGame.GamePanel;
import com.DragonXdroid.AdventureGame.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends Entity{

    private KeyHandler keyHandler;

    private final int width = 24;
    private final int height = 24;

    private final int screenX;
    private final int screenY;

    private String playerDirection = "down";

    public Player (KeyHandler keyHandler){
        this.keyHandler = keyHandler;

        screenX = GamePanel.SCREEN_WIDTH /2 - GamePanel.TILE_SIZE/2;
        screenY =  GamePanel.SCREEN_HEIGHT/2 - GamePanel.TILE_SIZE;
        setDefaultValues();

    }
    public void setDefaultValues(){
        setSpeed(5);
        setWorldXPosition(5*GamePanel.TILE_SIZE);
        setWorldYPosition(5*GamePanel.TILE_SIZE);
        getPlayerAnimations();

    }

    public void getPlayerAnimations() {
        getAnimations().put("down", loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Down")));
        getAnimations().put("up", loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Up")));
        getAnimations().put("right", loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Right")));
        getAnimations().put("left", loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Left")));
    }

    public List<BufferedImage> loadAnimation (File dir){
        List<BufferedImage> list = new ArrayList<>();
        Arrays.stream(dir.listFiles()).forEach(file -> {
            try {
            list.add(ImageIO.read(file));
            }
            catch (IOException e) {
            throw new RuntimeException(e);
            }
        });
        return list;
    }

    public void update() {
        if (keyHandler.isUpPressed()) {
            movePlayer(0, -getSpeed(), "up");
        } else if (keyHandler.isDownPressed()) {
            movePlayer(0, getSpeed(), "down");
        } else if (keyHandler.isRightPressed()) {
            movePlayer(getSpeed(), 0, "right");
        } else if (keyHandler.isLeftPressed()) {
            movePlayer(-getSpeed(), 0, "left");
        } else {
            setIdle(true);
        }

        updateSpriteCounter();
    }
    private void movePlayer(int x, int y, String direction) {
        setWorldXPosition(getWorldXPosition() + x);
        setWorldYPosition(getWorldYPosition() + y);
        playerDirection = direction;
        setIdle(false);
    }

    private void updateSpriteCounter() {
        setSpriteCounter(getSpriteCounter() + 1);

        if (getSpriteCounter() == 8) {
            if (isIdle()) {
                setSpriteNumber(0);
            } else {
                int currentNumber = getSpriteNumber();
                setSpriteNumber(currentNumber < 5 ? currentNumber + 1 : 0);
            }
            setSpriteCounter(0);
        }
    }

    public void draw(Graphics2D graphics2D){

        List<BufferedImage> directionAnimation = getAnimations().get(playerDirection);
        BufferedImage image = directionAnimation.get(getSpriteNumber());

        graphics2D.drawImage(image, screenX, screenY,
                width * GamePanel.SCALE,height * GamePanel.SCALE,null);
    }

    public KeyHandler getKeyHandler(){
        return this.keyHandler;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }
}
