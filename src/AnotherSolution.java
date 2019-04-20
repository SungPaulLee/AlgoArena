import java.util.ArrayList;
import java.util.List;

public class AnotherSolution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(head.toString());

        System.out.println(returnReverseOrderList(head));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    static ListNode returnReverseOrderList(ListNode head)
    {
        ListNode [] nodes = new ListNode[3];
        ListNode node = head;
        if(head == null)
            return null;
        if(head.next == null)
        {
            return head;
        }

        nodes[0] = head;
        nodes[1] = head.next;
        nodes[2] = head.next.next;
        while(nodes[2].next != null)
        {
            ListNode lastNode = nodes[2].next;
            nodes[1].next = nodes[0];
            nodes[2].next = nodes[1];
            nodes[0] = nodes[1];
            nodes[1] = nodes[2];
            nodes[2] = lastNode;
        }

        return nodes[2];

    }

    static TestingClass.ListNode setNext(TestingClass.ListNode node)
    {
        if(node.next == null)
            return node;
        TestingClass.ListNode rootNode = setNext(node.next);
        node.next.next = node;
        return rootNode;
    }


}
