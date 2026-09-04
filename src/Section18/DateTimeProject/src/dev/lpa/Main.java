package dev.lpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        LocalDate today = LocalDate.now();
        System.out.println("today = " + today); // today = 2026-09-04

        var Five5 = LocalDate.of(2018, 5, 5);
        System.out.println("Five5 = " + Five5);

        var may5th = LocalDate.of(2022, Month.MAY, 5);
        System.out.println("May 5th = " + may5th);

        var Day125 = LocalDate.ofYearDay(LocalDate.now().getYear(), 125);
        System.out.println("Day125 = " + Day125);

        var june1st = LocalDate.parse("2025-06-01");

        System.out.println("june1st.getDayOfWeek() = " + june1st.getDayOfWeek());
        System.out.println("june1st.getMonth() = " + june1st.getMonth());
        System.out.println("june1st.getYear() = " + june1st.getYear());

        System.out.println("june1st.getMonthValue() = " + june1st.getMonthValue());
        System.out.println("june1st.getDayOfYear() = " + june1st.getDayOfYear());

        System.out.println("june1st.get(ChronoField.MONTH_OF_YEAR) = " + june1st.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("june1st.get(ChronoField.DAY_OF_YEAR) = " + june1st.get(ChronoField.DAY_OF_YEAR));

        System.out.println(june1st.withYear(2000));
        System.out.println(june1st.withMonth(3));
        System.out.println(june1st.plusDays(365));
        System.out.println(june1st.plus(365, ChronoUnit.DAYS));

        System.out.println("May5 > today? " + may5th.isAfter(today));
        System.out.println("May5 < today? " + may5th.isBefore(today));
        System.out.println("May5 < today? " + may5th.compareTo(today));
        System.out.println("May5 < today? " + today.compareTo(may5th));
        System.out.println("Today = now? " + today.compareTo(LocalDate.now()));
        System.out.println("Today = now? " + today.equals(LocalDate.now()));

        System.out.println("----------------------------");
        may5th.datesUntil(may5th.plusDays(7)).forEach(System.out::println);

        System.out.println("----------------------------");
        may5th.datesUntil(may5th.plusMonths(1)).forEach(System.out::println);

//        System.out.println("----------------------------");
//        may5th.datesUntil(may5th.plusYears(1)).forEach(System.out::println);

        System.out.println("----------------------------");
        var time = LocalTime.now();
        System.out.println("time = " + time);

        var sevenAM = LocalTime.of(7, 0);
        System.out.println("sevenAM = " + sevenAM);

        var sevenThirty = LocalTime.of(7, 30);
        System.out.println("sevenThirty = " + sevenThirty);

        var sevenPM = LocalTime.parse("19:00");
        System.out.println("sevenPM = " + sevenPM);
        var sevenThirtyPM = LocalTime.parse("19:30:15.00123");
        System.out.println("sevenThirtyPM = " + sevenThirtyPM);
        System.out.println("sevenAM.get(ChronoField.AMPM_OF_DAY) = " + sevenAM.get(ChronoField.AMPM_OF_DAY));
        System.out.println("sevenThirtyPM.get(ChronoField.AMPM_OF_DAY) = " + sevenThirtyPM.get(ChronoField.AMPM_OF_DAY));

        System.out.println("sevenThirtyPM.plus(24,  ChronoUnit.HOURS) = " + sevenThirtyPM.plus(24, ChronoUnit.HOURS));
        System.out.println("sevenPM.range(ChronoField.HOUR_OF_DAY) = " + sevenPM.range(ChronoField.HOUR_OF_DAY));
        System.out.println("sevenPM.range(ChronoField.MINUTE_OF_HOUR) = " + sevenPM.range(ChronoField.MINUTE_OF_HOUR));
        System.out.println("sevenPM.range(ChronoField.MINUTE_OF_DAY) = " + sevenPM.range(ChronoField.MINUTE_OF_DAY));
        System.out.println("sevenPM.range(ChronoField.SECOND_OF_DAY) = " + sevenPM.range(ChronoField.SECOND_OF_DAY));
        System.out.println("sevenPM.range(ChronoField.SECOND_OF_MINUTE) = " + sevenPM.range(ChronoField.SECOND_OF_MINUTE));

        System.out.println("----------------------------");

        LocalDateTime todayAndNow = LocalDateTime.now();
        System.out.println("todayAndNow = " + todayAndNow);

        var jul5th = LocalDateTime.of(2026, 7, 5, 12, 0);
        System.out.printf("%tD %tr %n", jul5th, jul5th);
        System.out.printf("%1$tF %1$tT %n", jul5th);
        System.out.println("todayAndNow.format(DateTimeFormatter.BASIC_ISO_DATE) = " + todayAndNow.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("todayAndNow.format(DateTimeFormatter.ISO_WEEK_DATE) = " + todayAndNow.format(DateTimeFormatter.ISO_WEEK_DATE));

        var dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("todayAndNow.format(dtf) = " + todayAndNow.format(dtf));
        System.out.println("todayAndNow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) = "
                +
                todayAndNow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

        var towmorrow = todayAndNow.plusHours(24);
        System.out.println("towmorrow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) = "
                +
                towmorrow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
    }
}
