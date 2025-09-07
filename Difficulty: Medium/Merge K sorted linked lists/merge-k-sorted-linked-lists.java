/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    static Node mergeLL(Node h1, Node h2) {
        Node dummy = new Node(0);
        Node p = dummy;
        
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if (h1 != null) p.next = h1;
        else p.next = h2;
        
        return dummy.next;
    }
    Node mergeKLists(Node[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        Node head = arr[0];
        for (int i = 1; i < arr.length; i++) {
            head = mergeLL(head, arr[i]);
        }
        return head;
        
    }
}