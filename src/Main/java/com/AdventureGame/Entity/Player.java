package com.AdventureGame.Entity;

import com.AdventureGame.GamePanel;
import com.AdventureGame.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends Entity{

    private GamePanel gamePanel;

    private KeyHandler keyHandler;

    private final int width = 24;
    private final int height = 24;

    private final int screenX;
    private final int screenY;

    private String playerDirection = "down";

    public Player (GamePanel gamePanel, KeyHandler keyHandler){
        this.keyHandler = keyHandler;
        this.gamePanel = gamePanel;

        screenX = gamePanel.getScreenWidth()/2 - gamePanel.getTileSize()/2;
        screenY = gamePanel.getScreenHeight()/2 - gamePanel.getTileSize();
        setDefaultValues();

    }
    public void setDefaultValues(){
        setSpeed(5);
        setWorldXPosition(5*gamePanel.getTileSize());
        setWorldYPosition(5*gamePanel.getTileSize());
        getPlayerAnimations();

    }

    public void getPlayerAnimations() {
        setDownAnimation(loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Down")));
        setUpAnimation(loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Up")));
        setRightAnimation(loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Right")));
        setLeftAnimation(loadAnimation(new File("resources\\Entity\\Animations\\Player\\Walk\\Left")));
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

    public void update(){

        if (keyHandler.isDownPressed()||keyHandler.isUpPressed()||keyHandler.isRightPressed()||keyHandler.isLeftPressed()){
            setIdle(false);
            if (keyHandler.isUpPressed()){
                setWorldYPosition(getWorldYPosition() - getSpeed());
                playerDirection = "up";

            }
            else if (keyHandler.isDownPressed()){
                setWorldYPosition(getWorldYPosition() + getSpeed());
                playerDirection = "down";

            }
            else if (keyHandler.isRightPressed()) {
                setWorldXPosition(getWorldXPosition() + getSpeed());
                playerDirection = "right";
            }
            else if  (keyHandler.isLeftPressed()){
                setWorldXPosition(getWorldXPosition() - getSpeed());
                playerDirection = "left";
            }
        }
        else {
            setIdle(true);
        }

        setSpriteCounter(getSpriteCounter()+1);

        if (getSpriteCounter()==8){ // check if 8 frames have passed, Selected every due to it precisely simulating
            // the animation environment the animations were worked on in Aseprite. Aseprite frame duration is 135 frames
            System.out.println(getSpriteNumber());
            if(isIdle()){
                setSpriteNumber(0);
            }
            else {
                if (getSpriteNumber() < 5){
                    setSpriteNumber(getSpriteNumber()+1);
                }
                else if (getSpriteNumber()==5){
                    setSpriteNumber(0);
                }
            }
            setSpriteCounter(0);
        }
    }

    public void draw(Graphics2D graphics2D){

        BufferedImage image = null;

        if (playerDirection.equals("up")){
            image = getUpAnimation().get(getSpriteNumber());
        } else if (playerDirection.equals("down")) {
            image = getDownAnimation().get(getSpriteNumber());
        } else if (playerDirection.equals("right")) {
            image = getRightAnimation().get(getSpriteNumber());
        } else if (playerDirection.equals("left")) {
            image = getLeftAnimation().get(getSpriteNumber());
        }

        graphics2D.drawImage(image, screenX, screenY,
                width * gamePanel.getScale(),height * gamePanel.getScale(),null);
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
