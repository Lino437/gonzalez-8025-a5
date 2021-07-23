/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

/*
    Value     Serial Number   Name
    $399.00   AXB124AXY3      Xbox One
    $599.99   S40AZBDE47      Samsung TV
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemFormatTest {

    @Test
    void toFormattedValue() {
        List<String> values = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> actual = new ArrayList<>();

        values.add("$399.00");
        values.add("99.99");
        values.add("599.9873");

        expected.add("$399.00");
        expected.add("$99.99");
        expected.add("$599.99");

        for (String value : values) {
            actual.add(ItemFormat.toFormattedValue(value));
        }

        assertEquals(expected, actual);
    }

    @Test
    void toFormattedSerialNumber() {
        List<String> serialNumber = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> actual = new ArrayList<>();

        serialNumber.add("hello63727");
        serialNumber.add("Axb124AXY3");
        serialNumber.add("s40AZbDE47");
        serialNumber.add("abcdefghij");

        expected.add("HELLO63727");
        expected.add("AXB124AXY3");
        expected.add("S40AZBDE47");
        expected.add("ABCDEFGHIJ");

        for (String s : serialNumber) {
            actual.add(ItemFormat.toFormattedSerialNumber(s));
        }

        assertEquals(expected, actual);
    }
}