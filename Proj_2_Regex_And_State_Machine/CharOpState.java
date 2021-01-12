package Assignment2;

/*
Brayden Lappies
2020/10/28
This file constructs a state that may repeat
*/

import java.util.*;

public class CharOpState extends State{

    public CharOpState(List<Character> ch, char op) // brackets
    {
        count = 0;
        accept = ch;
        accepted = false;
        max = 256; //while technically this should go to infinity, that is unrealistic.
        if (op == '+')
            required = 1;
        else if (op == '*')
            required = 0;
        else
            System.out.println("The char " + op + " is not valid!");
    }
}
