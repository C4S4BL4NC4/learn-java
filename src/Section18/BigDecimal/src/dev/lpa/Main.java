package dev.lpa;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        double policyAmount = 100_000_000;
        int beneficiaries = 3;
        float percentageFloat = 1.0f / beneficiaries;
        double percentage = 1.0 / beneficiaries;

        System.out.println("percentage = " + percentage);
        System.out.println("percentageFloat = " + percentageFloat);

        double totalUsingFloat = policyAmount - ((policyAmount * percentageFloat) * beneficiaries);
        System.out.println("totalUsingFloat = " + totalUsingFloat); // -2.980...

        double totalUsing = policyAmount - ((policyAmount * percentage) * beneficiaries);
        System.out.println("totalUsing = " + totalUsing); // 0

        // BIG DECIMAL CLASS FOR BANKING APPS

        String[] tests = {".123", "8", "1000.00001", "15.456"};
        BigDecimal[] bds = new BigDecimal[tests.length];

        Arrays.setAll(bds, i -> new BigDecimal(tests[i]));
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");

        for (var bd : bds) {
            System.out.printf("%-14s %-15s %-8s %s%n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        double[] doubles = {.123, 8, 1000.00001, 15.456};
        BigDecimal[] bdsD = new BigDecimal[doubles.length];
        System.out.println("---------------------------------");
        Arrays.setAll(bdsD, i -> BigDecimal.valueOf(doubles[i]));
//        Arrays.setAll(bdsD, i -> new BigDecimal(doubles[i]));
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");

        for (var bd : bdsD) {
            System.out.printf("%-14s %-15s %-8s %s%n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        System.out.println("---------------------------------");

        var test1 = new BigDecimal("1.1111122222333334444455555");
        var test2 = BigDecimal.valueOf(2.4444455555666667777788888); // Chops of precision
        System.out.printf("%-30s %-30s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");
        System.out.printf("%-30s %-30s %-8s %s%n", test1, test1.unscaledValue(), test1.scale(), test1.precision());

        System.out.printf("%-30s %-30s %-8s %s%n", test2, test2.unscaledValue(), test2.scale(), test2.precision());

        System.out.println("---------------------------------");
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale", "Precision");
        for (var bd : bdsD) {
            System.out.printf("%-14s %-15s %-8s %s%n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.printf("%-14s %-15s %-8s %s%n", bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        var policyPayout = new BigDecimal("100000000");
        System.out.printf("%-14s %-15s %-8s %s%n", policyPayout, policyPayout.unscaledValue(), policyPayout.scale(), policyPayout.precision());

//        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.DECIMAL128);
        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), new MathContext(60, RoundingMode.UP));
        System.out.println("percent = " + percent);

        System.out.println("---------------------------------");

        BigDecimal checkAmount = policyPayout.multiply(percent);
        System.out.printf("%.2f%n", checkAmount);
        checkAmount = checkAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.printf("%-14s %-15s %-8s %s%n", checkAmount, checkAmount.unscaledValue(), checkAmount.scale(), checkAmount.precision());

        System.out.println("---------------------------------");

        BigDecimal totalCheckAmount = checkAmount.multiply(BigDecimal.valueOf(beneficiaries));
        System.out.printf("Combined: %.2f%n", totalCheckAmount);
        System.out.println("Remaining: " + policyPayout.subtract(totalCheckAmount));

    }
}
