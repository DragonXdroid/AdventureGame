package com.DragonXdroid.AdventureGame;

import com.DragonXdroid.AdventureGame.Entity.Player;
import com.DragonXdroid.AdventureGame.Maps.Map1;
import com.DragonXdroid.AdventureGame.Tiles.Tile;

import java.awt.*;
import java.util.List;

public class MapManager {

    private Player player;

    private Map1 map1 = new Map1();

    private MapCollisionManager mapCollisionManager;

    private List<Layer> mapData = map1.getMapData();

    public MapManager(Player player) {
        this.player = player;
        player.setMapData(mapData);

        this.mapCollisionManager = new MapCollisionManager(mapData, player);
    }

    public void draw(Graphics2D graphics2D) {
        for (int i = 0; i < mapData.size(); i++) {
            Layer layer = mapData.get(i);
            drawTileLayers(graphics2D, layer);
        }
    }

    public void update() {
        mapCollisionManager.updateTileCollision();
    }

    private void drawTileLayers(Graphics2D graphics2D, Layer layerData){
        int tileSize = GamePanel.MODIFIED_TILE_SIZE;

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

                    if (layerData.isComplex()){
                        // divide by 2 to Adjust the screen coordinates to center the larger plant within the tile
                        screenX += (tileSize - tile.getModifiedTileWidth())/2 ;
                        screenY += tileSize - tile.getModifiedTileHeight();
                    }
                    graphics2D.drawImage(tile.getImage(),
                            screenX, screenY,
                            tile.getModifiedTileWidth(), tile.getModifiedTileHeight(), null);
                    //tile.setCollisionArea(new Rectangle(screenX, screenY, tile.getModifiedTileWidth(), tile.getModifiedTileHeight()));
                    graphics2D.setColor(new Color(37, 82, 33, 234));
                    //graphics2D.drawRect(tile.getCollisionArea().x,tile.getCollisionArea().y, tile.getCollisionArea().width, tile.getCollisionArea().height);
                }
            }
        }
    }
}
