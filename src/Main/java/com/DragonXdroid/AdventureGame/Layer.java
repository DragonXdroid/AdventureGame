package com.DragonXdroid.AdventureGame;

import com.DragonXdroid.AdventureGame.Tiles.Tile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Layer {

    private final TileRenderer renderer;
    private final String dataPath;
    private final String name;
    private final Boolean isComplex;
    private List<List<Tile>> data = new ArrayList<>();

    public Layer(String dataPath) {
        this.dataPath = dataPath;
        this.name = dataPath.substring(dataPath.lastIndexOf('_') + 1, dataPath.lastIndexOf('.'));
        this.renderer = TileRenderer.getTileRenderer(name);
        this.isComplex = renderer.getTile(0).getOriginalTileHeight() > 16 || renderer.getTile(0).getOriginalTileWidth() > 16;
        loadLayerData();
    }

    public void loadLayerData() {
        try (CSVReader reader = new CSVReader(new FileReader(dataPath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.add(convertToTileList(line));
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        for (List<Tile> tile: data){
            System.out.println(tile);
        }
    }

    private List<Tile> convertToTileList(String[] line) {
        List<Tile> tileList = new ArrayList<>();

        for (String str : line) {
            tileList.add(Integer.parseInt(str) == -1 ? null : renderer.getTile(Integer.parseInt(str)));
        }

        return tileList;
    }

    public Boolean isComplex() {
        return isComplex;
    }

    public int getBufferZone() {
        return isComplex ? 6 : 2;
    }

    public String getDataPath() {
        return dataPath;
    }

    public List<List<Tile>> getData() {
        return data;
    }


}
