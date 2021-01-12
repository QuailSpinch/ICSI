package Assignment2;

/*
Brayden Lappies
2020/10/28
This file runs the full project, calling methods as needed on the
provided regex and file in the command line 
*/

import java.util.*;
import java.io.*;

public class regexMain {

    public static void main(String[] args) 
    {
        File fin = new File(args[1]); //file path
        try (Scanner fread = new Scanner(fin);) 
        {
            String expression;
            List<State> stateMachine;
            String searchString;
            regexSearch result = new regexSearch();
            int line;

            expression = args[0]; //regex
            stateMachine = regex.parse(expression); //parse regex into state machine
            
            line = 1;
            while (fread.hasNext()) //loop through file
            {
                searchString = fread.nextLine();
                result = regexSearch.search(stateMachine, searchString); //run line through statemachine
                if (result.found.equals("")) // no match
                {
                    //do nothing
                }
                else
                {
                    System.out.println("\nMatch found on line " + line + ", starting at position " +
                        (result.startIndex + 1) + " and ending at position " + result.endIndex + ": " + result.found);
                    System.out.println("If the regular expression entered was " + expression);
                    System.out.println("And the input file contained at line " + line + ":");
                    System.out.println(searchString);
                }
                line++;
            }
        }
        catch (Exception e)
        {
            System.out.println("File not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
