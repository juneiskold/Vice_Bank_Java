package org.juneiskld.Banking.ui;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {
    private JPanel mainPanel;

    public UserInterface() {
        setTitle("Banking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);

        createMenuBar();
        createMainContent();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu accountMenu = new JMenu("Account");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(accountMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    private void createMainContent() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Accounts", createAccountsPanel());
        tabbedPane.addTab("Transactions", createTransactionsPanel());
        tabbedPane.addTab("Budget", createBudgetPanel());

        mainPanel.add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createAccountsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Accounts Panel"), BorderLayout.NORTH);
        // Add more components for accounts management
        return panel;
    }

    private JPanel createTransactionsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Transactions Panel"), BorderLayout.NORTH);
        // Add more components for transaction management
        return panel;
    }

    private JPanel createBudgetPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Budget Panel"), BorderLayout.NORTH);
        // Add more components for budget management
        return panel;
    }

    public void display() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}