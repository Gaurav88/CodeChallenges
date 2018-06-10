import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 */
public class GoldmanSachs2 {
    public static void main(String[] args) {
        System.out.println(PrintMinNumberForPattern("NNMMM"));
    }

    static int PrintMinNumberForPattern(String pattern) {
        StringBuffer output = new StringBuffer();
        Stack<Integer> stack = new Stack();

        int i = 0;
        while (i <= pattern.length()) {
            if(i  < pattern.length() && pattern.charAt(i) != 'N' && pattern.charAt(i) != 'M'){
                output = new StringBuffer("-1");
                break;
            }
            stack.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'N') {
                while (!stack.empty()) {
                    output.append(Integer.toString(stack.peek()));
                    stack.pop();
                }
            }
            i++;
        }
        if (output.length() <= 1) {
            output = new StringBuffer("-1");
        }
        return Integer.parseInt(String.valueOf(output));
    }
}
