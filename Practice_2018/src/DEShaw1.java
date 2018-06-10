import java.util.Scanner;

public class DEShaw1 {
    static long mod = 1000000007;
    static long pairAndSum(int arr[], int n) {
        long ans = 0; // Initialize result

        for (int i = 0; i < 32; i++) {
            int k = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0)
                    k++;
            }
            ans += (1 << i) * (Math.pow(2, k) - 1) % mod;
        }
        return ans % mod ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(pairAndSum(arr, N));
        }
    }
}
