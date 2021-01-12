package Assignment1;

public class node 
{

    public static void recursiveSearch(node search, int value, int pass)
    {
        if (pass < 0) // has ehuasted through all nodes without finding the target value
        {
            System.out.println("Target value " + value + " not found");
        }
        else
        {
            if (search instanceof rootNode) //checks for root node (or leaf node)
            {
                rootNode root = (rootNode) search; //for ease of access
                if (value >= root.min && value <= root.max) //ensures the target is within range of the primary root node
                {
                    if (root.nodeList.get(pass) instanceof rootNode) // the root node contains more root nodes
                    {
                        rootNode newRoot = (rootNode) root.nodeList.get(pass);
                        if (value >= newRoot.min && value <= newRoot.max) // checks if target is in the range of the current "pass" node
                        {
                            recursiveSearch(newRoot, value, newRoot.nodeList.size() - 1); // target in range, enter this root node branch
                        }
                        else 
                        {
                            recursiveSearch(root, value, pass - 1); //target isn't in this branch, recusrivle call to check next branch
                        }
                    }
                    else if (root.nodeList.get(pass) instanceof leafNode) // the root contains leaf nodes
                    {
                        leafNode leaf = (leafNode) root.nodeList.get(pass);
                        if (leaf.values.contains(value)) // Target is within root node
                        {
                            System.out.println("Value " + value + " found in leaf node " + leaf);
                        }
                        else
                        {
                            recursiveSearch(root, value, pass - 1); //recursive call to check other leaf nodes of the root
                        }
                    }
                }
                else if (root.nodeList.size() - 1 == pass) // value was never in range (only triggers on first call, not recursive calls)
                {
                    System.out.println("Target value " + value + " not found.");
                }
            }
            else if (search instanceof leafNode)// passed a leaf node
            {
                leafNode leaf = (leafNode) search;
                if (leaf.values.contains(value))
                {
                    System.out.println("Value " + value + " found in leaf node " + leaf);
                }
                else
                {
                    System.out.println("Target value " + value + " not found.");
                }
            }
            else
            {
                System.out.println("Please call with a root node or a leaf node");
            }
        }
    }
}
