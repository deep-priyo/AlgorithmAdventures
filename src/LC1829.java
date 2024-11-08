public class LC1829 {
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length;
        for(int i : nums) {
            xor ^= i;
        }

        int maxi = (int)Math.pow(2, maximumBit) - 1;

        int idx = 0;
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            ans[idx++] = xor ^ maxi;
            xor ^= nums[i];
        }

        return ans;
    }
}
