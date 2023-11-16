package com.DragonXdroid.AdventureGame;

import com.DragonXdroid.AdventureGame.Tiles.Tile;
import com.DragonXdroid.AdventureGame.Tiles.TileIndexMap;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Layer {

    private Map<Integer, Tile> tileIndexMap;
    private String dataPath;
    private String name;
    private Boolean isComplex;

    private List<List<Tile>> data = new ArrayList<>();

    public Layer(String dataPath) {
        this.dataPath = dataPath;
        this.name = dataPath.substring(dataPath.lastIndexOf('_') + 1, dataPath.lastIndexOf('.'));
        setTileIndexMap();
        loadLayerData();
        setComplex();
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
            tileList.add(Integer.parseInt(str) == -1 ? null : tileIndexMap.get(Integer.parseInt(str)));
        }

        return tileList;
    }

    public void setTileIndexMap() {
        switch (name) {
            case "Grass" -> tileIndexMap = TileIndexMap.GRASS.tileIndexMap;
            case "Cliff" -> tileIndexMap = TileIndexMap.CLIFF.tileIndexMap;
            case "Trees" -> tileIndexMap = TileIndexMap.TREES.tileIndexMap;
        }
    }

    public void setComplex( ) {
        isComplex = tileIndexMap.get(0).getTileHeight() > 16 || tileIndexMap.get(0).getTileWidth() > 16;
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
