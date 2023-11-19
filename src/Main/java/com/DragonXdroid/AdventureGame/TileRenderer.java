package com.DragonXdroid.AdventureGame;

import com.DragonXdroid.AdventureGame.Tiles.CliffTile;
import com.DragonXdroid.AdventureGame.Tiles.GrassTile;
import com.DragonXdroid.AdventureGame.Tiles.SmallOakTree;
import com.DragonXdroid.AdventureGame.Tiles.Tile;

public enum TileRenderer {

    GRASS{
        @Override
        public Tile getTile(int index) {
            switch (index) {
                case 0 -> {return new GrassTile(0);}
                case 1 -> {return new GrassTile(1);}
                case 2 -> {return new GrassTile(2);}
                case 3 -> {return new GrassTile(3);}
                case 4 -> {return new GrassTile(4);}
                case 5 -> {return new GrassTile(5);}
                case 6 -> {return new GrassTile(6);}
                case 7 -> {return new GrassTile(7);}
                case 8 -> {return new GrassTile(8);}
            }
            return null;
        }
    },

    CLIFF{
        @Override
        public Tile getTile(int index) {
            switch (index) {
                case 0 -> {return new CliffTile(0);}
                case 1 -> {return new CliffTile(1);}
                case 2 -> {return new CliffTile(2);}
                case 3 -> {return new CliffTile(3);}
                case 4 -> {return new CliffTile(4);}
                case 5 -> {return new CliffTile(5);}
                case 6 -> {return new CliffTile(6);}
                case 7 -> {return new CliffTile(7);}
                case 8 -> {return new CliffTile(8);}
            }
            return null;
        }
    },

    TREES{
        @Override
        public Tile getTile(int index) {
            switch (index) {
                case 0 -> {return new SmallOakTree();}
            }
            return null;
        }
    };

   public abstract Tile getTile(int index);

   public static TileRenderer getTileRenderer(String name) {
         return switch (name) {
              case "Grass" -> GRASS;
              case "Cliff" -> CLIFF;
              case "Trees" -> TREES;
              default -> null;
         };
   }
}
