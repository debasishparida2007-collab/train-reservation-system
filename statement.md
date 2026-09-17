# Problem Statement
The current manual and legacy processes for booking train tickets are inefficient and prone to data inconsistencies, often resulting in double-booking errors due to a lack of real-time capacity tracking[cite: 1]. There is a critical need for a lightweight, highly reliable system that can process concurrent ticketing requests accurately without relying on heavy graphical interfaces. 

# Scope of the Project
This project is a terminal-based Train Ticket Reservation System built entirely in Java[cite: 1]. The scope encompasses three major functional modules: User Management for handling different access levels, Booking CRUD operations for searching and reserving seats, and an Automated Reporting system for generating ticket itineraries[cite: 1]. The system handles transactions safely and utilizes file-based storage to persist data across sessions.

# Target Users
*   **Passengers:** Users who need a quick and reliable way to search for available trains between cities, check seat availability, and book tickets[cite: 1].
*   **Administrators:** Users responsible for managing the backend inventory of available trains, routes, and overall seating capacities[cite: 1].

# High-Level Features
1.  **Terminal-Based Navigation:** Fully operable via command-line prompts.
2.  **Dynamic Route Searching:** Ability to filter available trains by source and destination[cite: 1].
3.  **Thread-Safe Seat Reservation:** Utilizes Java synchronization to lock seats during the booking process, ensuring reliability and preventing double-booking.
4.  **Automated Ticket Generation:** Creates and displays a formatted text-based ticket upon successful transaction.
5.  **Data Persistence:** Uses file storage to save train inventory and user booking history between application runs.
