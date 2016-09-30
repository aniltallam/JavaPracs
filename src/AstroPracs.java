/**
 * Created by Anil on 5/13/2016.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val) + " [" + LinkedListPracs.listToString(next) + "]";
    }
}
public class AstroPracs {

    //1. Single linked list of Fibonnaci numbers <= n
    public ListNode generateFibonnaciList(int n){
        if(n<0)
            return null; // or throw custom exception
        int prev=0, curr=1;
        ListNode head = new ListNode(prev);
        ListNode cursor = head;
        while (curr <= n){
            cursor.next = new ListNode(curr);
            cursor = cursor.next;
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return head;
    }

    //2. reverse a single linked list
    public ListNode reverseLinkedList(ListNode head){
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

    //3. Reverse every k number of elements in a single linked list
    public ListNode reverseForEachKnodes(ListNode head, int k) throws Exception {
        if(k<1) {
            throw new Exception("Invalid K value");
        }
        ListNode prev = null;
        ListNode curr = head;
        int cnt = k;
        while (curr != null && cnt > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            cnt--;
        }
        if(curr!=null)
            head.next = reverseForEachKnodes(curr, k);
        return prev;
    }

    //4. merge two lists such that each element of list 1 is surrounded be elements for list 2 and vice versa
    public ListNode mergeListsAlternatively(ListNode list1, ListNode list2){
        ListNode head = null, curr = null;
        int cnt = 1;
        while (list1 != null && list2 != null){
            if (cnt%2 == 1){
                if (head == null){
                    head = curr = list1;
                    list1 = list1.next;
                }else {
                    curr.next = list1;
                    curr = curr.next;
                    list1 = list1.next;
                }
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
            cnt++;
        }
        if (list1 != null)
            if(head == null)
                head = list1;
            else
                curr.next = list1;
        else if (list2 != null)
            if(head == null)
                head = list2;
            else
                curr.next = list2;
        return head;
    }
}
