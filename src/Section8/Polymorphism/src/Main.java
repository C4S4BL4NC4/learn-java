import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Movie crank = new Movie("Crank");
        crank.watchMovie();

        Movie jones = new Adventure("Indiana Jones");
        jones.watchMovie();

        Movie bTF = Movie.getMovie("Scieon", "Back to the future");
        bTF.watchMovie();

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Enter type ACS, Q to quit: ");
            String type = s.nextLine();
            if("Qq".contains(type)) {
                break;
            }
            System.out.print("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
