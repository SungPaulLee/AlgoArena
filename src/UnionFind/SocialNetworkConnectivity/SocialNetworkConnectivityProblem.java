package UnionFind.SocialNetworkConnectivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Social network connectivity. Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or better and use extra space proportional to n
 */
public class SocialNetworkConnectivityProblem {

    public static void main(String[] args)
    {
        int numOfMembers = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        System.out.println("Tell me how many member we have : " );
        numOfMembers = scanner.nextInt();
        Map<String, Member> nameToMember = new HashMap<>();

        while(true)
        {
            System.out.println("Please provide users who are friends : ");
            String information = strScanner.nextLine();
            String[] info = information.split(" ");
            Member firstMember;
            Member secondMember;

            if(nameToMember.get(info[0]) == null)
            {
                firstMember = new Member(info[0]);
                nameToMember.put(info[0], firstMember);
            }else
            {
                firstMember = nameToMember.get(info[0]);
            }

            if(nameToMember.get(info[1]) == null)
            {
                secondMember = new Member(info[1]);
                nameToMember.put(info[1], secondMember);
            }else
            {
                secondMember = nameToMember.get(info[1]);
            }

            if(union(firstMember, secondMember, numOfMembers))
                break;
        }

        System.out.println(System.currentTimeMillis());
    }

    public static boolean union(Member a, Member b, int totalMem)
    {
        boolean allConnected = false;
        Member parent1 = root(a);
        Member parent2 = root(b);

        if(parent1.equals(parent2))
        {
            if(parent1.getSize() == totalMem)
                return true;
            return allConnected;
        }

        if(parent1.getSize()<parent2.getSize())
        {
            parent1.setRoot(parent2);
            parent2.setSize(parent2.getSize() + parent1.getSize());
            if(parent2.getSize()==totalMem)
                return true;
        }else
        {
            parent2.setRoot(parent1);
            parent1.setSize(parent1.getSize() + parent2.getSize());
            if(parent1.getSize()==totalMem)
                return true;
        }

        return allConnected;
    }

    private static Member root(Member m)
    {
        while(!m.getRoot().equals(m))
        {
            m.setRoot(m.getRoot().getRoot());
            m = m.getRoot();
        }

        return m;
    }
}
