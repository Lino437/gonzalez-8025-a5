/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Iterator;

class SaveFileManagerTest {
    private String getAbsolutePath(String filePath) {
        String absolute = "";
        // try-catch block to handle exceptions
        try {

            // Create a file object
            File f = new File(filePath);

            // Get the absolute path of file f
            absolute = f.getAbsolutePath();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return absolute;
    }

    @Test
    void storeDataJSONArray() {
//        ObservableList<Item> dataList = FXCollections.observableArrayList();
//        JSONArray jsonArray = SaveFileManager.storeDataJSONArray(dataList);
//        JSONArray expected = new JSONArray();
//
//        dataList.add(new Item("$149.99", "HUIJO89012", "Play Station 3"));
//        dataList.add(new Item("$399.39", "AXB124AXY3", "Samsung TV"));
//        dataList.add(new Item("$599.59", "S40AZBDE47", "Xbox One"));
//        dataList.add(new Item("$119.99", "1234567890", "Dell Monitor"));
//        dataList.add(new Item("$99.99", "0987654321", "Logitech Keyboard"));
//
//
//
////        for (Item item : dataList) {
////            // set item values
////            JSONObject itemDetails = new JSONObject();
////            JSONObject itemObject = new JSONObject();
////            itemDetails.put("value", item.getValue());
////            itemDetails.put("serialNumber", item.getSerialNumber());
////            itemDetails.put("name", item.getName());
////            itemObject.put("item", itemDetails);
////            //Add items to list
////            expected.add(itemObject);
////        }
////
//        String absolutePath = getAbsolutePath("TrackingInventory\\src\\test\\resources\\testtsv.txt");
//        SaveFileManager.writeToFile(dataList, absolutePath);
//
//        assertEquals

    }
}