package dev.lpa;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        System.setProperty("user.timezone", "GMT");
        System.out.println("ZoneId.systemDefault() = " + ZoneId.systemDefault());
        System.out.println(
            "ZoneId.getAvailableZoneIds().size() = " + ZoneId.getAvailableZoneIds().size()
        );

        ZoneId.getAvailableZoneIds()
            .stream()
            .filter(tz -> tz.startsWith("US"))
            .sorted()
            .map(ZoneId::of)
            .forEach(z -> System.out.println(z.getId() + ":" + z.getRules()));

        System.out.println("-----------------------------");

        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldWay = new HashSet<>(Set.of(alternate));

        jdk8Zones.removeAll(oldWay);
        System.out.println("jdk8Zones = " + jdk8Zones);
        System.out.println("oldWay = " + oldWay);
        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println("bet = " + bet);

        System.out.println("-----------------------------");
        // instant class used to timestamps

        var now = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println(now);
        Instant instantNow = Instant.now();
        System.out.println(instantNow);

        System.out.println("-----------------------------");

        for (ZoneId z : List.of(
            ZoneId.of("Australia/Sydney"),
            ZoneId.of("Europe/Paris"),
            ZoneId.of("America/Los_Angeles")
        )) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("z:zzzz");
            System.out.println(z);
            System.out.println("\t" + instantNow.atZone(z).format(formatter));
            System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
            System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));

            Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
            LocalDateTime dob = LocalDateTime.ofInstant(dobInstant, ZoneId.systemDefault());
            System.out.println(
                "Birthday in LA time is : " +
                    dob.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
            );

            ZonedDateTime dobSydney = ZonedDateTime.ofInstant(
                dobInstant,
                ZoneId.of("Australia/Sydney")
            );
            System.out.println(
                "dobSydney = " +
                    dobSydney.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
            );

            ZonedDateTime dobHere = ZonedDateTime.ofInstant(dobInstant, ZoneId.systemDefault());
            System.out.println("dobHere = " + dobHere);

            ZonedDateTime firstOfMonth = ZonedDateTime.now().with(
                TemporalAdjusters.firstDayOfNextMonth()
            );
            System.out.println(
                "firstOfMonth = " +
                    firstOfMonth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
            );

            Period timePast = Period.between(LocalDate.EPOCH, dob.toLocalDate());
            System.out.println("timePast = " + timePast);

            Duration timeSince = Duration.between(Instant.EPOCH, dob.toInstant(ZoneOffset.UTC));
            System.out.println("timeSince = " + timeSince);

            System.out.println("-----------------------------");

            LocalDateTime dob2 = dob
                .plusYears(1)
                .plusDays(2)
                .plusDays(10)
                .plusHours(10)
                .plusMinutes(30)
                .plusSeconds(38);

            System.out.println(
                "Birthday in second kid LA time is : " +
                    dob2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
            );

            Period timePast2 = Period.between(LocalDate.EPOCH, dob2.toLocalDate());
            System.out.println("timePast2 = " + timePast2);

            Duration timeSince2 = Duration.between(Instant.EPOCH, dob2.toInstant(ZoneOffset.UTC));
            System.out.println("timeSince2 = " + timeSince2);

            System.out.println("-----------------------------");

            for (ChronoUnit unit : ChronoUnit.values()) {
                if (unit.isSupportedBy(LocalDate.EPOCH)) {
                    long val = unit.between(LocalDate.EPOCH, dob2.toLocalDate());
                    System.out.println(unit + " past = " + val);
                } else {
                    System.out.println("-- Not Supported: " + unit);
                }
            }

            System.out.println("-----------------------------");

            LocalDateTime ldt = LocalDateTime.ofInstant(Instant.EPOCH, ZoneOffset.UTC);

            for (ChronoUnit unit : ChronoUnit.values()) {
                if (unit.isSupportedBy(LocalDate.EPOCH)) {
                    long val = unit.between(ldt, dob2);
                    System.out.println(unit + " past = " + val);
                } else {
                    System.out.println("-- Not Supported: " + unit);
                }
            }
        }
    }
}
