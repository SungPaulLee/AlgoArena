package PriorityQueue.DynamicMedian;

public class DynamicMedianMain {

    public static void main(String[] args)
    {
        DynamicMedian dm = new DynamicMedian(new PriorityQueue(), new PriorityQueueMinHeap());

        dm.insert(1);
        dm.insert(2);
        dm.insert(3);
        dm.insert(4);
        dm.insert(5);

        System.out.println(dm.getMedian());
    }
}
