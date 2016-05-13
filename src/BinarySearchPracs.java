import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by well on 5/8/2016.
 */
public class BinarySearchPracs {

    // 1. Find number of occurences of a num in a sorted list
    public int findCount(final List<Integer> a, int b) {
        if(a == null)
            return 0;
        int cnt =0;
        int low =0, high = a.size()-1;

        while (low<=high){
            int mid = (low+high)/2;
            if (a.get(mid) == b){
                cnt++;
                for (int i = mid-1; i >= low ; i--) {
                    if (a.get(i) == b)
                        cnt++;
                    else
                        break;
                }
                for (int i = mid+1; i <= high; i++) {
                    if(a.get(i) == b)
                        cnt++;
                    else
                        break;
                }
                return cnt;
            }
            else if (a.get(mid) > b)
                high = mid -1;
            else
                low = mid + 1;
        }
        return cnt;
    }

    // 2. Search in a sorted matrix
    public int searchMatrix1(ArrayList<ArrayList<Integer>> a, int b) {
        if(a == null || a.size() < 1 || a.get(0) == null || a.get(0).size() < 1)
            return 0;
        int low_row = 0;
        int high_row = a.size() - 1;
        int col_high = a.get(0).size() - 1;

        while(low_row <= high_row){
            int mid_row = (low_row+high_row)/2;
            if(a.get(mid_row).get(0) > b){
                high_row = mid_row -1;
                continue;
            } else if (a.get(mid_row).get(col_high) < b){
                low_row = mid_row + 1;
                continue;
            }
            int low = 0;
            int high = col_high;
            while (low<=high){
                int mid = (low+high)/2;
                if(a.get(mid_row).get(mid) == b){
                    return 1;
                }else if(a.get(mid_row).get(mid) > b){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return 0;
        }
        return 0;
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int row, col;
        int m, n;

        if (A == null)
            return 0;

        m = A.size();

        if (m == 0)
            return 0;

        n = A.get(0).size();

        row = 0;
        col = n - 1;

        while (checkBound(row, col, m, n)) {

            if (B == A.get(row).get(col))
                return 1;

            int num = A.get(row).get(col);

            if (B < num)
                col--;
            else if (B > num)
                row++;

        }

        return 0;


    }

    public boolean checkBound(int row, int col, int m, int n) {
        return (row >= 0 && row < m && col >= 0 && col < n);
    }

    // 3. Square Root of Integer
    public int sqrt(int a) {
        int low =1;
        int high = a;
        while (low<= high){
            int mid = low + (high-low)/2;
            if(mid == a/mid)
                return mid;
            else if(mid > a/mid)
                high = mid -1;
            else
                low = mid + 1;
        }
        return high;
    }

    // 4. find powers
    public int pow1(int x, int n, int d) {

        if(x == 0)
            return 0;
        if( n<0)
            return -1;
        if(n ==0)
            return 1;

        ArrayList<Integer> list = new ArrayList<>();
        int start_rep = -1;
        long prod = 1;
        for (int i = 1; i <= n; i++) {
            prod*= x;
            int val = (int) (prod%d);
            if(val < 0)
                val = d+ val;
            if(list.contains(val)){
                start_rep = list.indexOf(val);
                break;
            }
            list.add(val);
        }
        int last = list.size() -1;
        if(n <= last + 1)
            return list.get(last);
        else if (start_rep == last)
            return list.get(last);
        else {
            int index = start_rep + (n-last - 2)%(last - start_rep + 1);
            return list.get(index);
        }
    }

    public int pow2(int x, int n, int d) {

        if(x == 0)
            return 0;
        if( n<0)
            return -1;
        if(n ==0)
            return 1;

        ArrayList<Integer> list = new ArrayList<>();
        int start_rep = -1;
        int val = 1;
        for (int i = 1; i <= n; i++) {
            long temp = val*(x%d);
            val = (int)(temp%d);
            if(val < 0)
                val = d+ val;
            if(list.contains(val)){
                start_rep = list.indexOf(val);
                break;
            }
            list.add(val);
        }
        int last = list.size() -1;
        if(n <= last + 1)
            return list.get(last);
        else if (start_rep == last)
            return list.get(last);
        else {
            int index = start_rep + (n-last - 2)%(last - start_rep + 1);
            return list.get(index);
        }
    }

    public int pow3(int x, int n, int d) {

        if(x == 0)
            return 0;
        if( n<0)
            return -1;
        if(n ==0)
            return 1;

        ArrayList<Integer> list = new ArrayList<>();
        int start_rep = -1;

        for (int i = 1; i <= n; i++) {
            int val = (int)(powBySquare(x,i)%d);
            if(val < 0)
                val = d+ val;
            if(list.contains(val)){
                start_rep = list.indexOf(val);
                break;
            }
            list.add(val);
        }
        int last = list.size() -1;
        if(n <= last + 1)
            return list.get(last);
        else if (start_rep == last)
            return list.get(last);
        else {
            int index = start_rep + (n-last - 2)%(last - start_rep + 1);
            return list.get(index);
        }
    }

    long powBySquare(long x, int n){

//        System.out.println("x = " + x);
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n%2 == 0)
            return powBySquare(x*x,n/2);
        else
            return x*powBySquare(x*x,(n-1)/2);
    }
    public int pow4(int x, int n, int d) {
        if(x == 0)
            return 0;
        if( n<0)
            return -1;
        if(n ==0)
            return 1;

        int val = (int)(powBySquare(x,n)%d);
        if(val < 0)
            val = d+ val;
        return val;
    }

    int pow(long x, int n, int d){
        System.out.println("x = " + x);
        if(n==0)
            return 1;
        if(n==1)
            return (int)x%d;
        if(n%2 == 0)
            return pow((x*x)%d,n/2,d);
        else
            return (int)(x*pow((x*x)%d,(n-1)/2,d))%d;
    }

    int pow5(int x, int n, int d){
        if(x==0)
            return 0;
        if(n<0)
            return -1;
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return x%d;
        }
        if(n%2==0){
            int a = pow5(x,n/2,d);
            int b = (int)(Math.pow(a,2)%d);
            return b;
        }else {
            int a = pow5(x,(n-1)/2,d);
            int b = (int)(Math.pow(a,2)%d);
            long temp = (long)b*x;
            int c = (int)(temp%d);
            return c;
            //return (int)(((Math.pow(a,2)%d)*x)%d);
        }
    }
    public int pow6(int x, int n, int d) {  //interviewBit best Solution

        long a = x;
        long res = 1L;

        while (n > 0) {

            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }

            a *= a;
            a %= d;
            n = n /2;

        }

        res = (res + d) % d;

        return (int) res;
    }

    // 5. Median of Array
    public double findMedianSortedArrays(final List<Integer> a_, final List<Integer> b_) {
        List<Integer> a = a_;
        List<Integer> b = b_;
        if (a == null || a.size() == 0) {
            a =b;
        }
        if (b == null || b.size() == 0){
            b =a;
        }
        if (a == null || a.size() == 0){
            return -1;
        }
        int as = 0, ae = a.size()-1;
        int bs = 0, be = b.size()-1;
        while (as<=ae && bs <= be){
            int val = compareMedians(a,b,as,ae,bs,be);
            if(val == 0 || (ae-as <2 && be-bs <2)){
                int a1 = a.get((ae+as)/2);
                int a2 = a.get((int)Math.ceil(((double) ae+as)/2));
                int b1 = b.get((be+bs)/2);
                int b2 = b.get((int)Math.ceil(((double) be+bs)/2));
                double med = a1>b1?a1:b1;
                med+=a2>b2?b2:a2;
                return med/2;
            } else if(val > 0){
                //if(ae-as > 1)
                    ae = (int)Math.ceil(((double) ae+as)/2);
                //if(be-bs>1)
                    bs = (be+bs)/2;
            } else {
                //if(ae-as > 1)
                    as = (ae+as)/2;
                //if(be-bs>1)
                    be = (int)Math.ceil(((double) be+bs)/2);
            }
        }
        return -1;
    }

    private int compareMedians(List<Integer> a, List<Integer> b, int as, int ae, int bs, int be) {
        int a1 = a.get((ae+as)/2);
        int a2 = a.get((int)Math.ceil(((double) ae+as)/2));
        int b1 = b.get((be+bs)/2);
        int b2 = b.get((int)Math.ceil(((double) be+bs)/2));
        if(a1>b2)
            return 1;
        else if(a2<b1)
            return -1;
        return 0;
    }

    public double findMedianSortedArrays1(final List<Integer> a_, final List<Integer> b_) {
        List<Integer> a = a_;
        List<Integer> b = b_;
        if (a == null || a.size() == 0) {
            a =b;
        }
        if (b == null || b.size() == 0){
            b =a;
        }
        if (a == null || a.size() == 0){
            return -1;
        }
        int as = 0, ae = a.size()-1;
        int bs = 0, be = b.size()-1;
        while (as<=ae && bs <= be){
            int val = compareMedians(a,b,as,ae,bs,be);
            if(val == 0 || (ae-as <2 && be-bs <2)){
                int a1 = a.get((ae+as)/2);
                int a2 = a.get((int)Math.ceil(((double) ae+as)/2));
                int b1 = b.get((be+bs)/2);
                int b2 = b.get((int)Math.ceil(((double) be+bs)/2));
                double med = a1>b1?a1:b1;
                med+=a2>b2?b2:a2;
                return med/2;
            } else if(val > 0){
                //if(ae-as > 1)
                ae = (int)Math.ceil(((double) ae+as)/2);
                //if(be-bs>1)
                bs = (be+bs)/2;
            } else {
                //if(ae-as > 1)
                as = (ae+as)/2;
                //if(be-bs>1)
                be = (int)Math.ceil(((double) be+bs)/2);
            }
        }
        return -1;
    }

    public double findMedianSortedArrays2(final List<Integer> a_, final List<Integer> b_) {
        List<Integer> a = a_;
        List<Integer> b = b_;

        if (a == null || b == null) {
            return -1;
        }
        int as = 0, ae = a.size() - 1;
        int bs = 0, be = b.size() - 1;


        int fill = (int)Math.ceil(((double)ae+be + 2)/2); //median position

        if((ae+be)%2 == 0){
            fill++;
        }
        ArrayList<Integer> tempFill = new ArrayList<>(fill);
        int fEnd = Integer.MIN_VALUE;
        int fBeforeEnd = Integer.MIN_VALUE;
        while (fill > 0){
            if(ae - as < be - bs){ // swap a, b
                List<Integer> temp = a;
                a = b;
                b = temp;

                int temp1 = ae;
                ae = be;
                be = temp1;

                temp1 = as;
                as = bs;
                bs = temp1;
            }

            int n1 = fill/2 > be - bs + 1 ? be-bs : fill/2 - 1;
            int m1 = fill - n1 - 2;

            if(n1 < 0) {
                fill -= m1 + 1;
                if(m1 > 0){
                    if(fEnd < a.get(as + m1 - 1))
                        fBeforeEnd = a.get(as + m1 -1);
                    else
                        fBeforeEnd = fEnd;
                } else {
                    fBeforeEnd = fEnd;
                }
                fEnd = a.get(as + m1);
                tempFill.addAll(a.subList(as,as+m1+1));
                as = as + m1 + 1;
            }
            else if (a.get(as+m1) == b.get(bs+n1)){
                fill-= m1 + n1 + 2;
                fEnd = fBeforeEnd = a.get(as+m1);
                tempFill.addAll(a.subList(as,as+m1+1));
                tempFill.addAll(b.subList(bs,bs+n1+1));
            }
            else if (a.get(as+m1) < b.get(bs+n1)) {
                fill -= m1 + 1;
                if (m1 > 0) {
                    if(fEnd < a.get(as + m1 - 1))
                        fBeforeEnd = a.get(as + m1 - 1);
                    else
                        fBeforeEnd = fEnd;
                } else {
                    fBeforeEnd = fEnd;
                }
                fEnd = a.get(as + m1);
                tempFill.addAll(a.subList(as,as+m1+1));
                as = as + m1 + 1;
                be = bs + n1;
            } else {
                fill -= n1 + 1;
                if (n1 > 0) {
                    if(fEnd < b.get(bs + n1 - 1))
                        fBeforeEnd = b.get(bs + n1 - 1);
                    else
                        fBeforeEnd = fEnd;
                } else {
                    fBeforeEnd = fEnd;
                }
                fEnd = b.get(bs + n1);
                tempFill.addAll(b.subList(bs,bs+n1+1));
                bs = bs + n1 + 1;
                ae = as + m1;
            }
        }
        System.out.println("tempFill = " + tempFill);
        System.out.println("fBeforeEnd = " + fBeforeEnd);
        System.out.println("fEnd = " + fEnd);
        if((a.size()+b.size()) % 2 == 0){
            return (double)(fEnd+fBeforeEnd)/2;
        }else
            return fEnd;
    }

    public double findMedianSortedArraysCrude(final List<Integer> a_, final List<Integer> b_) {
        List<Integer> a = new ArrayList<>(a_);
        a.addAll(b_);
        Collections.sort(a);
        int size = a.size();
        if(size%2 == 0){
            return ((double)a.get(size/2 -1)+a.get(size/2))/2;
        }
        else return a.get(size/2);

    }

    public double findMedianSortedArrays3(final List<Integer> a_, final List<Integer> b_) {
        List<Integer> a = a_;
        List<Integer> b = b_;

        if (a == null || b == null) {
            return -1;
        }

        int fill = (int)Math.ceil(((double)a.size() + b.size())/2); //median position

        if((a.size() + b.size())%2 == 0){
            fill++;
        }
        //ArrayList<Integer> tempFill = new ArrayList<>(fill);
        int fEnd = Integer.MIN_VALUE;
        int fBeforeEnd = Integer.MIN_VALUE;
        while (fill > 0){
            if(a.size() < b.size()){ // swap a, b
                List<Integer> temp = a;
                a = b;
                b = temp;
            }
//            System.out.println("Filled bucket = " + tempFill);
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//            System.out.println("More to fill = " + fill+"\n");

            int n1 = fill/2 > b.size() ? b.size() -1 : fill/2 - 1;
            int m1 = fill - n1 - 2;

            if(n1 < 0)
                n1 = 0;
            if(m1 < 0)
                m1 = 0;

            if (b.isEmpty() || a.get(m1) < b.get(n1)) {
                fill -= m1 + 1;
                if (fEnd < a.get(m1)) {
                    int temp = fEnd;
                    fEnd = a.get(m1);
                    if (m1 > 0) {
                        if (temp < a.get(m1 - 1))
                            fBeforeEnd = a.get(m1 - 1);
                        else
                            fBeforeEnd = temp;
                    } else {
                        fBeforeEnd = temp;
                    }
                } else if (fBeforeEnd < a.get(m1)) {
                    fBeforeEnd = a.get(m1);
                }
                //tempFill.addAll(a.subList(0, m1 + 1));
                if (!b.isEmpty()) {
                    if (m1 + 1 <= a.size() - 1)
                        a = a.subList(m1 + 1, a.size());
                    else
                        a = new ArrayList<>();
                    b = b.subList(0, n1 + 1);
                }
            }
            else if (a.get(m1) > b.get(n1)) {
                fill -= n1 + 1;
                //
                if (fEnd < b.get(n1)) {
                    int temp = fEnd;
                    fEnd = b.get(n1);
                    if (n1 > 0) {
                        if (temp < b.get(n1 - 1))
                            fBeforeEnd = b.get(n1 - 1);
                        else
                            fBeforeEnd = temp;
                    } else {
                        fBeforeEnd = temp;
                    }
                } else if (fBeforeEnd < b.get(n1)) {
                    fBeforeEnd = b.get(n1);
                }
                //
                //tempFill.addAll(b.subList(0,n1+1));
                a = a.subList(0, m1+1);
                if(n1+1 <= b.size() -1)
                    b = b.subList(n1+1, b.size());
                else
                    b = new ArrayList<>();
            }
            else { //when both are equal
                fill-= m1 + n1 + 2;
                fEnd = fBeforeEnd = a.get(m1);
                //tempFill.addAll(a.subList(0,m1+1));
                //tempFill.addAll(b.subList(0,n1+1));
            }
        }
//        System.out.println("Filled Bucket = " + tempFill);
//        System.out.println("\nfBeforeEnd = " + fBeforeEnd);
//        System.out.println("fEnd = " + fEnd);
        if((a_.size()+b_.size()) % 2 == 0){
            return (double)(fEnd+fBeforeEnd)/2;
        }else
            return fEnd;
    }
}
