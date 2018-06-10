import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Print substring of string which starts with Vowel and ends with consonants
public class Yatra2 {
    public static void main(String[] args) {
        findSubstrings("aab");

    }


    public static void findSubstrings(String str) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String s = str.substring(i, j);
                if (set.contains(s.charAt(0)) && !set.contains(s.charAt(s.length() - 1))) {
                    list.add(s);
                }
                //System.out.println(str.substring(i, j));
            }
        }
        int count = 0;
        for (String st : list) {
            if (count == 0 || count == list.size() - 1) {
                System.out.println(st);
            }
            count++;
        }
        if (list.size() == 1) {
            System.out.println(list.get(0));
        }
    }
}
