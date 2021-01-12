package Assignment1;
import java.util.*;

public class leafNode extends node
{
    List<Integer> values;
    public leafNode(List<Integer> vals)
    {
        if (vals.isEmpty())
        {
            ArrayList<Integer> error = new ArrayList<>(); // won't let the leaf node have an empty list
            error.add(-1);
            values = error;
            System.out.println("Error in creating node: values set to -1");
        }
        else
        {
            values = vals;
        }
    }
}
