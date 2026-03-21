import java.util.*;
public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void addAt(int index , int data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
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
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }
    public int removeLast(){
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
        for(int i = 0 ; i < size -2;i++){
            prev = prev.next;
        }

        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public int removeAt(int index){
        if(index == 0){
            return removeFirst();
        }
        Node prev = head;
        for(int i = 0 ; i < index -1; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        if(index == size -1){
            tail= prev;
        }
        size--;
        return val;
    }
    public void swap(int a, int b){
        if (a == b) {
            return;
        }
        if (a < 0 || b < 0 || a >= size || b >= size) {
            System.out.println("Invalid index for swap!");
            return;
        }

        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        Node first = head;
        for (int i = 0; i < a; i++) {
            first = first.next;
        }

        Node second = head;
        for (int i = 0; i < b; i++) {
            second = second.next;
        }

        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }
    public void beep(int n, int m){
        Node curr = head;
        while(curr != null){
            for(int i = 1 ; i < m && curr != null; i++){
                curr= curr.next;
            }
            Node temp = curr.next;
            for(int i = 0 ; i < n && temp!= null; i++){
                temp  = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }

    public void oddEvenLinkedList(){
        if (head == null || head.next == null) {
            return;
        }

        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = null;

            if (curr.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }

            curr = nextNode;
        }

        if (evenHead == null) {
            head = oddHead;
            tail = oddTail;
            return;
        }

        head = evenHead;
        evenTail.next = oddHead;
        tail = (oddTail != null) ? oddTail : evenTail;
    }

    public static Node mergeKSortedLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        for (Node node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        Node dummy = new Node(-1);
        Node curr = dummy;

        while (!pq.isEmpty()) {
            Node smallest = pq.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    public static Node buildList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node headNode = new Node(arr[0]);
        Node temp = headNode;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return headNode;
    }

    public static void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node l1 = buildList(new int[]{1, 3});
        Node l2 = buildList(new int[]{6, 8});
        Node l3 = buildList(new int[]{9, 10});

        Node[] lists = new Node[]{l1, l2, l3};
        Node mergedHead = mergeKSortedLists(lists);
        printList(mergedHead);
    }
}