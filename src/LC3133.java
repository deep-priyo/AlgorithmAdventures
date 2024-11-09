import java.util.Arrays;

public class LC3133 {
    public static void main(String[] args) {
        System.out.println(minEndOptimized(3,4));
    }
    public static long minEnd(int n, int x) {
        long[] arr = new long[n];
        arr[0] = x;
        int com=x;
        long j;
        for (int i = 1; i < n; i++) {
            for(j=x+1;;j++)
            {
                if((arr[i-1]&j)==com)
                {
                    arr[i] = j;
                    break;
                }
            }
            x= (int) (arr[i]);
        }
        //System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }
    public static long minEndOptimized(int n, int x) {
        long prev = x; // Start with the initial element as x
        long current;
        for (int i = 1; i < n; i++) {
            // Start from prev + 1 to ensure nums[i] > nums[i - 1]
            current = prev + 1;

            // Find the smallest number greater than prev that keeps the AND result as x
            while ((current & x) != x) {
                current++;
            }

            prev = current; // Update prev to be the current element
        }

        return prev; // The minimum possible value of nums[n - 1]
}
    }

