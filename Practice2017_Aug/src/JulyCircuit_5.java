import java.util.Map;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 30-07-2017.
 */
public class JulyCircuit_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int res = Math.min(replace(str), findMinInsert(new String(new StringBuffer(str).reverse()).toCharArray(), str.length()));
        System.out.println(res);
    }

    private static int replace(String str) {
        int count = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                count++;
            }
        }
        return count;
    }

    static int findMinInsert(char str[], int n) {

        for (int i = n - 1; i >= 0; i--) {
            if (isPalin(str, 0, i))
                return (n - i - 1);
        }
        return Integer.MAX_VALUE;
    }

    static boolean isPalin(char str[], int st, int end) {
        while (st < end) {
            if (str[st] != str[end])
                return false;
            st++;
            end--;
        }
        return true;
    }


}
