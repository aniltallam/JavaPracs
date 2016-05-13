import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by well on 5/7/2016.
 */
public class MathPracs {
    // 1. All Factors
    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if(a%i == 0){
                factors.add(i);
                if(i == a/i)
                    continue;
                factors.add(a/i);
            }
        }
        Collections.sort(factors);
        return factors;
    }

    // 2. PrimeSum
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> res = new ArrayList<>();

        if(a%2 != 0)
            return res;
        for (int i = 2; i <= a/2; i++) {
            if(isPrime(i) && isPrime(a -i)){
                res.add(i);
                res.add(a-i);
                break;
            }
        }
        return res;
    }

    private boolean isPrime(int a){
        if(a < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i == 0)
                return false;
        }
        return true;
    }

    // 3. Excel Column Number
    public int titleToNumber(String a) {
        int sum = 0;
        int mul = 0;
        char[] chars= a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int val = chars[i]-'A' +1;
            if(val < 1 || val > 26)
                return -1;
            mul = (int) Math.pow(26, chars.length - 1 -i);
            sum+= val*mul;
        }
        return sum;
    }

    // 4. GCD
    public int gcd1(int a, int b) {
        int low = a>b?b:a,
                high = a>b?a:b;
        if(low == 0)
            return high;
        if(high%low == 0)
            return low;
        for (int i = 2; i < low; i++) {
            if(low%i == 0 && high%(low/i) == 0)
                return low/i;
        }
        return 1;
    }
    public int gcd(int A, int B) { //Better and Correct solution
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }

    // 5. isPalindrome
    public boolean isPalindrome(int a) {
        if(a<0)
            return false;
        ArrayList<Integer> digits = new ArrayList<>();
        do{
            digits.add(a%10);
            a= a/10;
        }while (a>0);
        for (int i = 0; i < digits.size()/2; i++) {
            if (digits.get(i) != digits.get(digits.size() -1 - i))
                return false;
        }
        return true;
    }

    // 6. Rearrange Array
    public void arrange(ArrayList<Integer> a) {
        HashMap<Integer, Integer> displaced = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            int wanted_i = a.get(i);
            int wanted_val;
            if(displaced.containsKey(wanted_i)){
                wanted_val = displaced.get(wanted_i);
            }else {
                wanted_val = a.get(wanted_i);
            }
            int temp = a.get(i);
            a.set(i, wanted_val);
            displaced.put(i, temp);
        }
    }

    //7. Unique Paths
    public int uniquePaths(int a, int b) {
        if(a==1 || b ==1)
            return 1;
        return uniquePaths(a-1,b)+uniquePaths(a,b-1);
    }
}
