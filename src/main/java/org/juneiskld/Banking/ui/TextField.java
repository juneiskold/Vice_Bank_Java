package org.juneiskld.Banking.ui;

import javax.swing.JTextField;

public class TextField extends JTextField {
    public TextField(int columns) {
        super(columns);
    }

    public String getInput() {
        return getText().trim();
    }

    public void clearInput() {
        setText("");
    }
}