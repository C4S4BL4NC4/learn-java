public class Main {

    public static void main(String[] args) {
        System.out.println();
        Player player = new Player("Tim", 10, 100);
        Monster werewolf = new Monster("Werewolf", 20, 40);

        System.out.println(player.toString());
        System.out.println(werewolf.toString());
    }
}
