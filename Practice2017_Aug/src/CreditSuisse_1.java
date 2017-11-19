import java.math.BigDecimal;
import java.util.Scanner;

//Getting Timeoutfor for large test cases
public class CreditSuisse_1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int num = s.nextInt();
            BigDecimal res = calc(num);
            System.out.println(res.remainder(new BigDecimal(1000000007)));
        }
    }

    static BigDecimal factorial(int n) {
        int i;
        BigDecimal fact = new BigDecimal(1);
        for (i = 1; i <= n; i++) {
            fact = fact.multiply(new BigDecimal(i));
        }

        return fact;
    }

    static BigDecimal calc(int n) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int r = 1; r < n; r++) {
            //BigDecimal ncr = (factorial(n).divide(factorial(n - r).multiply(factorial(r))));
            BigDecimal ncr = comb(n, r);
            sum = sum.add(ncr);
        }

        return sum;
    }

    static BigDecimal comb(int n, int r) {
        if (r > n / 2) r = n - r; // because C(n, r) == C(n, n - r)
        BigDecimal ans = new BigDecimal(1);
        int i;

        for (i = 1; i <= r; i++) {
            ans = ans.multiply(new BigDecimal(n - r + i));
            ans = ans.divide(new BigDecimal(i));
        }

        return ans;
    }
}
