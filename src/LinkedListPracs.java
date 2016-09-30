/**
 * Created by anil on 13/9/16.
 */
public class LinkedListPracs {

    public static ListNode generateSingleLinkedList(int... nums) {
        ListNode head = null, n = null;
        for (int i : nums) {
            if (head == null) {
                head = n = new ListNode(i);
            } else {
                n.next = new ListNode(i);
                n = n.next;
            }
        }
        return head;
    }

    public static ListNode addAtFirst(ListNode node, int val) {
        ListNode temp = new ListNode(val);
        temp.next = node;
        return temp;
    }

    public static void printSingleLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            sb.append(" ");
            head = head.next;
        }
        return sb.toString();
    }

    public static int lengthOf(ListNode a) {
        int l = 0;
        while (a != null) {
            l++;
            a = a.next;
        }
        return l;
    }

    public static ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
