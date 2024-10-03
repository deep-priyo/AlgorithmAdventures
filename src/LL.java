public class LL {
    public ListNode head;
    private ListNode tail;
    private int size;
    public LL() {
        this.size = 0;
    }
    public void insertAtFirst(int val)
    {
        ListNode node = new ListNode(val);// I have the new node

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
        ListNode node = new ListNode(val);
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
        ListNode temp=head;
        while(index>1) {
            temp=temp.next;
            index--;
        }
        ListNode newNode = new ListNode(value,temp.next);
        temp.next = newNode;



    }
    public ListNode get(int index)
    {
        ListNode node = head;
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
        ListNode secondLast=get(size-2);
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
        ListNode prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;
    }public ListNode findValue(int data)
    {
        ListNode temp=head;
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
        ListNode temp=head;
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
        ListNode pointer = head;
        while(pointer != null) {
            System.out.print(pointer.value + "->");
            pointer = pointer.next;
        }
        System.out.print("END\n");
    }
    public static class ListNode
    {
        int value;
        ListNode next;
        public ListNode(int value)
        {
            this.value = value;
        }
        public ListNode(int value, ListNode next)
        {
            this.value = value;
            this.next = next;
        }


    }

    // questions
    public void dupliactes()
    {
        ListNode temp=head;
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
        ListNode firstHead= first.head;
        ListNode secondHead= second.head;
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
    public void reverse(ListNode node)
    {
        if(node==tail)
        {
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
    public ListNode reverseList(ListNode head)
    {
        if(head==null)
            return head;
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        while(present!=null)
        {
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null)
            {
                next=next.next;
            }
        }
        head=prev;
        return head;

    }
    public void iterativeRevers(ListNode node)
    {
        if(size<2)
            return;
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        while(present!=null)
        {
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null)
            {
                next=next.next;
            }
        }
        head=prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
            return head;
        ListNode current = head;
        ListNode prev= null;
        for (int i = 0; current!=null && i < left-1; i++) {
            prev=current;
            current=current.next;
        }
        ListNode last=prev;
        ListNode newEnd=current;
        ListNode next=current.next;
        for (int i = 0; current!=null &&i < right-left+1; i++) {
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null)
            {
                next=next.next;
            }
        }
        if(last!=null)
            last.next=prev;
        else
            head=prev;
        newEnd.next=current;
        return head;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode mid=head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            mid=mid.next;
        }
        ListNode prev=null;
        while(mid!=null)
        {
            ListNode temp=mid.next;
            mid.next=prev;
            prev=mid;
            mid=temp;
        }
        ListNode left=head;
        ListNode right=prev;
        while(right!=null)
        {
            if(left.value!=right.value)
                return false;
            left=left.next;
            right=right.next;
        }
        return true;
//        Node pointer=mid;
//         do{
//            System.out.println(head.value +"     "+pointer.value);
//            if(head.value!=pointer.value)
//                System.out.println();
//            head=head.next;
//            pointer=pointer.next;
//        }while ( pointer!=null);
//        return true;
    }


//https://leetcode.com/problems/reorder-list/description/

    public ListNode reorderList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode middle=middleNode(head);
        ListNode hs=reverseList(middle);
        ListNode hf=head;
        while(hf!=null && hs!=null)
        {
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;
            temp=hs.next;
            hs.next=hf;
            hs=temp;
        }
        if(hf!=null)
            hf.next=null;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)
            return null;
        ListNode curr=head;
        int size=0;
        while (curr!=null) {
            size++;
            curr=curr.next;
        }
        System.out.println("Size of LL:  "+size);
        if(size==n)
        {
            head=head.next;
            return head;
        }
        curr=head;
        while(size>n+1)
        {
            curr=curr.next;
            size--;
            System.out.println("size"+size);
        }
        System.out.println(curr.value);
        curr.next=curr.next.next;
        display();
        return head;
    }
 public ListNode removeNthFromEnd2(ListNode head,int n)
 {
     ListNode fast=head;
     ListNode slow=head;
     for (int i = 0; i < n; i++) {
         fast=fast.next;
     }
     while (fast!=null ) {
         fast=fast.next;
         slow=slow.next;
     }
     slow.next=slow.next.next;
     return head;
 }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum=new ListNode(0);
        ListNode curr=sum;
        int carry=0;
        while (l1!=null || l2!=null) {
            int a=l1==null?0:l1.value;
            int b=l2==null?0:l2.value;
            int toLinkedList=a+b+carry;
            carry=(toLinkedList/10);
            toLinkedList=toLinkedList%10;
            ListNode temp=new ListNode(toLinkedList);
            curr.next=temp;
            curr=temp;
            if(l1!=null)l1=l1.next;
            if (l2!=null)l2=l2.next;
        }
        if(carry>0) {
            curr.next= new ListNode(carry);
        }

        return sum.next;
    }
    public static void main(String[] args) {
        LL first=new LL();
//        first.insertAtFirst(5);
//        first.insertAtFirst(4);
//        //first.insertAtFirst(2);
//        first.insertAtFirst(3);
        first.insertAtFirst(2);
        first.insertAtFirst(1);
        first.display();
        first.removeNthFromEnd(first.head,2);
    }
}
