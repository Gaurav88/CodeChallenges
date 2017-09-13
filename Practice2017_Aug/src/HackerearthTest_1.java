import java.util.HashMap;
import java.util.Map;

public class HackerearthTest_1 {
    private static PayUHackerEarth_1.FastScanner s = new PayUHackerEarth_1.FastScanner();
    public static void main(String[] args) {
        int T = s.nextInt();
        for(int i=0; i<T; i++) {
            Map<Integer, Integer> hmap = new HashMap<>();
            int N = s.nextInt();
            int min = Integer.MAX_VALUE;
            for(int j=0; j<N; j++) {
                int num = s.nextInt();
                if(num <min){
                    min = num;
                }
                if(!hmap.containsKey(num)) {
                    hmap.put(num, 1);
                }
                else{
                    hmap.put(num, hmap.get(num)+1);
                }
            }
            if(hmap.get(min)%2 ==0){
                System.out.println("Unlucky");
            }
            else{
                System.out.println("Lucky");
            }

        }

    }
}
