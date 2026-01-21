// Node class to represent individual elements
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class with all operations
public class LinkedList {
    private Node head;
    
    // Constructor
    public LinkedList() {
        this.head = null;
    }
    
    // INSERTION OPERATIONS
    
    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // Insert at specific position (0-indexed)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    
    // DELETION OPERATIONS
    
    // Delete by value
    public void deleteByValue(int data) {
        if (head == null) return;
        
        if (head.data == data) {
            head = head.next;
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    // Delete at position (0-indexed)
    public void deleteAtPosition(int position) {
        if (head == null || position < 0) return;
        
        if (position == 0) {
            head = head.next;
            return;
        }
        
        Node current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    // UPDATE OPERATION
    
    // Update value at position
    public void updateAtPosition(int position, int newData) {
        Node current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            current.data = newData;
        }
    }
    
    // TRAVERSAL OPERATIONS
    
    // Display all elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Search for a value
    public int search(int data) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Not found
    }
    
    // Get size of list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // MAIN METHOD FOR TESTING
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Testing insertions
        System.out.println("=== INSERTION OPERATIONS ===");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2);
        System.out.print("After insertions: ");
        list.display();
        
        // Testing traversal
        System.out.println("\n=== TRAVERSAL OPERATIONS ===");
        System.out.println("Size: " + list.size());
        System.out.println("Search 15: Position " + list.search(15));
        System.out.println("Search 99: Position " + list.search(99));
        
        // Testing update
        System.out.println("\n=== UPDATE OPERATION ===");
        list.updateAtPosition(1, 25);
        System.out.print("After updating position 1 to 25: ");
        list.display();
        
        // Testing deletions
        System.out.println("\n=== DELETION OPERATIONS ===");
        list.deleteByValue(15);
        System.out.print("After deleting 15: ");
        list.display();
        
        list.deleteAtPosition(0);
        System.out.print("After deleting at position 0: ");
        list.display();
    }
}