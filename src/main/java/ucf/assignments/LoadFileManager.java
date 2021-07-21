/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

import javafx.stage.FileChooser;

import java.io.File;

public class LoadFileManager {
    // this method get filepath for an item to load
    public static String fileChooserLoad() {
        FileChooser fileChooser = new FileChooser();

        // set fileChooser
        fileChooser.setTitle("Load File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files (*.html)", "*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json"));

        File file = fileChooser.showOpenDialog(null);
        String absolutePath = null;

        if (file != null) {
            absolutePath = file.getAbsolutePath();
        }
        return absolutePath;
    }



}
