package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.game.ShooterGame;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");

        var console = new GameConsole<>(new ShooterGame("Shooter: The Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
