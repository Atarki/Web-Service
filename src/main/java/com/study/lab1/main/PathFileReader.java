package com.study.lab1.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class PathFileReader {

    public static ArrayList getItemList(String s) throws IOException {
        ArrayList citiesID = new ArrayList<>();
        String line;

        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(s));
        while ((line = bufferedReader.readLine()) != null) citiesID.add(line);
        bufferedReader.close();

        return citiesID;
    }
}
