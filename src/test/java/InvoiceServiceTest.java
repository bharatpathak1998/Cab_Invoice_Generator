import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @BeforeEach
    void setUp() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalPremiumFare() {
        double distance = 8.0;
        int time = 12;
        double fare = invoiceService.calculateFare(distance, time, true);
        Assertions.assertEquals(144, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalNormalFare() {
        double distance = 8.0;
        int time = 12;
        double fare = invoiceService.calculateFare(distance, time, false);
        Assertions.assertEquals(92, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnPremiumMinFare() {
        double distance = 0.2;
        int time = 2;
        double totalFare = invoiceService.calculateFare(distance, time, true);
        Assertions.assertEquals(20, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnNormalMinFare() {
        double distance = 0.2;
        int time = 2;
        double totalFare = invoiceService.calculateFare(distance, time, false);
        Assertions.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(8.0, 12),
                new Ride(0.2, 2)
        };
        InvoiceSummaryDTO summary = invoiceService.calculateFare(List.of(rides));
        InvoiceSummaryDTO expectedInvoiceSummary = new InvoiceSummaryDTO(2, 97.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void addRidesForUsers_ShouldReturnTrue() {
        RidesRepository ridesRepository = new RidesRepository();
        ridesRepository.addRideForUser(new Ride(8.0, 12), "1");
        ridesRepository.addRideForUser(new Ride(4.0, 9), "1");
        ridesRepository.addRideForUser(new Ride(2.0, 6), "1");
        ridesRepository.addRideForUser(new Ride(3.0, 7), "2");
        System.out.println(ridesRepository.map);
    }

    @Test
    public void getRidesOfUsers_ShouldReturnHistory() {
        RidesRepository ridesRepository = new RidesRepository();
        ridesRepository.addRideForUser(new Ride(8.0, 12), "1");
        ridesRepository.addRideForUser(new Ride(4.0, 9), "1");
        ridesRepository.addRideForUser(new Ride(2.0, 6), "1");
        List<Ride> rideForUser = ridesRepository.getRideForUser("1");
        Assertions.assertEquals(3, rideForUser.size());
    }

    @Test
    public void getRidesOfUsers_ShouldReturnDTO() {
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addRidesForUser("1", new Ride(8.0, 12));
        invoiceService.addRidesForUser("1", new Ride(4.0, 9));
        invoiceService.addRidesForUser("1", new Ride(2.0, 6));
        InvoiceSummaryDTO invoiceSummaryDTO = invoiceService.calculateFare("1");
        Assertions.assertEquals(3, invoiceSummaryDTO.getNumOfRides());
        Assertions.assertEquals(167.0, invoiceSummaryDTO.getTotalFare());
        Assertions.assertEquals(55.666666666666664, invoiceSummaryDTO.getAvgFare());
        System.out.println(invoiceSummaryDTO);
    }
}