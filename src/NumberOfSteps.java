import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSteps {

    public static void main (String[] args)
    {
        Map<Integer, Integer> countingWays = new HashMap<Integer,Integer>();

       // System.out.print(numOfWays(4, countingWays));
    }

    public static boolean isMatch(String s, String p)
    {
        char[] charStringArray = s.toCharArray();
        char[] charPatternArray = p.toCharArray();
        int pArrayIndex = 0;

        for(int i = 0; i < charStringArray.length; i++)
        {
                if(charStringArray[i] == charPatternArray[pArrayIndex] || charPatternArray[pArrayIndex] == '.')
                {
                    pArrayIndex ++;
                }else if (charPatternArray[pArrayIndex] == '*')
                {
                    if(charStringArray[i] != charPatternArray[pArrayIndex-1])
                    {
                        if(charStringArray[i] != charPatternArray[pArrayIndex + 1] && charPatternArray[pArrayIndex +1] != '.')
                        {
                            return false;
                        }else
                        {
                            pArrayIndex = pArrayIndex + 2;
                        }
                    }
                }else
                {
                    return false;
                }
        }




        //Check whether remaining pattern can match empty string

        return true;
    }
}
