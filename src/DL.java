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
  private class Node
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
