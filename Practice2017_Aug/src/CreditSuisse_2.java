import java.util.Scanner;

//Should be sole=ved by fenwick tree
public class CreditSuisse_2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int T = s.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < T; i++) {
            int type = s.nextInt();
            int pos = s.nextInt();
            int res = calc(arr, type, pos);
            if (type == 2) {
                System.out.println(res);
            }
        }
    }

    public static int calc(int[] arr, int type, int pos) {
        int res = 54;
        if (type == 1) {
            type1(arr, pos);
        }
        if (type == 2) {
            res = type2(arr, pos);
        }
        return res;
    }

    public static void type1(int arr[], int pos) {
        arr[pos] = -1;
    }

    public static int type2(int arr[], int pos) {
        for (int i = pos; i < arr.length; i++) {
            if (arr[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}
