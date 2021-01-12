package Assignment3;
/*
This class defines the Vinyl object that IS A(n) Audio which itself IS A Media.
This class specifically has two variables, recrod size and roation speed, on top
of what it inherits from Audio.
*/
public class Vinyl extends Audio{
    private int size; //inches
    private int speed; //rpm

    //constructors
    public Vinyl()
    {
        size = 0;
        speed = 0;
    }

    public Vinyl(int si)
    {
        size = si;
        speed = 0;
    }

    public Vinyl(int si, int sp)
    {
        size = si;
        speed = sp;
    }

    public Vinyl(int si, int sp, String ar, String l, int tr, String t, int r, String g, Boolean a)
    {
        size = si;
        speed = sp;
        setArtist(ar);
        setLabel(l);
        setTracks(tr);
        setTitle(t);
        setRelease(r);
        setGenre(g);
        setAvailable(a);
    }

    //setters and getters
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    //overwrite toString for specific class
    public String toString()
    {
        String output;
        String avail;
        if (Boolean.TRUE.equals(getAvailable()))
            avail = "Yes";
        else
            avail = "No";
        output = "Title: " + getTitle() + "\nArtist: " + getArtist() + "\nLabel: " + getLabel() +
            "\nGenre: " + getGenre() + "\nTracks: " + getTracks() + "\nSize: " + getSize() + "\nSpeed: " +
            getSpeed() + "\nRelease Year: " + getRelease() + "\nAvialable: " + avail + "\n";
        return output;
    }
}
