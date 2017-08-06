import java.util.*;

/**
 * Created by Gaurav-PC on 30-07-2017.
 */

/**
 * Problem Statement:
 Alex works in a firm that deals with the requests that come with their own  Priority Value at different instants of time .
 Now he has to maintain a list of these requests with their own Priority Value and the time at which they come. He updates the list according to the following queries:
 Type 1: Update the Priority Value of the request at time
 p in the list. In case there is no request present at time t in list, set the
 Priority Value of that request top at time t in the list.

 Type 2: Remove the request which came at time
 t, from the list. It is guaranteed that some request has already been come at that time before. Alternatively, there will always be a request at time
 t currently present in the list.

 Type 3: Print the minimum
 Priority Value of the request, followed by a space and the maximum Priority Value of the request currently present in the list.

 Type 4: Print the
 Priority Value of the request, of the highest time present in the list.

 Note:
 1. The time instants given for query
 1 may not be in ascending order.
 2. There can be more than two time instants with same
 Priority Value of the request.

 Constraints:
 1<q<2×105
 1<t,p<2×109

 Input Format:
 First line of the input contains
 q, the number of queries.

 Then
 q lines follow. Each of the
 q lines correspond to one of the query mentioned above.
 Type 1: Integer with value 1, followed by space and two space-separated integers p and t , denoting the
 Priority Value of the request and time t, respectively.
 Type 2: Integer with value 2, followed by space and single integer t, denoting the time.
 Type 3: Integer with value
 Type 4: Integer with value

 Output Format:

 For each query of type
 3
 3 , output the minimum and maximum
 Priority Value of the request currently present in the list.
 For each query of type
 4, output the
 Priority Value of the request of highest time, currently present in the list.

 Note: You can assume that whenever query of type
 3,4 occurs, the data is not null i.e some answer exists.

 Sample Input
 6
 1 3 10
 1 5 2
 3
 4
 2 5
 3
 Sample Output
 2 10
 2
 10 10
 */
//50% timeout
public class BimaHackerEarth_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        List<TimeValue> tList = new ArrayList<>();
        Set<TimeValue> tSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int type = s.nextInt();
            if (type == 1) {
                int time = s.nextInt();
                int pv = s.nextInt();
                TimeValue tv = new TimeValue(time, pv);
                if(!tSet.contains(tv)) {
                    tList.add(tv);
                }
                else{
                    update(tList,time,pv);
                }
                tSet.add(tv);

            }
            if (type == 2) {
                int time = s.nextInt();

                type2(tList, time);
            }
            if (type == 3) {
                Collections.sort(tList, new Comparator<TimeValue>() {
                    @Override
                    public int compare(TimeValue o1, TimeValue o2) {
                        return o1.pv - o2.pv;
                    }
                });
                System.out.println(tList.get(0).pv + " " + tList.get(tList.size() - 1).pv);
            }
            if (type == 4) {
                Collections.sort(tList);
                System.out.println(tList.get(tList.size() - 1).pv);
            }

        }
    }

    private static void type2(List<TimeValue> arr, int time) {
        for (TimeValue i : arr) {
            if (i.time == time) {
                arr.remove(i);
                break;
            }
        }
    }

    private static void update(List<TimeValue> arr, int time, int pv) {
        for (TimeValue i : arr) {
            if (i.time == time) {
                i.pv = pv;
                break;
            }
        }
    }

}

class TimeValue implements Comparable<TimeValue> {
    int time;
    int pv;

    public TimeValue(int time, int pv) {
        this.time = time;
        this.pv = pv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeValue timeValue = (TimeValue) o;

        return time == timeValue.time;
    }

    @Override
    public int hashCode() {
        return time;
    }

    @Override
    public int compareTo(TimeValue o) {
        return this.time - o.time;
    }
}