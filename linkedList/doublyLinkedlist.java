import java.util.*;

public class DoublyLinkedlist{
        public class Node {
            int data;
            Node next;
            Node prev;

            public Node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }
        public static Node head;
        public static Node tail;
        public static int size;

        public void addFirst(int data) {
            Node newNode = new Node(data);
            size++;

            if (head == null) {
                head = tail = newNode;
                return;
            }

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "<->");
                temp = temp.next;
            }
            System.out.println("null");
        }
        public int removeFirst() {
            if (size == 0) {
                System.out.println("Doubly LinkedList is empty!");
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
            head.prev= null;
            size--;
            return val;
        }
        public void addLast(int data) {
            Node newNode = new Node(data);
            size++;

            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        public int removeLast() {
            if (size == 0) {
                System.out.println("doubly LinkedList is empty!");
                return Integer.MIN_VALUE;
            }

            int val = tail.data;

            if (size == 1) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }

            size--;
            return val;
        }
        public void reverse(){
            Node prev = null;
            Node current = head;
            Node next;
            while(current != null){
                next = current.next;
                current.next = prev;
                current.prev = next;

                prev = current;
                current = next;
            }
            head = prev;
        }
        public static Boolean isCycle(){
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    return true;
                }
            }
            return false;
        }

    public static void main(String args[]){
        DoublyLinkedlist dll = new DoublyLinkedlist();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        dll.removeFirst();
        dll.print();
        dll.addLast(11);
        dll.print();
        dll.removeLast();
        dll.print();
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addFirst(6);
        dll.print();
        dll.reverse();
        dll.print();
    }
}