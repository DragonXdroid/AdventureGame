package com.AdventureGame;

import com.AdventureGame.Entity.Player;
import com.AdventureGame.Maps.Map1;

import java.awt.*;
import java.util.List;

public class MapManager {

    private GamePanel gamePanel;

    private Player player;

    private Map1 map1 = new Map1();

    private List<List<Integer>> mapData = map1.load();

    public MapManager(GamePanel gamePanel, Player player) {
        this.gamePanel = gamePanel;
        this.player = player;
    }

    public void draw(Graphics2D graphics2D) {
        int tileSize = gamePanel.getTileSize();

        // Calculate the visible area around the player
        int startCol = Math.max(0, player.getWorldXPosition() / tileSize - gamePanel.getScreenCol() / 2);
        int startRow = Math.max(0, player.getWorldYPosition() / tileSize - gamePanel.getScreenRow() / 2);

        int endCol = Math.min(mapData.get(0).size(), startCol + gamePanel.getScreenCol() + 2); // Increase by 1 tile
        int endRow = Math.min(mapData.size(), startRow + gamePanel.getScreenRow() + 2); // Increase by 1 tile

        // Adjust the visible range based on player movement
        for (int row = startRow; row < endRow; row++) {
            for (int col = startCol; col < endCol; col++) {
                int num = mapData.get(row).get(col);
                int screenX = col * tileSize - player.getWorldXPosition() + player.getScreenX();
                int screenY = row * tileSize - player.getWorldYPosition() + player.getScreenY();
                graphics2D.drawImage(map1.getTile(num).getImage(), screenX, screenY, tileSize, tileSize, null);
            }
        }
    }

}
