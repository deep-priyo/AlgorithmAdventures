import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class LC150 {
    public static void main(String[] args) {
        String[] tokens={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Final result: "+evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        for(String token:tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int b=stack.pop();
                int a=stack.pop();
                switch (token) {
                    case "+" ->
                        stack.push(a + b);
                    case "-" ->
                        stack.push(a - b);
                    case "*" ->
                        stack.push(a * b);
                    default ->
                        stack.push(a / b);
                }
            }
            else stack.push(Integer.parseInt(token));

        }

        return stack.pop();

    }
}
