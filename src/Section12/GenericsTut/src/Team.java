import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String coutnryCode) {
    @Override
    public String toString() {
        return name + " (" + type + " in " + coutnryCode + ")";
    }
}

public class Team<T extends Player, S> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
        this.affiliation = null;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {
        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {
        System.out.println(teamName + "'s Roster:");
        System.out.println((affiliation == null ? "" : "AFFILIATION: " + affiliation));
        System.out.println(teamMembers);
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins++;
            return message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            return message = "tied";
        } else {
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + "(Ranked " + ranking() + ")";
    }
}
