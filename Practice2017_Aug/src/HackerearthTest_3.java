import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HackerearthTest_3 {
    private static PayUHackerEarth_1.FastScanner s = new PayUHackerEarth_1.FastScanner();

    public static void main(String[] args) throws IOException {
        int x = s.nextInt();
        int N = s.nextInt();
        int[] input = new int[N];
        int[] count = new int[N];
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = s.nextInt();
            input[i] = num;
            if (!hmap.containsKey(num)) {
                int fact = primeFactors(num);
                count[i] = fact;
                hmap.put(num, fact);
            } else {
                count[i] = hmap.get(num);
            }
        }

        long out_ = evaluate(x, input, count);
        System.out.println(out_);

    }

    static long evaluate(int x, int[] input, int[] count) {
        // Write your code here
        long resMin = Integer.MAX_VALUE;
        int temp = x;
        for (int j = 0; j < (input.length - x); j++) {
            int fact = 0;
            long res = 0;
            for (int i = temp - 1; i >= j; i--) {
                if (count[i] > fact) {
                    fact = count[i];
                    res = input[i];
                }
            }
            temp++;
            if (res < resMin) {
                resMin = res;
            }
        }
        return resMin;
    }

    public static int primeFactors(int n) {
        Set<Integer> set = new HashSet<>();
        while (n % 2 == 0) {
            set.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        if (n > 2)
            set.add(n);
        return set.size();
    }
}
