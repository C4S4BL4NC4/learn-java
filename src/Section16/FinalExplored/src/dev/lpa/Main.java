package dev.lpa;

import consumer.spicific.ChildClass;
import dev.lpa.generic.BaseClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        var parent = new BaseClass();
        var child = new ChildClass();
        var childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("------------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("------------------------");
        child.recommendedMethod();

        System.out.println("------------------------");

        // RUNNING STATICS ON CLASS INSTANTS CAN CAUSE HIDDEN METHODS TO TRIGGER
        parent.recommendedStaticMethod();
        System.out.println("------------------------");
        childReferredToAsBase.recommendedStaticMethod();
        System.out.println("------------------------");
        child.recommendedStaticMethod();

        String xArgument = "This is what I have got to say about this section.";
        doXYZ(xArgument, 16);

    }

    public static void doXYZ(String x, int y) {
        final String c = x + " " + y;
        System.out.println("c = " + c);
    }
}
