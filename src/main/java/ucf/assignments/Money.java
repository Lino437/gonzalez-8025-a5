/*
 * UCF COP3330 Summer 2021 Assignment 5 Solution
 * Copyright 2021 first_name last_name
 */

package ucf.assignments;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.CollationElementIterator;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Money {
    public static void main(String[] args) {

            BigDecimal modelVal = new BigDecimal("24.99");
            BigDecimal displayVal = modelVal.setScale(2, RoundingMode.HALF_EVEN);
            NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
            usdCostFormat.setMinimumFractionDigits( 1 );
            usdCostFormat.setMaximumFractionDigits( 2 );
            System.out.println( usdCostFormat.format(displayVal.doubleValue()) );

    }
}
