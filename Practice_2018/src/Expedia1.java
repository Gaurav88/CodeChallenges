import java.util.ArrayList;
import java.util.List;

public class Expedia1 {
    public static void main(String[] args) {
        String res[] = missingWords("I am using HackerRank to improve programming", "I am using HackerRank improve");
        for (String str : res) {
            System.out.println(str);
        }
    }

    static String[] missingWords(String s, String t) {
        List<String> res = new ArrayList<>();
        String words[] = s.split(" ");
        String words2[] = t.split(" ");
        for (int i = 0; i < words.length; i++) {
            int flag = 0;
            for (int j = 0; j < words2.length; j++) {

                if (words[i].toLowerCase().equals(words2[j].toLowerCase())) {
                    flag = 1;
                    words2[j] = "";
                    break;
                }
            }
            if (flag == 0) {
                res.add(words[i]);
            }
        }
        String finalRes[] = res.toArray(new String[res.size()]);

        return finalRes;
    }

}
