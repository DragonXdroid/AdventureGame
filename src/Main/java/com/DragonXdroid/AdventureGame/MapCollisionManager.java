package com.DragonXdroid.AdventureGame;

import com.DragonXdroid.AdventureGame.Entity.Player;
import com.DragonXdroid.AdventureGame.Tiles.Tile;

import java.awt.*;
import java.util.List;

public class MapCollisionManager {

    private Player player;
    private List<Layer> mapData;

    public MapCollisionManager(List<Layer> mapData, Player player) {
        this.mapData = mapData;
        this.player = player;
        updateTileCollision();
    }

    public void updateTileCollision() {
        for (Layer layer : mapData) {
            int tileSize = GamePanel.MODIFIED_TILE_SIZE;

            for (int row = 0; row < layer.getData().size(); row++) {
                for (int col = 0; col < layer.getData().get(row).size(); col++) {
                    Tile tile = layer.getData().get(row).get(col);
                    if (tile != null) {

                        // Calculate the absolute screen coordinates of the tile
                        int screenX = col * tileSize - player.getWorldXPosition() + player.getScreenX();
                        int screenY = row * tileSize - player.getWorldYPosition() + player.getScreenY();

                        int tileWidth = tile.getOriginalTileWidth() * GamePanel.SCALE;
                        int tileHeight = tile.getOriginalTileHeight() * GamePanel.SCALE;
                        if (layer.isComplex()) {
                            // divide by 2 to Adjust the screen coordinates to center the larger plant within the tile
                            screenX += (tileSize - tileWidth) / 2;
                            screenY += tileSize - tileHeight;
                        }

                        // Set the collision area for the tile based on absolute screen coordinates
                        tile.setCollisionArea(new Rectangle(
                                screenX + tile.getCollisionXOffset(), screenY + tile.getCollisionYOffset(),
                                tile.getCollisionWidth(), tile.getCollisionHeight()));
                    }
                }
            }
        }
    }

}
