import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 8.0;
        int time = 12;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(92, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 0.2;
        int time = 2;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {
                new Ride(8.0, 12),
                new Ride(0.2, 2)
        };
        double fare = invoiceService.calculateFare(rides);
        Assertions.assertEquals(97, fare, 0.0);
    }
}