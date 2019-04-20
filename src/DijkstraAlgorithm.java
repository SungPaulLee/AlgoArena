public class DijkstraAlgorithm {

    static int totalNodesNum = 6;
    static boolean[] visited = {false,false,false,false,false,false};
    static int[][] distance2 = {
            {0,2,5,1,10000,10000},
            {2,0,3,2,10000,10000},
            {5,3,0,3,1,5},
            {1,2,3,0,1,10000},
            {10000,10000,1,1,0,2},
            {10000,10000, 5, 10000,2,0}
    };
    static int[] distance = new int[6];

    public static void main (String args[])
    {
        dijkstra(1);
        for(int i = 0; i < distance.length; i ++)
        {
            System.out.print(distance[i]);
        }
    }

    static int getClosestIndex()
    {
        int dis = 10000;
        int minIndex = 0;
        for(int i = 0; i < totalNodesNum; i++)
        {
            if(!visited[i] && distance[i] < dis)
            {
                dis = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void dijkstra(int start)
    {
        //first initialize distance[] from distance2[][]
        for(int i = 0; i < totalNodesNum; i++)
        {
            distance[i] = distance2[start][i];
        }
        //mark start node to be visited
        visited[start] = true;
        for(int i = 0; i < totalNodesNum; i++)
        {
            int current = getClosestIndex();
            //mark this node to be visited
            visited[current] = true;
            for(int j = 0; j < totalNodesNum; j++)
            {
                if(distance[current] + distance2[current][j] < distance[j])
                    distance[j] = distance[current] + distance2[current][j];
            }
        }
    }
}
