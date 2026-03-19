import java.util.*;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    // add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // add at index
    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }

        size++;
    }

    // remove first
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty!");
            return Integer.MIN_VALUE;
        }

        int val = head.data;

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }

        size--;
        return val;
    }

    // remove last
    public int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList is empty!");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    // remove at index
    public int removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }

        if (index == 0) {
            return removeFirst();
        }

        Node prev = head;

        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = prev.next.next;

        if (index == size - 1) {
            tail = prev;
        }

        size--;
        return val;
    }

    // print list
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // find mid (optimized for merge sort)
    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next; // IMPORTANT

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // merge two sorted lists
    private Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    // merge sort
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addAt(1, 8);

        ll.print();

        ll.head = ll.mergeSort(ll.head);

        ll.print();
    }
}