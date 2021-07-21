/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 first_name last_name
 */
package ucf.assignments;

import javafx.scene.control.Alert;

public class AlertManager {
    public static void alertValue() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Value Validator");
        alert.setHeaderText("Enter a number value");

        alert.showAndWait();
    }

    public static void alertSerialNumber() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Serial Number Validator");
        alert.setHeaderText("Enter a unique Serial Number\n" +
                "Format XXXXXXXXXX where X is a letter or digit");

        alert.showAndWait();
    }

    public static void alertDuplicateSerialNumber() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Duplicate Serial Number");
        alert.setHeaderText("Serial number is duplicated\n" +
                "Try another Serial Number");

        alert.showAndWait();
    }

    public static void alertName() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Name Validator");
        alert.setHeaderText("Enter a name between 2 and 256 characters");

        alert.showAndWait();
    }

    // alert for help
    public static void alertHelp() {
        // Open new Window
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setResizable(true);
        alert.setContentText(helpText());
        alert.showAndWait();
    }

    // This is the help String for message
    public static String helpText() {
        String str = "**Help: 3 step guide to perform each behavior on the application**\n" +
                "\n" +
                "Add Item\n" +
                "1. Fill the boxes below which correspond to each of the attributes (Value, Serial Number, Name)\n" +
                "2. Click Button called \"Add Item\" to include it to the table\n" +
                "3. A new Item should appear on the bottom of the table\n" +
                "\n" +
                "Delete Item\n" +
                "1. Select an item to be deleted on the table\n" +
                "2. Click the Button delete to delete Item\n" +
                "3. The deleted Item should be deleted from table\n" +
                "\n" +
                "Edit Text (Value, Serial Number, Name)\n" +
                "1. Double-click on \"Text\" to be edited\n" +
                "2. Update the text of the Item\n" +
                "3. Click \"enter\" key, the text should be updated\n" +
                "\n" +
                "Search Item by Serial Number and Name\n" +
                "1. Select the \"search bar\" on the top right of the App\n" +
                "2. Update the text of the search field\n" +
                "3. The table will update by every character entered\n" +
                "\n" +
                "To see this again\n" +
                "1. Click Help menu on the top left of the page\n" +
                "2. Click About\n" +
                "3. This file should appear on a new window\n";
        return str;
    }
}
