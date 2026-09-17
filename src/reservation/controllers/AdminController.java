package reservation.controllers;

import reservation.models.Train;

public class AdminController {
    private BookingManager bookingManager;

    public AdminController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void viewAllTrains() {
        System.out.println("\n--- All System Trains ---");
        for (Train t : bookingManager.getAllTrains()) {
            System.out.println(t.toString());
        }
    }
    
    public void addTrain(String id, String name, String src, String dest, int seats) {
        bookingManager.getAllTrains().add(new Train(id, name, src, dest, seats));
        bookingManager.saveTrains();
        System.out.println("Train successfully added!");
    }
}