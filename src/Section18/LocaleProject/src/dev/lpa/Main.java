package dev.lpa;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        Locale.setDefault(Locale.US);
        System.out.println("Locale.getDefault() = " + Locale.getDefault());

        System.out.println("----------------------------------");

        Locale en = new Locale("en");
        Locale enUS = new Locale("en", "US");
        Locale enCA = new Locale("en", "CA");

        Locale enIN = new Locale.Builder().setLanguage("en").setRegion("IN").build();
        Locale enNZ = new Locale.Builder().setLanguage("en").setRegion("NZ").build();
        Locale trTR = new Locale.Builder().setLanguage("tr").setRegion("TR").build();
        Locale arIQ = new Locale.Builder().setLanguage("ar").setRegion("IQ").build();

        var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        for (var l : List.of(
            enUS,
            enCA,
            enIN,
            enNZ,
            trTR,
            Locale.UK,
            Locale.GERMANY,
            Locale.FRENCH,
            arIQ
        )) {
            System.out.println(
                l.getDisplayName() + " = " + LocalDateTime.now().format(dtf.withLocale(l))
            );
        }

        System.out.println("----------------------------------");

        var wdayMonth = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");

        LocalDate May5th = LocalDate.of(2020, 5, 5);
        for (var locale : List.of(Locale.CANADA, Locale.CHINA, Locale.GERMANY, Locale.FRANCE)) {
            System.out.println(
                locale.getDisplayName() +
                    " : " +
                    locale.getDisplayName(locale) +
                    "=\n\t" +
                    May5th.format(wdayMonth.withLocale(locale))
            );

            var decimalInfo = NumberFormat.getNumberInstance(locale);
            System.out.println(decimalInfo.format(6000000.12345));

            var currency = NumberFormat.getCurrencyInstance(locale);
            Currency localCurr = Currency.getInstance(locale);

            System.out.println(
                currency.format(555.555) +
                    " [" +
                    localCurr.getCurrencyCode() +
                    "] " +
                    localCurr.getDisplayName(locale) +
                    "/" +
                    localCurr.getDisplayName()
            );
        }

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter amount: ");
        scanner.useLocale(Locale.ITALY);
        var amount = scanner.nextBigDecimal();
        var decimalInfo = NumberFormat.getNumberInstance(Locale.ITALY);
        System.out.println("My loan = " + decimalInfo.format(amount));
    }
}
