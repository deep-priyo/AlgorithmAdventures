public class LC2 {
    public LL.ListNode addTwoNumbers(LL.ListNode l1, LL.ListNode l2) {
        LL.ListNode sum=new LL.ListNode(0);
        LL.ListNode curr=sum;
        int carry=0;
        while (l1!=null && l2!=null) {
            int toLinkedList=l1.value+l2.value+carry;
            if(carry>0)
                carry--;
            if(toLinkedList>=10)
            {
                carry=carry+(toLinkedList/10);
                toLinkedList=toLinkedList%10;
            }

            LL.ListNode temp=new LL.ListNode(toLinkedList);
            curr.next=temp;
            curr=temp;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null) {
            int toLinkedList=l1.value+carry;
            if(carry>0)
                carry--;
            if(toLinkedList>=10)
            {
                carry=carry+(toLinkedList/10);
                toLinkedList=toLinkedList%10;
            }

            LL.ListNode temp=new LL.ListNode(toLinkedList);
            curr.next=temp;
            curr=temp;
            l1=l1.next;
        }
        while (l2!=null) {
            int toLinkedList=l2.value+carry;
            if(carry>0)
                carry--;
            if(toLinkedList>=10)
            {
                carry=carry+(toLinkedList/10);
                toLinkedList=toLinkedList%10;
            }

            LL.ListNode temp=new LL.ListNode(toLinkedList);
            curr.next=temp;
            curr=temp;
            l2=l2.next;
        }
        if(carry>0) {
            LL.ListNode temp = new LL.ListNode(carry);
            curr.next=temp;
            curr=temp;
        }
        System.out.println(carry);
        return sum.next;
    }
}
