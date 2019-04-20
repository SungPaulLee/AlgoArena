public class TestingClass {
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
        if(head == null) return null;
        ListNode newHead = setNext(head);
        head.next = null;
        return newHead;
    }

    static ListNode setNext(ListNode node)
    {
        if(node.next == null)
            return node;
        ListNode rootNode = setNext(node.next);
        node.next.next = node;
        return rootNode;
    }


}
