//https://leetcode.com/problems/remove-all-occurrences-of-a-substring/submissions/1539297201/?envType=daily-question&envId=2025-02-11
import java.util.Stack;
public class LC1910 {
    public static void main(String[] args) {
        String s="eemckxmckx", part = "emckx";
        System.out.println(removeOccurrences(s,part));
    }
    public static String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        int partLength = part.length();

        for (char c : s.toCharArray()) {
            stack.push(c);

            // Check last 'partLength' characters in stack
            if (stack.size() >= partLength) {
                boolean match = true;

                // Compare last `partLength` elements in stack with `part`
                for (int i = 0; i < partLength; i++) {
                    if (stack.get(stack.size() - partLength + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }

                // If they match, remove them
                if (match) {
                    for (int i = 0; i < partLength; i++) {
                        stack.pop();
                    }
                }
            }
        }

        // Convert stack to final string
        StringBuilder result = new StringBuilder(stack.size());
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
