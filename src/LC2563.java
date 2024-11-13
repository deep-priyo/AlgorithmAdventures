public class LC2563 {
    public static void main(String[] args) {
        int[] arr={0,1,7,4,4,5};
        System.out.println( countFairPairs(arr,3,6));

    }
    public static long countFairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
            
        }
        return count;
    }
}
