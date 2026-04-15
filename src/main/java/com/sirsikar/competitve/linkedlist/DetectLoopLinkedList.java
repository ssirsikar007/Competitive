package com.sirsikar.competitve.linkedlist;

public class DetectLoopLinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = createLinkedListLoop(arr);
        //print(head);
        System.out.println("Is loop present in  LinkedList");
        System.out.println(detectLoop(head));
    }

    private static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null  && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                return true;
            }

        }
        return false;
    }

    private static Node createLinkedListLoop(int[] arr) {
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

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.getData() + "-->");
            head = head.getNext();
        }
        System.out.println();
    }
}
