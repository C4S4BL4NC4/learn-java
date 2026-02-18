public class main {
    public static void main(String[] args) {
        double kilometers = (100 * 1.60344);
        int highScore = 50;

        if (highScore > 25) {
            highScore = 1000 + highScore;
        }

        int health = 100;
        if((health < 25) && (highScore > 1000)) {
            highScore = highScore - 1000;
        }
    }
}

/*
* if () {
* }
* else if() {
* }
* else {
* }
*/