package consumer.spicific;

import dev.lpa.generic.BaseClass;

public class ChildClass extends BaseClass {


    // Static method hiding
//    public static void recommendedStaticMethod() {
//        System.out.println("[ChildClass.recommendedStaticMethod()] Best way to hide and statically do it.");
//        optionalStaticMethod();
//        mandatoryStaticMethod();
//    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[Child.recommendedMethod()] I'll do things my way!");
//        optionalMethod();
//    }

    @Override
    protected void optionalMethod() {
        System.out.println("[Child.optionalMethod()] Extra stuff happened");
        super.optionalMethod();
    }
}
