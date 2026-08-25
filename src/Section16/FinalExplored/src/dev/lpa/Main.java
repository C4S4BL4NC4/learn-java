package dev.lpa;

import consumer.spicific.ChildClass;
import dev.lpa.generic.BaseClass;
import external.util.Logger;

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
        StringBuilder zArgument = new StringBuilder("Only this section: ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("xArgument = " + xArgument);
        System.out.println("zArgument = " + zArgument);

        var tracker = new StringBuilder("Step 1: is abc");
        // logger edits the message so to counter that behavior we tracker.toString() defensive coding
        Logger.logToConsole(tracker.toString());
        tracker.append(", step 2 is xyz");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);

    }

    public static void doXYZ(String x, int y, final StringBuilder z) {
        final String c = x + y;
        System.out.println("c = " + c);
        x = c;
        z.append(y);
    }
}
