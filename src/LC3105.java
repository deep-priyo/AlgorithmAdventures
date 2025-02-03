public class LC3105 {
    public static void main(String[] args) {

    }
    public int longestMonotonicSubarray(int[] nums) {
        int longestSubarray = 1;
        int increasingCount = 1, decreasingCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // Increasing sequence
                increasingCount++;
                decreasingCount = 1; // Reset decreasing count
            } else if (nums[i] < nums[i - 1]) { // Decreasing sequence
                decreasingCount++;
                increasingCount = 1; // Reset increasing count
            } else { // Equal elements break monotonicity
                increasingCount = 1;
                decreasingCount = 1;
            }
            longestSubarray = Math.max(longestSubarray, Math.max(increasingCount, decreasingCount));
        }

        return longestSubarray;
    }
}
