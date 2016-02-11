package com.study.lab1.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class PathFileReader {
    public static ArrayList getItemList(String s) throws IOException {
        ArrayList citiesID = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(s));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            citiesID.add(line);
            System.out.println("city: " + line);
        }
        bufferedReader.close();
        System.out.println(citiesID.toArray());
        return citiesID;
    }
}
