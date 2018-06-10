import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

//Missed Bigger Set
public class GoogleCodeJam2 {
    private static FastScanner s = new FastScanner();

    public static void main(String[] args) {
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int arr[] = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = s.nextInt();
            }
            troubleSort(arr);
            int res = checkSorted(arr);
            int count = i + 1;
            if (res == -1) {
                System.out.println("Case #" + count + ": OK");
            } else {
                System.out.println("Case #" + count + ": " + res);
            }
        }
    }

    public static void troubleSort(int[] arr) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < arr.length - 2; i++) {
                if (arr[i] > arr[i + 2]) {
                    done = false;
                    int temp = arr[i];
                    arr[i] = arr[i + 2];
                    arr[i + 2] = temp;
                }
            }
        }
    }

    public static int checkSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }
}
