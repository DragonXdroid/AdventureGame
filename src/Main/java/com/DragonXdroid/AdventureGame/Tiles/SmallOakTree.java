package com.DragonXdroid.AdventureGame.Tiles;

import com.DragonXdroid.AdventureGame.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SmallOakTree extends ComplexTile {

    public SmallOakTree() {
        try {
            setImage(ImageIO.read(new File("resources/Objects/SmallOakTree.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setCollision(true);
        setOriginalTileWidth(32);
        setOriginalTileHeight(42);
        setCollisionHeight(12);
        setCollisionWidth(8);
        setCollisionYOffset(30);
        setCollisionXOffset(11);
        setName("SmallOakTree");
    }

}
