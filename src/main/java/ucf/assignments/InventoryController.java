/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 first_name last_name
 */

/*
Using IntelliJ and Gradle, you will create a GUI-based desktop application to allow a user to track their personal inventory.

The program should allow you to enter an item, a serial number, and estimated value.
 The program should then be able to display a tabular report of the data that looks like this:

    Value     Serial Number   Name
    $399.00   AXB124AXY3      Xbox One
    $599.99   S40AZBDE47      Samsung TV

The program should also allow the user to export the data as either a tab-separated value (TSV) file, or as a HTML file.
 When exported as an HTML file, the data should be stored inside of a table structure to mimic the displayed appearance.

You will be responsible for both the design (UML diagrams) and implementation (production and test code) of this application

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
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {


    // configure the table
    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> valueColumn;
    @FXML
    private TableColumn<Item, String> serialNumberColumn;
    @FXML
    private TableColumn<Item, String> nameColumn;

    // variable for new Item Object
    @FXML
    private TextField valueTextField;
    @FXML
    private TextField serialNumberTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField searchTextField;


    public final ObservableList<Item> dataList = FXCollections.observableArrayList();


    public void changeValueCellEvent(TableColumn.CellEditEvent<Item, String> itemStringCellEditEvent) {
    }

    public void changeSerialNumberCellEvent(TableColumn.CellEditEvent<Item, String> itemStringCellEditEvent) {
    }

    public void changeNameCellEvent(TableColumn.CellEditEvent<Item, String> itemStringCellEditEvent) {
    }

    public void newFileClicked(ActionEvent actionEvent) {

    }

    public void saveAsClicked(ActionEvent actionEvent) {
    }

    public void loadClicked(ActionEvent actionEvent) {
    }

    public void closeClicked(ActionEvent actionEvent) {
    }

    public void helpClicked(ActionEvent actionEvent) {
    }

    public void searchButton(ActionEvent actionEvent) {
    }

    public void removeItem(ActionEvent actionEvent) {
    }

    public void AddNewItem(ActionEvent actionEvent) {
        if (ConditionsManager.validateValue(valueTextField.getText())) {
            AlertManager.alertValue();
        } else if (ConditionsManager.validateSerialNumber(serialNumberTextField.getText())) {
            AlertManager.alertSerialNumber();
        } else if (ConditionsManager.validateDuplicateSerialNumber(serialNumberTextField.getText(), dataList)) {
            AlertManager.alertDuplicateSerialNumber();
        } else if (ConditionsManager.validateName(nameTextField.getText())) {
            AlertManager.alertName();
        } else {
            Item newItem = new Item(ItemFormat.toFormattedValue(valueTextField.getText()),
                    ItemFormat.toFormattedSerialNumber(serialNumberTextField.getText()),
                    nameTextField.getText());

            valueTextField.setText("$");
            serialNumberTextField.setText("");
            nameTextField.setText("");

            // get all the items from the table list, then add the new Item
            dataList.add(newItem);
            tableView.getItems().add(newItem);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set up the columns in the table
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // load data
        tableView.setItems(getPeople());

        // Allowing description and to be editable
        tableView.setEditable(true);
        valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        serialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // This allows the multiple rows to be selected
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    // This method will return an ObservableList of Item objects
    @FXML
    public ObservableList<Item> getPeople() {
        ObservableList<Item> item = FXCollections.observableArrayList();
        ObservableList<Item> sampleList = FXCollections.observableArrayList();

        sampleList.add(new Item("$149.99", "HUIJO89012", "Play Station 3"));
        sampleList.add(new Item("$399.00", "AXB124AXY3", "Samsung TV"));
        sampleList.add(new Item("$599.99", "S40AZBDE47", "XBOX ONE"));
        sampleList.add(new Item("$119.99", "1234567890", "Dell Monitor"));
        sampleList.add(new Item("$99.99", "0987654321", "Logitech Keyboard"));

        item.addAll(sampleList);
        dataList.addAll(sampleList);

        return item;
    }

    public void searchSerialNumberNewLetter(KeyEvent keyEvent) {
    }
}
