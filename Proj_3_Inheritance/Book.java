package Assignment3;
/*
This class defines the Book object that IS A Media. This class specifically has three
variables — Author, Publisher, and Number of Pages — on top of what it inherits from Audio.
*/
public class Book extends Media{
    String author;
    String publisher;
    int pages; //page count

    //constructors
    public Book()
    {
        author = "";
        publisher = "";
        pages = 0;
    }

    public Book(String au)
    {
        author = au;
        publisher = "";
        pages = 0;
    }

    public Book(String au, String pu)
    {
        author = au;
        publisher = pu;
        pages = 0;
    }

    public Book(String au, String pu, int pa)
    {
        author = au;
        publisher = pu;
        pages = pa;
    }

    public Book(String au, String pu, int pa, String t, int r, String g, Boolean a)
    {
        author = au;
        publisher = pu;
        pages = pa;
        setTitle(t);
        setRelease(r);
        setGenre(g);
        setAvailable(a);
    }

    //setters and getters
    public void setAuthor(String a) 
    {
        this.author = a;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public void setPublisher(String p)
    {
        this.publisher = p;
    }

    public String getPublisher() 
    {
        return this.publisher;
    }

    public void setPages(int p) 
    {
        this.pages = p;
    }

    public int getPages() 
    {
        return this.pages;
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
        output = "Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nPublisher: " + getPublisher() +
            "\nGenre: " + getGenre() + "\nPages: " + getPages() + "\nRelease Year: " + getRelease() + 
            "\nAvialable: " + avail + "\n";

        return output;
    }
}
