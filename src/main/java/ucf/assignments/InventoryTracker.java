/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 first_name last_name
 */

package ucf.assignments;

/*
 Write a program that tracks your personal inventory. The program should allow you to enter an item,
 a serial number, and estimated value. The program should then be able to print out a tabular report
  in both HTML and CSV formats that looks like this:

Value     Serial Number   Name
$399.00   AXB124AXY       Xbox One
$599.99   S40AZBDE4       Samsung TV

Constraints

    Your application shall satisfy the following requirements:

    The user shall interact with the application through a Graphical User Interface
    The user shall be able to store at least 100 inventory items
        Each inventory item shall have a value representing its monetary value in US dollars
        Each inventory item shall have a unique serial number in the format of XXXXXXXXXX where X can be either a letter or digit
        Each inventory item shall have a name between 2 and 256 characters in length (inclusive)
    The user shall be able to add a new inventory item
        The application shall display an error message if the user enters an existing serial number for the new item
    The user shall be able to remove an existing inventory item
    The user shall be able to edit the value of an existing inventory item
    The user shall be able to edit the serial number of an existing inventory item
        The application shall prevent the user from duplicating the serial number
    The user shall be able to edit the name of an existing inventory item
    The user shall be able to sort the inventory items by value
    The user shall be able to sort inventory items by serial number
    The user shall be able to sort inventory items by name
    The user shall be able to search for an inventory item by serial number
    The user shall be able to search for an inventory item by name
    The user shall be able to save their inventory items to a file
        The user shall be able to select the file format from among the following set of options: TSV (tab-separated value), HTML, JSON
            TSV files shall shall list one inventory item per line, separate each field within an inventory item using a tab character, and end with the extension .txt
            HTML files shall contain valid HTML and end with the extension .html
            JSON files shall contain valid JSON and end with the extension .json
        The user shall provide the file name and file location of the file to save
    The user shall be able to load inventory items from a file that was previously created by the application.
        The user shall provide the file name and file location of the file to load
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InventoryTracker extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InventoryTracker.fxml")));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Inventory Tracker");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
