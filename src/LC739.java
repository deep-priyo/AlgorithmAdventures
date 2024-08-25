import java.util.Arrays;

//https://leetcode.com/problems/daily-temperatures/description/
public class LC739 {
    public static void main(String[] args) {
        int[] arr={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
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

}

