import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int count = 0;

    Playlist(int maxSize) {
        songs = new String[maxSize];
    }

    boolean addSong(String title) {
        if (count >= songs.length) return false;
        songs[count++] = title;
        return true;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() { return count; }
}

public class PlaylistApp {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Copy: " + Arrays.toString(copy));
        System.out.println("Real: " + Arrays.toString(p.getSongs()));
        System.out.println("Count: " + p.getSongCount());
    }
}
