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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFileManager {
    // select correct file and write to it in adequate format
    public static void writeToFile(ObservableList<Item> dataList, String absolutePath) {
        String extension = FilenameUtils.getExtension(absolutePath);

        switch (extension) {
            case "txt" -> writeToTSVFile(dataList, absolutePath);
            case "html" -> writeToHTMLFile(dataList, absolutePath);
            case "json" -> writeToJSONFile(storeDataJSONArray(dataList), absolutePath);
        }
    }

    // this method get filepath for an item to save
    public static String fileChooserSave() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files (*.html)", "*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json"));

        File file = fileChooser.showSaveDialog(null);
        String absolutePath = "";

        if (file != null) {
            absolutePath = file.getAbsolutePath();
        }
        return absolutePath;
    }

    // get data from tableView
    public static void writeToTSVFile(ObservableList<Item> dataList, String absolutePath) {
        try {
            FileWriter fos = new FileWriter(absolutePath);
            PrintWriter dos = new PrintWriter(fos);
            dos.println("Value\tSerial Number\tName\t");

            // loop through all your data and print it to the file
            for (Item item : dataList) {
                dos.print(item.getValue() + "\t");
                dos.print(item.getSerialNumber() + "\t");
                dos.print(item.getName() + "\t");
                dos.println();
            }
            dos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error Printing Tab Delimited File");
        }
    }

    // write to html file in table format
    public static void writeToHTMLFile(ObservableList<Item> dataList, String absolutePath) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(absolutePath));
            pw.println("<TABLE BORDER><TR><TH>Value<TH>Serial Number<TH>Name</TR>");
            for (Item item : dataList) {
                pw.println("<TR><TD>" + item.getValue()
                        + "<TD>" + item.getSerialNumber()
                        + "<TD>" + item.getName());
            }
            pw.println("</TABLE>");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // write to json file
    public static void writeToJSONFile(JSONArray itemList, String absolutePath) {
        //Write JSON file
        try (FileWriter file = new FileWriter(absolutePath)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(itemList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // add data to json array
    @SuppressWarnings("unchecked")
    public static JSONArray storeDataJSONArray(ObservableList<Item> dataList) {
        //json file structure
        JSONArray itemList = new JSONArray();

        for (Item item : dataList) {
            // set item values
            JSONObject itemDetails = new JSONObject();
            JSONObject itemObject = new JSONObject();
            itemDetails.put("value", item.getValue());
            itemDetails.put("serialNumber", item.getSerialNumber());
            itemDetails.put("name", item.getName());
            itemObject.put("item", itemDetails);
            //Add items to list
            itemList.add(itemObject);
        }

        return itemList;
    }
}
