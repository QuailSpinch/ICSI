package Assignment1;
import java.util.*;

public class bTree_Test2 
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        int input;
        ArrayList<Integer> leafOne = new ArrayList<>();
        
        ArrayList<Integer> leafTwo = new ArrayList<>();
        
        ArrayList<Integer> leafThree = new ArrayList<>();
        
        System.out.println("Input values to be added to tree (1-1000), EOF to stop (^z)");
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
            else if (input >= 201 && input <= 1000)
            {
                leafThree.add(input);
            }
        }
        while (kb.hasNext());
        kb.close();

        leafNode leafNodeOne = new leafNode(leafOne);
        ArrayList<node> leafListOne = new ArrayList<>();
        leafListOne.add(leafNodeOne);
        rootNode rootOne = new rootNode(1, 100, leafListOne);

        leafNode leafNodeTwo = new leafNode(leafTwo);
        ArrayList<node> leafListTwo = new ArrayList<>();
        leafListTwo.add(leafNodeTwo);
        rootNode rootTwo = new rootNode(101, 200, leafListTwo);

        leafNode leafNodeThree = new leafNode(leafThree);
        ArrayList<node> leafListThree = new ArrayList<>();
        leafListThree.add(leafNodeThree);
        rootNode rootThree = new rootNode(201, 1000, leafListThree);

        
        ArrayList<node> rNodes = new ArrayList<>();
        Collections.addAll(rNodes, rootOne, rootTwo, rootThree);
        rootNode top = new rootNode(1, 1000, rNodes);

        node.recursiveSearch(top, 800, top.nodeList.size() - 1);
        node.recursiveSearch(top, -1, top.nodeList.size() - 1);
        node.recursiveSearch(top, 44, top.nodeList.size() - 1);
    }
}