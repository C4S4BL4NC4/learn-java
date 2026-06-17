import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name, artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (title == null || title.isBlank() || duration <= 0) return false;
        if (findSong(title) != null) return false; // prevent duplicates
        this.songs.add(new Song(title, duration));
        return true;
    }

    private Song findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle().equals(title)) return song; // use equals
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && index < songs.size()) {
            // fix bound
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        return false;
    }
}
