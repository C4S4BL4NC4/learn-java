record BaseballPlayer (String name, String position){}
public class GenericsTut {
    public static void main(String[] args) {
        System.out.println("========================");
        BaseballTeam phillies = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Huston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(marsh);
        phillies.addTeamMember(harper);

        phillies.listTeamMembers();
    }

    public static void scoreResult(BaseballTeam team1, int t1Score, BaseballTeam team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s. %n", team1, message, team2);
    }
}
