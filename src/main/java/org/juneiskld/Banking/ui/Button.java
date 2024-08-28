package org.juneiskld.Banking.ui;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Button extends JButton {
    public Button(String text, ActionListener listener) {
        super(text);
        addActionListener(listener);
    }
}