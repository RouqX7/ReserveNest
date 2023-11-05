package org.example.view;

import java.util.Scanner;

public class SignUpView {
    private final Scanner scanner;

    public SignUpView() {
        this.scanner = new Scanner(System.in);
    }

    public String getEmailFromUser() {
        System.out.println("Please enter your email:");
        return scanner.nextLine().trim();
    }

    public String getPasswordFromUser() {
        System.out.println("Please enter a password:");
        return scanner.nextLine().trim();
    }

    public void showRegistrationSuccess(String userId) {
        System.out.println("Registration successful. Your user ID is: " + userId);
    }

    public void showRegistrationError(String message) {
        System.out.println("Registration failed: " + message);
    }

    public void showInvalidInputMessage(String inputType) {
        System.out.println("Invalid " + inputType + ". Please try again.");
    }
    public void displayRegistrationResult(boolean success, String message) {
        if (success) {
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Login failed: " + message);
        }
    }
}
