import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 01-08-2017.
 */
//Partly complete
public class AugustEasy_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Danger(s.nextInt());
        }
        int T = s.nextInt();
        for (int k = 0; k < T; k++) {
            int l = s.nextInt();
            int r = s.nextInt();
            int res = 0;
            Map<Integer, Integer> hMap = new HashMap<>();
            for (int i = l - 1; i < r; i++) {

                if (!hMap.containsKey(arr[i])) {
                    hMap.put(arr[i], 1);
                } else {
                    hMap.put(arr[i], hMap.get(arr[i]) + 1);
                }
            }
            for (int num : hMap.keySet()) {
                if (hMap.get(num) > 1) {
                    res = res + calc(hMap.get(num) - 1);
                }
            }
            System.out.println(res);
        }

    }

    static int Danger(int cost) {
        int danger_val = 0;
        for (int i = 1; i <= cost; i++) {
            if (cost % i == 0) {
                danger_val++;
            }
        }
        return danger_val;
    }

    private static int calc(int num) {
        int res = 0;
        while (num > 0) {
            res = num + res;
            num--;
        }
        return res;
    }
}
