package UnionFind;

//Weighted union find with path compression
public class UnionFindImpl {

    private int[] rootContainer;
    private int[] size;

    public UnionFindImpl(int numOfObjects)
    {
        this.rootContainer = new int[numOfObjects];
        this.size = new int[numOfObjects];
        initialize();
    }

    //initialize rootContainer and size array
    private void initialize()
    {
        for(int i = 0; i < rootContainer.length; i++)
        {
            rootContainer[i] = i;
            size[i] = 1;
        }
    }

    //method to check whether object p is connected to object q
    public boolean find(int p, int q)
    {
        if(root(p) == root(q))
            return true;
        return false;
    }

    //method to union object p and object q
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        //if root of p and root of q is same, it is already connected, so don't do anything
        if(i == j)
            return;

        //always put smaller tree under larger tree to maintain tree as flat as possible
        if(size[i] < size[j])
        {
            rootContainer[i] = j;
            size[j] = size[j] + size[i];
        }else
        {
            rootContainer[j] = i;
            size[i] = size[i] + size[j];
        }
    }

    //return root of object o
    private int root(int o)
    {
        //while root of o is not itself (which means it is not a root)
        while(o != rootContainer[o])
        {
            //path compression (move o one level up by setting its parent to grand parent
            rootContainer[o] = rootContainer[rootContainer[o]];
            //set o to root of o
            o = rootContainer[o];
        }

        return o;
    }


}
