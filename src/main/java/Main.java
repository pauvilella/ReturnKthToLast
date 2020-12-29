public class Main {
    //Implement the algorithm iteratively
    static MySinglyLinkedListNode<Integer> retKthToLast1(MySinglyLinkedList<Integer> list, int k) {
        if(k == 0) { return new MySinglyLinkedListNode<Integer>(null, null); }

        MySinglyLinkedListNode<Integer> fast = list.head;
        MySinglyLinkedListNode<Integer> slow = list.head;

        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     * Index
     */
    //Wrapper class for a counter.
    public static class Index {
        public int value = 0;
    }

    //Implement the algorithm recursively
    static MySinglyLinkedListNode<Integer> retKthToLast2(MySinglyLinkedList<Integer> list, int k) {
        Index idx = new Index();
        return kthToLast(list.head, k, idx);
    }

    static MySinglyLinkedListNode<Integer> kthToLast(MySinglyLinkedListNode<Integer> head, int k, Index idx) {
        if (head == null) {
            return new MySinglyLinkedListNode<Integer>(null, null);
        }
        MySinglyLinkedListNode<Integer> node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }

    public static void main(String[] args) {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<Integer>();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addEnd(6);
        list.addEnd(7);
        MySinglyLinkedListNode<Integer> resultNode = retKthToLast1(list, 1);
        resultNode.printMe();
        resultNode = retKthToLast2(list, 3);
        resultNode.printMe();
    }
}
