public class Ride {
    public int time;
    public double distance;
    private boolean isPremium;


    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "time=" + time +
                ", distance=" + distance +
                '}';
    }
}