import java.util.*;

public class CoursesProblem {

    public static void main (String[] args)
    {
        int input[][] = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        boolean val = canFinish(4, input);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //first build the map for the graph
        Map<Integer, List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        for(int i = 0; i < prerequisites.length; i++)
        {
            int firstElem = prerequisites[i][0];
            int secondElem = prerequisites[i][1];

            if(graph.get(firstElem) == null)
            {
                List<Integer> list = new ArrayList<Integer>();
                list.add(secondElem);
                graph.put(firstElem, list);
            }else
            {
                graph.get(firstElem).add(secondElem);
            }
        }

        //Now iterate map for each key on graph and see if traversing its vertices has
        //dependency on the key itself
        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet())
        {
            Stack<Integer> stack = new Stack<Integer>();
            List<Integer> visited = new ArrayList<Integer>();

            Integer root = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            stack.push(root);
            while(!stack.isEmpty())
            {
                Integer vertex = stack.pop();
                if(visited.contains(vertex))
                    return false;
                if(graph.get(vertex) != null) //if the course has any dependency
                {
                    visited.add(vertex);
                    for(Integer neighbor : graph.get(vertex))
                    {
                        // if(neighbor.equals(root))
                        //     return false;
                        stack.push(neighbor);
                    }
                }
            }
        }
        return true;
    }
}
