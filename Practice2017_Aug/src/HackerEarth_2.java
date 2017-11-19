public class HackerEarth_2 {
    private static PayUHackerEarth_1.FastScanner s = new PayUHackerEarth_1.FastScanner();

    private static int countArr[] = new int[1000000];

    public static void main(String[] args) {
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int birds[] = new int[N];

            for (int j = 0; j < N; j++) {
                birds[j] = s.nextInt();
            }

            int Q = s.nextInt();
            int query[][] = new int[Q][2];
            int maxQuery = 0;
            int minQuery = 0;
            for (int k = 0; k < Q; k++) {
                int t1 = s.nextInt();
                int t2 = s.nextInt();
                query[k][0] = t1;
                query[k][1] = t2;
                if (t2 > maxQuery) {
                    minQuery = maxQuery;
                    maxQuery = t2;
                    calculate(birds, minQuery, maxQuery);
                }

                System.out.println(solveWithDP(birds, t1, t2));
            }

        }
    }

    static long solveWithDP(int[] birds, int t1, int t2) {
        // Write your code here
        int max = 0;

        for (int j = t1; j <= t2; j++) {
            if (countArr[j] > max) {
                max = countArr[j];
            }
        }
        return max;
    }

    static long solve(int[] birds, int t1, int t2) {
        // Write your code here
        int count = 0;

        for (int j = 0; j < birds.length; j++) {
            int start = t1 / birds[j];
            int end = t2 / birds[j];
            if (end - start > 0) {
                count++;
            }
        }
        return count;
    }

    static void calculate(int[] birds, int min, int max) {
        for (int j = min; j < max; j++)
            for (int i = 0; i < birds.length; i++) {
                if (j % birds[i] == 0) {
                    countArr[j] = countArr[j] + 1;
                }
            }

    }
}
