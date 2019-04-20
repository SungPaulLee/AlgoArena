import java.util.Stack;

public class RobotPath {


    public static void main(String[] args)
    {
        int[][] path = {{0,0,0},
                {-1,0,-1},
                {-1,0,0}};

        System.out.println("Number of cores : " + Runtime.getRuntime().availableProcessors());
        findPath(path);
    }

    public static void findPath(int[][] data)
    {
        int numRow = data.length;
        int numCol = data[0].length;

        int x = 0;
        int y = 0;

        Stack<String> trackPos = new Stack<String>();
        int[][] info = new int[numRow][numCol];
        if(doesPathExist(data,x,y,info,trackPos))
        {
            while(!trackPos.empty())
            {
                String st = trackPos.pop();
                System.out.println(st);
            }
        }else
        {
            System.out.println("Path does not exist");
        }

    }

    public static boolean doesPathExist(int[][] path, int x, int y, int[][] info, Stack<String> st)
    {
        //false condition
        System.out.println("Accessing " + x + "," + y);
        System.out.println(path[0].length + "," + path.length);
        if((x>path[0].length-1 || y>path.length-1) || (path[x][y]==-1))
            return false;
        if(x== path[0].length -1 && y == path.length-1)
        {
            st.push("{" + x + "," + y + "}");
            info[x][y] = 1;
            return true;
        }

        if(info[x][y]==1)
            return true;

        if(doesPathExist(path, x+1, y, info, st) == true || doesPathExist(path, x, y+1, info, st))
        {
            info[x][y] = 1;
            st.push("{" + x + "," + y + "}");
            return true;
        }

        return false;
    }
}
