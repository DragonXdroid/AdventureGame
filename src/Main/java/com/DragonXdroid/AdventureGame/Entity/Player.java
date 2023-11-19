package com.DragonXdroid.AdventureGame.Entity;
import com.DragonXdroid.AdventureGame.GamePanel;
import com.DragonXdroid.AdventureGame.KeyHandler;
import com.DragonXdroid.AdventureGame.Layer;
import com.DragonXdroid.AdventureGame.Tiles.Tile;

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

    private final int screenX;
    private final int screenY;


    public Player (KeyHandler keyHandler){
        this.keyHandler = keyHandler;

        screenX = GamePanel.SCREEN_WIDTH /2 - GamePanel.MODIFIED_TILE_SIZE /2;
        screenY =  GamePanel.SCREEN_HEIGHT/2 - GamePanel.MODIFIED_TILE_SIZE;


        setWidth(24);
        setHeight(24);
        setDirection("down");
        setSpeed(5);
        setWorldXPosition(5*GamePanel.MODIFIED_TILE_SIZE);
        setWorldYPosition(5*GamePanel.MODIFIED_TILE_SIZE);
        loadPlayerAnimations();

        Rectangle collisionArea = new Rectangle(screenX + 8*GamePanel.SCALE, screenY + 9*GamePanel.SCALE,
                8 * GamePanel.SCALE, 14 * GamePanel.SCALE);
        setCollisionArea(collisionArea);



    }

    public void loadPlayerAnimations() {
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
        setDirection(direction);

        // Calculate future collision areas based on intended movement
        Rectangle futureCollisionArea = new Rectangle(
                getCollisionArea().x + x,
                getCollisionArea().y + y,
                getCollisionArea().width,
                getCollisionArea().height
        );

        if (!isCollision(futureCollisionArea)) {
            // Update the player's position if no future collision is detected
            setWorldXPosition(getWorldXPosition() + x);
            setWorldYPosition(getWorldYPosition() + y);
            setIdle(false);
        }
    }

    private boolean isCollision(Rectangle futureCollisionArea) {
        // Check for collisions in the future position
        for (Layer layer : getMapData()) {
            for (List<Tile> row : layer.getData()) {
                for (Tile tile : row) {
                    if (tile != null && tile.isCollision()) {
                        Rectangle tileCollisionArea = tile.getCollisionArea();

                        // Check for intersection with future collision area
                        if (futureCollisionArea.intersects(tileCollisionArea)) {
                            return true; // Collision detected
                        }
                    }
                }
            }
        }
        return false; // No collision detected
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

        List<BufferedImage> directionAnimation = getAnimations().get(getDirection());
        BufferedImage image = directionAnimation.get(getSpriteNumber());

        graphics2D.drawImage(image, screenX, screenY,
                getWidth() * GamePanel.SCALE,getHeight() * GamePanel.SCALE,null);


        //graphics2D.setColor(Color.BLUE);
        //graphics2D.drawRect(getCollisionArea().x, getCollisionArea().y, getCollisionArea().width, getCollisionArea().height);
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
