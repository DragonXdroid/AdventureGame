package com.AdventureGame.Tiles;

public class GrassTile extends Tile{

    public GrassTile(int grassType) {
        setImage("/Tiles/GrassTile"+grassType+".png");
        setCollision(false);
    }
}
