import java.util.*;

public class RidesRepository {

    Map<String, List<Ride>> map = new HashMap();

    public Map<String, List<Ride>> addRideForUser(Ride ride, String userID) {
        if (map.containsKey(userID)) {
            List<Ride> rides = map.get(userID);
            rides.add(ride);
        } else {
            List<Ride> ride1 = new ArrayList<>();
            ride1.add(ride);
            map.put(userID, ride1);
        }
        return map;
    }

    public List<Ride> getRideForUser(String userID) {
        return map.containsKey(userID)? map.get(userID): Collections.emptyList();
    }
}