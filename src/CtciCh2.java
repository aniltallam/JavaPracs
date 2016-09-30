/**
 * Created by anil on 13/9/16.
 */
public class CtciCh2 {

    public ListNode addReverseList(ListNode a, ListNode b) {
        return addReverseList(a, b, 0);
    }

    public ListNode addReverseList(ListNode a, ListNode b, int rem) {
        if (a == null && b == null)
            return rem > 0 ? new ListNode(rem) : null;
        int sum = rem;
        if (a != null)
            sum += a.val;
        if (b != null)
            sum += b.val;
        ListNode s = new ListNode(sum % 10);
        rem = sum / 10;
        s.next = addReverseList(
                a != null ? a.next : null,
                b != null ? b.next : null,
                rem);
        return s;
    }

    public ListNode addOrderedList(ListNode a, ListNode b) {
        int la = LinkedListPracs.lengthOf(a),
                lb = LinkedListPracs.lengthOf(b);
        return addOrderedList(a, b, la, lb);
    }

    public ListNode addOrderedList(ListNode a, ListNode b, int la, int lb) {
//        System.out.println(a + ", "+b);
//        System.out.println(la + ", "+lb);
        if (la == 0 && lb == 0) {
            return new ListNode(0);
        }
        int va = 0, vb = 0;
        int max = Math.max(la, lb);
        if (la == max) {
            va = a.val;
            la--;
            a = a.next;
        }
        if (lb == max) {
            vb = b.val;
            lb--;
            b = b.next;
        }
        ListNode s = addOrderedList(a, b, la, lb);

        int sum = va + vb + s.val;
        s.val = sum % 10;
        s = LinkedListPracs.addAtFirst(s, sum / 10);
        return s;
    }
}
