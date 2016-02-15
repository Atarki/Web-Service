package com.study.lab1.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathFileReader {

    public static List<Object> getItemList(String pathToFile) throws IOException {
        List<Object> personList = new ArrayList<>();
        String line;
        BufferedReader bufferedReader;

        FileReader fileReader = new FileReader(pathToFile);
        bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
//                String[] personData = line.split("\\s*,\\s*");
            String[] personData = line.replaceAll("\\s", "").split(",");
            Person person = new Person();
            person.setName(personData[0]);
            person.setGender(personData[1]);
            person.setAge(personData[2]);
            person.setEmail(personData[3]);
            person.setStatus(personData[4]);
            person.setCity(personData[5]);
            person.setSoftware(personData[6]);

            personList.add(person);
        }
        bufferedReader.close();
        return personList;
    }
}
