package com.AdventureGame.Maps;

import com.AdventureGame.Tiles.GrassTile;
import com.AdventureGame.Tiles.Tile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Map1 {

    private final Map<String,String> mapCSV = Map.of("grass", "resources\\MapCSVs\\Map1\\Map1_grass.csv");

    private final Map<Integer, Tile> tileMap = Map.of(
            0, new GrassTile(0),
            1, new GrassTile(1),
            2, new GrassTile(2),
            3, new GrassTile(3),
            4, new GrassTile(4),
            5, new GrassTile(5),
            6, new GrassTile(6),
            7, new GrassTile(7),
            8, new GrassTile(8)
            );

    public List<List<Integer>> load() {
        List<List<Integer>> mapData = new ArrayList<>(); // List to hold lists of integers

        try (CSVReader reader = new CSVReader(new FileReader(mapCSV.get("grass")))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                mapData.add(convertToIntList(line)); // Add converted line to the main list
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace(); // Handle exceptions
        }

        for (List<Integer> str: mapData){
            System.out.println(str);
        }
        return mapData; // Return the final list
    }

    // Function to convert an array of strings to a list of integers
    private List<Integer> convertToIntList(String[] line) {
        List<Integer> intList = new ArrayList<>(); // List to hold integers

        for (String str : line) {
            intList.add(Integer.parseInt(str)); // Convert strings to integers and add to the list
        }

        return intList; // Return the list of integers
    }

    public Tile getTile(int number) {
        return tileMap.get(number);

    }


}
