public class CircularLL {
    private Node head;
    private Node tail;
    int size;
    public CircularLL() {
        this.size = 0;
    }
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head=tail=newNode;
            return;
        }
        tail.next = newNode;
        newNode.next=head;
        tail=newNode;
        size++;
    }
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> "); // Print current node's data with arrow
            current = current.next;
        } while (current != head); // Continue until we loop back to head

        // Close the loop visually
        System.out.print("(back to head: " + head.data + ")\n");
    }
    private class Node
    {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
