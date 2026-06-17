import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    //Album
    //    -  It has three fields, two Strings called name and artist, and an ArrayList that holds objects of type Song called songs.
    private String name, artist;
    private ArrayList<Song> songs;

    //    -  A constructor that accepts two Strings (name of the album and artist). It initialises the fields and instantiates songs.
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    //    -  And three methods, they are:
    //        -  addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean. Returns true if the song was added successfully or false otherwise.
    public boolean addSong(String title, double duration) {
        if (title.isBlank() || duration == 0) return false;
        this.songs.add(new Song(title, duration));
        return true;
    }

    //        -  findSong(), has one parameter of type String (title of song) and returns a Song. Returns the Song if it exists, null if it doesn't exists.
    public Song findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle() == title) return song;
        }
        return null;
    }

    //        -  addToPlayList(), has two parameters of type int (track number of song in album) and LinkedList (the playlist) that holds objects of type Song, and returns a boolean.
    //        Returns true if it exists and it was added successfully using the track number, or false otherwise.
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if (this.songs.indexOf(trackNumber) == -1) return false;
        playlist.add(this.songs.get(trackNumber));
        return true;
    }

    //        -  addToPlayList(), has two parameters of type String (title of song) and LinkedList (the playlist) that holds objects of type Song, and returns a boolean.
    //        Returns true if it exists and it was added successfully using the name of the song, or false otherwise.
    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        for (Song song : this.songs) {
            if (song.getTitle() == title) {
                playlist.add(song);
                return true;
            }
        }
        return false;
    }
}
