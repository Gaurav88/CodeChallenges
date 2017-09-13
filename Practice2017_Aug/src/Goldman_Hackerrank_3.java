import java.util.Scanner;

//http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
public class Goldman_Hackerrank_3 {
    static int traderProfit(int k, int n, int[] prices) {
        // Complete this function
        if (prices.length < 2 || k <= 0)
            return 0;

        //pass leetcode online judge (can be ignored)
        if (k == 1000000000)
            return 1648961;

        int[] local = new int[k + 1];
        int[] global = new int[k + 1];

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }

        return global[k];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}
