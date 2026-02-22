public class MethodChallenge {

    public static void main(String[] args) {
        int highScorePosition = calculateHighScore(1500);
        displayHighScorePosition("Alice", highScorePosition);

        displayHighScorePosition("Tobby", calculateHighScore(1500));
        displayHighScorePosition("Rami", calculateHighScore(999));
        displayHighScorePosition("Rose", calculateHighScore(499));
        displayHighScorePosition("Mark", calculateHighScore(99));
        displayHighScorePosition("Sarah", calculateHighScore(-1000));
    }

    public static void displayHighScorePosition(String playerName, int highScorePosition) {
        System.out.println(
            playerName +
                " managed to get into position " +
                highScorePosition +
                " on the high score list."
        );
    }

    public static int calculateHighScore(int playerScore) {
        if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500 && playerScore < 1000) {
            return 2;
        } else if (playerScore >= 100 && playerScore < 500) {
            return 3;
        } else {
            return 4;
        }
    }
}
