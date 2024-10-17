public class lc2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode s=head;
        ListNode f=head;
        ListNode prev=head;
        while(f != null && f.next !=null)
        {
            prev=s;
            s=s.next;
            f=f.next.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}
