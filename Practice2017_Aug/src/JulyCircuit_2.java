import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 29-07-2017.
 */
public class JulyCircuit_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int j = 0; j < T; j++) {
            int N = s.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = s.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(getMinSum(arr) + " " + getMaxSum(arr));
        }
    }

    private static long getMinSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i = i + 2) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }

    private static long getMaxSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i = i + 2) {
            sum += Math.abs(arr[i] - arr[arr.length - (i + 1)]);
        }
        return sum;
    }
}
