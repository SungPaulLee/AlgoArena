public class DijkstraAlgorithmShortestPath {
    public static void main(String[] args)
    {
        int totalNumNodes = 5;
        int[][] pathLength = {{0,6,10000,1,10000},
                {6,0,5,2,2},
                {10000,5,0,10000,5},
                {1,2,10000,0,1},
                {10000,2,5,1,0}};

        dijkstraShortestPath(pathLength, 0, 2, 5);
    }

    public static void dijkstraShortestPath(int[][] pl, int s, int f, int totalNodes)
    {
        boolean[] v = new boolean[totalNodes];
        int[] d = new int[totalNodes];
        int[] prevNode = new int[totalNodes];
        //initialize d with pl
        for(int i = 0; i < totalNodes; i++)
        {
            d[i] = pl[s][i];
        }

        v[s] = true;
        int indexStart = s;
        for(int i = 0; i < totalNodes; i++)
        {
            int curIndex = findShortestIndex(pl,indexStart,v);
            if(curIndex != s && v[curIndex] == false)
            {
                v[curIndex] = true;
                for(int j = 0; j < totalNodes; j++)
                {
                    if(d[curIndex] + pl[curIndex][j] <  d[j])
                    {
                        d[j] = d[curIndex] + pl[curIndex][j];
                        prevNode[j] = curIndex;
                    }
                }
            }
            indexStart = curIndex;
        }

        System.out.print("-->" + f);
        while(s != f)
        {
            System.out.println("-->" + prevNode[f]);
            f = prevNode[f];
        }
    }
    //find shortest node which is unvisited
    public static int findShortestIndex(int[][] pl, int node, boolean[] v)
    {
        int d = 10000;
        int index = 0;
        for(int i = 0; i < v.length; i++)
        {
            if(pl[node][i] != 0 && v[i] == false)
            {
                if(pl[node][i] < d)
                {
                    index = i;
                    d = pl[node][i];
                }
            }
        }
        return index;
    }
}
