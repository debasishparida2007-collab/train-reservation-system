# Terminal-Based Train Ticket Reservation System

Terminal-Based Train Ticket Reservation System developed using pure Java (without any external libraries/frameworks) as part of the project for the Java Course, VITyarthi "Build Your Own Project".

## Description
This project is a simulation of a real-time railway booking system. It operates entirely via the command-line interface, enabling passengers to search for train routes, check real-time seat availability, and book tickets. It also allows administrators to manage train inventory, utilizing thread-safe operations to prevent double-booking and keeping a record of generated tickets.

## Key Features
*   Creation and management of users (Passengers and Administrators).
*   Dynamic route searching based on source and destination cities.
*   Thread-safe ticket booking utilizing Java synchronization to lock seat availability.
*   Automated text-based ticket generation and itinerary formatting.
*   Custom checked exceptions for invalid train IDs, overbooking scenarios, and invalid input formats.
*   File-based data storage for train inventory and passenger records to persist state between runs.
*   Strictly terminal-based execution with no GUI dependencies.

## Technologies / Tools Used
*   The Java 21 edition builds on the standard edition with support for the `java.io`, `java.util`, `java.util.concurrent`, and `java.time` libraries.
*   No external dependencies or third-party frameworks.

## Project Structure
```text
train-reservation-system/
├── src/
│   └── reservation/
│       ├── Main.java
│       ├── models/
│       │   ├── Train.java
│       │   ├── User.java
│       │   ├── Passenger.java
│       │   └── Ticket.java
│       ├── controllers/
│       │   ├── BookingManager.java
│       │   └── AdminController.java
│       └── exceptions/
│           └── InvalidBookingException.java
├── data/
│   └── train_data.csv
├── README.md
└── statement.md
```
How to Install and Run
Install Java 21+ (JDK): See which version of Java is installed by running java -version in your terminal/command prompt.

Go into the project folder:

```text
cd train-reservation-system
```
Compile the source code:

```text
javac -d out src/reservation/Main.java src/reservation/models/*.java src/reservation/controllers/*.java src/reservation/exceptions/*.java
```
Run the compiled application:

```text
java -cp out reservation.Main
```

How to Test
The project was hand-tested with a series of commands being executed in the console to ensure that all features are functioning properly. The following steps have been carried out:

Launched the application and navigated the main menu to select the "Search Trains" option.

Entered valid source and destination cities (e.g., Delhi to Mumbai) and confirmed that available trains and seat counts were displayed.

Selected the "Book Ticket" option and entered a valid Train ID and passenger name, verifying that a formatted ticket was printed to the console.

Searched for the same train again to confirm that the available seat count decreased by exactly one.

Attempted to book a ticket using a non-existent Train ID to check that the InvalidBookingException correctly displayed an error message without crashing the program.

Attempted to book more seats than available on a specific train to ensure the system rejected the booking due to insufficient capacity.

Closed the program and re-opened it to ensure train capacities and ticket histories were populated properly from the file storage.
