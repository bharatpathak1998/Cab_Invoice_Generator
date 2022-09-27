public class Ride {
    public int time;
    public double distance;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }
    @Override
    public String toString() {
        return "Ride{" +
                "time=" + time +
                ", distance=" + distance +
                '}';
    }
}