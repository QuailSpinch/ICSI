package Assignment3;

import java.io.*;
import java.util.*;

public class libraryMain {
    public static int getNumber(Scanner kb) //gets a number for menu choices and data entry
    {
        int entry;
        entry = Integer.parseInt(kb.nextLine());
        return entry;
    }

    public static String getString(Scanner kb) //gets a string from the user for data entry
    {
        String entry;
        entry = kb.nextLine();
        return entry;
    }

    public static void printInventory(List<ArrayList<Media>> e)
    {
        int i;
        int j;
        System.out.println("\n\nLibrary's Inventory:");
        for (i = 0; i < e.size(); i++) //iterates through categories of media
        {
            ArrayList<Media> current = e.get(i);
            for (j = 0; j < current.size(); j++) //iterates through category
            {
                System.out.println("---------------------------------------------------");
                System.out.println(current.get(j).toString()); //prints the object using it's specifc toString
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void searchTitle(List<ArrayList<Media>> e, String tSearch) //searches for titles
    {
        int i;
        int j;
        int found = 0;
        for (i = 0; i < e.size(); i++)
        {
            ArrayList<Media> current = e.get(i);
            for (j = 0; j < current.size(); j++) //iterates through all objects created
            {
                if (current.get(j).getTitle().equalsIgnoreCase(tSearch)) //checks for match
                {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println(current.get(j).toString()); //prints matches
                    found++;
                }
            }
        }
        if (found == 0) //no matches found
            System.out.println("\nNo items found!");
    }

    public static void searchYear(List<ArrayList<Media>> e, int ySearch) //searches year released, similar to title
    {
        int i;
        int j;
        int found = 0;
        for (i = 0; i < e.size(); i++)
        {
            ArrayList<Media> current = e.get(i);
            for (j = 0; j < current.size(); j++)
            {
                if (current.get(j).getRelease() == ySearch)
                {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println(current.get(j).toString());
                    found++;
                }
            }
        }
        if (found == 0)
            System.out.println("\nNo items found!");
    }

    public static void searchGenre(List<ArrayList<Media>> e, String gSearch) //searches by genre, similar to title
    {
        int i;
        int j;
        int found = 0;
        for (i = 0; i < e.size(); i++)
        {
            ArrayList<Media> current = e.get(i);
            for (j = 0; j < current.size(); j++)
            {
                if (current.get(j).getGenre().equalsIgnoreCase(gSearch))
                {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println(current.get(j).toString());
                    found++;
                }
            }
        }
        if (found == 0)
            System.out.println("\nNo items found!");
    }

    public static void searchAvailable(List<ArrayList<Media>> e) //searches availablity, prints all available items
    {
        int i;
        int j;
        int found = 0;
        for (i = 0; i < e.size(); i++)
        {
            ArrayList<Media> current = e.get(i);
            for (j = 0; j < current.size(); j++)
            {
                if (Boolean.TRUE.equals(current.get(j).getAvailable()))
                {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println(current.get(j).toString());
                    found++;
                }
            }
        }
        if (found == 0)
            System.out.println("\nNo items available!");
    }

    public static void search(List<ArrayList<Media>> e, Scanner kb) //basis for searching
    {
        int choice;
        int searchNumber;
        String searchString;
        Boolean valid = false;
        System.out.println("\n\nSearch by: ");
        System.out.println("1. Title\n2. Year Released\n3. Genre\n4. Avialable"); 
        System.out.print("Enter selction: "); //choose what to search by
        while (Boolean.FALSE.equals(valid))
        {
            choice = getNumber(kb); 
            switch (choice)
            {
                case 1:
                    System.out.print("\n\nEnter Title to Search: ");
                    searchString = getString(kb);
                    searchTitle(e, searchString);
                    valid = true;
                    break;
                case 2:
                    System.out.print("\n\nEnter Year: ");
                    searchNumber = getNumber(kb);
                    searchYear(e, searchNumber);
                    valid = true;
                    break;
                case 3:
                    System.out.print("\n\nEnter Genre: ");
                    searchString = getString(kb);
                    searchGenre(e, searchString);
                    valid = true;
                    break;
                case 4:
                    System.out.println("\n\nGetting available Items: ");
                    searchAvailable(e);
                    valid = true;
                    break;
                default:
                    System.out.println("\nNot a valid choice, try again");
            }
        }
    }

    public static void addItem(List<ArrayList<Media>> e, Scanner kb) //add new media
    {
        int choice;
        String menu = "\nEnter new:\n1. Book\n2. Film\n3. CD\n4. Vinyl";
        System.out.println(menu);
        System.out.print("Your selection: "); //choose type of media to add
        choice = getNumber(kb);
        String t;
        int year;
        String g;
        String avail;
        Boolean a;
        if (choice == 1) //makes new book
        {
            String au;
            String pu;
            int pa;
            System.out.print("\nEnter Title: "); //gets data for book
            t = getString(kb);
            System.out.print("\nEnter Release Year: ");
            year = getNumber(kb);
            System.out.print("\nEnter Genre: ");
            g = getString(kb);
            System.out.print("\nEnter Author: ");
            au = getString(kb);
            System.out.print("\nEnter Publisher: ");
            pu = getString(kb);
            System.out.print("Enter Page Count: ");
            pa = getNumber(kb);
            System.out.print("\nAvailable? (y/n): ");
            avail = getString(kb);
            if (avail.equalsIgnoreCase("y"))
                a = true;
            else if (avail.equalsIgnoreCase("n"))
                a = false;
            else 
            {
                System.out.println("\nNot valid selection, defaulting to available");
                a = true;
            }
            Book b = new Book(au, pu, pa, t, year, g, a); //makes the book
            e.get(0).add(b); //add the book to the book section of the library
        }
        else if (choice == 2) //Make new film, Similar to Book section
        {
            String d;
            String s;
            int ru;
            String f;
            System.out.print("\nEnter Title: "); 
            t = getString(kb);
            System.out.print("\nEnter Release Year: ");
            year = getNumber(kb);
            System.out.print("\nEnter Genre: ");
            g = getString(kb);
            System.out.print("\nEnter Director: ");
            d = getString(kb);
            System.out.print("\nEnter Studio: ");
            s = getString(kb);
            System.out.print("\nEnter Runtime: ");
            ru = getNumber(kb);
            System.out.print("\nEnter Format: ");
            f = getString(kb);
            System.out.print("\nAvailable? (y/n): ");
            avail = getString(kb);
            if (avail.equalsIgnoreCase("y"))
                a = true;
            else if (avail.equalsIgnoreCase("n"))
                a = false;
            else 
            {
                System.out.println("\nNot valid selection, defaulting to available");
                a = true;
            }
            Film fi = new Film(d, s, ru, f, t, year, g, a);
            e.get(1).add(fi);
        }
        else if (choice == 3) //Make new CD, similar to Book section
        {
            String ar;
            String l;
            int tr;
            int d;
            System.out.print("\nEnter Title: ");
            t = getString(kb);
            System.out.print("\nEnter Release Year: ");
            year = getNumber(kb);
            System.out.print("\nEnter Genre: ");
            g = getString(kb);
            System.out.print("\nEnter Artist: ");
            ar = getString(kb);
            System.out.print("\nEnter Label: ");
            l = getString(kb);
            System.out.print("\nEnter Track Count: ");
            tr = getNumber(kb);
            System.out.print("\nEnter Disc Count: ");
            d = getNumber(kb);
            System.out.print("\nAvailable? (y/n): ");
            avail = getString(kb);
            if (avail.equalsIgnoreCase("y"))
                a = true;
            else if (avail.equalsIgnoreCase("n"))
                a = false;
            else 
            {
                System.out.println("\nNot valid selection, defaulting to available");
                a = true;
            }
            CD c = new CD(d, ar, l, tr, t, year, g, a);
            e.get(2).add(c);
        }
        else if (choice == 4) //Make new Vinyl, similar to the Book section
        {
            String ar;
            String l;
            int tr;
            int si;
            int sp;
            System.out.print("\nEnter Title: ");
            t = getString(kb);
            System.out.print("\nEnter Release Year: ");
            year = getNumber(kb);
            System.out.print("\nEnter Genre: ");
            g = getString(kb);
            System.out.print("\nEnter Artist: ");
            ar = getString(kb);
            System.out.print("\nEnter Label: ");
            l = getString(kb);
            System.out.print("\nEnter Track Count: ");
            tr = getNumber(kb);
            System.out.print("\nEnter Size (diameter in inches): ");
            si = getNumber(kb);
            System.out.print("\nEnter Speed: ");
            sp = getNumber(kb);
            System.out.print("\nAvailable? (y/n): ");
            avail = getString(kb);
            if (avail.equalsIgnoreCase("y"))
                a = true;
            else if (avail.equalsIgnoreCase("n"))
                a = false;
            else 
            {
                System.out.println("\nNot valid selection, defaulting to available");
                a = true;
            }
            Vinyl v = new Vinyl(si, sp, ar, l, tr, t, year, g, a);
            e.get(3).add(v);
        }
        else
            System.out.println("\nNot a valid selection");
    }

    public static void deleteItem(List<ArrayList<Media>> e, Scanner kb) //remove an item by title
    {
        int i;
        int j;
        String delete;
        String confirm;
        System.out.print("\nEnter title of item to delete: ");
        delete = getString(kb);
        for (i = 0; i < e.size(); i++)
        {
            ArrayList<Media> current = e.get(i);
            for (j = 0; j < current.size(); j++)
            {
                if (current.get(j).getTitle().equalsIgnoreCase(delete)) //goes through collection, can find multiple matches
                {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println(current.get(j).toString());
                    System.out.print("Are you sure you want to delete this entry? (y/n)"); //confirm deletion
                    confirm = getString(kb);
                    if (confirm.equalsIgnoreCase("y"))
                    {
                        current.remove(j); //remove the item
                        j--; //just to be safe
                        System.out.println("\nEntry deleted");
                    }
                }
            }
        }
    }

    public static void export(List<ArrayList<Media>> e, Scanner kb) //Send inventory to output file
    {
        int i;
        int j;
        String fileDestination;
        System.out.print("Enter file desitnation to export to: "); //enter output file
        fileDestination = getString(kb);
        File fileOut = new File(fileDestination);
        try (FileWriter fout = new FileWriter(fileOut))
        {
            if (fileOut.createNewFile()) //if File doesn't exist, create it!
            {
                System.out.println("File created! Now writing to file");
            }
            for (i = 0; i < e.size(); i++)
            {
                ArrayList<Media> current = e.get(i);
                for (j = 0; j < current.size(); j++) //iterate through entire library
                {
                    fout.write("\n---------------------------------------------------\n");
                    fout.write(current.get(j).toString()); //print each item with it's toString
                }
            }
        } //fout closes by defualt with end of try{}
        catch (IOException ex) 
        {
            System.out.println("\nAn error occured!");
            ex.printStackTrace();
        }
        System.out.println("Items exported!");
    }

    public static void importItems(List<ArrayList<Media>> e, Scanner kb) //fill Library with data from file
    { //This reads in standard data formated specifically for this Library. Not any old format will work
        String fileFrom;
        String in;
        String t;
        int r;
        String g;
        String avail;
        boolean a;
        System.out.print("Enter file to read from: "); //Select file to get data from
        fileFrom = getString(kb);
        File fileIn = new File(fileFrom);
        try (Scanner fin = new Scanner(fileIn))
        {
            while (fin.hasNext()) // While not EOF
            {
                in = fin.nextLine();
                if (in.equalsIgnoreCase("book")) //Reads in a book
                {
                    String au;
                    String pu;
                    int pa;
                    t = fin.nextLine();
                    r = Integer.parseInt(fin.nextLine());
                    g = fin.nextLine();
                    au = fin.nextLine();
                    pu = fin.nextLine();
                    pa = Integer.parseInt(fin.nextLine());
                    avail = fin.nextLine();
                    if (avail.equalsIgnoreCase("yes"))
                        a = true;
                    else
                        a = false;
                    Book b = new Book(au, pu, pa, t, r, g, a);
                    e.get(0).add(b);
                }
                else if (in.equalsIgnoreCase("film")) //reads in a Film
                {
                    String d;
                    String s;
                    int ru;
                    String f;
                    t = fin.nextLine();
                    r = Integer.parseInt(fin.nextLine());
                    g = fin.nextLine();
                    d = fin.nextLine();
                    s = fin.nextLine();
                    ru = Integer.parseInt(fin.nextLine());
                    f = fin.nextLine();
                    avail = fin.nextLine();
                    if (avail.equalsIgnoreCase("yes"))
                        a = true;
                    else
                        a = false;
                    Film fi = new Film(d, s, ru, f, t, r, g, a);
                    e.get(1).add(fi);
                }
                else if (in.equalsIgnoreCase("cd")) //reads in a CD
                {
                    String ar;
                    String l;
                    int tr;
                    int d;
                    t = fin.nextLine();
                    r = Integer.parseInt(fin.nextLine());
                    g = fin.nextLine();
                    ar = fin.nextLine();
                    l = fin.nextLine();
                    tr = Integer.parseInt(fin.nextLine());
                    d = Integer.parseInt(fin.nextLine());
                    avail = fin.nextLine();
                    if (avail.equalsIgnoreCase("yes"))
                        a = true;
                    else
                        a = false;
                    CD c = new CD(d, ar, l, tr, t, r, g, a);
                    e.get(2).add(c);
                }
                else if (in.equalsIgnoreCase("vinyl")) //reads in a Vinyl
                {
                    String ar;
                    String l;
                    int tr;
                    int si;
                    int sp;
                    t = fin.nextLine();
                    r = Integer.parseInt(fin.nextLine());
                    g = fin.nextLine();
                    ar = fin.nextLine();
                    l = fin.nextLine();
                    tr = Integer.parseInt(fin.nextLine());
                    si = Integer.parseInt(fin.nextLine());
                    sp = Integer.parseInt(fin.nextLine());
                    avail = fin.nextLine();
                    if (avail.equalsIgnoreCase("yes"))
                        a = true;
                    else
                        a = false;
                    Vinyl v = new Vinyl(si, sp, ar, l, tr, t, r, g, a);
                    e.get(3).add(v);
                }
            }
        } //fin closes automaticall with end of try{}
        catch (IOException ex)
        {
            System.out.println("\nAn error occured!");
            ex.printStackTrace();
        }
    }

    public static void menu(List<ArrayList<Media>> e, Scanner kb) //Main Menu that loops till user wants to leave
    {
        Boolean run = true;
        String mainMenu = "\n1: Print all Items\n2: Search for an Item\n3: Enter new Item\n" + 
        "4: Delete an Item\n5: Export Inventory data to file\n6: Import data from file\n7: Exit";
        
        while(Boolean.TRUE.equals(run))
        {
            int choice;
            System.out.println(mainMenu);
            System.out.print("Your choice: "); //Make choice
            choice = getNumber(kb);
            switch (choice) //Do operation for choice
            {
                case 1:
                    printInventory(e);
                    System.out.println("\nAnything else?");
                    break;
                case 2:
                    search(e, kb);
                    System.out.println("\nAnything else?");
                    break;
                case 3:
                    addItem(e, kb);
                    System.out.println("\nAnything else?");
                    break;
                case 4:
                    deleteItem(e, kb);
                    System.out.println("\nAnything else?");
                    break;
                case 5:
                    export(e, kb);
                    System.out.println("\nAnything else?");
                    break;
                case 6:
                    importItems(e, kb);
                    System.out.println("\nAnything else?");
                    break;
                case 7:
                    run = false; //User wants to leave. Bye bye
                    System.out.println("Thank you for using the Library! Have a good day!");
                    break;
                default:
                    System.out.println("choice not valid, enter again: ");
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in); //Acanner used for all user input
        ArrayList<ArrayList<Media>> library = new ArrayList<>(); //Library of media
        ArrayList<Media> books = new ArrayList<>(); //Book category
        ArrayList<Media> films = new ArrayList<>(); //Film category
        ArrayList<Media> cds = new ArrayList<>(); //CD category
        ArrayList<Media> vinyls = new ArrayList<>(); //Vinyl category
        library.add(books);
        library.add(films);
        library.add(cds);
        library.add(vinyls); //All categories in Library
        System.out.println("Welcome to the Library! What would you like to do today?:");
        menu(library, kb);
        kb.close();//close scanner
    }
}
