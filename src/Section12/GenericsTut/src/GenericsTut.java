interface Player {}

record BaseballPlayer(String name, String position) implements Player {}

record FootballPlayer(String name, String position) implements Player {}

public class GenericsTut {

    public static void main(String[] args) {
        var philly = new Affiliation("city", "Philadelphia, PA", "US");
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Huston Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Huston Astros");
        scoreResult(phillies2, 3, astros2, 5);

        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, String> astros = new Team<>("Huston Astros", "City Huston in TX, US");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");

        phillies.addTeamMember(marsh);
        phillies.addTeamMember(harper);
        phillies.listTeamMembers();
        astros.listTeamMembers();

        SportsTeam mancity = new SportsTeam("Manchester City");
        SportsTeam barcelona = new SportsTeam("FC Barcelona");
        var haaland = new FootballPlayer("Erling Haaland", "Central Forward");
        var yamal = new FootballPlayer("Lamine Yamal", "Central Forward");

        mancity.addTeamMember(haaland);
        mancity.addTeamMember(harper); // !!!
        barcelona.addTeamMember(yamal);
        barcelona.addTeamMember(marsh); // !!!
        scoreResult(barcelona, 2, mancity, 3);
        mancity.listTeamMembers();
        //        astros.addTeamMember(haaland);

        //        // Available because of Team<T> to fix Team<T extends Player, Affiliation>
        //        Team<String> sb = new Team<>("Superbad FC");
        //        var mclovin = "Fogule Mclovin " + "CAM";
        //        sb.addTeamMember(mclovin);
    }

    public static void scoreResult(
        BaseballTeam team1,
        int t1Score,
        BaseballTeam team2,
        int t2Score
    ) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s. %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1Score, SportsTeam team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s. %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1Score, Team team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s. %n", team1, message, team2);
    }
}
