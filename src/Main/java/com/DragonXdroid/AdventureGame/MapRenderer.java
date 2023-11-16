package com.DragonXdroid.AdventureGame;

import com.DragonXdroid.AdventureGame.Entity.Player;
import com.DragonXdroid.AdventureGame.Maps.Map1;
import com.DragonXdroid.AdventureGame.Tiles.Tile;

import java.awt.*;
import java.util.List;

public class MapRenderer {

    private Player player;

    private Map1 map1 = new Map1();

    private List<Layer> mapData = map1.getMapData();

    public MapRenderer(Player player) {
        this.player = player; //
    }

    public void draw(Graphics2D graphics2D) {
        for (int i = 0; i < mapData.size(); i++) {
            Layer layer = mapData.get(i);
            drawTileLayers(graphics2D, layer);
        }
    }

    private void drawTileLayers(Graphics2D graphics2D, Layer layerData){
        int tileSize = GamePanel.TILE_SIZE;

        // Calculate the visible area around the player
        int startCol = Math.max(0, player.getWorldXPosition() / tileSize - GamePanel.SCREEN_COL / 2);
        int startRow = Math.max(0, player.getWorldYPosition() / tileSize - GamePanel.SCREEN_ROW  / 2);

        // Visible Range Extension

        int endCol = Math.min(layerData.getData().get(0).size(), startCol + GamePanel.SCREEN_COL  + layerData.getBufferZone());
        int endRow = Math.min(layerData.getData().size(), startRow + GamePanel.SCREEN_COL + layerData.getBufferZone());

        // Adjust the visible range based on player movement
        for (int row = startRow; row < endRow; row++) {
            for (int col = startCol; col < endCol; col++) {
                Tile tile = layerData.getData().get(row).get(col);
                int screenX = col * tileSize - player.getWorldXPosition() + player.getScreenX();
                int screenY = row * tileSize - player.getWorldYPosition() + player.getScreenY();
                if (tile != null){
                    int tileWidth = tile.getTileWidth() * GamePanel.SCALE;
                    int tileHeight = tile.getTileHeight() * GamePanel.SCALE;
                    if (layerData.isComplex()){
                        // divide by 2 to Adjust the screen coordinates to center the larger plant within the tile
                        screenX += (tileSize - tileWidth)/2 ;
                        screenY += tileSize - tileHeight;
                    }
                    graphics2D.drawImage(tile.getImage(), screenX, screenY, tileWidth, tileHeight, null);
                }
            }
        }
    }


}
