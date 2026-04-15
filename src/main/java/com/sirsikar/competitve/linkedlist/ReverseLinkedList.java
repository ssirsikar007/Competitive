package com.sirsikar.competitve.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = createLinkedList(arr);
        print(head);
        System.out.println("Printing reverse LinkedList");
        print(reverse(head));
    }

    private static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            cur.setNext(node);
            cur = node;
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

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node tempNext = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }

}
