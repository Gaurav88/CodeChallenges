import java.util.*;

public class EqualExperts1 {
    static Map<Long, Long> hMap = new HashMap<>();
    static int index = 0;
    static long max = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        List<Long> arr = new LinkedList<>();

        boolean check = true;
        long temp = 0;
        long num = 0;
        max = 0;

        for (int i = 0; i < N; i++) {

            num = s.nextLong();
            if (check && i > 0 && temp < num) {
                max = num;
                index = i;
                //check = false;
            }
            if (temp > num) {
                check = false;
            }
            temp = num;
            arr.add(num);

            if (hMap.containsKey(num)) {
                hMap.put(num, hMap.get(num) + 1);
            } else {
                hMap.put(num, 1L);
            }
        }
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            long var = s.nextLong();
            rules(arr, var, max);
            System.out.println(arr.size());
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void rules(List<Long> arr, long num, long max) {
        if (num == max) {
            return;
        }
        if (num > max) {
            addMax(arr, num);
        } else if (hMap.containsKey(num) && hMap.get(num) >= 2L) {
            return;
        } else if (hMap.containsKey(num) && hMap.get(num) == 1L) {
            insertDecresing(arr, num);
        } else {
            insertIncresing(arr, num);
        }
    }

    public static void insertIncresing(List<Long> arr, long num) {

        for (int i = 0; i < arr.size(); i++) {
            long temp = arr.get(i);
            if (temp > num) {
                arr.add(i, num);
                if (hMap.containsKey(num)) {
                    hMap.put(num, hMap.get(num) + 1);
                } else {
                    hMap.put(num, 1L);
                }
                break;
            }
        }

    }

    public static void insertDecresing(List<Long> arr, long num) {

        for (int i = arr.size() - 1; i >= 0; i--) {
            long temp = arr.get(i);
            if (temp > num) {
                arr.add(i + 1, num);
                if (hMap.containsKey(num)) {
                    hMap.put(num, hMap.get(num) + 1);
                } else {
                    hMap.put(num, 1L);
                }
                break;
            }
        }
    }

    public static void addMax(List<Long> arr, long num) {

        arr.add(index + 1, num);
        if (hMap.containsKey(num)) {
            hMap.put(num, hMap.get(num) + 1);
        } else {
            hMap.put(num, 1L);
        }
        max = num;
        index++;
    }
}
