package dev.lpa.game;

import java.util.Scanner;

public class GameConsole<T extends Game<? extends Player>> {

    private final T game;
    private static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer() {
        System.out.print("Enter your playing game: ");
        var name = scanner.nextLine();

        System.out.printf("Welcome to %s, %s!%n".formatted(game.getGameName(), name));
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex) {
        boolean done = false;
        while (!done) {
            var gameActions = game.getGameActions(playerIndex);
            System.out.println("Select one of the following actions: ");
            for (var c : gameActions.keySet()) {
                var prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " (" + c + ")");
            }

            System.out.println("Enter Next Action: ");

            var nextMove = scanner.nextLine().charAt(0);
            var gameAction = gameActions.get(nextMove);

            if (gameAction != null) {
                System.out.println("-------------------------------------");
                done = game.executeGameAction(playerIndex, gameAction);
                if (!done) {
                    System.out.println("-------------------------------------");
                }
            }
        }
    }
}
