public class InvoiceSummaryDTO {

    private final int numOfRides;
    private final double totalFare;
    private final double avgFare;

    public InvoiceSummaryDTO(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.avgFare = this.totalFare / this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummaryDTO that = (InvoiceSummaryDTO) o;
        return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avgFare, avgFare) == 0;
    }

    @Override
    public String toString() {
        return "InvoiceSummaryDTO{" +
                "numOfRides=" + numOfRides +
                ", totalFare=" + totalFare +
                ", avgFare=" + avgFare +
                '}';
    }

    public int getNumOfRides() {
        return numOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAvgFare() {
        return avgFare;
    }
}