/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

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
    @DisplayName("This test 4 values, for which true is an invalid value and false is valid")
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
    @DisplayName("This test 4 values, for which true is an invalid value and false is valid")
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
    @DisplayName("This test 4 values, for which true is an invalid value and false is valid")
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
}