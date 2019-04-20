package PriorityQueue.DynamicMedian;

import java.util.Vector;

//maxHeap
public class PriorityQueue {

    //we can implement priorityQueue with maxHeap

    private Vector<Integer> list;

    public PriorityQueue()
    {
        list = new Vector<Integer>();
    }

    public int getSizeOfHeap()
    {
        return list.size();
    }

    //add to the end and find its way to correct position
    public void insert(int n)
    {
        list.add(n);
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
        int size = list.size();
        int firstChildIndex = index*2+1;
        int secondChildIndex = firstChildIndex+1;
        int indexToSwap = firstChildIndex;
        while((firstChildIndex <= size-1))
        {
            if(secondChildIndex <= size-1)
            {
                if(list.get(firstChildIndex) < list.get(secondChildIndex))
                {
                    indexToSwap = secondChildIndex;
                }
            }

            if(list.get(index) < list.get(indexToSwap))
            {
                swap(index, indexToSwap);
                index = indexToSwap;
            }else
            {
                break;
            }
        }
    }

    private void swimUp(int index)
    {
        while(index > 0 && (list.get((index-1)/2) < list.get(index)))
        {
            swap((index-1)/2, index);
            index = (index-1)/2;
        }
    }

    private void swap(int index1, int index2)
    {
        int tmp = list.get(index1);
        int tmp2 = list.get(index2);
        list.set(index1, tmp2);
        list.set(index2, tmp);
    }

    public Integer getRoot()
    {
        if(list.size()==0)
            return null;
        return list.get(0);
    }

}
