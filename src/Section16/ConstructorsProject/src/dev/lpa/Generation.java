package dev.lpa;

public enum Generation {
    GEN_Z(1997, 2012),
    MILLENNIALS(1981, 1996),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1928, 1945),
    GREATEST_GENERATION(1901, 1927);

    Generation(int startYear, int endYear) {
        System.out.println("Inside of the enum constructor.");
    }
}
