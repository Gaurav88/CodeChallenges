import java.util.Scanner;

public class Goldman_Hackerrank_1 {
    static long buyMaximumProducts(int n, long k, int[] a) {
        // Complete this function
        long sum = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            sum += (i + 1) * a[i];
            count = count + i + 1;
            if (sum > k) {
                count = divide(sum, k, a[i], count);
                break;
            }
        }
        return count;
    }

    static long divide(long sum, long k, int num, long count) {
        while (sum > k) {
            sum = sum - num;
            count--;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}
