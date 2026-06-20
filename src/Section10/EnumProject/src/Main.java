import java.util.Random;

public class Main {
    static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            DaysOfTheWeek weekDay = getRandomDay();
            System.out.printf("Name = %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());
        }
    }

    public static DaysOfTheWeek getRandomDay() {
        int randomInt = new Random().nextInt(7);
        var allDays = DaysOfTheWeek.values();
        return allDays[randomInt];
    }
}
