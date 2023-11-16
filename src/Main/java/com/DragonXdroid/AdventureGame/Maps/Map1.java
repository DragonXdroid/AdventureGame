package com.DragonXdroid.AdventureGame.Maps;

import com.DragonXdroid.AdventureGame.Layer;
import com.DragonXdroid.AdventureGame.Tiles.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Map1 {

    private final File CSVFolder = new File("resources/MapCSVs/Map1");

    private List<Layer> mapData = new ArrayList<>();


     public Map1() {
         loadMapData();
     }

     private void loadMapData() {
         for (File file : CSVFolder.listFiles()) {
             System.out.println(file.getPath());
             mapData.add(new Layer(file.getPath()));

         }
     }


    public List<Layer> getMapData() {
        return mapData;
    }
}
