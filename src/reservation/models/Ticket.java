package reservation.models;

import java.util.UUID;

public class Ticket {
    private String ticketId;
    private String passengerName;
    private Train train;

    public Ticket(String passengerName, Train train) {
        this.ticketId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.passengerName = passengerName;
        this.train = train;
    }

    public void printTicket() {
        System.out.println("\n========================================");
        System.out.println("          TICKET CONFIRMATION           ");
        System.out.println("========================================");
        System.out.println("Ticket ID : " + ticketId);
        System.out.println("Passenger : " + passengerName);
        System.out.println("Train     : " + train.getName() + " (" + train.getTrainId() + ")");
        System.out.println("Route     : " + train.getSource() + " -> " + train.getDestination());
        System.out.println("========================================\n");
    }
}