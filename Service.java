package com.mycompany.servicebookingapp;

// Concept 2: Abstraction
public abstract class Service implements Discountable {
    protected String serviceName;
    protected double basePrice;
    protected ServiceType type; // Concept 3: Enum used as a field

    public Service(String serviceName, double basePrice, ServiceType type) {
        this.serviceName = serviceName;
        this.basePrice = basePrice;
        this.type = type;
    }

    //  Abstract Method
    public abstract double calculateFinalPrice();

    //  Non-abstract method to be overridden
    public void printSummary() {
        System.out.println("Service: " + serviceName + " | Type: " + type);
    }

    //  Method Overloading (Version 1)
    public void displayDetails() {
        System.out.println("Details: " + serviceName + " [" + type + "]");
    }

    //  Method Overloading (Version 2 - different parameters)
    public void displayDetails(boolean showPrice) {
        displayDetails();
        if (showPrice) {
            System.out.println("Base Price: $" + basePrice);
        }
    }

    //  Implementation of Interface method
    @Override
    public double applyDiscount(double percentage) {
        return basePrice - (basePrice * (percentage / 100));
    }
}
