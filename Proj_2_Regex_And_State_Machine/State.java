package Assignment2;

/*
Brayden Lappies
2020/10/28
This file lays out the basis of what all states will have
*/

import java.util.*;

public class State {
    List<Character> accept;
    boolean accepted;
    int count;
    int required;
    int max;

    public void setAccepted()
    {
        accepted = true;
    }

    public void clearAccepted()
    {
        accepted = false;
    }

    public void incr()
    {
        count++;
    }

    public boolean isAcceptable()
    {
        boolean good;
        if (count >= required)
            good = true;
        else
           good = false;

        return good;
    }
}
