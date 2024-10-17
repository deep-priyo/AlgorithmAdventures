import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23 {
    public static void main(String[] args) {
        ListNode Node=new ListNode();

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
            for (ListNode node : lists) {
                while (node != null) {
                    pq.add(node.val);
                    node = node.next;
                }
            }
            if(pq.isEmpty())
                return null;
            ListNode head=new ListNode(-1);
            ListNode cur=head;
            while (!pq.isEmpty()) {
                ListNode temp=new ListNode(pq.poll());
                cur.next = temp;
                cur=temp;
            }
            return head;
        }

    }
}
