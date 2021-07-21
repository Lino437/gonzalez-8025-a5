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
        return """
                **Help: 3 step guide to perform each behavior on the application**

                Add Item
                1. Fill the boxes below which correspond to each of the attributes (Value, Serial Number, Name)
                2. Click Button called "Add Item" to include it to the table
                3. A new Item should appear on the bottom of the table

                Delete Item
                1. Select an item to be deleted on the table
                2. Click the Button delete to delete Item
                3. The deleted Item should be deleted from table

                Edit Text (Value, Serial Number, Name)
                1. Double-click on "Text" to be edited
                2. Update the text of the Item
                3. Click "enter" key, the text should be updated

                Search Item by Serial Number and Name
                1. Select the "search bar" on the top right of the App
                2. Update the text of the search field
                3. The table will update by every character entered

                To see this again
                1. Click Help menu on the top left of the page
                2. Click About
                3. This information should appear on a new window
                """;
    }
}
