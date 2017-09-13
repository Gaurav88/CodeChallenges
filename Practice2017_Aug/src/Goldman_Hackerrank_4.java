import java.util.Scanner;

public class Goldman_Hackerrank_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] t = new int[n];
        for (int t_i = 0; t_i < n; t_i++) {
            t[t_i] = in.nextInt();
        }
        int[] p = new int[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextInt();
        }
        for (int a0 = 0; a0 < q; a0++) {
            int _type = in.nextInt();
            int v = in.nextInt();
            int res = Integer.MAX_VALUE;
            if (_type == 1) {
                res = minTimeForPrice(p, v);
                if (res == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(t[res]);
                }
            }
            if (_type == 2) {
                res = maxPriceAfterTime(t, p, v);
                System.out.println(res);
            }
            //System.out.println(res);
        }
        in.close();
    }

    private static int minTimeForPrice(int p[], int price) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] >= price) {
                return i;
            }
        }
        return -1;
    }

    private static int maxPriceAfterTime(int t[], int p[], int time) {
        int pos = getClosestK(t, time);
        if (pos == -1) {
            return -1;
        }
        int max = 0;
        for (int i = pos; i < p.length; i++) {
            if (p[i] >= max) {
                max = p[i];
            }
        }
        return max;
    }

    public static int getClosestK(int[] a, int x) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= x) {
                return i;
            }
        }
        return -1;
    }

}
