package com.DragonXdroid.AdventureGame.Tiles;

import com.DragonXdroid.AdventureGame.GamePanel;
import com.DragonXdroid.AdventureGame.TileSheetReader;

public class GrassTile extends Tile{

    public GrassTile(int grassType) {
        TileSheetReader tileSheet = new TileSheetReader("Grass");
        setImage(tileSheet.getTile(grassType));
        setCollision(false);
        setCollisionHeight(GamePanel.ORGINAL_TILE_SIZE);
        setCollisionWidth(GamePanel.ORGINAL_TILE_SIZE);
        setName("Grass"+grassType);
    }
}
