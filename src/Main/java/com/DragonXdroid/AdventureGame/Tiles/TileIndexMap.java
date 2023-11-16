package com.DragonXdroid.AdventureGame.Tiles;

import java.util.Map;

public enum TileIndexMap {

    GRASS(Map.of(
            0, new GrassTile(0),
            1, new GrassTile(1),
            2, new GrassTile(2),
            3, new GrassTile(3),
            4, new GrassTile(4),
            5, new GrassTile(5),
            6, new GrassTile(6),
            7, new GrassTile(7),
            8, new GrassTile(8)
    )),

    CLIFF(Map.of(
            0, new CliffTile(0),
            1, new CliffTile(1),
            2, new CliffTile(2),
            3, new CliffTile(3),
            4, new CliffTile(4),
            5, new CliffTile(5),
            6, new CliffTile(6),
            7, new CliffTile(7),
            8, new CliffTile(8)
    )),

    TREES(Map.of(
            0, new SmallOakTree()
    ));

    final public Map <Integer, Tile> tileIndexMap;

    TileIndexMap(Map<Integer, Tile> tileIndexMap) {
        this.tileIndexMap = tileIndexMap;
    }
}
