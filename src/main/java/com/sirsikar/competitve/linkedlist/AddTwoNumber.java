package com.sirsikar.competitve.linkedlist;

public class AddTwoNumber {
    public static void main(String[] args) {
        int[] num1 = {2,4,3};
        int[] num2 = {5,6,4};
        Node head1 = createLinkedList(num1);
        Node head2 = createLinkedList(num2);
        print(head1);
        print(head2);
        System.out.println("Printing reverse LinkedList");
        print(addTwoLL(head1, head2));
    }

    private static Node addTwoLL(Node head1, Node head2) {
        Node dummyHead = new Node(0);
        Node tail = dummyHead;
        Node p1 = head1;
        Node p2 = head2;
        int carry = 0;

        while (p1 != null || p2 != null || carry !=0) {
            int dig1 = p1 != null ? p1.getData() : 0;
            int dig2 = p2 != null ? p2.getData() : 0;
            int sum = dig1 + dig2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            Node newNode = new Node(digit);
            tail.setNext(newNode);
            tail = tail.getNext();

            p1 = p1 !=null ? p1.getNext(): null;
            p2 = p2 != null ? p2.getNext(): null;
        }
        return dummyHead.getNext();
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.getData() + "-->");
            head = head.getNext();
        }
        System.out.println();
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
}

