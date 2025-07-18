package org.montano.java.swing.jdbc.utils;

import javax.swing.*;

public class IsNumber {
    public static int tryConvertToInt(JTextField field){
        int number = 0;
        try {
            number = Integer.parseInt(field.getText());
        } catch (NumberFormatException e){}

        return number;
    }

    public static double tryConvertToDouble(JTextField field){
        double number = 0;
        try {
            number = Double.parseDouble(field.getText());
        } catch (NumberFormatException e){}

        return number;
    }
}
