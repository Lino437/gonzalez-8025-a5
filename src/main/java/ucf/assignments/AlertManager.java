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

}
