import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        // LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Istanbul");
        placesToVisit.add(0, "Bodrum");

        // Add Elements
        placesToVisit.addFirst("Kayseri");
        placesToVisit.addLast("Hatay");
        System.out.println(placesToVisit);

        // Add Queue methods
        placesToVisit.offer("Izmir");
        placesToVisit.offerFirst("Kocali");
        placesToVisit.offerLast("Bursa");
        System.out.println(placesToVisit);

        // Add Stack Methods
        placesToVisit.push("Antalya");
        System.out.println(placesToVisit);

        // Remove
        placesToVisit.remove(1);
        placesToVisit.remove("Hatay");
        placesToVisit.remove();
        placesToVisit.removeFirst();
        placesToVisit.removeLast();
        System.out.println(placesToVisit);

        // Remove stack
        placesToVisit.pop();
        System.out.println(placesToVisit);

        // Getting Elements
        System.out.println(placesToVisit.get(0));
        System.out.println(placesToVisit.getFirst());
        System.out.println(placesToVisit.getLast());
        System.out.println(placesToVisit.indexOf("Istanbul"));
        System.out.println(placesToVisit.lastIndexOf("Istanbul"));

        // Queue get
        System.out.println(placesToVisit.element());

        // Stack get
        System.out.println(placesToVisit.peek());
        System.out.println(placesToVisit.peekFirst());
        System.out.println(placesToVisit.peekLast());
        System.out.println(placesToVisit);

        // List Iteration
        ListIterator<String> iterator = placesToVisit.listIterator(1);
        while (iterator.hasNext()) {
            var city = iterator.next();
        }

        testIterator(placesToVisit);
    }

    private static void testIterator(LinkedList<String> list) {
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println("next iterator -> " + iterator.next());
            if (iterator.next().equals("Izmir")) {
                iterator.remove();
                iterator.add("Izmit");
                iterator.add("Kocali");
                iterator.add("Bursa");

            }
        }
        System.out.println(list);
    }
}
