import java.util.*;

public class CodeGladiatorSemi2018_1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int len[] = new int[N];
        int time[] = new int[N];
        List<Set<String>> dSet = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            len[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
            int temp = time[i] + len[i];
            int t = time[i];
            int l = len[i];

            while (l >= 0) {
                if (dSet.size() > t && dSet.get(t) != null) {
                    dSet.get(t).add(Integer.toString(i + 1));
                    l--;
                    t++;
                } else {
                    int count = t;
                    while (count >= 0) {
                        dSet.add(new HashSet<>());
                        count--;
                    }
                    dSet.get(t).add(Integer.toString(i + 1));
                    l--;
                    t++;
                }
            }
            if (temp > max) {
                max = temp;
            }
        }

        /*Set<String>[] hSet = new HashSet[max + 1];
        for (int k = 0; k <= max; k++) {
            hSet[k] = new HashSet<>();
        }*/
        int res = calculate(len, time, dSet);
        System.out.println(res);
    }

    private static int calculate(int[] len, int[] time, List<Set<String>> hSet) {

        /*for (int i = 0; i < len.length; i++) {
            for (int j = time[i]; j <= len[i] + time[i]; j++) {
                hSet[j].add(Integer.toString(i + 1));

            }
        }*/

        int res = 0;
        for (int i = 0; i < hSet.size(); i++) {
            for (int j = i + 1; j < hSet.size(); j++) {
                Set<String> tempSet = new HashSet<>();
                tempSet.addAll(hSet.get(i));
                tempSet.addAll(hSet.get(j));
                if (tempSet.size() > res) {
                    res = tempSet.size();
                }
            }
        }

        return res;
    }


}
