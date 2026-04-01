public class Main {

    public static void main(String[] args) {
        Player player = new Player("Tim", 20, "Sword");

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer alice = new EnhancedPlayer("Alice");
        System.out.println("Initial health is " + alice.healthRemaining());

        Printer G3010 = new Printer(50, false);
        G3010.printPages(50);
        G3010.addToner(150);
    }
}
