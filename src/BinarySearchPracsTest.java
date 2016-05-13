import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by well on 5/8/2016.
 */
public class BinarySearchPracsTest {
    public static void run(){
        BinarySearchPracs o = new BinarySearchPracs();

//        testfindCount(o);
//        testsearchMatrix(o);
//        testSqrt(o);
//        testPow(o);
        testfindMedianSortedArrays(o);
    }

    static void testfindCount(BinarySearchPracs o) {
        System.out.println("Testing findCount");
        //List<Integer> a = new ArrayList<>();
        Integer a[] = {5, 7,7, 8,8, 10};
        int b = 8;
        System.out.println("Factors of 6 = " + o.findCount(Arrays.asList(a),b));

        b = 5;
        System.out.println("Factors of 6 = " + o.findCount(Arrays.asList(a),b));

        b = 7;
        System.out.println("Factors of 6 = " + o.findCount(Arrays.asList(a),b));

        b = 10;
        System.out.println("Factors of 6 = " + o.findCount(Arrays.asList(a),b));

        b = -1;
        System.out.println("Factors of 6 = " + o.findCount(Arrays.asList(a),b));

        b = 6;
        System.out.println("Factors of 6 = " + o.findCount(Arrays.asList(a),b));

        b = 11;
        System.out.println("Factors of 6 = " + o.findCount(Arrays.asList(a),b));
    }

    static void testsearchMatrix(BinarySearchPracs o) {
        System.out.println("Testing searchMatrix");
        //List<Integer> a = new ArrayList<>();
        Integer a1[] = {2,3,4,6};
        Integer a2[] = {16, 19, 33, 36};
        Integer a3[] = {37, 38, 38, 41};
        Integer a4[] = {47, 47, 50, 51};
        Integer a5[] = {55, 57, 58, 62};
        Integer a6[] = {63, 65, 66, 66};
        Integer a7[] = {68, 70, 75, 77};
        Integer a8[] = {78, 84, 84, 86};
        Integer a9[] = {86, 87, 88, 92};
        Integer a10[] = {94, 95, 96, 97};
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<Integer>(Arrays.asList(a1)));
        a.add(new ArrayList<Integer>(Arrays.asList(a2)));
        a.add(new ArrayList<Integer>(Arrays.asList(a3)));
        a.add(new ArrayList<Integer>(Arrays.asList(a4)));
        a.add(new ArrayList<Integer>(Arrays.asList(a5)));
        a.add(new ArrayList<Integer>(Arrays.asList(a6)));
        a.add(new ArrayList<Integer>(Arrays.asList(a7)));
        a.add(new ArrayList<Integer>(Arrays.asList(a8)));
        a.add(new ArrayList<Integer>(Arrays.asList(a9)));
        a.add(new ArrayList<Integer>(Arrays.asList(a10)));


        int b = 81;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));

        b = 84;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));

        b = 97;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));

        b = 1001;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));

        b = 0;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));

        b = 2;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));

        b = 6;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));

        b = 86;
        System.out.println("searchMatrix "+a+"\n\tkey = "+b+"\n\tresult = " + o.searchMatrix(a, b));
    }

    static void testSqrt(BinarySearchPracs o) {
        System.out.println("Testing sqrt");
        int a = 2147483647;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));

        a = -4;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));
        a = 0;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));
        a = 1;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));
        a = 2;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));
        a = 3;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));
        a = 4;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));
        a = 11;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));
        a = 2147483647;
        System.out.println("sqrt of " + a + "\n = " + o.sqrt(a));

    }

    static void testPow(BinarySearchPracs o) {
        long start = System.nanoTime();
        System.out.println("Testing Pow");
        int a = 2147483647;
        int x = 2;
        int n = 5;
        int d = 5;

        for (int i = 2; i < 20; i++) {
            d = i;
            for (int j = 0; j < 28; j++) {
                n = j;
                int val = o.pow(x,n,d);
                //System.out.print("pow(" + x + ","+n+") % "+d+" = " + val);
                int exp = (int)((long)Math.pow(x,n))%d;
                if(val != exp)
                    System.out.println(" -----  Something is wrong!!! Expected = " + exp);
                //System.out.println();
            }
        }

        x = 79161127;
        n = 99046373;
        d = 57263970;

        System.out.print("\tpow(" + x + ","+n+") % "+d+" = " + o.pow(x,n,d));

        x = 64228540;
        n = 77622773;
        d = 88392672;
        System.out.print("  |\tpow(" + x + ","+n+") % "+d+" = " + o.pow(x,n,d));

        long time = System.nanoTime() - start;
        System.out.println("\nDuration = "+ time);
    }

    static void testfindMedianSortedArrays(BinarySearchPracs o) {
        System.out.println("Testing findMedianSortedArrays");
        //List<Integer> a = new ArrayList<>();
//        Integer a[] = {-40, -25, 5, 10, 14, 28, 29, 48};
//        Integer b[] = {-48, -31, -15, -6, 1, 8};
//
//        System.out.println("Median = " + o.findMedianSortedArrays(Arrays.asList(a), Arrays.asList(b)));

        Integer a1[] = {-1,1,3,4,5,6};
        Integer b1[] = {0,2};

        //System.out.println("Median = " + o.findMedianSortedArrays3(Arrays.asList(a1), Arrays.asList(b1)));
        //System.out.println("Median (Expected) = " + o.findMedianSortedArraysCrude(Arrays.asList(a1), Arrays.asList(b1)));

        Integer a2[] = {-50, -47, -36, -35, 0, 13, 14, 16};
        Integer b2[] = {-31, 1, 9, 23, 30, 39};

        System.out.println("Median = " + o.findMedianSortedArrays3(Arrays.asList(a2), Arrays.asList(b2)));
        System.out.println("Median (Expected) = " + o.findMedianSortedArraysCrude(Arrays.asList(a2), Arrays.asList(b2)));

    }

}
