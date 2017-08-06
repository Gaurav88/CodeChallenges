import java.util.Scanner;

/**
 * Created by Gaurav-PC on 30-07-2017.
 */
/**Alex and Requests
 Alex is working in a firm, where he needs to process requests according to their priority. He has
 N allocation systems. At any instance,
 ith system can process only one request with priority
 i or above.
 For each request, on any eligible system, Alex can also terminate the request with less priority than that of the current request, in order to assign the current request to the system. There will be
 Q incoming requests and he needs to tell whether he can assign a system to each request or not.
 Alex needs to assign each request to the system optimally, such that he can assign maximum number of incoming requests. The number of requests (which are already assigned) terminated by Alex, doesn't matter here.
 Note:
 If not terminated explicitly, consider the processing time of every request as infinite.

 Input Format:
 First line of the input contains
 N, denoting the number of allocation systems.
 Next line contains one integer
 Q, which denotes the number of incoming requests.
 In next
 Q lines, each line contains one integer
 X, denoting the priority of the request.
 Output Format:

 For each incoming request, in new line print
 YES, if Alex can assign a system to the request, else print
 NO .
 Note:
 If Alex can anyhow assign the current request to the system, he can't reject the request. It is necessary to assign the request to any system.
 Constraints:
 1=N=100
 1=X=100000
 1=Q=10000
 Sample Input
 2
 5
 3
 4
 2
 1
 3
 Sample Output
 YES
 YES
 YES
 NO
 YES
 Explanation
 1) Priority of the Request is 3, can be assigned to second system.

 2) Priority of the Request is 4, can be assigned to second system, by termination the request with priority 3.

 3) Priority of the Request is 2, can be assigned to first system.

 4) Priority of the Request is 1, can't be assigned to any system.

 5) Priority of the Request is 3, can be assigned to first system, by termination the request with priority 2.
//Perfect
 **/
public class BimaHackerEarth_1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] sys = new int[N];
        for (int i = 0; i < N; i++) {
            sys[i] = i;
        }
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int Q = s.nextInt();
            System.out.println(checkPos(sys,Q));
        }
    }

    private static String checkPos(int[] arr, int Q) {
        if (Q - 1 < arr.length && arr[Q - 1] < Q) {
            arr[Q - 1] = Q;
            return "YES";
        } else {
            for (int i = arr.length-1; i >= 0; i--) {
                if(arr[i] <Q){
                    arr[i] = Q;
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
