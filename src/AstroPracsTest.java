/**
 * Created by Anil on 5/13/2016.
 */
public class AstroPracsTest {
    public static void run() {
        AstroPracs o = new AstroPracs();

        testGenerateFibonnaciList(o);
        testReverseLinkedList(o);
        testReverseForEachKnodes(o);
        testMergeListsAlternatively(o);
    }

    private static void testGenerateFibonnaciList(AstroPracs o){
        System.out.println("In testGenerateFibonnaciList !!!\n--------------------------------\n");

        int n = -2;
        System.out.println("Fibonacci series for n = " + n);
        printSingleLinkedList(o.generateFibonnaciList(n));

        n = 0;
        System.out.println("Fibonacci series for n = " + n);
        printSingleLinkedList(o.generateFibonnaciList(n));

        n = 1;
        System.out.println("Fibonacci series for n = " + n);
        printSingleLinkedList(o.generateFibonnaciList(n));

        n = 2;
        System.out.println("Fibonacci series for n = " + n);
        printSingleLinkedList(o.generateFibonnaciList(n));

        n = 100;
        System.out.println("Fibonacci series for n = " + n);
        printSingleLinkedList(o.generateFibonnaciList(n));

        System.out.println("\n ----------- End Of TestCase -------------\n\n");

    }
    static void printSingleLinkedList(ListNode head){
        while (head!= null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static void testReverseLinkedList(AstroPracs o) {
        System.out.println("In testReverseLinkedList !!!\n-------------------------\n");

        int n = 300;
        ListNode head = o.generateFibonnaciList(n);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        head = o.reverseLinkedList(head);
        System.out.print("Reversed list -> ");printSingleLinkedList(head);
        System.out.println("\n");

        head = o.reverseLinkedList(null);
        System.out.print("Checking for null -> ");printSingleLinkedList(head);
        System.out.println("\n");

        head = o.reverseLinkedList(new ListNode(2));
        System.out.print("Checking for single node with val 2 -> "); printSingleLinkedList(head);

        System.out.println("\n ----------- End Of TestCase -------------\n\n");
    }

    private static void testReverseForEachKnodes(AstroPracs o) {
        System.out.println("In testReverseForEachKnodes !!!\n----------------------------\n");

        int k = 3;
        ListNode head = generateSequentialList(25);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        try {
            head = o.reverseForEachKnodes(head, k);
            System.out.print("Reversed list for k = "+k+" -> "); printSingleLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");

        k = 1;
        head = generateSequentialList(25);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        try {
            head = o.reverseForEachKnodes(head, k);
            System.out.print("Reversed list for k = "+k+" -> "); printSingleLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");

        k = 24;
        head = generateSequentialList(25);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        try {
            head = o.reverseForEachKnodes(head, k);
            System.out.print("Reversed list for k = "+k+" -> "); printSingleLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");

        k = 25;
        head = generateSequentialList(25);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        try {
            head = o.reverseForEachKnodes(head, k);
            System.out.print("Reversed list for k = "+k+" -> "); printSingleLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");

        k = 30;
        head = generateSequentialList(25);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        try {
            head = o.reverseForEachKnodes(head, k);
            System.out.print("Reversed list for k = "+k+" -> "); printSingleLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");


        try {
            head = o.reverseForEachKnodes(null, k);
            System.out.print("Checking for null -> "); printSingleLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");


        try {
            head = o.reverseForEachKnodes(new ListNode(2), 3);
            System.out.print("Checking for single node with val 2 -> ");printSingleLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");

        k = -1;
        head = generateSequentialList(25);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        try {
            head = o.reverseForEachKnodes(head, k);
            System.out.print("Reversed list for k = "+k+" -> "); printSingleLinkedList(head);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("e = " + e);
        }
        System.out.println("\n");

        k = 0;
        head = generateSequentialList(25);
        System.out.print("Actual list -> "); printSingleLinkedList(head);
        try {
            head = o.reverseForEachKnodes(head, k);
            System.out.print("Reversed list for k = "+k+" -> "); printSingleLinkedList(head);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("e = " + e);
        }
        System.out.println("\n ----------- End Of TestCase -------------\n\n");
    }

    static ListNode generateSequentialList(int n){
        ListNode head = null;
        ListNode temp = null;
        for (int i = 1; i <= n; i++) {
            if(head == null){
                head = temp = new ListNode(i);
            }else {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
        }
        return head;
    }

    private static void testMergeListsAlternatively(AstroPracs o) {
        System.out.println("In testMergeListsAlternatively !!!\n-------------------------------\n");

        ListNode list1 = generateSequentialList(10);
        list1 = o.reverseLinkedList(list1);
        System.out.print("list1 -> "); printSingleLinkedList(list1);
        ListNode list2 = generateSequentialList(10);
        System.out.print("list2 -> "); printSingleLinkedList(list2);
        System.out.print("Merged list (list1, list2) -> "); printSingleLinkedList(o.mergeListsAlternatively(list1, list2));
        System.out.println("\n");

        list1 = o.reverseLinkedList(generateSequentialList(5));
        System.out.print("list1 -> "); printSingleLinkedList(list1);
        list2 = generateSequentialList(10);
        System.out.print("list2 -> "); printSingleLinkedList(list2);
        System.out.print("Merged list (list1, list2) -> "); printSingleLinkedList(o.mergeListsAlternatively(list1, list2));
        System.out.println("\n");

        list1 = o.reverseLinkedList(generateSequentialList(10));
        System.out.print("list1 -> "); printSingleLinkedList(list1);
        list2 = generateSequentialList(5);
        System.out.print("list2 -> "); printSingleLinkedList(list2);
        System.out.print("Merged list (list1, list2) -> "); printSingleLinkedList(o.mergeListsAlternatively(list1, list2));
        System.out.println("\n");

        list1 = o.reverseLinkedList(generateSequentialList(0));
        System.out.print("list1 -> "); printSingleLinkedList(list1);
        list2 = generateSequentialList(5);
        System.out.print("list2 -> "); printSingleLinkedList(list2);
        System.out.print("Merged list (list1, list2) -> "); printSingleLinkedList(o.mergeListsAlternatively(list1, list2));
        System.out.println("\n");

        list1 = o.reverseLinkedList(generateSequentialList(5));
        System.out.print("list1 -> "); printSingleLinkedList(list1);
        list2 = generateSequentialList(0);
        System.out.print("list2 -> "); printSingleLinkedList(list2);
        System.out.print("Merged list (list1, list2) -> "); printSingleLinkedList(o.mergeListsAlternatively(list1, list2));
        System.out.println("\n");

        list1 = null;
        System.out.print("list1 -> "); printSingleLinkedList(list1);
        list2 = null;
        System.out.print("list2 -> "); printSingleLinkedList(list2);
        System.out.print("Merged list (list1, list2) -> "); printSingleLinkedList(o.mergeListsAlternatively(list1, list2));

        System.out.println("\n ----------- End Of TestCase -------------\n\n");
    }
}
