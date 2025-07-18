package org.montano.java.swing.jdbc.utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreateFormPanel extends JFrame {
    public static JPanel getFormPanel(String[] labels, ArrayList<JTextField> fields){
        JPanel formPanel = new JPanel(new GridLayout(4,2,20,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        for (int i = 0; i < labels.length; i++){
            formPanel.add(new JLabel(labels[i]));
            formPanel.add(fields.get(i));
        }

        formPanel.add(new JLabel(""));

        return formPanel;
    }
}
