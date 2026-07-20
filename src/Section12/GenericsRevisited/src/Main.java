import dev.generics.Affiliation;
import dev.generics.Team;
import dev.lpa.BaseballPlayer;
import dev.lpa.BaseballTeam;
import dev.pregen.FootballPlayer;
import dev.pregen.SportsTeam;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        BaseballTeam astros = new BaseballTeam("Astros");
        BaseballTeam renegades = new BaseballTeam("Renegades");

        BaseballPlayer massiveSwing = new BaseballPlayer("Massive Swing", "MID");
        BaseballPlayer rightHander = new BaseballPlayer("Right Hander", "TOP");
        BaseballPlayer mechanicArm = new BaseballPlayer("Mechanic Arm", "BOTTOM");
        BaseballPlayer mercuryFeet = new BaseballPlayer("Mercury Feet", "MID");

        astros.addTeamMember(massiveSwing);
        astros.addTeamMember(mercuryFeet);

        renegades.addTeamMember(mechanicArm);
        renegades.addTeamMember(rightHander);

        scoreResults(astros, 4, renegades, 3);

        astros.listTeamMembers();
        renegades.listTeamMembers();

        SportsTeam gladiators = new SportsTeam("Gladiators FC");
        SportsTeam hurricanes = new SportsTeam("Hurricanes FC");

        gladiators.addTeamMember(new FootballPlayer("Fast Walker", "ST"));
        hurricanes.addTeamMember(new FootballPlayer("Immovable Object", "GK"));
        hurricanes.addTeamMember(massiveSwing);

        gladiators.listTeamMembers();
        hurricanes.listTeamMembers();

        var toronto = new Affiliation("Toronto", "city", "CA");
        var amsterdam = new Affiliation("Amsterdam", "city", "NL");

        Team<FootballPlayer, Affiliation> rangers = new Team<>("Rangers", toronto);
        Team<BaseballPlayer, Affiliation> runners = new Team<>("Runners", amsterdam);

        runners.addTeamMember(new BaseballPlayer("Speed Demon", "MID"));
        rangers.addTeamMember(new FootballPlayer("Playmaker", "CM"));

        runners.listTeamMembers();
        rangers.listTeamMembers();
    }

    public static void scoreResults(Team t1, int s1, Team t2, int s2) {
        String message = t1.setScore(s1, s2);
        t2.setScore(s2, s1);
        System.out.printf("%s %s %s \n", t1, message, t2);
    }

    public static void scoreResults(BaseballTeam t1, int s1, BaseballTeam t2, int s2) {
        String message = t1.setScore(s1, s2);
        t2.setScore(s2, s1);
        System.out.printf("%s %s %s \n", t1, message, t2);
    }

    public static void scoreResults(SportsTeam t1, int s1, SportsTeam t2, int s2) {
        String message = t1.setScore(s1, s2);
        t2.setScore(s2, s1);
        System.out.printf("%s %s %s \n", t1, message, t2);
    }
}
