import java.util.*;

//check can string be made palindrome
public class Dell_2 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str = sc.next();
            if (isPalindrome(str)) {
                boolean res = canFormPalindrome(str);
                if (res) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }

        }

    }

    static boolean isPalindrome(String str) {
        int N = str.length();
        int count = 0;
        int begin  = 0;
        int end    = str.length() - 1;
        int middle = (begin + end)/2;

        for (int i = begin; i <= middle; i++) {
            if (str.charAt(begin) != str.charAt(end)) {
                count++;
            }
            begin++;
            end--;
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    static int NO_OF_CHARS = 256;

    static boolean canFormPalindrome(String str) {

        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        for (int i = 0; i < str.length(); i++)
            count[(int) (str.charAt(i))]++;

        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return false;
        }

        return true;
    }
}
