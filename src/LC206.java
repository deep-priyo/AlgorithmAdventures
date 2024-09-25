import java.util.Stack;

public class LC206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Display the elements of the linked list
        System.out.print("Linked List: ");
        head.display();
        reverseList(head);

    }
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            stack.push(current.val);
            current=current.next;
        }
        head=null;
        while (!stack.isEmpty()) {
            head=new ListNode(stack.pop());
        }
        current=head;
        while (!stack.isEmpty()) {
            current.next = new ListNode(stack.pop());
            current=current.next;
        }
        return head;
    }
}
