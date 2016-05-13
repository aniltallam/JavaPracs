import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 class Solution {
    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode head, temp, prev, curr, o1, o2, rt;
        head = curr = a;
        temp = prev = o1 = o2 = rt = null;
        int cnt = 1;

        while(curr!=null){
            temp = curr;
            curr = curr.next;

            if(cnt == m){
                rt = temp;
                o1 = prev;
            } else if (cnt > m && cnt < n) {
                temp.next = prev;
            } else if (cnt == n){
                o2 = temp.next; // null
                temp.next = prev;
                if(o1 != null)
                    o1.next = temp;
                else
                    head = temp;
                rt.next = o2;
                break;
            }

            prev = temp;
            cnt++;
        }


        return head;
    }


    public ListNode detectCycle2(ListNode a) {

        ListNode curr = a;
        HashSet vList = new HashSet();

        while(curr != null){
            if(vList.contains(curr)){
                return curr;
            } else {
                vList.add(curr);
                curr = curr.next;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode a) {
        ListNode cycleNode = isCycle(a);
        if(cycleNode == null)
            return null;
        int cSize = cycleSize(cycleNode);

        return  getCycleNode(a, cSize);

    }

    ListNode isCycle(ListNode a){
        if(a == null || a.next == null)
            return null;

        ListNode curr1 = a;
        ListNode curr2 = a.next;

        while(curr1 != null && curr2 != null){
            if(curr1 == curr2){
                return curr1;
            } else {
                if(curr2.next == null)
                    return null;
                curr1 = curr1.next;
                curr2 = curr2.next.next;
            }
        }


        return null;
    }

    int cycleSize(ListNode a){

        int cnt = 1;
        ListNode start = a, curr = a.next;
        while (curr!= null){
            if(curr == start){
                return cnt;
            }
            cnt++;
            curr = curr.next;
        }
        return cnt;
    }

    ListNode getCycleNode(ListNode a, int cSize){
        ListNode start = a;
        ListNode startPlusK = a;
        for(int i =0; i< cSize; i++){
            startPlusK = startPlusK.next;
        }

        while (true){
            if(start == startPlusK)
                return  start;
            start = start.next;
            startPlusK = startPlusK.next;
        }
    }
/*
    ListNode reverseListTill(ListNode A, int count){

        for(int i =1; i <= count ; i++){

            temp = curr;
            curr = curr.next;

            if(i ==1){
                rt = temp;

            }else if(i >1 && i < count){
                temp.next = prev;
            } else if(i == count){
                A = temp;
                rt.next = temp.next;
                temp.next = prev;
            }

            prev = temp;

        }
        return A;

    } */


}

//class ListNode {
//    public int val;
//    public ListNode next;
//    ListNode(int x) { val = x; next = null; }
//}

