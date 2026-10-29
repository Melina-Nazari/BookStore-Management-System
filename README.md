# BookStore Management Application

A Java Swing desktop bookstore application originally developed for **COE 528 – Object-Oriented Analysis & Design** at Toronto Metropolitan University (Winter 2026). This repository organizes the recovered original source files for sharing and includes a small fix to the loyalty-points redemption calculation.

## Features

- Owner (`admin` / `admin`) and customer sign-in
- Owner book and customer account management
- Customer book selection, purchasing, and points redemption
- Silver membership below 1,000 points; Gold at 1,000 or more
- State interface and `SilverState` / `GoldState` implementations
- Single-window Java Swing interface with `CardLayout`
- Plain-text file persistence in `books.txt` and `customers.txt` on window close

## Requirements

Java JDK 8 or newer. No third-party dependencies, Maven, or Gradle required.

## Run

From the repository root:

```sh
mkdir -p out
javac -d out src/*.java
java -cp out BookStoreApp
```

Or open the source files in NetBeans or VS Code with Java support.

## Try it

1. Log in as owner using `admin` / `admin`.
2. Add a few books and create a customer with a fictional username and password.
3. Log out and sign in as that customer.
4. Select books and use **Buy** or **Redeem points and Buy**.
5. Close the window and relaunch to check saved records.

## Project structure

- `src/BookStoreApp.java`: Swing screens, navigation, purchase workflow
- `src/BookStore.java`, `src/Book.java`, `src/Customer.java`: domain objects and operations
- `src/State.java`, `src/SilverState.java`, `src/GoldState.java`: loyalty membership states
- `src/DataStore.java`: text-file loading and saving
- `tests/BookStoreSmokeTest.java`: dependency-free checks of basic domain and persistence behavior

## Run basic checks

```sh
mkdir -p out
javac -d out src/*.java tests/*.java
java -cp out BookStoreSmokeTest
```

These checks do not exercise the graphical UI. Manually verify the GUI workflow before describing the application as fully tested.


## Limitations and security

This is an **educational project**, not production e-commerce software. Passwords are stored in plaintext, and the owner uses a hard-coded demo login. Do **not** enter real passwords or customer data. Local `.txt` data files are excluded from Git. The application uses `double` for prices, which is not appropriate for production financial calculations. The GUI and purchase edge cases require further testing.
