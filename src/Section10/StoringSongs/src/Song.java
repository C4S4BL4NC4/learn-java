public class Song {

    //    -   It has two fields, a String called title and a double called duration.
    private String title;
    private double duration;

    //    -  A constructor that accepts a String (title of the song) and a double (duration of the song). It initialises title and duration.

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    //    -  And two methods, they are:
    //
    //        -  getTitle(), getter for title.

    public String getTitle() {
        return title;
    }

    //        -  toString(), Songs overriding toString method. Returns a String in the following format: "title: duration"

    @Override
    public String toString() {
        return title + ": " + duration;
    }
}
