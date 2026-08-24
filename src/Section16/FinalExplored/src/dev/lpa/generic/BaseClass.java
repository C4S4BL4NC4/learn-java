package dev.lpa.generic;

public class BaseClass {
    public final static void recommendedStaticMethod() {
        System.out.println("[BaseClass.recommendedStaticMethod()] Best way to statically do it.");
        optionalStaticMethod();
        mandatoryStaticMethod();
    }

    private static void mandatoryStaticMethod() {
        System.out.println("[BaseClass.mandatoryStaticMethod()] NON-NEGOTIABLE STATIC METHOD.");
    }

    protected static void optionalStaticMethod() {
        System.out.println("[BaseClass.optionalStaticMethod()] Optional static method.");
    }

    public final void recommendedMethod() {
        System.out.println("[BaseClass.recommendedMethod()] Best way to do it.");
        optionalMethod();
        mandatoryMethod();
    }

    private void mandatoryMethod() {
        System.out.println("[BaseClass.mandatoryMethod()] NON-NEGOTIABLE");
    }

    protected void optionalMethod() {
        System.out.println("[BaseClass.optionalMethod()] A Customizable method.");
    }
}
