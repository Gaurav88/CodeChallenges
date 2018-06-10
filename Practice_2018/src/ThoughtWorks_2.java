import java.math.BigInteger;
import java.util.Scanner;

public class ThoughtWorks_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        String A = sc.next();
        StringBuilder B = new StringBuilder(sc.next());
        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            B.setCharAt(num - 1, '1');
            int res = new BigInteger(B.toString()).compareTo(new BigInteger(A));
            if (res >= 0){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
