import java.util.Scanner;

public class Dell_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            int sum = 0;
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            int res = equilibrium(arr, sum, N);
            if (res == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(res);
            }
        }
    }

    static int equilibrium(int arr[], int sum, int n) {
        int minDiff = Integer.MAX_VALUE;
        int leftsum = 0; // initialize leftsum

        for (int i = 0; i < n; ++i) {
            sum -= arr[i]; // sum is now right sum for index i

            /*if (leftsum == sum)
                return i;*/
            leftsum += arr[i];

            int diff = Math.abs(sum - leftsum);
            if (diff < minDiff) {
                minDiff = diff;
            }

        }

        /* If no equilibrium index found, then return 0 */
        return minDiff;
    }

}
