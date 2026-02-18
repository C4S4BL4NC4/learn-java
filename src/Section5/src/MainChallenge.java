public class MainChallenge {
    public static void main(String[] args){
        calculateScore();
        callingCode(12, false);
        int num = 10;
        myMethod(num); // Copy
        System.out.println(num);

    }
    public static void calculateScore() {
        boolean gameOver = true;
        int score = 10000;
        int levelCompleted = 8;
        int bonus = 200;
        int finalScore = score;
        if(gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }

    public static void callingCode(int score, boolean isTrue) {
        System.out.println(score);
        System.out.println(isTrue);
    }

    public static void myMethod(int num) {
        System.out.println(num);
        num--;
        System.out.println(num);
    }
}
