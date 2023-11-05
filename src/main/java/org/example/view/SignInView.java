package org.example.view;
import java.util.Scanner;

public class SignInView {
    private final Scanner scanner;
    public SignInView() {
        this.scanner = new Scanner(System.in);
    }

    public String getEmailFromUser() {
        System.out.println("Please enter your email:");
        return scanner.nextLine();
    }

    public String getPasswordFromUser() {
        System.out.println("Please enter your password:");
        return scanner.nextLine();
    }
    public void displayLoginResult(boolean success, String message) {
        if (success) {
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Login failed: " + message);
        }
    }
    public String getRoleFromUser() {
        System.out.println("Are you an Admin or a User? (admin/user/exit):");
        return scanner.nextLine().trim().toLowerCase();
    }

    public String getActionFromUser() {
        System.out.println("Would you like to log in or register? (login/register):");
        return scanner.nextLine().trim().toLowerCase();
    }
}
