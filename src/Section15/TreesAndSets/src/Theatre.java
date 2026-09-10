import java.util.*;

public class Theatre {
    class Seat implements Comparable<Seat> {
        private boolean isOccupied;
        private String seatNumber;

        public Seat(char row, int number) {
            this.seatNumber = "%C%03d".formatted(row, number).toUpperCase();
            this.isOccupied = true;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNumber.compareTo(o.seatNumber);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    private String theatreName;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatsPerRow + (int)'A');
            int seatInRow = i % seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    public void printSeatMap() {
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n2$s Seat Map%n%1$s%n", separatorLine, theatreName);
        System.out.println(separatorLine);
    }
}
