import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HackerEarth_1 {
    private static PayUHackerEarth_1.FastScanner s = new PayUHackerEarth_1.FastScanner();
    public static void main(String[] args) throws IOException {
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int A = s.nextInt();
            int B = s.nextInt();
            int K = s.nextInt();
            System.out.println(solve(A, K, B));
        }
    }

    static long solve(int A, int K, int B) {
        // Write your code here
        if(B >= A){
            return -1;
        }
        long count = 0;
        long m = K;
        while (m >= A) {
            m = m - A + B;
            count++;
        }
        return count;
    }
}
