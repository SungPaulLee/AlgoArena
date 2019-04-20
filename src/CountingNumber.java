import java.util.*;

public class CountingNumber {
    public static void main(String[] args) {
        Integer[] test ={5,3,3,1,0,4,5,6};

        List<Integer> testingValues = Arrays.asList(test);
        System.out.println(testingValues);

        int totalCount = returnTotalCount(testingValues);

        System.out.print(totalCount);
    }

    public static Integer returnTotalCount(List<Integer> testingValues)
    {
        testingValues.sort(Comparator.reverseOrder());
        if(testingValues.size() ==0)
        {
            return 0;
        }else if (testingValues.size() ==1)
        {
            return 1;
        }else if(testingValues.size() == 2)
        {
            if(testingValues.get(0) + testingValues.get(1)*10 > 26)
                return 1;
            return 2;
        }else
        {
            int firstCount = 1;
            int secondCount = testingValues.get(0) + testingValues.get(1) * 10 > 26 ? 1 : 2;
            int totalCount = 0;
            for(int i=2; i<testingValues.size();i++)
            {
                if(testingValues.get(i)*10 + testingValues.get(i-1) > 26 ||testingValues.get(i)==0 || testingValues.get(i-1) ==0 || testingValues.get(i-2)==0 )
                {
                    totalCount = secondCount;
                    firstCount = secondCount;
                    secondCount = totalCount;
                }else
                {
                    totalCount = secondCount + firstCount;
                    firstCount = secondCount;
                    secondCount = totalCount;
                }

            }

            return totalCount;
        }

    }
}
