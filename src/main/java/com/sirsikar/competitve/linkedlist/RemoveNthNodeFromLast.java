package com.sirsikar.competitve.linkedlist;

public class RemoveNthNodeFromLast {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = createLinkedList(arr);
        print(head);
        System.out.println("Removing nth item from list");
        print(removeNthFromEnd(head,2));
        print(head);
    }

    private static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            cur.setNext(node);
            cur = node;
        }
        // cur.setNext(head);
        return head;
    }

    private static  Node removeNthFromEnd(Node head, int n) {
        // Handle single node list
        if (head.getNext() == null) return null;

        Node ptr = head;
        Node temp = head;

        // Move ptr forward n times to create the gap
        int i = 1;
        while (i <= n) {
            ptr = ptr.getNext();
            i++;
        }

        // If ptr becomes null, we need to remove the head
        if (ptr == null) return head.getNext();

        // Move both until ptr reaches the last node
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
            temp = temp.getNext();
        }

        // Skip the nth node from the end
        if (temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
        }

        return head;

    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.getData() + "-->");
            head = head.getNext();
        }
        System.out.println();
    }
}
