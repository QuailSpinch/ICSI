package Assignment3;
/*
This class defines the Media object that is the super class for all items in the 
Library. This class has four variable that are common amongst all Media — Title,
Year of Release, Genre of Media, and if it is Available from the Library.
*/
public class Media {
    private String title;
    private int release;
    private String genre;
    private Boolean available; //is checked out or not

    // Constructors
    public Media()
    {
        title = "";
        release = 1970; //Placeholder year
        genre = "";
        available = false;
    }

    public Media(String t)
    {
        title = t;
        release = 1970;
        genre = "";
        available = false;
    }

    public Media (String t, int r)
    {
        title = t;
        release = r;
        genre = "";
        available = false;
    }

    public Media(String t, int r, String g)
    {
        title = t;
        release = r;
        genre = g;
        available = false;
    }

    public Media(String t, int r, String g, Boolean a)
    {
        title = t;
        release = r;
        genre = g;
        available = a;
    }

    //Setters and Getters
    public void setTitle(String t)
    {
        this.title = t;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setRelease(int r)
    {
        this.release = r;
    }

    public int getRelease()
    {
        return this.release;
    }

    public void setGenre(String g)
    {
        this.genre = g;
    }

    public String getGenre()
    {
        return this.genre;
    }

    public void setAvailable(Boolean a)
    {
        this.available = a;
    }

    public Boolean getAvailable()
    {
        return this.available;
    }
}
