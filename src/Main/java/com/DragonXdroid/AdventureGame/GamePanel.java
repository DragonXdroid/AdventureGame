package com.DragonXdroid.AdventureGame;

import com.DragonXdroid.AdventureGame.Entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int ORGINAL_TILE_SIZE = 16; // 16 x 16 tiles
    public static final int SCALE = 6;
    public static final int TILE_SIZE = ORGINAL_TILE_SIZE * SCALE; // 64 x 64 tiles
    public static final int SCREEN_COL = 16; //1536
    public static final int SCREEN_ROW = 9; // 896

    public static final int SCREEN_WIDTH = SCREEN_COL * TILE_SIZE;
    public static final int SCREEN_HEIGHT = SCREEN_ROW * TILE_SIZE;

    private Thread gameThread;
    private KeyHandler keyHandler;
    private Player player;
    private MapRenderer mapRenderer;

    private int FPS = 60;

    public GamePanel  (){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);


        keyHandler = new KeyHandler();
        this.player = new Player(keyHandler);
        this.addKeyListener(player.getKeyHandler());
        this.mapRenderer = new MapRenderer(player);
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

        mapRenderer.draw(graphics2D);
        player.draw(graphics2D);

        graphics2D.dispose();
    }


    public Player getPlayer() {
        return player;
    }
}
