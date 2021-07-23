/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadFileManagerTest {
    // try-catch block to handle exceptions
    private static String getAbsolutePath(String path) {
        String absolute = null;
        try {
            // Create a file object
            File f = new File(path);

            // Get the absolute path of file f
            absolute = f.getAbsolutePath();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return absolute;
    }

    @Test
    void tsvFileReader() {
        String absolute = getAbsolutePath("testtsv.txt");
        ArrayList<String[]> expected = new ArrayList<>();
        ArrayList<String[]> actual = LoadFileManager.tsvFileReader(absolute);

        ObservableList<Item> item = FXCollections.observableArrayList();

        item.add(new Item("Value", "Serial Number", "Name"));
        item.add(new Item("$149.99", "HUIJO89012", "Play Station 3"));
        item.add(new Item("$399.39", "AXB124AXY3", "Samsung TV"));

        for (Item value : item) {
            expected.add(new String[]{
                    value.getValue(),
                    value.getSerialNumber(),
                    value.getName()
            });
        }

        String[] tempExpect = expected.get(0);
        String[] tempActual = actual.get(0);

        assertEquals(tempExpect[0], tempActual[0]);
        assertEquals(tempExpect[1], tempActual[1]);
        assertEquals(tempExpect[2], tempActual[2]);

        tempExpect = expected.get(1);
        tempActual = actual.get(1);

        assertEquals(tempExpect[0], tempActual[0]);
        assertEquals(tempExpect[1], tempActual[1]);
        assertEquals(tempExpect[2], tempActual[2]);

        tempExpect = expected.get(2);
        tempActual = actual.get(2);

        assertEquals(tempExpect[0], tempActual[0]);
        assertEquals(tempExpect[1], tempActual[1]);
        assertEquals(tempExpect[2], tempActual[2]);
    }

    @Test
    void htmlFileReader() {
        String absolute = getAbsolutePath("testhtml.html");
        ArrayList<String[]> expected = new ArrayList<>();
        ArrayList<String[]> actual = LoadFileManager.htmlFileReader(absolute);

        ObservableList<Item> item = FXCollections.observableArrayList();

        item.add(new Item("$149.99", "HUIJO89012", "Play Station 3"));
        item.add(new Item("$399.39", "AXB124AXY3", "Samsung TV"));
        item.add(new Item("$599.59", "S40AZBDE47", "Xbox One"));

        for (Item value : item) {
            expected.add(new String[]{
                    value.getValue(),
                    value.getSerialNumber(),
                    value.getName()
            });
        }

        String[] tempExpect = expected.get(0);
        String[] tempActual = actual.get(1);

        assertEquals(tempExpect[0], tempActual[1]);
        assertEquals(tempExpect[1], tempActual[2]);
        assertEquals(tempExpect[2], tempActual[3]);

        tempExpect = expected.get(1);
        tempActual = actual.get(2);

        assertEquals(tempExpect[0], tempActual[1]);
        assertEquals(tempExpect[1], tempActual[2]);
        assertEquals(tempExpect[2], tempActual[3]);

        tempExpect = expected.get(2);
        tempActual = actual.get(3);

        assertEquals(tempExpect[0], tempActual[1]);
        assertEquals(tempExpect[1], tempActual[2]);
        assertEquals(tempExpect[2], tempActual[3]);
    }
}