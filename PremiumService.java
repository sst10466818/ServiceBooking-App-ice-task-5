package com.mycompany.servicebookingapp;

public class PremiumService extends Service {
    private double luxuryTax = 50.0;

    public PremiumService(String serviceName, double basePrice, ServiceType type) {
        super(serviceName, basePrice, type);
    }

    //  Implementing Abstract Method
    @Override
    public double calculateFinalPrice() {
        // Adds a premium fee based on enum level
        double multiplier = (type == ServiceType.PREMIUM) ? 1.5 : 1.0;
        return (basePrice * multiplier) + luxuryTax;
    }

    //  Method Overriding
    @Override
    public void printSummary() {
        System.out.println(">>> PREMIUM BOOKING: " + serviceName.toUpperCase() + " (Includes Priority Support)");
    }
}
