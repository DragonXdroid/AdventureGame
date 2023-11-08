package Entity;

import Main.GamePanel;
import Main.KeyHandler;

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

    final private int width = 24;
    final private int height = 24;

    private String playerDirection = "down";

    public Player (GamePanel gamePanel, KeyHandler keyHandler){
        this.keyHandler = keyHandler;
        this.gamePanel = gamePanel;
        setDefaultValues();

    }
    public void setDefaultValues(){
        setSpeed(5);
        setXPosition(100);
        setYPosition(100);
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
                setYPosition(getYPosition() - getSpeed());
                playerDirection = "up";

            }
            else if (keyHandler.isDownPressed()){
                setYPosition(getYPosition() + getSpeed());
                playerDirection = "down";

            }
            else if (keyHandler.isRightPressed()) {
                setXPosition(getXPosition() + getSpeed());
                playerDirection = "right";
            }
            else if  (keyHandler.isLeftPressed()){
                setXPosition(getXPosition() - getSpeed());
                playerDirection = "left";
            }
        }
        else {
            setIdle(true);
        }

        setSpriteCounter(getSpriteCounter()+1);

        if (getSpriteCounter()==8){ // check if 8 frames have passed
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

        graphics2D.drawImage(image,getXPosition(),getYPosition(),this.width * gamePanel.getScale(),this.height * gamePanel.getScale(),null);
    }

    public KeyHandler getKeyHandler(){
        return this.keyHandler;
    }
}
