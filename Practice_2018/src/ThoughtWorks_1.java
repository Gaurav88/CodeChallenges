import java.util.Scanner;

public class ThoughtWorks_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long num = sc.nextLong();
            long temp = (num * 2) + 1;
            double num1 = Math.log(temp);
            double num2 = Math.log(3);
            //System.out.println(Math.log(2.71828));
            int res = (int) Math.floor(num1 / num2);
            System.out.println(res);
            //System.out.println(num1/num2);
        }
    }
}
