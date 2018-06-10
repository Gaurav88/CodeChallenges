import java.util.HashSet;
import java.util.Scanner;

public class AppliedTechgig {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        int res = logic(arr, k);
        System.out.println(res);
    }

    static int logic(int[] arr, int k) {
        for (int i = 0; i < arr.length - k; i++) {
            int num1 = arr[i];
            int num2 = arr[i + k];
            int temp1 = num1;
            int temp2 = num2;
            while (num1 > 1 && num2 > 1 && !checkPrime(num1, num2)) {
                num1 = num1 - 1;
                num2 = num2 + 1;
            }
            if (num1 > 1 && num2 > 1) {
                arr[i] = num1;
                arr[i + k] = num2;
                continue;
            }
            num1 = temp1;
            num2 = temp2;
            while (num1 > 1 && num2 > 1 && !checkPrime(num1, num2)) {
                num1 = num1 + 1;
                num2 = num2 - 1;
            }

            if (num1 > 1 && num2 > 1) {
                arr[i] = num1;
                arr[i + k] = num2;
                continue;
            }

            if (num1 <= 1 || num2 <= 1) {
                //res = true;
                return -1;
            }
        }
        return 1;
    }

    static boolean checkPrime(int n1, int n2) {
        if (isPrime(n1) && isPrime(n2)) {
            return true;
        }
        return false;
    }

    static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


}
