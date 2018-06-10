import java.util.Stack;

//brackets balance check
public class Yatra1 {
    public static void main(String[] args) {

    }

    static String[] braces(String[] values) {

        Stack<Character> st = new Stack();
        String[] res = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length(); j++) {
                if (values[i].charAt(j) == '{' || values[i].charAt(j) == '(' || values[i].charAt(j) == '[') {
                    st.push(values[i].charAt(j));
                }
                if (values[i].charAt(j) == '}' || values[i].charAt(j) == ')' || values[i].charAt(j) == ']') {
                    if(st.isEmpty()){
                        res[i] = "NO";
                        break;
                    }
                    else if(!isMatchingPair(st.pop(), values[i].charAt(j))){
                        res[i] = "NO";
                        break;
                    }
                }
                res[i] = "YES";
            }
        }
        return res;
    }

    static boolean isMatchingPair(char character1, char character2)
    {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }
}
