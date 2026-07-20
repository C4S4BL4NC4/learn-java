package dev.pregen;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {
    private String teamName;
    private List<Player> players = new ArrayList<>();
    private int losses, ties, wins = 0;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void addTeamMember(Player x) {
        if (!players.contains(x)) {
            players.add(x);
        }
    }

    public void listTeamMembers() {
        System.out.println(teamName + " Roster");
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

