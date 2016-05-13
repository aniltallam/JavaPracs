import java.util.ArrayList;

/**
 * Created by well on 5/7/2016.
 */
public class ArrayPracsTest {
    public static void run(){
        ArraysPracs o = new ArraysPracs();

        testCoverPoints(o);
        testLargestNumber(o);
        testSetZeroes(o);
        testFirstMissingPositive(o);
        testMaxset(o);
    }

    public static void testCoverPoints(ArraysPracs o){
        System.out.println("Testing CoverPoints function of ArrayPracs");
        //int[] x = {0, 3, 0};
        //int[] y = {0, 3, 1};
        int res = -1;
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        x.add(0); y.add(0);
        res = o.coverPoints(x, y);
        System.out.println("res = " + res);
        x.clear(); y.clear();

        x.add(0); y.add(0);
        x.add(3); y.add(3);
        x.add(0); y.add(1);
        res = o.coverPoints(x, y);
        System.out.println("res = " + res);
        x.clear(); y.clear();

        x.add(0); y.add(0);
        x.add(-1); y.add(-5);
        x.add(1); y.add(5);
        res = o.coverPoints(x, y);
        System.out.println("res = " + res);
        x.clear(); y.clear();

        x.add(0); y.add(0);
        x.add(1); y.add(1);
        x.add(0); y.add(0);
        res = o.coverPoints(x, y);
        System.out.println("res = " + res);
        x.clear(); y.clear();
    }

    public static void testLargestNumber(ArraysPracs o){
        System.out.println("Testing LargestNumber function of ArrayPracs");
        int res = -1;
        ArrayList<Integer> x = new ArrayList<>();

//        x.add(3);
//        x.add(30);
//        x.add(34);
//        x.add(5);
//        x.add(9);
//        System.out.println("res = " + largestNumber(x));
//        x.clear();
//
//        x.add(65);
//        x.add(653);
//        x.add(657);
//        x.add(5);
//        x.add(9);
//        System.out.println("res = " + largestNumber(x));
//        x.clear();
//
//        x.add(8);
//        x.add(89);
//        System.out.println("res = " + largestNumber(x));
//        x.clear();
//
//        x.add(0);
//        x.add(0);
//        x.add(0);
//        x.add(0);
//        System.out.println("res = " + largestNumber(x));
//        x.clear();
//
//        x.add(0);
//        x.add(0);
//        x.add(2);
//        x.add(1);
//        System.out.println("res = " + largestNumber(x));
//        x.clear();

        x.add(472);
        x.add(663);
        x.add(964);
        x.add(722);
        x.add(485);
        x.add(852);
        x.add(635);
        x.add(4);
        x.add(368);
        x.add(676);
        x.add(319);
        x.add(412);
        System.out.println("res = " + o.largestNumber(x));
        // System.out.println("res = " + insertionSort(x));
        x.clear();
    }

    public static void testSetZeroes(ArraysPracs o){
        System.out.println("Testing SetZeroes function of ArrayPracs");
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(0);
        a1.add(1);
        a.add(new ArrayList<>(a1));
        a1.clear();

        a1.add(1);
        a1.add(1);
        a1.add(1);
        a.add(new ArrayList<>(a1));
        a1.clear();

        a1.add(1);
        a1.add(1);
        a1.add(1);
        a.add(new ArrayList<>(a1));
        a1.clear();

        o.setZeroes(a);

    }

    public static void testFirstMissingPositive(ArraysPracs o){
        System.out.println("Testing FirstMissingPositive function of ArrayPracs");

        ArrayList<Integer> x = new ArrayList<>();

        x.add(1);
        x.add(2);
        x.add(0);
        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();

        x.add(3);
        x.add(4);
        x.add(-1);
        x.add(1);
        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();

        x.add(-8);
        x.add(-7);
        x.add(-6);
        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();

        x.add(5);
        x.add(3);
        x.add(6);
        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();

        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();

        x.add(0);
        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();

        x.add(1);
        x.add(1);
        x.add(2);
        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();

        x.add(1);
        x.add(1);
        x.add(1);
        System.out.println("res = " + o.firstMissingPositive(x));
        x.clear();
    }

    public static void testMaxset(ArraysPracs o){
        System.out.println("Testing maxset function of ArrayPracs");
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(5);
        x.add(-7);
        x.add(2);
        x.add(3);
        System.out.println("res = " + o.maxset(x));
        x.clear();


        x.add(2);
        x.add(5);
        x.add(-1);
        x.add(2);
        x.add(5);
        System.out.println("res = " + o.maxset(x));
        x.clear();

        x.add(2);
        x.add(5);
        x.add(-1);
        x.add(1);
        x.add(5);
        x.add(1);
        System.out.println("res = " + o.maxset(x));
        x.clear();

        x.add(1);
        x.add(4);
        x.add(2);
        x.add(-1);
        x.add(1);
        x.add(5);
        x.add(1);
        System.out.println("res = " + o.maxset(x));
        x.clear();

        int[] gen = { 336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421 };

        for (int i: gen
                ) {
            x.add(i);
        }
        System.out.println("res = " + o.maxset(x));
        x.clear();


    }
}
