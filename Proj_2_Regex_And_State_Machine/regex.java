package Assignment2;

/*
Brayden Lappies
2020/10/28
This file takes a regex and parses it down to create a state machine to use in a search
*/

import java.util.*;

public class regex {
    
    //parse regex
    public static List<State> parse(String exprStr)
    {
        ArrayList<State> stateMachine = new ArrayList<>();
        String expression;
        expression = exprStr;
        char current;
        char next;
        int i;
        int j;
        int exprLen;
        exprLen = exprStr.length(); // ease of access

        for (i = 0; i < exprLen; i++)
        {
            current = expression.charAt(i); 
            if (i != (exprLen - 1)) //end of regex
                next = expression.charAt(i + 1);
            else // more to check on
                next = '\0';

            ArrayList<Character> ch = new ArrayList<>(); 
            ch.clear(); //new list for each pass
            
            if (Character.isLetter(current) || Character.isDigit(current)) //Will need a state
            {
                if (next != '\0')
                {
                    if (Character.isLetter(next) || Character.isDigit(next) || next == '[') //next doesn't impact
                    {
                        ch.add(current);
                        CharState state = new CharState(ch); //create state
                        stateMachine.add(state); //add to machine
                    }
                    else if (next == '+') //changes type of state
                    {
                        ch.add(current);
                        CharOpState state = new CharOpState(ch, '+');
                        stateMachine.add(state);
                    }
                    else if (next == '*')
                    {
                        ch.add(current);
                        CharOpState state = new CharOpState(ch, '*');
                        stateMachine.add(state);
                    }
                }
                else //end of regex, only characters matter now
                {
                    ch.add(current);
                    CharState state = new CharState(ch);
                    stateMachine.add(state);
                }
            }
            else if (current == '[' ) // special case that works similar to above, but loops
            {
                j = (i + 1);
                //for (j = (i + 1); j < exprLen; j++) 
                while (j != ']')
                {
                    if (exprStr.charAt(j) != ']')
                    {
                        ch.add(exprStr.charAt(j)); // adds all characters to what will become the state
                        j++;
                    }
                    else //The rest same as above for no [
                    {
                        i = j; // set for loop iteration to end of the 
                        if (j != (exprLen - 1))
                            next = expression.charAt(j + 1);
                        else
                            next = '\0';

                        if (next != '\0')
                        {
                            if (Character.isLetter(next) || Character.isDigit(next))
                            {
                                CharState state = new CharState(ch);
                                stateMachine.add(state);
                                break;
                            }
                            else if (next == '+')
                            {
                                CharOpState state = new CharOpState(ch, '+');
                                stateMachine.add(state);
                                break;
                            }
                            else if (next == '*')
                            {
                                CharOpState state = new CharOpState(ch, '*');
                                stateMachine.add(state);
                                break;
                            }
                        }
                        else
                        {
                            // end of regex, ended on ] nothing else needed
                            CharState state = new CharState(ch);
                            stateMachine.add(state);
                            break;
                        }
                    }
                }
            }
            else if (current == ']' || current == '+' || current == '*') //no state made from these
            {
                //do nothing
            }
        }
        return stateMachine;
    }
}