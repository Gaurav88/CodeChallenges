import java.util.Scanner;

/**
 * Created by Gaurav-PC on 29-07-2017.
 */

//Totally Wrong
public class LoweHackerEarth_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int j = 0; j < T; j++) {
            int N = s.nextInt();
            int X = s.nextInt();
            int Y = s.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = s.nextInt();
            }
            int res = steps(X - 1, arr[X - 1], Y - 1, arr);
            System.out.println(res);
        }
    }

    static int steps(int source, int step, int dest, int[] arr) {
        // base cases
        if (Math.abs(source) > (dest)) return Integer.MAX_VALUE;
        if (source == dest) return step;

        // at each point we can go either way

        // if we go on positive side
        int sour = 0;
        if (source + arr[source] >= arr.length) {
            sour = source + arr[source] - arr.length;
        } else {
            sour = source + arr[source];
        }
        int pos = steps(sour, arr[source], dest, arr);
        int sour1 = 0;
        if (source - arr[source] < 0) {
            sour1 = arr.length - (arr[source] - source);
        } else {
            sour1 = source - arr[source];
        }
        // if we go on negative side
        int neg = steps(sour1, arr[source], dest, arr);

        // minimum of both cases
        return Math.min(pos, neg);
    }

}
