import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LensKart3 {
    private static LensKart1.FastScanner s = new LensKart1.FastScanner();
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            long[] arr = new long[N];
            //PriorityQueue<Long> pq = new PriorityQueue();
            for (int j = 0; j < N; j++) {
                arr[j] = s.nextInt();
                //long num = s.nextLong();
                //pq.add(num);
            }
            //Arrays.sort(arr);
            calculate(arr);
            //calculateNew(pq, N);
        }
    }

    private static void calculate(long[] arr) {
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
            long sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    sum += arr[i];
                } else {
                    break;
                }
            }
            int temp = i;
            while (temp > 0 && arr[temp - 1] >= arr[i]) {
                sum += arr[i];
                temp--;
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

/*    private static void calculateNew(PriorityQueue<Long> pq, long len) {
        long N = len;
        long max = Long.MIN_VALUE;
        while (pq.size() > 0) {
            long temp = pq.poll() * N;
            if (temp > max) {
                max = temp;
            }
            N--;
        }
        System.out.println(max);
    }*/


}
