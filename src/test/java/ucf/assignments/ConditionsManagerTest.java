/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
    Value     Serial Number   Name
    $399.00   AXB124AXY3      Xbox One
    $599.99   S40AZBDE47      Samsung TV
 */


class ConditionsManagerTest {

    @Test
    @DisplayName("true is an invalid value and false is valid")
    void validateValue() {
        List<String> values = new ArrayList<>();
        List<Boolean> expected = new ArrayList<>();
        List<Boolean> actual = new ArrayList<>();

        values.add("$399.00");
        values.add("$599.99");
        values.add("Hello World");
        values.add("");

        expected.add(false);
        expected.add(false);
        expected.add(true);
        expected.add(true);

        for (int i = 0; i < values.size(); i++) {
            actual.add(ConditionsManager.validateValue(values.get(i)));
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("true is an invalid value and false is valid")
    void validateSerialNumber() {
        List<String> serialNumber = new ArrayList<>();
        List<Boolean> expected = new ArrayList<>();
        List<Boolean> actual = new ArrayList<>();

        serialNumber.add("AXB124AXY3");
        serialNumber.add("S40AZBDE47");
        serialNumber.add("Hello Worl");
        serialNumber.add("");

        expected.add(false);
        expected.add(false);
        expected.add(true);
        expected.add(true);

        for (int i = 0; i < serialNumber.size(); i++) {
            actual.add(ConditionsManager.validateSerialNumber(serialNumber.get(i)));
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("true is an invalid value and false is valid")
    void validateName() {
        List<String> name = new ArrayList<>();
        List<Boolean> expected = new ArrayList<>();
        List<Boolean> actual = new ArrayList<>();

        name.add("Xbox One");
        name.add("Samsung TV");
        name.add("wudvbiuerbvfierbvciorhbvourbvcoruhbvcudnbvcuidnbvcoidnhcgtngnynjhyjhynynynyntnbodn" +
                "coidhcoiuwehiuchiuwedochowech08wc80ef320f2349fu0834hvc03rhnvcidwhcowidhc0oiwhdcidhc" +
                "lkegfhieuvghfoiergfergfbiruefhurfhurbvfnuorbviurbvourbnvoirnvcoinriovnriovrivhirvni" +
                "uytfigohjf3h4gw98cedbiaceut4rwn9v384t oirjuv8gtwurp9u3w4t8b674b9754ug8hrgfhirfhirji");
        name.add("");

        expected.add(false);
        expected.add(false);
        expected.add(true);
        expected.add(true);

        for (int i = 0; i < name.size(); i++) {
            actual.add(ConditionsManager.validateName(name.get(i)));
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("true is an invalid serial Number because is duplicated and false is valid")
    void validateDuplicateSerialNumber() {
        ObservableList<Item> dataList = FXCollections.observableArrayList();

        dataList.add(new Item("$149.99", "HUIJO89012", "Play Station 3"));
        dataList.add(new Item("$399.39", "AXB124AXY3", "Samsung TV"));
        dataList.add(new Item("$599.59", "S40AZBDE47", "Xbox One"));
        dataList.add(new Item("$119.99", "1234567890", "Dell Monitor"));
        dataList.add(new Item("$99.99", "0987654321", "Logitech Keyboard"));

        assertEquals(true, ConditionsManager.validateDuplicateSerialNumber("0987654321", dataList));
        assertEquals(true, ConditionsManager.validateDuplicateSerialNumber("HUIJO89012", dataList));
        assertEquals(false, ConditionsManager.validateDuplicateSerialNumber("GDVCYIU373", dataList));
        assertEquals(false, ConditionsManager.validateDuplicateSerialNumber("HUINWNCEBW", dataList));
    }

    @Test
    @DisplayName("true is on list and false the value is not on the list")
    void searchBox() {
        ObservableList<Item> dataList = FXCollections.observableArrayList();

        dataList.add(new Item("$149.99", "HUIJO89012", "Play Station 3"));

        assertEquals(true, ConditionsManager.searchBox("", dataList.get(0)));
        assertEquals(true, ConditionsManager.searchBox("play", dataList.get(0)));
        assertEquals(false, ConditionsManager.searchBox(" random", dataList.get(0)));
        assertEquals(false, ConditionsManager.searchBox(" another random", dataList.get(0)));

    }

    @Test
    @DisplayName("true is a valid absolutePath and false invalid")
    void validateAbsolutePath() {
        assertEquals(false, ConditionsManager.validateAbsolutePath(""));
        assertEquals(false, ConditionsManager.validateAbsolutePath(" "));
        assertEquals(true, ConditionsManager.validateAbsolutePath("D:\\hello.txt"));
        assertEquals(true, ConditionsManager.validateAbsolutePath("D:\\hello.json"));

    }
}