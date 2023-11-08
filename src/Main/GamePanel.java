import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable {

    private final int orginalTileSize = 16; // 16 x 16 tiles
    private final int scale = 4;
    private final int tileSize = orginalTileSize * scale; // 48 x 48 tiles
    private final int screenCol = 16; //1536
    private final int screenRow = 9; // 896

    private final int screenWidth = screenCol * tileSize;
    private final int screenHeight = screenRow * tileSize;

    private Thread gameThread;
    private KeyHandler keyHandler;

    private int playerX = 10;
    private  int playerY = 10;
    private int playerSpeed = 4;

    private int FPS = 60;

    public GamePanel  (){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
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

        if (keyHandler.isUpPressed()){
          playerY -= playerSpeed;
        }
        else if (keyHandler.isDownPressed()){
            playerY += playerSpeed;
        }
        else if (keyHandler.isRightPressed()) {
            playerX += playerSpeed;
        }
        else if  (keyHandler.isLeftPressed()) {
            playerX -= playerSpeed;
        }

    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(playerX,playerY,tileSize,tileSize);
        graphics2D.dispose();

    }

}
