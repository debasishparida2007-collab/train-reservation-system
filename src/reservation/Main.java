package reservation;

import reservation.controllers.BookingManager;
import reservation.controllers.AdminController;
import reservation.models.Ticket;
import reservation.exceptions.InvalidBookingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingManager bookingManager = new BookingManager();
        AdminController adminController = new AdminController(bookingManager);
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("  Terminal Train Reservation System      ");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Search Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Admin: View All Trains");
            System.out.println("4. Admin: Add New Train");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter Source City: ");
                        String src = scanner.nextLine().trim();
                        System.out.print("Enter Destination City: ");
                        String dest = scanner.nextLine().trim();
                        bookingManager.displayAvailableTrains(src, dest);
                        break;
                    case "2":
                        System.out.print("Enter Train ID (e.g., T101): ");
                        String trainId = scanner.nextLine().trim();
                        System.out.print("Enter Passenger Name: ");
                        String name = scanner.nextLine().trim();
                        
                        if (name.isEmpty()) {
                            System.out.println("Error: Name cannot be empty.");
                            break;
                        }
                        
                        Ticket ticket = bookingManager.bookTicket(trainId, name);
                        ticket.printTicket();
                        break;
                    case "3":
                        adminController.viewAllTrains();
                        break;
                    case "4":
                        System.out.print("Enter New Train ID: ");
                        String newId = scanner.nextLine().trim();
                        System.out.print("Enter Train Name: ");
                        String newName = scanner.nextLine().trim();
                        System.out.print("Enter Source: ");
                        String newSrc = scanner.nextLine().trim();
                        System.out.print("Enter Destination: ");
                        String newDest = scanner.nextLine().trim();
                        System.out.print("Enter Total Seats: ");
                        int seats = Integer.parseInt(scanner.nextLine().trim());
                        adminController.addTrain(newId, newName, newSrc, newDest, seats);
                        break;
                    case "5":
                        running = false;
                        System.out.println("Exiting system. Have a great journey!");
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 5.");
                }
            } catch (InvalidBookingException e) {
                System.out.println("\n" + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("\nError: Please enter valid numeric values for seats.");
            } catch (Exception e) {
                System.out.println("\nAn unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}