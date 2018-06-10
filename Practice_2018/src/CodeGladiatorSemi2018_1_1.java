import java.util.*;

//Passed perfectly on techgig Semi Q1
public class CodeGladiatorSemi2018_1_1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int len[] = new int[N];
        int time[] = new int[N];
        int end[] = new int[N];
        List<Set<String>> dSet = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            len[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
            end[i] = time[i] + len[i] + 1;
        }

        int res = createMaps(time, end, N);
        System.out.println(res);
    }

    static int createMaps(int[] start, int[] exit, int n) {
        Map<Integer, Set> entryMap = new HashMap<>();
        Map<Integer, Set> exitMap = new HashMap<>();
        for (int i = 0; i < start.length; i++) {
            if (entryMap.containsKey(start[i])) {
                Set<String> s = entryMap.get(start[i]);
                s.add(Integer.toString(i + 1));
                entryMap.put(start[i], s);
            } else {
                Set<String> s = new HashSet();
                s.add(Integer.toString(i + 1));
                entryMap.put(start[i], s);
            }
        }

        for (int i = 0; i < exit.length; i++) {
            if (exitMap.containsKey(exit[i])) {
                Set<String> s = exitMap.get(exit[i]);
                s.add(Integer.toString(i + 1));
                exitMap.put(exit[i], s);
            } else {
                Set<String> s = new HashSet();
                s.add(Integer.toString(i + 1));
                exitMap.put(exit[i], s);
            }
        }
        return findMaxGuests(start, exit, entryMap, exitMap, n);
    }

    static int findMaxGuests(int[] start, int[] exit, Map<Integer, Set> entryMap, Map<Integer, Set> exitMap, int n) {
        // Sort arrival and exit arrays
        Arrays.sort(start);
        Arrays.sort(exit);
        Map<Integer, Set> finalMap = new HashMap<>();
        Set<String> tempSet = new HashSet<>();

        int time = start[0];
        int i = 1, j = 0;
        tempSet = entryMap.get(time);
        Set<String> st = new HashSet<>();
        st.addAll(tempSet);
        finalMap.put(time, st);
        tempSet = entryMap.get(time);

        while (i < n && j < n) {
            if (start[i] <= exit[j]) {
                Set<String> s = entryMap.get(start[i]);
                tempSet.addAll(s);
                Set<String> set = new HashSet<>();
                set.addAll(tempSet);
                finalMap.put(start[i], set);

                i++; //increment index of arrival array
            } else // If event is exit, decrement count
            { // of guests.
                Set<String> s = exitMap.get(exit[j]);
                tempSet.removeAll(s);
                Set<String> set = new HashSet<>();
                set.addAll(tempSet);
                finalMap.put(exit[j], set);

                j++;
            }
        }

        while (i < start.length) {
            Set<String> s = entryMap.get(start[i]);
            tempSet.addAll(s);
            Set<String> set = new HashSet<>();
            set.addAll(tempSet);
            finalMap.put(start[i], set);

            i++;
        }

        while (j < exit.length) {
            Set<String> s = exitMap.get(exit[j]);
            tempSet.removeAll(s);
            Set<String> set = new HashSet<>();
            set.addAll(tempSet);
            finalMap.put(exit[j], set);

            j++;
        }
        return calculate(finalMap);

    }

    private static int calculate(Map<Integer, Set> finalMap) {
        Collection<Set> hSet = finalMap.values();
        List<Set> arr = new ArrayList<>();
        arr.addAll(hSet);
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                Set<String> tempSet = new HashSet<>();
                tempSet.addAll(arr.get(i));
                tempSet.addAll(arr.get(j));
                if (tempSet.size() > res) {
                    res = tempSet.size();
                }
            }
        }

        return res;
    }
}
