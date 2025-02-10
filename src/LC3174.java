import java.util.Stack;

public class LC3174 {
    public static void main(String[] args) {
        String s = "sl2yqa6z8i0eqyqnla250rh8olipeu4oie5t16n8p2n67e391n01s7ol11qg93u6tuoy55no117861sj4wfno27p65212";
        System.out.println(clearDigits(s));
    }

    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }


        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
