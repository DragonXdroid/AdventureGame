package com.AdventureGame;

import com.AdventureGame.Entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private final int orginalTileSize = 16; // 16 x 16 tiles
    private final int scale = 6;
    private final int tileSize = orginalTileSize * scale; // 64 x 64 tiles
    private final int screenCol = 16; //1536
    private final int screenRow = 9; // 896

    private final int screenWidth = screenCol * tileSize;
    private final int screenHeight = screenRow * tileSize;

    private Thread gameThread;
    private KeyHandler keyHandler;
    private Player player;
    private MapManager mapManager;

    private int FPS = 60;

    public GamePanel  (){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);


        keyHandler = new KeyHandler();
        this.player = new Player(this,keyHandler);
        this.addKeyListener(player.getKeyHandler());
        this.mapManager = new MapManager(this,player);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000/FPS; // 16,666,666.666666666
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1){
                // 1: UPDATE - update information such as character position
                this.update();

                // 2: DRAW - draw the screen with the updated information
                this.repaint();

                delta--;
            }

            if (timer==1_000_000_000){
                System.out.println(FPS + drawCount);
                drawCount = 0;
                timer = 0;
            }


        }
    }

    public void update(){

        player.update();

    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;

        mapManager.draw(graphics2D);
        player.draw(graphics2D);

        graphics2D.dispose();
    }

    public int getTileSize(){
        return tileSize;
    }

    public int getScale(){
        return scale;
    }

    public int getScreenCol() {
        return screenCol;
    }

    public int getScreenRow() {
        return screenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public Player getPlayer() {
        return player;
    }
}
