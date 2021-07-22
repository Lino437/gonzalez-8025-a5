/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadFileManager {

    // select correct file and write to it in adequate format
    public static void loadFile(ObservableList<Item> dataList, String absolutePath) {
        String extension = FilenameUtils.getExtension(absolutePath);

        switch (extension) {
            case "txt" -> loadTSVFile(dataList, absolutePath);
            case "html" -> loadHTMLFile(dataList, absolutePath);
            case "json" -> loadJSONFile(dataList, absolutePath);
        }
    }

    // this method get filepath for an item to load
    public static String fileChooserLoad() {
        FileChooser fileChooser = new FileChooser();

        // set fileChooser
        fileChooser.setTitle("Load File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files (*.html)", "*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json"));

        File file = fileChooser.showOpenDialog(null);
        String absolutePath = "";

        if (file != null) {
            absolutePath = file.getAbsolutePath();
        }
        return absolutePath;
    }

    public static void loadTSVFile(ObservableList<Item> dataList, String absolutePath) {
        ArrayList<String[]> data = tsvFileReader(absolutePath);

        for (int i = 1; i < data.size(); i++) {
            int j = 0;

            String[] item = data.get(i);

            dataList.add(new Item(item[j], item[j + 1], item[j + 2]));
        }
    }

    public static ArrayList<String[]> tsvFileReader(String absolutePath) {
        ArrayList<String[]> data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        File file = new File(absolutePath);

        try (BufferedReader TSVReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = TSVReader.readLine()) != null) {
                String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                data.add(lineItems); //adding the splitted line array to the ArrayList
            }
        } catch (Exception e) {
            System.out.println("Something went wrong loading tsv file");
        }
        return data;
    }

    public static void loadHTMLFile(ObservableList<Item> dataList, String absolutePath) {
        ArrayList<String[]> data = htmlFileReader(absolutePath);

        // get data from ArrayList and
        for (int i = 1; i < data.size() - 1; i++) {
            int j = 1;

            String[] item = data.get(i);

            dataList.add(new Item(item[j], item[j + 1], item[j + 2]));
        }

    }

    public static ArrayList<String[]> htmlFileReader(String absolutePath) {
        ArrayList<String[]> data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        File file = new File(absolutePath);

        // store data on ArrayList of String's
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = TSVReader.readLine()) != null) {
                String[] lineItems = line.split("<TD>"); //splitting the line and adding its items in String[]
                data.add(lineItems); //adding the split line array to the ArrayList
            }
        } catch (Exception e) {
            System.out.println("Something went wrong loading html file");
        }
        data.forEach(array -> System.out.println(Arrays.toString(array)));
        return data;
    }

        @SuppressWarnings("unchecked")
    public static void loadJSONFile(ObservableList<Item> dataList, String absolutePath) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(absolutePath)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray itemList = (JSONArray) obj;

            //Iterate over employee array
            itemList.forEach(emp -> parseItemObject((JSONObject) emp, dataList));

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void parseItemObject(JSONObject item, ObservableList dataList) {
        //Get item object within list
        JSONObject employeeObject = (JSONObject) item.get("item");

        //Get item first name
        dataList.add(new Item((String) employeeObject.get("value"),
                (String) employeeObject.get("serialNumber"),
                (String) employeeObject.get("name")));
    }
}
