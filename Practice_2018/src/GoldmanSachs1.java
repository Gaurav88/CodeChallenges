import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoldmanSachs1 {
    public static void main(String[] args) {
        int[] numberArray = {1456, 345671,43218, 123};
        System.out.println(findQualifiedNumbers(numberArray));
    }

    static String findQualifiedNumbers(int[] numberArray) {
        List<Integer> list = new ArrayList<>();
        for (int num : numberArray) {
            String numberAsString = Integer.toString(num);
            if (numberAsString.contains("1") && numberAsString.contains("2") && numberAsString.contains("3")) {
                list.add(num);
            }
        }
        Collections.sort(list);
        StringBuffer str = new StringBuffer();
        int count = 0;
        for (int num : list) {
            count++;
            str.append(num);
            if (count < list.size())
                str.append(",");
        }
        if(str.length() == 0){
            str.append("-1");
        }
        return str.toString();
    }
}
