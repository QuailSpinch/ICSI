package Assignment2;

/*
Brayden Lappies
2020/10/28
This file runs the tests by running lines through the state machine
*/

import java.util.*;

public class regexSearch {
    int startIndex;
    int endIndex;
    String found;

    public regexSearch() //data to send back through as result of search()
    {
        startIndex = 0;
        endIndex = 0;
        found = "";
    }

    public static boolean chackAccept(List<State> st, int i) //recursive check to confirm match
    {
        while (i >= 0)
        {
            if (st.get(i).accepted)
            {
                if (i == 0) // final state accepted
                {
                    st.get(i).clearAccepted();
                    return true;
                }
            }
            else //failed
                return false;
            st.get(i).clearAccepted();
            i--;
        }
        return false; // i was negative, couldn't run
    }

    public static regexSearch search(List<State> machine, String searchString)
    {
        List<State> stateMachine = machine;
        String search = searchString;
        String temp;
        temp = "";
        boolean searching;
        regexSearch result = new regexSearch();
        int i; //string iteration
        int j; //machine iteration
        int k; //string while in machine iteration

        for (i = 0; i < search.length(); i++)
        {
            if (stateMachine.get(0).accept.contains(search.charAt(i))) //starts going through the states
            {
                searching = true;
                k = i;
                j = 0;
                while (searching)
                {
                    if (j < stateMachine.size()) 
                    {
                        //looking in range, current acceptable in state, and doesn't occur too many time
                        while (k < search.length() && stateMachine.get(j).accept.contains(search.charAt(k)) && 
                        stateMachine.get(j).count < stateMachine.get(j).max) 
                        {
                            temp = temp.concat(Character.toString(search.charAt(k))); //put on potential found string
                            stateMachine.get(j).incr(); // count of matches +1
                            k++;
                        }
                        if (stateMachine.get(j).count >= stateMachine.get(j).required) // occurnece requirement met
                        {
                            stateMachine.get(j).setAccepted();
                            stateMachine.get(j).count = 0; // for any more potential matches afterwards
                            j++;
                        }
                        else // state failed
                        {
                            stateMachine.get(j).clearAccepted();
                            break;
                        }
                    }
                    else //end of machine reached
                        searching = false;
                }
                if (regexSearch.chackAccept(stateMachine, (stateMachine.size() - 1)) && //all accepted
                    temp.length() > result.found.length()) // is longest found match
                {
                    result.found = temp;
                    result.startIndex = i;
                    result.endIndex = k;
                }
                temp = "";
            }
        }           
    return result;
    }
}
