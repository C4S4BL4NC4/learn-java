package dev.lpa.lambdaTypes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        int result = calculator((a , b) -> a + b, 4,6);
        var coords = Arrays.asList(
                new double[]{47.2, -17.3},
                new double[]{16.4, -23.6},
                new double[]{67.8, -54.7}
        );
        coords.forEach(coord -> System.out.println(Arrays.toString(coord)));

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("lat:%f lng:%f",lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
    }

    public static <T> T calculator(Operation<T> function, T val1, T val2) {
        T result = function.operate(val1, val2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer) {
        consumer.accept(t1, t2);
    }
}
