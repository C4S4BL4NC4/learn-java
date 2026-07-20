package dev.generics;

import dev.pregen.Player;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player, S> {
    private String teamName;
    private List<T> players = new ArrayList<>();
    private int losses, ties, wins = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public String getTeamName() {
        return teamName;
    }

    public void addTeamMember(T x) {
        if (!players.contains(x)) {
            players.add(x);
        }
    }

    public void listTeamMembers() {
        System.out.print(teamName + " Roster");
        System.out.println(affiliation == null ? "" : " AFFILIATION: " + affiliation);
        System.out.println(players);
    }

    public int ranking() {
        return (losses * 2) + ties + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";

        if (ourScore > theirScore) {
            wins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            ties++;
            message = "tied";
        } else {
            losses++;
        }

        return message;
    }

    @Override
    public String toString() {
        return teamName + " Ranked("+ ranking() + ")";
    }
}
