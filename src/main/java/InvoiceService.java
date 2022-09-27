import java.util.List;

public class InvoiceService {

    private static final double MIN_FARE = 5;
    private static final double MIN_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    RidesRepository ridesRepository = new RidesRepository();

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MIN_FARE);
    }

    public InvoiceSummaryDTO calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummaryDTO(rides.size(), totalFare);
    }

    public void addRidesForUser(String userID, Ride ride) {
        ridesRepository.addRideForUser(ride, userID);
    }

    public List<Ride> getRidesForUser(String userID) {
        return ridesRepository.getRideForUser(userID);
    }

    public InvoiceSummaryDTO calculateFare(String userID) {
        return calculateFare(getRidesForUser(userID));
    }
}