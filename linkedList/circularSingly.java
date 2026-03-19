public class CircularLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // add to empty list
    static Node addToEmpty(Node last, int data) {
        if (last != null) return last;

        Node newNode = new Node(data);
        newNode.next = newNode;
        return newNode;
    }

    // add at beginning
    static Node addFront(Node last, int data) {
        if (last == null) return addToEmpty(last, data);

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;

        return last;
    }

    // add at end
    static Node addEnd(Node last, int data) {
        if (last == null) return addToEmpty(last, data);

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;

        return last;
    }

    // add after a given value
    static Node addAfter(Node last, int key, int data) {
        if (last == null) return null;

        Node temp = last.next;

        do {
            if (temp.data == key) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
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

    // delete first node
    static Node removeFirst(Node last) {
        if (last == null) return null;

        if (last.next == last) return null;

        last.next = last.next.next;
        return last;
    }

    // delete last node
    static Node removeLast(Node last) {
        if (last == null) return null;

        if (last.next == last) return null;

        Node temp = last.next;

        while (temp.next != last) {
            temp = temp.next;
        }

        temp.next = last.next;
        last = temp;

        return last;
    }

    // delete a node by value
    static Node deleteKey(Node last, int key) {
        if (last == null) return null;

        Node curr = last.next;
        Node prev = last;

        do {
            if (curr.data == key) {
                if (curr == last && curr == last.next) {
                    return null;
                }

                prev.next = curr.next;

                if (curr == last) {
                    last = prev;
                }

                return last;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != last.next);

        System.out.println("Key not found");
        return last;
    }

    // print list
    static void print(Node last) {
        if (last == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = last.next;

        do {
            System.out.print(temp.data + " -> ");
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