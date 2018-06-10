import java.util.*;

public class Expedia3 {
    public static void main(String[] args) {
        int arr[] = {1, 4, 4, 2, 2, 30, 50, 40};
        int arr2[] = {8, 5, 5, 5, 5, 1, 1, 1, 4, 4};
        customSort(arr);
    }

    static void customSort(int[] arr) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int num : arr) {
            if (hMap.containsKey(num)) {
                hMap.put(num, hMap.get(num) + 1);
            } else {
                hMap.put(num, 1);
            }
        }
        List list = new LinkedList(hMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int val = o1.getValue().compareTo(o2.getValue());
                int key = o1.getKey().compareTo(o2.getKey());
                if (val == 0) {
                    return key;
                } else {
                    return val;
                }
            }
        });

        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = (Map.Entry) it.next();
            int val = entry.getValue();
            while (val != 0) {
                System.out.println(entry.getKey());
                val--;
            }
        }
    }
}
