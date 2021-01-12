package Assignment1;
import java.util.*;
//Searches for values in b-tree. If found says the value and which leafNode (address) it was in.
public class bTree_Main 
{
    public static void main(String[] args)
    {
        int input;
        Scanner kb = new Scanner(System.in);
        ArrayList<Integer> leafOne = new ArrayList<>();  //creates int array list for leaf node
        ArrayList<Integer> leafTwo = new ArrayList<>();
        ArrayList<Integer> leafThree = new ArrayList<>();
        ArrayList<Integer> leafFour = new ArrayList<>();
        ArrayList<Integer> leafFive = new ArrayList<>();
        

        System.out.println("Input values to be added to tree (1-1000), EOF to stop (^z)"); // gets input
        do
        {
            input = kb.nextInt();
            if (input >= 1 && input <= 100)
            {
                leafOne.add(input);
            }
            else if (input >= 101 && input <= 200)
            {
                leafTwo.add(input);
            }
            else if (input >= 201 && input <= 400)
            {
                leafThree.add(input);
            }
            else if (input >= 401 && input <= 500)
            {
                leafFour.add(input);
            }
            else if (input >= 501 && input <= 1000)
            {
                leafFive.add(input);
            }
        }
        while (kb.hasNext());
        kb.close();

        leafNode leafNodeOne = new leafNode(leafOne);  // creates leaf node
        ArrayList<node> leafListOne = new ArrayList<>();
        leafListOne.add(leafNodeOne);
        rootNode rootOne = new rootNode(1, 100, leafListOne); // creates root node and puts leaf node into the root node

        leafNode leafNodeTwo = new leafNode(leafTwo);
        ArrayList<node> leafListTwo = new ArrayList<>();
        leafListTwo.add(leafNodeTwo);
        rootNode rootTwo = new rootNode(101, 200, leafListTwo);

        leafNode leafNodeThree = new leafNode(leafThree);
        ArrayList<node> leafListThree = new ArrayList<>();
        leafListThree.add(leafNodeThree);
        rootNode rootThree = new rootNode(201, 400, leafListThree);

        leafNode leafNodeFour = new leafNode(leafFour);
        ArrayList<node> leafListFour = new ArrayList<>();
        leafListFour.add(leafNodeFour);
        rootNode rootFour = new rootNode(401, 500, leafListFour);

        leafNode leafNodeFive = new leafNode(leafFive);
        ArrayList<node> leafListFive = new ArrayList<>();
        leafListFive.add(leafNodeFive);
        rootNode rootFive = new rootNode(501, 1000, leafListFive);


        ArrayList<node> rNodes = new ArrayList<>(); // creates root node array list
        Collections.addAll(rNodes, rootOne, rootTwo, rootThree, rootFour, rootFive);
        rootNode top = new rootNode(1, 1000, rNodes); // creates the start of the tree

        node.recursiveSearch(top, 112, top.nodeList.size() - 1);
        node.recursiveSearch(top, 78, top.nodeList.size() - 1);
        node.recursiveSearch(top, 15, top.nodeList.size() - 1);
    }
}
