/**
 * Created by anil on 13/9/16.
 */
public class CtciCh2Test {

    public static void run() {
        CtciCh2 o = new CtciCh2();

        testAdd(o);
    }

    private static void testAdd(CtciCh2 o){
        System.out.println("In testAdd !!!\n--------------------------------\n");

        ListNode a = LinkedListPracs.generateSingleLinkedList(1,2,3,4,5),
                b = LinkedListPracs.generateSingleLinkedList(7,8,9);
        System.out.println("Ordered Add : " +
                LinkedListPracs.listToString(a) +
                " + " +
                LinkedListPracs.listToString(b) +
                " = " +
                LinkedListPracs.listToString(o.addOrderedList(a,b))
        );
        a = LinkedListPracs.reverseLinkedList(a);
        b = LinkedListPracs.reverseLinkedList(b);
        ListNode sum = o.addReverseList(a,b);
        System.out.println("Reversed Add : " +
                LinkedListPracs.listToString(a) +
                " + " +
                LinkedListPracs.listToString(b) +
                " = " +
                LinkedListPracs.listToString(sum)
        );

        System.out.println("\n ----------- End Of TestCase -------------\n\n");

    }

}
