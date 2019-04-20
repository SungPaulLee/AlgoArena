public class ReverseQuadTree {
    public static void main(String[] args)
    {
        String input = "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";

        System.out.print(reverse(input));
    }

    public static String reverse (String input)
    {
        IntegerObj index = new IntegerObj(0);
        return reverseHelperFun(input, index);
    }

    public static String reverseHelperFun(String input, IntegerObj index)
    {
        char[] chars = input.toCharArray();
        char c = chars[index.getVal()];
        index.setVal(index.getVal() + 1);
        //basecase
        if('w'==c || 'b' == c)
        {
            return String.valueOf(c);
        }
        String upperLeft = reverseHelperFun(input, index);
        String upperRight = reverseHelperFun(input, index);
        String lowerLeft = reverseHelperFun(input, index);
        String lowerRight = reverseHelperFun(input, index);

        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }

    static class IntegerObj
    {
        int val;
        IntegerObj(int val)
        {
            this.val = val;
        }

        public int getVal()
        {
            return val;
        }

        public void setVal(int val)
        {
            this.val = val;
        }

    }
}
