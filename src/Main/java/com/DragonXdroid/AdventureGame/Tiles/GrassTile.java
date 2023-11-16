package com.DragonXdroid.AdventureGame.Tiles;

import com.DragonXdroid.AdventureGame.TileSheetReader;

public class GrassTile extends Tile{

    public GrassTile(int grassType) {
        TileSheetReader tileSheet = new TileSheetReader("Grass");
        setImage(tileSheet.getTile(grassType));
        setCollision(false);
        setName("Grass"+grassType);
    }
}
