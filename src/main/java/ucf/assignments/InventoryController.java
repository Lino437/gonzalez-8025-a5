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

   x The user shall interact with the application through a Graphical User Interface
   x The user shall be able to store at least 100 inventory items
      x  Each inventory item shall have a value representing its monetary value in US dollars
      x  Each inventory item shall have a unique serial number in the format of XXXXXXXXXX where X can be either a letter or digit
      x  Each inventory item shall have a name between 2 and 256 characters in length (inclusive)
   x The user shall be able to add a new inventory item
       x The application shall display an error message if the user enters an existing serial number for the new item
   x The user shall be able to remove an existing inventory item
   x The user shall be able to edit the value of an existing inventory item
   x The user shall be able to edit the serial number of an existing inventory item
       x The application shall prevent the user from duplicating the serial number
   x The user shall be able to edit the name of an existing inventory item
   x The user shall be able to sort the inventory items by value
   x The user shall be able to sort inventory items by serial number
   x The user shall be able to sort inventory items by name
   x The user shall be able to search for an inventory item by serial number
   x The user shall be able to search for an inventory item by name
   x The user shall be able to save their inventory items to a file
       x The user shall be able to select the file format from among the following set of options: TSV (tab-separated value), HTML, JSON
           x TSV files shall shall list one inventory item per line, separate each field within an inventory item using a tab character,
             and end with the extension .txt
           x HTML files shall contain valid HTML and end with the extension .html
           x JSON files shall contain valid JSON and end with the extension .json
       x The user shall provide the file name and file location of the file to save
   x The user shall be able to load inventory items from a file that was previously created by the application.
       x The user shall provide the file name and file location of the file to load
 */
package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

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


    public void changeValueCellEvent(TableColumn.CellEditEvent editedCell) {
        // if value entered does not meet condition, pop alert
        if (ConditionsManager.validateValue(editedCell.getNewValue().toString())) {
            AlertManager.alertValue();
        } else {
            Item itemSelected = tableView.getSelectionModel().getSelectedItem();
            dataList.remove(itemSelected);

            itemSelected.setValue(ItemFormat.toFormattedValue(editedCell.getNewValue().toString()));
            dataList.add(itemSelected);

        }
    }

    public void changeSerialNumberCellEvent(TableColumn.CellEditEvent editedCell) {
        // if value entered does not meet condition, pop alert
        if (ConditionsManager.validateSerialNumber(editedCell.getNewValue().toString())) {
            AlertManager.alertSerialNumber();
        } else if (ConditionsManager.validateDuplicateSerialNumber(editedCell.getNewValue().toString(), dataList)) {
            AlertManager.alertDuplicateSerialNumber();
        } else {
            Item itemSelected = tableView.getSelectionModel().getSelectedItem();
            dataList.remove(itemSelected);

            itemSelected.setValue(ItemFormat.toFormattedSerialNumber(editedCell.getNewValue().toString()));
            dataList.add(itemSelected);
        }
    }

    public void changeNameCellEvent(TableColumn.CellEditEvent editedCell) {
        // if value entered does not meet condition, pop alert
        if (ConditionsManager.validateName(editedCell.getNewValue().toString())) {
            AlertManager.alertName();
        } else {
            Item itemSelected = tableView.getSelectionModel().getSelectedItem();
            dataList.remove(itemSelected);

            itemSelected.setValue(editedCell.getNewValue().toString());
            dataList.add(itemSelected);
        }
    }

    public void saveAsClicked(ActionEvent actionEvent) {
        String absolutePath = SaveFileManager.fileChooserSave();

        // if valid absolutePath  to data on file
        if (ConditionsManager.validateAbsolutePath(absolutePath)) {
            SaveFileManager.writeToFile(dataList, absolutePath);
        }
    }

    public void loadClicked(ActionEvent actionEvent) {
        String absolutePath = LoadFileManager.fileChooserLoad();

        // update dataList to data on file
        if (ConditionsManager.validateAbsolutePath(absolutePath)) {
            dataList.remove(0, dataList.size());
            LoadFileManager.loadFile(dataList, absolutePath);
        }
    }

    public void closeClicked(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    public void helpClicked(ActionEvent actionEvent) {
        AlertManager.alertHelp();
    }

    public void removeItem(ActionEvent actionEvent) {
        // delete selected item
        Item item = tableView.getSelectionModel().getSelectedItem();
        dataList.remove(item);
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

            valueTextField.clear();
            serialNumberTextField.clear();
            nameTextField.clear();

            // get all the items from the table list, then add the new Item
            dataList.add(newItem);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set up the columns in the table
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // load predefined data
        getPeople();

        // Allowing description and to be editable
        tableView.setEditable(true);
        valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        serialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        FilteredList<Item> filteredData = new FilteredList<>(dataList, b -> true);

        searchTextField.textProperty().addListener((observable, oldValue, newValue) ->
                filteredData.setPredicate(item -> ConditionsManager.searchBox(newValue, item)));

        SortedList<Item> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(sortedData);
    }

    // This method will return an ObservableList of Item objects
    @FXML
    public void getPeople() {
        ObservableList<Item> item = FXCollections.observableArrayList();

        item.add(new Item("$149.99", "HUIJO89012", "Play Station 3"));
        item.add(new Item("$399.39", "AXB124AXY3", "Samsung TV"));
        item.add(new Item("$599.59", "S40AZBDE47", "Xbox One"));
        item.add(new Item("$119.99", "1234567890", "Dell Monitor"));
        item.add(new Item("$99.99", "0987654321", "Logitech Keyboard"));

        dataList.addAll(item);
    }
}
