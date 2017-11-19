import java.io.IOException;
import java.util.Map;

//http://www.geeksforgeeks.org/subsequence-maximum-odd-sum/
public class Honeywell_2 {
    private static PayUHackerEarth_1.FastScanner s = new PayUHackerEarth_1.FastScanner();

    public static void main(String[] args) throws IOException {
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            long[] arr = new long[N];
            for (int j = 0; j < N; j++) {
                arr[j] = s.nextLong();
            }
            //long K = s.nextLong();
            System.out.println(findMaxOddSubarraySum(arr, N));
        }
    }

    static long findMaxOddSubarraySum(long arr[], long n) {
        // Here min_odd is the minimum odd number (in
        // absolute terms). Initializing with max value
        // of int .
        long m = Integer.MAX_VALUE;

        // To check if there is al-least one odd number.
        boolean isOdd = false;

        long sum = 0;  // To store sum of all positive elements
        for (int i = 0; i < n; i++) {
            // Adding positive number would increase
            // the sum.
            if (arr[i] > 0)
                sum = sum + arr[i];

            // To find the minimum odd number(absolute)
            // in the array.
            if (arr[i] % 2 != 0) {
                isOdd = true;
                if (m > Math.abs(arr[i]))
                    m = Math.abs(arr[i]);
            }
        }

        // If there was no odd number
        if (isOdd == false)
            return -1;

        // Now, sum will be either odd or even.
        // If even, changing it to odd. As, even - odd = odd.
        // since m is the minimum odd number(absolute).
        if (sum % 2 == 0)
            sum = sum - m;

        return sum;
    }
}
