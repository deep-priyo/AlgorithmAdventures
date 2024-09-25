public class LL {
    public Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }
    public void insertAtFirst(int val)
    {
        Node node = new Node(val);// I have the new node

        node.next = head;
        head = node;
        if(tail == null)// this is the first node
            tail = node;
        size++;
    }
    public void insertAtLast(int val)
    {
        if(tail == null) {
        insertAtFirst(val);
        return;}
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }
    public void insert(int value,int index)
    {
        if(index==0) {
            insertAtFirst(value);
            return;
        }
        if(index==size) {
            insertAtLast(value);
            return;
        }
        Node temp=head;
        while(index>1) {
            temp=temp.next;
            index--;
        }
        Node newNode = new Node(value,temp.next);
        temp.next = newNode;



    }
    public Node get(int index)
    {
        Node node = head;
        for(int i=0;i<index;i++) {
            node=node.next;
        }
        return node;
    }
    public int deleteLast2()
    {
        if(size<=1)
        {
            return deleteFirst();
        }
        Node secondLast=get(size-2);
        int val=tail.value;
        tail=secondLast;
        tail.next=null;
        return val;
    }
    public int deleteAtIndex(int index)
    {
        if(index==0) {
            return deleteFirst();
        }
        if(index==size-1) {
            return deleteLast2();
        }
        Node prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;
    }public Node findValue(int data)
    {
        Node temp=head;
        while(temp.next!=null) {
            if(temp.value==data) {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    public int deleteLast()
    {
        Node temp=head;
        int val=tail.value;
        if(head==null) {
            System.out.println("List is empty");
            return -1;
        }
        if(head==tail) {
            head=tail=null;
            return val ;
        }
        while(temp.next!=tail) {
            temp=temp.next;
        }
        tail=temp;
        tail.next=null;
        return val;
    }
    public int deleteFirst()
    {
        int val=head.value;
        head = head.next;
        if(head==null)
            tail = null;
        size--;
        return val;
    }
    public void displayHead()
    {
        System.out.println("Head: " + head.value);
    }
    public void displayTail()
    {
        System.out.println("Tail: " + tail.value);
    }
    public void getSize(){
        System.out.println("Size: " + size);
    }
    public void display()
    {
        Node pointer = head;
        while(pointer != null) {
            System.out.print(pointer.value + "->");
            pointer = pointer.next;
        }
        System.out.print("END\n");
    }
    public class Node
    {
        private int value;
        private Node next;
        public Node(int value)
        {
            this.value = value;
        }
        public Node(int value, Node next)
        {
            this.value = value;
            this.next = next;
        }


    }

    // questions
    public void dupliactes()
    {
        Node temp=head;
        while(temp.next!=null) {
            if(temp.value==temp.next.value) {
                temp.next=temp.next.next;
             size--;
            }
            else {
                temp=temp.next;
            }

        }
        tail=temp;
        tail.next=null;
    }
    public int hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&& fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
            {
                int c=0;
                do
                {
                    slow=slow.next;
                    c++;
                }while(slow!=fast);
                //System.out.println(c+1);
                return c;
            }
        }
        return 0;
    }
    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while(f != null && f.next !=null)
        { s=s.next;
            f=f.next.next;
        }
        return s;
    }
    public ListNode detectCycle(ListNode head) {
        int lengthCycle= hasCycle(head);
        if(lengthCycle==0)return null;
        ListNode first=head;
        ListNode second=head;
        for(int i=1;i<=lengthCycle;i++)
        {
            second =second.next;
        }
        while(first!=second)
        {
            first=first.next;
            second=second.next;
        }
        return first;
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public static  LL merge(LL first, LL second) {
        Node firstHead= first.head;
        Node secondHead= second.head;
        LL ans=new LL();
        while(firstHead!=null && secondHead!=null) {
            if(firstHead.value<secondHead.value)
            {
                ans.insertAtLast(firstHead.value);
                firstHead=firstHead.next;
            }
            else
            {
                ans.insertAtLast(secondHead.value);
                secondHead=secondHead.next;
            }
        }
        while(secondHead!=null) {
            ans.insertAtLast(secondHead.value);
            secondHead=secondHead.next;
        }
        while (firstHead != null) {
            ans.insertAtLast(firstHead.value);
            firstHead=firstHead.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        LL first=new LL();
        LL second=new LL();
        first.insertAtFirst(5);
        first.insertAtFirst(3);
        first.insertAtFirst(1);
        second.insertAtFirst(14);
        second.insertAtFirst(9);
        second.insertAtFirst(2);
        second.insertAtFirst(1);
        first.display();
        second.display();
        LL ans=merge(first,second);
        ans.display();
    }
}
