package reservation.controllers;

import reservation.models.Train;
import reservation.models.Ticket;
import reservation.exceptions.InvalidBookingException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Train> trains;
    private final String DATA_FILE = "../data/train_data.csv";

    public BookingManager() {
        trains = new ArrayList<>();
        loadTrains();
    }

    private void loadTrains() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            new File("../data").mkdirs();
            trains.add(new Train("T101", "Shatabdi Express", "Delhi", "Mumbai", 50));
            trains.add(new Train("T102", "Rajdhani Express", "Mumbai", "Delhi", 30));
            trains.add(new Train("T103", "Vande Bharat", "Delhi", "Bhopal", 45));
            saveTrains();
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    trains.add(new Train(data[0], data[1], data[2], data[3], Integer.parseInt(data[4])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading train data: " + e.getMessage());
        }
    }

    public void saveTrains() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Train t : trains) {
                bw.write(t.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving train data: " + e.getMessage());
        }
    }

    public void displayAvailableTrains(String source, String destination) {
        System.out.println("\n--- Available Trains ---");
        boolean found = false;
        for (Train t : trains) {
            if (t.getSource().equalsIgnoreCase(source) && t.getDestination().equalsIgnoreCase(destination)) {
                System.out.println(t.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No trains found for this route.");
        }
    }

    public Ticket bookTicket(String trainId, String passengerName) throws InvalidBookingException {
        for (Train t : trains) {
            if (t.getTrainId().equalsIgnoreCase(trainId)) {
                if (t.bookSeat()) {
                    saveTrains(); 
                    return new Ticket(passengerName, t);
                } else {
                    throw new InvalidBookingException("Booking Failed: No seats available on train " + trainId);
                }
            }
        }
        throw new InvalidBookingException("Booking Failed: Train ID '" + trainId + "' not found.");
    }
    
    public List<Train> getAllTrains() {
        return trains;
    }
}