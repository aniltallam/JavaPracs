import java.util.*;
//import java.util.stream.Collectors;

/**
 * Created by well on 5/4/2016.
 */
public class ArraysPracs {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;

        if(a.size() == 0 && a.get(0) == null) //expectation check
            return result;

        int rows = a.size();
        int cols = a.get(0).size();

        spiralAdd(result,a,0,0,rows,cols);

        return result;
    }

    void spiralAdd(ArrayList<Integer> result, List<ArrayList<Integer>> a, int x, int y, int Rows, int Cols){

        if(Cols == 0 || Rows == 0 || x <0 || y < 0 ) //expectation check
            return; //wrong inputs.
        int Y = y+Cols -1;
        int X = x+Rows -1;
        for (int j = y; j <= Y; j++) {
            result.add((a.get(x)).get(j));
        }
        if(Rows == 1)
            return;

        for (int i = x+1; i <= X; i++) {
            result.add((a.get(i)).get(Y));
        }
        if(Cols == 1)
            return;

        for (int j = Y -1; j >= y ; j--) {
            result.add((a.get(X)).get(j));
        }

        for (int i = X -1; i > x ; i--) {
            result.add((a.get(i)).get(y));
        }

        if((Rows - 2) > 0 || (Cols -2) > 0){
            spiralAdd(result,a,x+1,y+1,Rows -2, Cols -2);
        }
    }

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder2(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;
        int m =0,n = 0, row = 0, col = -1;
        int dir = 0;
        int layer = 0;

        if(a == null || a.size() == 0)
            return result;
        n = a.size();
        m= a.get(0).size();

        /// direction is determined in prev step
        // only increment is decided in current step
        // + what shall be next direction is determined here

        for (int step = 0; step < m*n; step++) {

            switch (dir){
                case 0: //right
                    col++;
                    if(col == m -1 - layer) {
                        dir = 1;
                    }
                    break;
                case 1: //down
                    row++;
                    if(row == n-1 - layer){
                        dir = 2;
                    }
                    break;
                case 2: //left
                    col--;
                    if(col == layer){
                        dir = 3;
                    }
                    break;
                case 3: //up
                    row--;
                    if(row == 1 + layer) {
                        layer++; // In next step enter inner layer
                        dir = 0;
                    }
                    break;
            }
            result.add(a.get(row).get(col));
        }
        return result;
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int x = 0, y = 0;
        int steps = 0;

        if(X == null || Y == null || X.size() != Y.size())
            return -1;
        for (int i = 0; i < X.size(); i++) {
            if(i == 0) {
                x = X.get(i);
                y = Y.get(i);
            }
            else {
                int x1 = X.get(i);
                int y1 = Y.get(i);

                int xdist = Math.abs(x-x1);
                int ydist = Math.abs(y-y1);
                int actDist = xdist > ydist ? xdist:ydist;
                steps = steps + actDist;
                x = x1;
                y = y1;
            }
        }
        return steps;
    }

    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for (int i = 1; i < a.size(); i= i+2) {
            int temp = a.get(i);
            a.set(i,a.get(i-1));
            a.set(i-1, temp);
        }
        return a;
    }

    public class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
            Interval(int s, int e) { start = s; end = e; }
        }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> finalIntervals = new ArrayList<>();
        boolean isAdded = false;
        for (int i = 0; i < intervals.size(); i++) {
            if(!isAdded) {
                if (isIntervalsOverlapping(newInterval, intervals.get(i))) {
                    newInterval = mergeIntervals(newInterval, intervals.get(i));
                    continue;
                } else if (newInterval.end < intervals.get(i).start) {
                    finalIntervals.add(newInterval);
                    isAdded = true;
                }
            }
            finalIntervals.add(intervals.get(i));
        }
        if(!isAdded)
            finalIntervals.add(newInterval);
        return finalIntervals;
    }

    private Interval mergeIntervals(Interval newInterval, Interval interval) {
        int start = Math.min(newInterval.start, interval.start);
        int end = Math.max(newInterval.end, interval.end);
        return  (new Interval(start, end));
    }

    static boolean isIntervalsOverlapping(Interval i1, Interval i2){
        if(i1.start >= i2.start && i1.start <= i2.end)
            return true;
        if(i1.end >= i2. start && i1.end <= i2.end)
            return true;
        if(i1.start <= i2.start && i1.end >=i2.end)
            return true;
        return false;
    }

    public String largestNumber(final List<Integer> a1) {
        List<Integer> a = new ArrayList<>(a1);
//        for (int i = 1; i < a.size(); i++) {
//            for (int j = i; j > 0; j--) {
//                if (specialCompare(a.get(j), a.get(j - 1))) {
//                    int temp = a.get(j);
//                    a.set(j, a.get(j - 1));
//                    a.set(j - 1, temp);
//                } else {
//                    break;
//                }
//            }
//        }

        a = mergeSort(a);

        StringBuilder sb = new StringBuilder();
        boolean nonZeroFound = false;
        for (int i : a) {
            if (i == 0 && !nonZeroFound)
                continue;
            nonZeroFound = true;
            sb.append(i);
        }
        String str = sb.length() > 0 ? sb.toString() : "0";

        return str;
    }

    private boolean specialCompare(Integer a, Integer b) {
        String ab = a+""+b,
                ba = b+""+a;
        long ab1 = Long.parseLong(ab);
        long ba1 = Long.parseLong(ba);

        return (ab1 > ba1);

    }

    private boolean specialCompare1(Integer a, Integer b) {

        List<Integer> A = new ArrayList<>();
        do{
            int dig = a%10;
            a=a/10;
            A.add(dig);
        }while (a>0);

        List<Integer> B = new ArrayList<>();
        do{
            int dig = b%10;
            b=b/10;
            B.add(dig);
        }while (b>0);

        Collections.reverse(A);
        Collections.reverse(B);
        int i =0;
        do{
            if (A.get(i) > B.get(i))
                return true;
            else if (A.get(i) < B.get(i))
                return false;
            i++;
        } while (i < A.size() && i < B.size());
        for (int j = i-1; j < B.size(); j++) {
            if (A.get(i-1) > B.get(j))
                return true;
            else if (A.get(i-1) < B.get(j))
                return false;
        }
        for (int j = i-1; j < A.size(); j++) {
            if (B.get(i-1) > A.get(j))
                return false;
            else if (B.get(i-1) < A.get(j))
                return true;
        }
        return false;
    }

    public static String insertionSort(final List<Integer> a1) {
        List<Integer> a = new ArrayList<>(a1);
        for (int i = 1; i < a.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (a.get(j) > a.get(j - 1)) {
                    int temp = a.get(j);
                    a.set(j, a.get(j - 1));
                    a.set(j - 1, temp);
                } else
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean nonZeroFound = false;
        for (int i : a) {
            if (i == 0 && !nonZeroFound)
                continue;
            nonZeroFound = true;
            sb.append(i + " ");
        }
        String str = sb.length() > 0 ? sb.toString() : "0";

        return str;
    }

    public List<Integer> mergeSort(List<Integer> a){
        if(a.size() < 2)
            return a;
        int mid = a.size()/2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            left.add(a.get(i));
        }
        for (int i = mid; i < a.size(); i++) {
            right.add(a.get(i));
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j= 0;
        while (i < left.size() && j < right.size()){
            if(specialCompare(left.get(i), right.get(j))) {
                result.add(left.get(i));
                i++;
            }
            else {
                result.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()){
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()){
            result.add(right.get(j));
            j++;
        }
//        System.out.print("Left: ");
//        for (int e: left) {
//            System.out.print(e+" ");
//        }
//        System.out.print("Right: ");
//        for (int e: right) {
//            System.out.print(e+" ");
//        }
//        System.out.print("| Result: ");
//        for (int e: result) {
//            System.out.print(e+" ");
//        }
//        System.out.println();
        return result;
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if(a== null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0)
            return; // wrong inputs
        int rows = a.size();
        int cols = a.get(0).size();
        List<Integer> rowlist = new ArrayList<>();
        List<Integer> collist = new ArrayList<>();

        // 1. marking rows and cols which are to be made zeroes later
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(a.get(i).get(j) == 0){
                    if(!rowlist.contains(i))
                        rowlist.add(i);
                    if(!collist.contains(j))
                        collist.add(j);
                }
            }
        }

        // 2. make marked rows and cols as zeroes.
        for (int row: rowlist) {
            for (int j = 0; j < cols; j++) {
                a.get(row).set(j, 0);
            }
        }
        for (int col: collist) {
            for (int i = 0; i < rows; i++) {
                a.get(i).set(col, 0);
            }
        }
    }

    public int firstMissingPositive(ArrayList<Integer> a) {
        if(a == null || a.size() == 0)
            return 1;
        Collections.sort(a);
        List<Integer> ps = a.stream().filter(p -> p >0).collect(java.util.stream.Collectors.toList());

        if(ps.isEmpty())
            return 1;
        if(ps.get(0) != 1)
            return 1;
        for (int i = 0; i < ps.size(); i++) {
            if(i == ps.size() -1)
                return ps.get(i)+1;
            if(ps.get(i+1) - ps.get(i) > 1)
                return ps.get(i)+1;
        }
        return 1; //actually return last elem in ps + 1
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<SubArray> salist = nonNegSubArrays(a);
        if(salist.isEmpty())
            return new ArrayList<Integer>();
        Collections.sort(salist);
        return  salist.get(salist.size()-1).list;
    }

    private ArrayList<SubArray> nonNegSubArrays(ArrayList<Integer> a) {
        boolean start = false;
        SubArray sa = null;
        ArrayList<SubArray> salist = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)>=0){
                if(!start){
                    start = true;
                    sa = new SubArray();
                    sa.list.add(a.get(i));
                    salist.add(sa);
                } else {
                    sa.list.add(a.get(i));
                }
            } else {
                if (start){
                    start = false;
                    sa = null;
                }
            }
        }
        return salist;
    }

    static class SubArray implements Comparable{
        public ArrayList<Integer> list = new ArrayList<>();
        public void add(int a){
            list.add(a);
        }

        @Override
        public int compareTo(Object o) {
            SubArray that = (SubArray)o;
            long sum1 = this.list.stream().mapToLong(Integer::longValue).sum();
            long sum2 = that.list.stream().mapToLong(Integer::longValue).sum();
            int res = compareTo(sum1, sum2);
            if(res != 0)
                return res;
            res = compareTo(this.list.size(), that.list.size());
            if(res != 0)
                return res;
            for (int i = 0; i < this.list.size(); i++) {
                res = compareTo(that.list.get(i), this.list.get(i));
                if(res != 0)
                    return res;
            }
            return 0;
        }

        static int compareTo(long a, long b){
            if(a != b)
                return a>b? 1:-1;
            else
                return 0;
        }
    }



}
