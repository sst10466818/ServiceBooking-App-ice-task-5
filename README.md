# ServiceBooking-App-ice-task-5

## Project Overview

 This app simulates a **Service Booking System**, allowing users to create bookings, view detailed summaries, and apply discounts through a text-based menu.

 

## Key Technical Implementations

The project demonstrates the following six core Java concepts as required by the activity guidelines:

Exception Handling: Utilizes ` try-catch `  blocks to manage `NumberFormatException` during input parsing and implements custom validation using  `IllegalArgumentException`  for negative values.

Abstraction & Interfaces: Features an abstract superclass `Service` and a `Discountable` interface to define essential behaviors for the booking system.

Enum Implementation: Uses a `ServiceType` enum (`BASIC`, `STANDARD`, `PREMIUM`) to categorize bookings and control pricing logic.

Type Casting: Demonstrates widening casting during final price calculations and narrowing casting (`double`  to `int`) to display rounded total units.

Method Overloading: The `Service` class includes overloaded `displayDetails()` methods to provide different levels of information based on the arguments passed.

Method Overriding: The `PremiumService` subclass overrides the `printSummary()` method from the superclass to provide specialized output for high-tier bookings.


## Application Structure

* `App.java`: The main entry point containing the user menu, input logic, and exception handling.

* `Service.java`: Abstract superclass defining the core properties and overloaded methods.

* `PremiumService.java`: Subclass that extends `Service` and overrides the summary behavior.

* `ServiceType.java`: Enum defining the fixed service levels.

* `Discountable.java`: Interface for applying price reductions.


## How to Run

1. Open the project in **NetBeans** (ensure Maven is configured).

2. Right-click the project and select **Clean and Build** to prepare the environment.  

3. Run the `App.java` file.

4. Follow the console prompts to interact with the menu.
    
