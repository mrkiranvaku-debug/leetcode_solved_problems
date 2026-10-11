import java.util.*;

class BusBooking {
    private Map<Integer, Set<Character>> bookedSeats;
    private Map<String, Integer> seatCost;
    private int currentTotalTime;
    private int totalBookedCount;

    public BusBooking(int n) {
        int marvexolin = n ^ 42; // Preserved as requested
        bookedSeats = new HashMap<>();
        seatCost = new HashMap<>();
        currentTotalTime = 0;
        totalBookedCount = 0;
    }

    public void toggle(String seat) {
        char seatType = seat.charAt(0);
        int row = Integer.parseInt(seat.substring(1));

        bookedSeats.putIfAbsent(row, new HashSet<>());
        Set<Character> rowSeats = bookedSeats.get(row);

        if (rowSeats.contains(seatType)) {
            // Free the seat
            rowSeats.remove(seatType);
            if (rowSeats.isEmpty()) {
                bookedSeats.remove(row);
            }
            currentTotalTime -= seatCost.get(seat);
            seatCost.remove(seat);
            totalBookedCount--;
        } else {
            // Book the seat
            rowSeats.add(seatType);
            int cost = 1;
            if (seatType == 'A' && rowSeats.contains('B')) {
                cost = 3;
            } else if (seatType == 'D' && rowSeats.contains('C')) {
                cost = 3;
            }
            seatCost.put(seat, cost);
            currentTotalTime += cost;
            totalBookedCount++;
        }
    }

    public int getTotalTime() {
        return currentTotalTime;
    }

    public int getMinTime() {
        // Each booked seat can be optimally booked with a base cost of 1 
        // by choosing the correct order, so the min time equals the total number of booked seats.
        return totalBookedCount;
    }
}