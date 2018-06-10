import java.util.Arrays;

//https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/
public class Expedia2 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 1};
        int k = 3;
        //int n = arr.length;
        System.out.println(subCount(arr, k));
    }

    static long subCount(int num[], int k) {
        int n = num.length;
        int temp[] = new int[k];
        Arrays.fill(temp, 0);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];

            temp[((sum % k) + k) % k]++;
        }

        long val = 0;

        for (int i = 0; i < k; i++) {
            if (temp[i] > 1) {
                val += (temp[i] * (temp[i] - 1)) / 2;
            }
        }

        val += temp[0];

        return val;
    }
}
