import java.util.Scanner;

/**
 * Created by Gaurav-PC on 01-08-2017.
 */
public class AugustEasy_1 {

    static long mod = 1000000007;

    public static void main(String[] args) {
        long arr[] = new long[100000];
        calc(arr, 100000);
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int max = 0;
        int[] temp = new int[T];
        for (int i = 0; i < T; i++) {
            int num = s.nextInt();
            for (int k = 0; k < num; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }


    }

    private static void calc(long arr[], int max) {
        int N = 0;
        int num1 = 2;
        int num2 = 3;

        arr[0] = num1;
        arr[1] = num2;
        int j = 2;
        //long[] dum = new long[max];
        long dum = 2;
        //dum[1] = 6;
        int count = 1;
        while (N < max - 2) {
            long res = arr[count] % mod * dum % mod;
            dum = res;
            count++;
            arr[j++] = res % mod + 1 % mod;
            N++;
        }
    }
}