# Polynomial Calculator

A simple Polynomial Calculator built in Java that performs operations on polynomials, offering functionalities such as addition, subtraction, multiplication, division, derivation, and integration. The user interacts with the calculator through a dedicated graphical user interface (GUI).

## Table of Contents
- **Features**
- **Technologies Used**
- **Functional Requirements**
- **Non-Functional Requirements**
- **Project Structure**
- **Usage**
- **Examples**

---

## Features

- Intuitive GUI for polynomial input and operations selection
- Supports addition, subtraction, multiplication, division, derivation, and integration of polynomials
- Real-time display of results or error messages in case of invalid operations

---

## Technologies Used

- Java
- Swing for the GUI

--- 

## Functional Requirements

- User interface for easy interaction
- Polynomial input by the user in the form (+-)ax^b or (+-)axb (optional '' and '^')
- Operation selection from the interface
- Display of results after operations or error messages in case of failure

---

## Non-Functional Requirements

- User-friendly and intuitive interface
- High-performance operations with quick responses
- Efficient handling of polynomial operations
- Use of appropriate data structures (TreeMap) to store and manipulate polynomials

---

## Project Structure

- Polynomial Class
  - Converts polynomial strings into TreeMap and vice versa.
  - Key Methods:
    - getPolynomialMap(String input) - Parses the input string and returns a TreeMap.
    - toString(TreeMap<Integer, Double> polynomial) - Converts a TreeMap back into a polynomial string.
- Polynomial Operations Interface
  - Defines the operations that can be performed on polynomials:
    - add, sub, mul, div, derivative, integral
- Operations Class
  - Implements the PolynomialOperations interface and performs the operations:
    - add() - Adds two polynomials.
    - sub() - Subtracts one polynomial from another.
    - mul() - Multiplies two polynomials.
    - div() - Divides one polynomial by another, returning quotient and remainder.
    - derivative() - Calculates the derivative of a polynomial.
    - integral() - Calculates the integral of a polynomial.
- View Class
  - Handles the graphical user interface, enabling interaction with the calculator.
- Controller Class
  - Manage the interactions between the View and the Operations.
  - Manages input extraction, error handling, and invoking the appropriate operations.
- Main Class
  - Initializes the GUI and starts the application.

---

## Usage

- Enter two polynomials into the provided input fields.
- Select the desired operation.
- View the result or any error messages in the result box.

---

## Examples

- Example Input
  - +3x^2 -5x + 2
  - 2x^3 + 4x - 1
- Example Output
  - For add operation: +2x^3 +3x^2 -x + 1

 ---
 
