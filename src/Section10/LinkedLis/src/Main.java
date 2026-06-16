import java.util.LinkedList;

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
    }
}
