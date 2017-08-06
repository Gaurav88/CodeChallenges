import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 29-07-2017.
 */
public class JulyCircuit_1 {
    static HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {
        allPrime(400);
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                //right
                if (j + 1 < N) {
                    sum += arr[i][j + 1];
                }
                //left
                if (j - 1 >= 0) {
                    sum += arr[i][j - 1];
                }
                //bottom
                if (i + 1 < N) {
                    sum += arr[i + 1][j];
                }
                //top
                if (i - 1 >= 0) {
                    sum += arr[i - 1][j];
                }
                if (set.contains(sum)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void allPrime(int n) {

        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                set.add(i);
        }
    }
}
