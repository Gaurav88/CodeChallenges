//Minimum Number of Manipulations required to make two Strings Anagram Without Deletion of Character
public class Yatra3 {
    public static void main(String[] args) {
       // int res = countManipulations("c", "bbb");
        int res1 = countManipulations("a", "bb");
        System.out.println(res1);
    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = countManipulations(a[i], b[i]);
        }
        return res;
    }

    static int countManipulations(String s1, String s2) {
        if(s1.length() != s2.length()){
            return -1;
        }
        int count = 0;

        int char_count[] = new int[26];

        for (int i = 0; i < s1.length(); i++)
            char_count[s1.charAt(i) - 'a']++;


        for (int i = 0; i < s2.length(); i++)
            if (char_count[s2.charAt(i) - 'a']-- <= 0)
                count++;

        return count;
    }

    static int MAX_CHAR = 26;

    static int leastCount(String s1, String s2) {
        int n = s1.length();
        int count1[] = new int[MAX_CHAR];
        int count2[] = new int[MAX_CHAR];

        // count the number of different
        // characters in both strings
        for (int i = 0; i < n; i++) {
            count1[s1.charAt(i) - 'a'] += 1;
            count2[s2.charAt(i) - 'a'] += 1;
        }

        // check the difference in characters
        // by comparing count arrays
        int res = 0;
        for (int i = 0; i < MAX_CHAR; i++) {
            if (count1[i] != 0) {
                res += Math.abs(count1[i] - count2[i]);
            }
        }
        return res;
    }
}
