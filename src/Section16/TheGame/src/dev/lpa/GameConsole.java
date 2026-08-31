package dev.lpa;

import java.util.Scanner;

public class GameConsole {
    private final String username;

    {
        var scanner = new Scanner(System.in);
        System.out.printf("Enter your username: ");
        username = scanner.nextLine();
        System.out.println("Hello, " + username);
    }

    public String getUsername() {
        return username;
    }
}
