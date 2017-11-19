import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NationalInstruments_1 {
    private static PayUHackerEarth_1.FastScanner s = new PayUHackerEarth_1.FastScanner();

    public static void main(String[] args) {

        try {
            int T = s.nextInt();
            for (int i = 0; i < T; i++) {
                int N = s.nextInt();
                int K = s.nextInt();
                char[][] A = new char[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        A[j][k] = s.next().charAt(0);
                    }
                }
                System.out.println(solution(A, K));
            }
        } catch (Exception e) {
        }

    }

    static int solution(char[][] A, int K) {
        int res = 0;
        // Write your code here
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == 'P') {
                    int temp = K;
                    //int count = 1;
                    while (temp != 0) {
                        if (j - temp >= 0 && A[i][j - temp] == 'T') {
                            res++;
                            A[i][j - temp] = 'X';
                            break;
                        } else if (j + temp < A.length && A[i][j + temp] == 'T') {
                            res++;
                            A[i][j + temp] = 'X';
                            break;
                        }
                        //count++;
                        temp--;
                    }
                }
            }
        }
        return res;
    }
}
