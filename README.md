# BookStore Management Application

A Java Swing desktop application developed as part of COE 528 – Object-Oriented Analysis & Design at Toronto Metropolitan University.

The application demonstrates object-oriented programming, GUI development, the State Design Pattern, and file-based data persistence through a bookstore management system.

## Features

- **Role-Based Authentication:** Separate Owner and Customer interfaces.
- **Inventory Management:** Owners can add and remove books and manage customer accounts.
- **Purchasing System:** Customers can browse, select, and purchase books.
- **Loyalty Rewards:** Customers earn and redeem points, with automatic transitions between Silver and Gold membership tiers.
- **State Design Pattern:** Uses a `State` interface with `SilverState` and `GoldState` implementations.
- **Data Persistence:** Stores and retrieves book and customer information using Java file I/O.
- **Graphical Interface:** Built with Java Swing and `CardLayout` for screen navigation.

## Technologies Used

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- State Design Pattern
- Java File I/O
- GUI Development

## Project Structure

- `BookStoreApp.java` – Graphical interface, navigation, and purchasing workflows
- `BookStore.java` – Bookstore operations and management
- `Book.java` – Book data model
- `Customer.java` – Customer accounts and loyalty points
- `State.java` – Loyalty state interface
- `SilverState.java` / `GoldState.java` – Membership state implementations
- `DataStore.java` – File-based data persistence

## How to Run

**Requirements:** Java JDK 8 or newer.

1. Clone or download the repository.
2. Open a terminal in the project directory.
3. Compile and run the application:

```bash
mkdir -p out
javac -d out src/*.java
java -cp out BookStoreApp
```

Alternatively, open the Java source files in NetBeans or VS Code with Java support.

## Application Workflow

1. Log in as Owner using the demo credentials (`admin` / `admin`).
2. Add books and create customer accounts.
3. Log out and sign in as a customer.
4. Select books and complete purchases.
5. Earn or redeem loyalty points.
6. Close and reopen the application to verify saved data.

