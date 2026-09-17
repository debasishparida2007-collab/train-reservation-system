package reservation.models;

public class Train {
    private String trainId;
    private String name;
    private String source;
    private String destination;
    private int availableSeats;

    public Train(String trainId, String name, String source, String destination, int seats) {
        this.trainId = trainId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.availableSeats = seats;
    }

    public String getTrainId() { return trainId; }
    public String getName() { return name; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }

    public synchronized boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s to %s) | Seats: %d", trainId, name, source, destination, availableSeats);
    }
    
    public String toCSV() {
        return trainId + "," + name + "," + source + "," + destination + "," + availableSeats;
    }
}