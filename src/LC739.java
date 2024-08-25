import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/description/
public class LC739 {
    public static void main(String[] args) {
        int[] arr={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures2(arr)));
    }
    //brute force approach time limit exceeded O(n^2)
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] arr=new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int k=0;
            for (int j = i+1; j < temperatures.length; j++) {
                k+=1;
                if (temperatures[j] > temperatures[i]) {
                    arr[i]=k;
                    break;
                }
            }
        }
        return arr;
    }
    //optimized approach
    public static int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack=new Stack<Integer>();
        int[] arr=new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int a = stack.pop();
                arr[a] = i - a; // Set the result for day 'a'
            }
            stack.push(i); // Push the current day's index onto the stack

        }
        return arr;
    }

}

