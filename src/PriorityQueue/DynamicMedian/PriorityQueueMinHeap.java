package PriorityQueue.DynamicMedian;

import java.util.Vector;

public class PriorityQueueMinHeap {

    private Vector<Integer> list;

    public PriorityQueueMinHeap()
    {
        list = new Vector<Integer>();
    }

    public int getSizeOfHeap()
    {
        return list.size();
    }

    public void insert(int d)
    {
        list.add(d);
        swimUp(list.size()-1);
    }

    public int pop()
    {
        int root = list.get(0);
        int lastElem = list.get(list.size()-1);
        list.set(0, lastElem);
        list.remove(list.size()-1);
        sink(0);


        return root;
    }

    private void sink(int index)
    {
        int firstChildIndex = index*2+1;
        int secondChildIndex = firstChildIndex+1;
        int indexToSwap = firstChildIndex;

        while(firstChildIndex <= list.size()-1)
        {
            if(secondChildIndex <= list.size()-1 && list.get(secondChildIndex) < list.get(firstChildIndex))
                indexToSwap = secondChildIndex;
            if(list.get(indexToSwap) < list.get(index))
            {
                swap(indexToSwap, index);
                index = indexToSwap;
            }else
            {
                break;
            }
        }
    }

    private void swimUp(int index)
    {
        while(index > 0 && list.get((index-1)/2) > list.get(index))
        {
            swap(index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    private void swap(int index1, int index2)
    {
        int i = list.get(index1);
        int j = list.get(index2);

        list.set(index2, i);
        list.set(index1, j);
    }

    public Integer getRoot()
    {
        if(list.size()==0)
            return null;
        return list.get(0);
    }
}
