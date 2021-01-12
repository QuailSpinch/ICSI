package Assignment2;

/*
Brayden Lappies
2020/10/28
This file constructs a state that doesn't have a repeating potential
*/

import java.util.*;

public class CharState extends State{

    public CharState(List<Character> ch) //just a single char
    {
        required = 1;
        count = 0;
        max = 1;
        accept = ch;
        accepted = false;
    }
    
}
