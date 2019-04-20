package SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args)
    {
        Integer[] data = {1,3,5,2,4};
        List<Integer> dataInList = Arrays.asList(data);
        List<Integer> dataList = new ArrayList<>(dataInList);
        mergeSort(dataList, 0, 4);

        for(int i : dataList)
        {
            System.out.println(i);
        }
    }
    //배열 위주
//    public static void mergeSort(int[] data, int l, int h)
//    {
//        //handle exceptional case
//        if(l<h)
//        {
//                int m = (l + h)/2;
//                mergeSort(data, l, m);
//                mergeSort(data, m+1, h);
//
//                merge(data, l, m, h);
//        }
//    }
//
//    public static void merge(int[] data, int l, int m, int h)
//    {
//        int leftTmpSize = m-l+1;
//        int rightTmpSize = h-m;
//        int[] leftTmp = new int[leftTmpSize];
//        int[] rightTmp = new int[rightTmpSize];
//
//        //fill in lefttmp and righttmp
//        for(int i = 0; i < leftTmpSize; i ++)
//        {
//            leftTmp[i] = data[l+i];
//        }
//
//        for(int j = 0; j < rightTmpSize; j++)
//        {
//            rightTmp[j] = data[m+1+j];
//        }
//
//        //merging algorithm
//        int leftIndex = 0;
//        int rightIndex = 0;
//        int tracking = l;
//        while(leftIndex < leftTmpSize && rightIndex < rightTmpSize)
//        {
//            if(leftTmp[leftIndex] <= rightTmp[rightIndex])
//            {
//                data[tracking] = leftTmp[leftIndex];
//                leftIndex++;
//            }else
//            {
//                data[tracking] = rightTmp[rightIndex];
//                rightIndex++;
//            }
//            tracking++;
//        }
//
//        while(leftIndex<leftTmpSize)
//        {
//            data[tracking] = leftTmp[leftIndex];
//            leftIndex++;
//            tracking++;
//        }
//
//        while(rightIndex<rightTmpSize)
//        {
//            data[tracking] = rightTmp[rightIndex];
//            rightIndex++;
//            tracking++;
//        }
//
//
//    }

    //Array위주
    static void mergeSort(List<Integer> list, int l, int h)
    {
        if(l < h)
        {
            int m = (l+h)/2;
            mergeSort(list, l, m);
            mergeSort(list, m+1, h);

            sort(list, l, m, h);
        }
    }

    static void sort(List<Integer> list, int l, int m, int h)
    {

        List<Integer> leftCopy = list.subList(l,m);
        List<Integer> rightCopy = list.subList(m+1,h);

        int pos = l;
        int leftCur = 0;
        int rightCur = 0;
        while(leftCur<leftCopy.size() && rightCur < rightCopy.size())
        {
            if(leftCopy.get(leftCur)<=rightCopy.get(rightCur))
            {
                list.set(pos, leftCopy.get(leftCur));
                leftCur++;
                pos++;
            }else
            {
                list.set(pos, rightCopy.get(rightCur));
                rightCur++;
                pos++;
            }
        }

        while(leftCur<leftCopy.size())
        {
            list.set(pos,leftCopy.get(leftCur));
            leftCur++;
        }

        while(rightCur<rightCopy.size())
        {
            list.set(pos, rightCopy.get(rightCur));
            rightCur++;
        }

    }
}
