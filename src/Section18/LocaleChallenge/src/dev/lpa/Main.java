package dev.lpa;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        LocalDateTime date = LocalDateTime.now();

        var jane = new Employee("Jane", Locale.US, "America/New_York");
        var joe = new Employee("Joe", "en-AU", "Australia/Sydney");

        var janeRules = jane.zoneId.getRules();
        var joeRules = joe.zoneId.getRules();

        System.out.println(jane + " " + janeRules);
        System.out.println(joe + " " + joeRules);

        int days = 10;

        var map = schedule(joe, jane, days);
        var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);

        for (LocalDate ldt : map.keySet()) {
            System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
            for (ZonedDateTime zdt : map.get(ldt)) {
                System.out.println(
                    "\t" +
                        jane.getDateInfo(zdt, dtf) +
                        " <--> " +
                        joe.getDateInfo(zdt.withZoneSameInstant(joe.zoneId()), dtf)
                );
            }
        }
    }

    private static Map<LocalDate, List<ZonedDateTime>> schedule(
        Employee firstEmployee,
        Employee secondEmployee,
        int days
    ) {
        Predicate<ZonedDateTime> rules = zdt ->
            zdt.getDayOfWeek() != DayOfWeek.SATURDAY &&
            zdt.getDayOfWeek() != DayOfWeek.SUNDAY &&
            zdt.getHour() >= 7 &&
            zdt.getHour() < 18;

        LocalDate startingDate = LocalDate.now().plusDays(2);

        return startingDate
            .datesUntil(startingDate.plusDays(days + 1))
            .map(dt -> dt.atStartOfDay(firstEmployee.zoneId()))
            .flatMap(dt -> IntStream.range(0, 24).mapToObj(dt::withHour))
            .filter(rules)
            .map(dtz -> dtz.withZoneSameInstant(secondEmployee.zoneId()))
            .filter(rules)
            .collect(
                Collectors.groupingBy(ZonedDateTime::toLocalDate, TreeMap::new, Collectors.toList())
            );
    }

    private record Employee(String name, Locale locale, ZoneId zoneId) {
        public Employee(String name, String locale, String zoneId) {
            this(name, Locale.forLanguageTag(locale), ZoneId.of(zoneId));
        }

        public Employee(String name, Locale locale, String zoneId) {
            this(name, locale, ZoneId.of(zoneId));
        }

        String getDateInfo(ZonedDateTime zdt, DateTimeFormatter dtf) {
            return "%s [%s] : %s".formatted(name, zoneId, zdt.format(dtf.localizedBy(locale)));
        }
    }
}
