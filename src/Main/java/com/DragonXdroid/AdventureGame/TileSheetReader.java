package com.DragonXdroid.AdventureGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TileSheetReader {
    private BufferedImage tileSheet;

    private List<BufferedImage> tiles = new ArrayList<>();

    public TileSheetReader(String tileSheetName) {
        try {
            tileSheet = ImageIO.read(new File("resources/TileSheets/"+tileSheetName+"Tiles.png"));
            slice(16, 16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void slice(int tileWidth, int tileHeight) {
        int columns = tileSheet.getWidth() / tileWidth;
        int rows = tileSheet.getHeight() / tileHeight;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                BufferedImage tile = tileSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
                tiles.add(tile);
            }
        }
    }

    public BufferedImage getTile(int index) {
       return tiles.get(index);
    }
}



