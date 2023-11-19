package com.DragonXdroid.AdventureGame.Tiles;

import com.DragonXdroid.AdventureGame.GamePanel;
import com.DragonXdroid.AdventureGame.TileSheetReader;

public class CliffTile extends Tile {

    public CliffTile(int cliffType) {
        TileSheetReader tileSheet = new TileSheetReader("Cliff");
        setImage(tileSheet.getTile(cliffType));
        setCollision(true);
        setCollisionHeight(GamePanel.ORGINAL_TILE_SIZE);
        setCollisionWidth(GamePanel.ORGINAL_TILE_SIZE);
        setName("Cliff"+cliffType);
    }


}
