public class DL {
    Node head;
    int size;
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if(head != null) {
        head.prev = newNode;}
        head = newNode;
    }
    public Node getNode(int index) {
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    public void insertAtIndex(int index, int data) {

        if(index == 0) {
            insertFirst(data);
            return;
        }
        if(index == size) {
            insertLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = getNode(index - 1);  // Get node just before the index

        // Correctly set newNode's next and prev pointers
        newNode.next = current.next;
        newNode.prev = current;

        // Update the next node's previous pointer if it exists
        if (current.next != null) {
            current.next.prev = newNode;
        }

        // Link the current node to the new node
        current.next = newNode;

        size++;
    }
    public void insertLast(int data) {
        Node newNode = new Node(data);
        Node current = head;
        if(head == null) {
            insertFirst(data);
            return;
        }
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
        newNode.next = null;
    }
    public void display()
    {
        Node current = head;
        Node last = null;
        while(current != null) {
            System.out.print(current.data+"->");
            last = current;
            current = current.next;
        }

        System.out.print("END\n");
        System.out.println("\nReverse order");
        while(last != null) {
            System.out.print(last.data+"<-");
            last = last.prev;
        }
        System.out.print("END\n");
    }
  public class Node
  {
      int data;
      Node next;
      Node prev;
      public Node(int val)
      {
          this.data=val;
      }
      public Node(int val, Node next, Node prev)
      {
          this.data=val;
          this.next=next;
          this.prev=prev;
      }
  }

}
