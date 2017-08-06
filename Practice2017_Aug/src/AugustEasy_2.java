import java.util.Scanner;

/**
 * Created by Gaurav-PC on 01-08-2017.
 */
public class AugustEasy_2 {
    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int l = s.nextInt();
            int r = s.nextInt();
            int res = 0;
            for (int j = l - 1; j <= r - 1; j++) {
                res = res ^ arr[j];
            }
            if (res == 0) {
                System.out.println("Ferb");
            } else {
                System.out.println("Phineas");
            }
        }

        System.out.println("Hello World!");
    }
}


