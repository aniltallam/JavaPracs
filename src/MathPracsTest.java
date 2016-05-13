import java.util.ArrayList;

/**
 * Created by well on 5/7/2016.
 */
public class MathPracsTest {
    public static void run(){
        MathPracs o = new MathPracs();
        //testAllFactors(o);
        //testPrimesum(o);
        //testTitleToNumber(o);
        //testGCD(o);
        //testIsPalindrome(o);
        //testArrange(o);
        testUniquePaths(o);
    }

    static void testAllFactors(MathPracs o){
        System.out.println("Testing allFactors");
        int a = 6;
        System.out.println("Factors of 6 = " + o.allFactors(a));

        a = 0;
        System.out.println("Factors of 0 = " + o.allFactors(a));

        a = 1;
        System.out.println("Factors of 1 = " + o.allFactors(a));

        a = 13;
        System.out.println("Factors of 13 = " + o.allFactors(a));

        a = 15632484;
        System.out.println("Factors of 15632484 = " + o.allFactors(a));
    }

    static void testPrimesum(MathPracs o) {
        System.out.println("Testing primesum");
        int a = 2;
        System.out.println("primesum of 2 = " + o.primesum(a));

        a = 3;
        System.out.println("primesum of 3 = " + o.primesum(a));

        a = 4;
        System.out.println("primesum of 4 = " + o.primesum(a));

        a = 6;
        System.out.println("primesum of 6 = " + o.primesum(a));

        a = 222;
        System.out.println("primesum of 222 = " + o.primesum(a));
    }

    static void testTitleToNumber(MathPracs o) {
        System.out.println("Testing TitleToNumber");
        String a = "A";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "Z";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "AA";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "ZZ";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "AAA";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "AaA";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "a";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "123";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));

        a = "";
        System.out.println("TitleToNumber of " + a + " = " + o.titleToNumber(a));
    }

    static void testGCD(MathPracs o) {
        System.out.println("Testing gcd");
        int a = 6, b = 9;
        System.out.println("GCD of " + a + ", " + b + " = " + o.gcd(a, b));

        a = 9;
        b = 6;
        System.out.println("GCD of " + a + ", " + b + " = " + o.gcd(a, b));

        a = 16;
        b = 12;
        System.out.println("GCD of " + a + ", " + b + " = " + o.gcd(a, b));

        a = 7;
        b = 13;
        System.out.println("GCD of " + a + ", " + b + " = " + o.gcd(a, b));

        a = -9; b =-6;
        System.out.println("GCD of " + a + ", "+ b + " = "  + o.gcd(a,b));

        a = 1; b =0;
        System.out.println("GCD of " + a + ", "+ b + " = "  + o.gcd(a,b));
    }

    static void testIsPalindrome(MathPracs o) {
        System.out.println("Testing isPalindrome");
        int a = 0;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = 2;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = 11;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = 232;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = 233;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = 2332;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = -2332;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = 23232;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));

        a = 1111;
        System.out.println("isPalindrome of "+a+ " = " + o.isPalindrome(a));
    }

    static void testArrange(MathPracs o) {
        System.out.println("Testing arrange");
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(0);
        System.out.print("Before: " + a);
        o.arrange(a);
        System.out.println("\tAfter: " + a);
        a.clear();

        a.add(5);
        a.add(3);
        a.add(1);
        a.add(2);
        a.add(0);
        a.add(4);
        System.out.print("Before: " + a);
        o.arrange(a);
        System.out.println("\tAfter: " + a);
        a.clear();

        a.add(5);
        a.add(0);
        a.add(1);
        a.add(0);
        a.add(0);
        a.add(2);
        System.out.print("Before: " + a);
        o.arrange(a);
        System.out.println("\tAfter: " + a);
        a.clear();

    }

    static void testUniquePaths(MathPracs o) {
        System.out.println("Testing uniquePaths");
        int a = 1, b = 1;
        System.out.println("UniquePaths for " + a + "X" + b + " : " + o.uniquePaths(a, b));
        a = 2;
        b = 2;
        System.out.println("UniquePaths for " + a + "X" + b + " : " + o.uniquePaths(a, b));

        a = 3;
        b = 3;
        System.out.println("UniquePaths for " + a + "X" + b + " : " + o.uniquePaths(a, b));

        a = 4;
        b = 4;
        System.out.println("UniquePaths for " + a + "X" + b + " : " + o.uniquePaths(a, b));

        a = 5;
        b = 5;
        System.out.println("UniquePaths for " + a + "X" + b + " : " + o.uniquePaths(a, b));

    }
}
