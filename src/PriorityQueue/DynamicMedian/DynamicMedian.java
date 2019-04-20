package PriorityQueue.DynamicMedian;

public class DynamicMedian {


    PriorityQueue maxHeap;
    PriorityQueueMinHeap minHeap;

    public DynamicMedian(PriorityQueue maxHeap, PriorityQueueMinHeap minHeap)
    {
        this.maxHeap = maxHeap;
        this.minHeap = minHeap;
    }

    public void insert(int d)
    {
        if(maxHeap.getSizeOfHeap()<=minHeap.getSizeOfHeap())
        {
            maxHeap.insert(d);
        }else
        {
            minHeap.insert(d);
        }

        if((maxHeap.getRoot()!=null && minHeap.getRoot()!=null) && maxHeap.getRoot() > minHeap.getRoot())
        {
            int maxHeapRoot = maxHeap.pop();
            int minHeapRoot = minHeap.pop();

            minHeap.insert(maxHeapRoot);
            maxHeap.insert(minHeapRoot);
        }
    }

    public int getMedian()
    {
        return maxHeap.getRoot();
    }

    public static void main(String[] args)
    {
        PriorityQueue maxHeap = new PriorityQueue();
        PriorityQueueMinHeap minHeap = new PriorityQueueMinHeap();

        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);

        minHeap.insert(4);
        minHeap.insert(5);

    }
}
