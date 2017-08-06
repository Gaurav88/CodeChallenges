import java.io.IOException;
import java.util.*;

/**
 * Created by Gaurav-PC on 29-07-2017.
 */

/**
 * Superdromes are those numbers which are palindromic in both binary and decimal representation.
 * The number represented in binary representation will be up to its most significant bit which is 1.
 * For example, 2 will be represented as {10}, 6 will be represented as {110} and so on.
 * Now killjee ask you to find number of Superdromes less than or equal to
 * n for given
 * n.
 * INPUT FORMAT
 * First line of input contains a single integer
 * q, denoting number of queries.
 * Next line contains
 * q space separated integer,
 * ith integer is
 * n for
 * ith query.
 * <p>
 * OUTPUT FORMAT
 * <p>
 * Output a single integer, number of Superdromes
 * ≤n for each query. Print answer for each query in new line.
 * Sample Input
 * 3
 * 1 2 3
 * Sample Output
 * 1
 * 1
 * 2
 * Explanation
 1 and 3 are superdromes while 2 is not a superdrome.
 */
public class LoweHackerEarth_1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int max = 0;
        int arr[] = new int[T];
        Set<Integer> set = new HashSet<>();

        for (int t_i = 0; t_i < T; t_i++) {
            int n = 0;
            try {
                n = s.nextInt();
            } catch (Exception e) {
                //System.out.println("0");
                s.next();
                continue;
            }
            if (n > max) {
                max = n;
            }

            arr[t_i] = n;
            set.add(n);

        }

        Map<Integer, Integer> hmap = solve(max, set);
        for (int i = 0; i < T; i++) {
            if (hmap.containsKey(arr[i])) {
                System.out.println(hmap.get(arr[i]));
            }else{
                System.out.println(0);
            }
        }

    }

    static Map<Integer, Integer> solve(int n, Set<Integer> set) {
        // Write your code here
        int count = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) {
                count++;
            }
            if (set.contains(i)) {
                hmap.put(i, count);
            }
        }
        return hmap;
    }

    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rev = sb.toString();
        if (str.equals(rev)) {
            return true;
        } else {
            return false;
        }
    }


}
