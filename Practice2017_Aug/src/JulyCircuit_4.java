import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Gaurav-PC on 31-07-2017.
 */
//Wrong
public class JulyCircuit_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int sum = s.nextInt();
        Map<Integer, Integer> hmap = new LinkedHashMap<>();
        int tmax = 0;
        for (int j = 0; j < N; j++) {

            int t = s.nextInt();
            int d = s.nextInt();
            hmap.put(t, d);
            if (t > tmax) {
                tmax = t;
            }
        }
        int[] arr = new int[tmax + 1];
        buildArray(arr, hmap);
        minSubArray(arr, sum);
        // int res = smallestSubWithSum(arr, tmax + 1, sum);
        System.out.println();
    }

    private static void buildArray(int[] arr, Map<Integer, Integer> hmap) {
        int temp = 0;
        int dNew;
        int dOld = 0;
        int tNew = 0;
        int tOld = 0;
        int len = 0;
        for (Integer e : hmap.keySet()) {
            len++;
            tNew = e;
            dNew = hmap.get(e);
            for (int i = tOld; i < tNew; i++) {
                arr[i] = dOld;
            }

            dOld = dNew;
            tOld = tNew;

        }
        arr[tOld] = dOld;
    }

    public static void minSubArray(int[] arrA, int x) {
        int start = 0;
        int ansEnd = 0;
        int ansStart = 0;
        int currSum = 0;
        int minLen = arrA.length;
        for (int i = 0; i <= arrA.length; i++) {
            while (currSum >= x) {
                currSum = currSum - arrA[start];
                if (i - start <= minLen) {
                    minLen = (i - start);
                    ansEnd = i;
                    ansStart = start;
                }
                start++;
            }
            if (currSum == x) {
                ansEnd = i;
                break;
            }
            if (i < arrA.length) {
                currSum = currSum + arrA[i];
            }
        }
        if (currSum != x) {
            double last = (x - currSum);
            double frac = last / arrA[ansEnd - 1];
            //minLen = minLen - 1 + frac;
            int[] fraction = toFractionPos(minLen -1 + frac);
            System.out.println(fraction[0] + "/" + fraction[1]); // 1/10000
        }
        else{
            System.out.println(minLen + "/1");
        }

    }


    private static int[] toFractionPos(double x) {
        String[] parts = Double.toString(x).split("\\.");
        double den = Math.pow(10, parts[1].length()); //denominator
        double num = Double.parseDouble(parts[0]) * den + Double.parseDouble(parts[1]); //numerator
        return reduceFraction((int) num, (int) den);
    }

    public static int[] reduceFraction(int num, int den) {
        int gcf = GCF(num, den); //greatest common factor
        int[] rf = {num / gcf, den / gcf};
        return rf;
    }

    public static int GCF(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return (GCF(b, a % b));
        }
    }
}
