package Assignment3;
/*
This class defines the CD object that IS A(n) Audio which itself IS A Media. This
class specifically has one variable, number of discs, on top of what it inherits 
from Audio.
*/
public class CD extends Audio{
    private int discs;

    //constructors
    public CD()
    {
        discs = 0;
    }

    public CD(int d)
    {
        discs = d;
    }

    public CD(int d, String ar, String l, int tr, String t, int r, String g, Boolean a)
    {
        discs = d;
        setArtist(ar);
        setLabel(l);
        setTracks(tr);
        setTitle(t);
        setRelease(r);
        setGenre(g);
        setAvailable(a);
    }

    //setter and getter
    public void setDiscs(int discs) {
        this.discs = discs;
    }

    public int getDiscs() {
        return discs;
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
            "\nGenre: " + getGenre() + "\nTracks: " + getTracks() + "\nDiscs: " + getDiscs() + 
            "\nRelease Year: " + getRelease() + "\nAvialable: " + avail + "\n";
        return output;
    }
}
