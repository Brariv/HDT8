package com;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;

public class TxtReader {
    
    public ArrayList<ArrayList<String>> readTxTFile(String filename) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<String> words = new ArrayList<String>();
                String[] lineWords = line.split(",");
                for (String word : lineWords) {
                    words.add(word);
                }
                list.add(words);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

