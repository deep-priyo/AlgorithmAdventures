import java.util.Arrays;

public class LC1732 {
    public static void main(String[] args) {
        int []arr={-5,1,5,0,-7};
        largestAltitude(arr);
    }
    public static  int largestAltitude(int[] gain) {
        int maximum=0;
        int sum=0;
        for (int j : gain) {
            sum += j;
            maximum = Math.max(maximum, sum);
        }
        return maximum;
    }
}
