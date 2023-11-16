package com.DragonXdroid.AdventureGame.Tiles;

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

        setCollision(false);
        setTileWidth(32);
        setTileHeight(42);
        setName("SmallOakTree");
    }

}
