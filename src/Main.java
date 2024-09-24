public class Main {
    public static void main(String[] args) {
        LL linkedList = new LL();
        linkedList.insertAtFirst(5);
        linkedList.insertAtFirst(4);
        linkedList.insertAtFirst(3);
        linkedList.insertAtFirst(2);
        linkedList.insertAtFirst(1);
        linkedList.insert(45,2);
        linkedList.display();
        linkedList.displayHead();
        linkedList.displayTail();
        linkedList.deleteFirst();
        linkedList.display();
        linkedList.deleteLast();
        linkedList.display();
        linkedList.deleteAtIndex(2);
        linkedList.display();
        //linkedList.getSize();
    }
}