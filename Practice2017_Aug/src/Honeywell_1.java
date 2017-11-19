import java.io.IOException;

public class Honeywell_1 {
    private static PayUHackerEarth_1.FastScanner s = new PayUHackerEarth_1.FastScanner();

    public static void main(String[] args) throws IOException {
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            long M = s.nextLong();
            long N = s.nextLong();
            long K = s.nextLong();
            System.out.println(solve(M, N, K));
        }
    }

    static long solve(long M, long N, long K) {
        // Write your code here

        long mul = M * N;
        while (mul > K) {
            if (M > N) {
                M = M - 1;
            } else {
                N = N - 1;
            }
            mul = M * N;
        }
        return mul;
    }
}
