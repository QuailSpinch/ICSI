package Assignment3;
/*
This class defines the Film object that IS A Media. This class specifically has four
variables — Director, Studio, Runtime, and Format — on top of what it inherits from Audio.
*/
public class Film extends Media{
    private String director;
    private String studio;
    private int runtime; //in minutes
    private String format; //VHS, DVD, or BR

    //constructors
    public Film()
    {
        director = "";
        studio = "";
        runtime = 0;
        format = "";
    }

    public Film(String d)
    {
        director = d;
        studio = "";
        runtime = 0;
        format = "";
    }

    public Film(String d, String s)
    {
        director = d;
        studio = s;
        runtime = 0;
        format = "";
    }

    public Film(String d, String s, int ru)
    {
        director = d;
        studio = s;
        runtime = ru;
        format = "";
    }

    public Film(String d, String s, int ru, String f)
    {
        director = d;
        studio = s;
        runtime = ru;
        format = f;
    }

    public Film(String d, String s, int ru, String f, String t, int r, String g, Boolean a)
    {
        director = d;
        studio = s;
        runtime = ru;
        format = f;
        setTitle(t);
        setRelease(r);
        setGenre(g);
        setAvailable(a);
    }

    //setters and getters
    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getStudio() {
        return studio;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    //overwrite toString for specific class
    public String toString() {
        String output;
        String avail;
        if (Boolean.TRUE.equals(getAvailable()))
            avail = "Yes";
        else
            avail = "No";
        output = "Title: " + getTitle() + "\nDirector: " + getDirector() + "\nStudio: " + getStudio() +
        "\nGenre: " + getGenre() + "\nRun Time: " + getRuntime() + "\nRelease Year: " + getRelease() + 
        "\nFormat: " + getFormat() + "\nAvialable: " + avail + "\n";

        return output;
    }
}
