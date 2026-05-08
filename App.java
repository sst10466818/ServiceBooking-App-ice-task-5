package com.mycompany.servicebookingapp;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service currentBooking = null;

        while (true) {
            System.out.println("\n--- Service Booking Menu ---");
            System.out.println("1. Create New Booking");
            System.out.println("2. View Booking Summary");
            System.out.println("3. Apply Discount & Exit");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine()); // Concept 1: Parsing logic

                if (choice == 1) {
                    System.out.print("Enter Service Name: ");
                    String name = sc.nextLine();

                    // Custom Validation & Exception Handling
                    System.out.print("Enter Base Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    if (price < 0) throw new IllegalArgumentException("Price cannot be negative!");

                    System.out.println("Select Type: 1. BASIC, 2. STANDARD, 3. PREMIUM");
                    int typeChoice = Integer.parseInt(sc.nextLine());
                    
                    //  Mapping input to Enum values
                    ServiceType selectedType;
                    switch (typeChoice) {
                        case 1 -> selectedType = ServiceType.BASIC;
                        case 3 -> selectedType = ServiceType.PREMIUM;
                        default -> selectedType = ServiceType.STANDARD;
                    }

                    currentBooking = new PremiumService(name, price, selectedType);
                    System.out.println("Booking Created Successfully.");

                } else if (choice == 2) {
                    if (currentBooking == null) {
                        System.out.println("No booking found. Please create one first.");
                    } else {
                        //  Demonstrate Overridden Method
                        currentBooking.printSummary(); 
                        
                        // Demonstrate Overloaded Methods
                        currentBooking.displayDetails();
                        currentBooking.displayDetails(true);
                    }
                } else if (choice == 3 || choice == 4) {
                    if (choice == 3 && currentBooking != null) {
                        double discounted = currentBooking.applyDiscount(10);
                        
                        //  Type Casting
                        // Widening: int to double
                        double finalTotal = currentBooking.calculateFinalPrice();
                        // Narrowing: double to int (Rounding for display)
                        int roundedTotal = (int) finalTotal; 
                        
                        System.out.println("Discounted Base Price: $" + discounted);
                        System.out.println("Final Total (incl. fees): $" + finalTotal);
                        System.out.println("Total Whole Units: " + roundedTotal);
                    }
                    System.out.println("Exiting Application...");
                    break;
                } else {
                    System.out.println("Invalid Menu Option.");
                }

            } catch (NumberFormatException e) { // Concept 1: Catching parsing errors
                System.out.println("Error: Please enter a valid numeric value.");
            } catch (IllegalArgumentException e) { // Concept 1: Catching custom validation
                System.out.println("Validation Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        sc.close();
    }
}
