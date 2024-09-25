public class ListNode {
      int val;
     ListNode next;
     ListNode() {

     }
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val; this.next = next;
     }
    public void display() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.print("END\n");
    }
}
