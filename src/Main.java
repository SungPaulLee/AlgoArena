import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter input : " );
        String input = in.nextLine();
        System.out.print("input is " + input);
    }

    public static void postOrderTraverse(List<Integer> preOrderTraverse, List<Integer> inorderTraverse)
    {
        if(preOrderTraverse.size()==0)
        {
            return;
        }else
        {
            int root = preOrderTraverse.get(0);
            int leftSubTreeSize = inorderTraverse.indexOf(root);
            int rightSubTreeSize = inorderTraverse.size()-leftSubTreeSize-1;

            List<Integer> leftSubtreePreOrder = new ArrayList<>();
            List<Integer> leftSubtreeInOrder = new ArrayList<>();
            List<Integer> rightSubtreePreOrder = new ArrayList<>();
            List<Integer> rightSubtreeInOrder = new ArrayList<>();

            if(leftSubTreeSize!=0)
            {
                leftSubtreePreOrder = preOrderTraverse.subList(1,1+leftSubTreeSize);
                leftSubtreeInOrder = inorderTraverse.subList(0,leftSubTreeSize);
            }

            if(rightSubTreeSize!=0)
            {
                rightSubtreePreOrder = preOrderTraverse.subList(1+leftSubTreeSize,preOrderTraverse.size());
                rightSubtreeInOrder = inorderTraverse.subList(1+leftSubTreeSize,inorderTraverse.size());
            }


            postOrderTraverse(leftSubtreePreOrder,leftSubtreeInOrder);
            postOrderTraverse(rightSubtreePreOrder,rightSubtreeInOrder);

            System.out.print(root + " ");

        }




    }
}
