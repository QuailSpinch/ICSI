package Assignment1;
import java.util.*;

public class rootNode extends node
{
    final int min;
    final int max;
    List<node> nodeList;
    public rootNode(int min, int max, List<node> nodes)
    {
        this.min = min;
        this.max = max;
        if (nodes.isEmpty())
        {
            ArrayList<Integer> error = new ArrayList<>(); // wont let the root node have an empty list. 
            error.add(-1);
            leafNode empty = new leafNode(error); // creates a leafnode with an error value and stick it into the created root note.
            nodes.add(empty);
            System.out.println("This node has an error and will only return -1 values.");
        }
        nodeList = nodes;
    }
}
