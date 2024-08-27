package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.bank.Bank;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminOperations {

    private static final Logger logger = Logger.getLogger(AdminOperations.class.getName());

    public static void performAdminOperations(Scanner scanner, Bank bank) {
