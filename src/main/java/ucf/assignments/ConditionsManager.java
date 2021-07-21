/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 first_name last_name
 */
package ucf.assignments;

import javafx.collections.ObservableList;

import java.math.BigDecimal;


public class ConditionsManager {
    public static boolean validateValue(String text) {
        text = text.replace("$", "");
        try {
            new BigDecimal(text);
            return false;
        } catch (Exception e) {
            System.out.println("Big decimal conversion error");
            return true;
        }
    }

    public static boolean validateSerialNumber(String text) {
        // checks if the String is null
        if (text == null) {
            return true;
        }
        if (text.length() != 10) {
            return true;
        }
        for (int i = 0; i < text.length(); i++) {
            // if it is neither a letter nor a digit then it will return true
            if ((Character.isLetterOrDigit(text.charAt(i)) == false)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateDuplicateSerialNumber(String text, ObservableList<Item> dataList) {
        if (!validateSerialNumber(text)) {
            for (int i = 0; i < dataList.size(); i++) {
                String str = dataList.get(i).getSerialNumber();
                if (ItemFormat.toFormattedSerialNumber(text).equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateName(String text) {
        if (text.length() < 2 || text.length() > 256) {
            return true;
        }
        return false;
    }

    public static boolean searchBox(String newValue, Item item) {
        if (newValue == null || newValue.isEmpty()) {
            return true;
        }
        // compare the name and serial number to filter text
        String lowerCaseFilter = newValue.toLowerCase();

        if (item.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
            return true;
        } else if (item.getSerialNumber().toLowerCase().indexOf(lowerCaseFilter) != -1) {
            return true;
        } else {
            return false;
        }
    }
}
