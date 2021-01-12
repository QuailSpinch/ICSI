package Assignment3;
/*
This class defines the Audio object that IS A Media. This class specifically has three
variables — Artist/composer, Record label, and Number of Tracks — on top of what it 
inherits from Audio.
*/
public class Audio extends Media{
    private String artist;
    private String label;
    private int tracks;

    //constructors
    public Audio()
    {
        artist = "";
        label = "";
        tracks = 0;
    }

    public Audio(String ar)
    {
        artist = ar;
        label = "";
        tracks = 0;
    }

    public Audio(String ar, String l)
    {
        artist = ar;
        label = l;
        tracks = 0;
    }

    public Audio(String ar, String l, int tr)
    {
        artist = ar;
        label = l;
        tracks = tr;
    }

    public Audio(String ar, String l, int tr, String t, int r, String g, Boolean a)
    {
        artist = ar;
        label = l;
        tracks = tr;
        setTitle(t);
        setRelease(r);
        setGenre(g);
        setAvailable(a);
    }

    //setters and getters
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public int getTracks() {
        return tracks;
    }
}
