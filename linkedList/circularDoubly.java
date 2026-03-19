public class CircularDoublyLL {

    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    // add to empty
    static Node addToEmpty(Node last, int data) {
        if (last != null) return last;

        Node newNode = new Node(data);
        newNode.next = newNode;
        newNode.prev = newNode;

        return newNode;
    }

    // add at front
    static Node addFront(Node last, int data) {
        if (last == null) return addToEmpty(last, data);

        Node head = last.next;
        Node newNode = new Node(data);

        newNode.next = head;
        newNode.prev = last;

        head.prev = newNode;
        last.next = newNode;

        return last;
    }

    // add at end
    static Node addEnd(Node last, int data) {
        if (last == null) return addToEmpty(last, data);

        Node head = last.next;
        Node newNode = new Node(data);

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;

        return newNode; // new last
    }

    // add after a key
    static Node addAfter(Node last, int key, int data) {
        if (last == null) return null;

        Node temp = last.next;

        do {
            if (temp.data == key) {
                Node newNode = new Node(data);

                newNode.next = temp.next;
                newNode.prev = temp;

                temp.next.prev = newNode;
                temp.next = newNode;

                if (temp == last) {
                    last = newNode;
                }

                return last;
            }
            temp = temp.next;
        } while (temp != last.next);

        System.out.println("Key not found");
        return last;
    }

    // remove first
    static Node removeFirst(Node last) {
        if (last == null) return null;

        if (last.next == last) return null;

        Node head = last.next;
        Node newHead = head.next;

        last.next = newHead;
        newHead.prev = last;

        return last;
    }

    // remove last
    static Node removeLast(Node last) {
        if (last == null) return null;

        if (last.next == last) return null;

        Node newLast = last.prev;

        newLast.next = last.next;
        last.next.prev = newLast;

        return newLast;
    }

    // delete by value
    static Node deleteKey(Node last, int key) {
        if (last == null) return null;

        Node curr = last.next;

        do {
            if (curr.data == key) {

                if (curr.next == curr) {
                    return null;
                }

                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                if (curr == last) {
                    last = curr.prev;
                }

                return last;
            }
            curr = curr.next;
        } while (curr != last.next);

        System.out.println("Key not found");
        return last;
    }

    // print
    static void print(Node last) {
        if (last == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = last.next;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != last.next);

        System.out.println("(circular)");
    }

    // main
    public static void main(String[] args) {
        Node last = null;

        last = addToEmpty(last, 1);
        last = addEnd(last, 2);
        last = addEnd(last, 3);
        last = addFront(last, 0);

        print(last);

        last = addAfter(last, 2, 99);
        print(last);

        last = removeFirst(last);
        print(last);

        last = removeLast(last);
        print(last);

        last = deleteKey(last, 99);
        print(last);
    }
}