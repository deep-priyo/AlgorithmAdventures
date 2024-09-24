public class Main {
    public static void main(String[] args) {
//        LL linkedList = new LL();
//        linkedList.insertAtFirst(5);
//        linkedList.insertAtFirst(4);
//        linkedList.insertAtFirst(3);
//        linkedList.insertAtFirst(2);
//        linkedList.insertAtFirst(1);
//        linkedList.insert(45,2);
//        linkedList.display();
//        linkedList.displayHead();
//        linkedList.displayTail();
//        linkedList.deleteFirst();
//        linkedList.display();
//        linkedList.deleteLast();
//        linkedList.display();
//        linkedList.deleteAtIndex(2);
//        linkedList.display();
        //linkedList.getSize();
//        DL dl = new DL();
//        dl.insertFirst(4);
//        dl.insertFirst(3);
//        dl.insertFirst(2);
//        dl.insertFirst(1);
//        dl.insertLast(5);
//        dl.insertAtIndex(2,45);
//        dl.display();
        CircularLL ll = new CircularLL();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        ll.display();
        ll.delete(3);
        ll.display();
        ll.delete(1);
        ll.display();
        ll.delete(5);
        ll.display();
    }
}