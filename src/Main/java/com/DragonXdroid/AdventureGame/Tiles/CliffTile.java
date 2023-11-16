package com.DragonXdroid.AdventureGame.Tiles;

import com.DragonXdroid.AdventureGame.TileSheetReader;

public class CliffTile extends Tile {

    public CliffTile(int cliffType) {
        TileSheetReader tileSheet = new TileSheetReader("Cliff");
        setImage(tileSheet.getTile(cliffType));
        setCollision(false);
        setName("Cliff"+cliffType);
    }


}
