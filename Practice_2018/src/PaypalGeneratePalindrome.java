import java.util.*;

public class PaypalGeneratePalindrome {
    static long createPalindrome(long input, long b, int isOdd) {
        long n = input;
        long palin = input;


        if (isOdd == 1)
            n /= b;


        while (n > 0) {
            palin = palin * b + (n % b);
            n /= b;
        }
        return palin;
    }


    static List<Long> generatePaldindromes(long n) {
        long number;
        List<Long> list = new ArrayList<>();

        for (int j = 0; j < 1; j++) {

            int i = 1;
            while ((number = createPalindrome(i, 10, j % 2)) < n) {
                //System.out.print(number + " ");
                list.add(number);
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception{
        long n = 1000000000L;
        List<Long> list = generatePaldindromes(n);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long num = sc.nextLong();
            print(list.get((int)num - 1));
        }
    }

    private static void print(long num) {
        String st = Long.toString(num);
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < st.length(); i++) {
            int temp = Character.getNumericValue(st.charAt(i));
            if (!hmap.containsKey(temp)) {
                hmap.put(temp, 1);
            } else {
                hmap.put(temp, hmap.get(temp) + 1);
            }
        }

        int res = -1;
        for (int key : hmap.keySet()) {
            int temp = hmap.get(key);

            if (temp > max) {
                max = temp;
                res = key;
            } else if (temp == max) {
                if (key < res) {
                    res = key;
                }
            }
        }

        System.out.println(res);

    }
}
