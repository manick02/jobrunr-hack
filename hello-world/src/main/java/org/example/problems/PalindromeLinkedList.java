package org.example.problems;

import java.util.List;

public class PalindromeLinkedList {

    Node head;

    public PalindromeLinkedList(List<Integer> list) {
        create(list);
    }

    private void create(List<Integer> list) {
        Node temp = null;
        for (int num : list) {
            if (head == null) {
                head = new Node();
                head.val = num;
                temp = head;
            } else {
                Node node = new Node();
                node.val = num;
                temp.next = node;
                temp = node;
            }
        }
    }


    public boolean isPalindrpme() {

        Node slow = this.head;
        Node fast = this.head;
        Node firstSegmentEnd = null;
        while (fast != null && fast.next != null) {
            firstSegmentEnd = slow;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        firstSegmentEnd.next = null;
        Node temp = slow;
        Node prev = null;
        while (temp != null) {
            Node save = temp.next;
            temp.next = prev;
            prev = temp;
            temp = save;
        }

        Node reversed = prev;
        Node forward = head;
        while (forward!=null && reversed!=null) {
            if (forward.val != reversed.val) {
                return false;
            }
            forward = forward.next;
            reversed = reversed.next;
        }

        return true;

    }

    class Node {
        Node next;
        int val;
    }
}
