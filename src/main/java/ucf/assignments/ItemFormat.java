/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ItemFormat {

    public static String toFormattedValue(String value) {
        BigDecimal bd = null;

        value = value.replace("$", "");

        try {
            bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        } catch (Exception e) {
            System.out.println("Error converting to Big Decimal");
        }
        value = bd.toString();
        value = "$" + value;
        return value;
    }

    public static String toFormattedSerialNumber(String text) {
        String str = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                str += Character.toUpperCase(text.charAt(i));
            } else {
                str += text.charAt(i);
            }
        }
        return str;
    }
}
