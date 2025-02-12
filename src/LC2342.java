public class LC2342 {
    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7};
        System.out.println(maximumSumBruteForce(nums));
    }
    public static int maximumSumBruteForce(int[] nums) {
        int[] digSumArray=digitSums(nums);
        int maxSum=-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(digSumArray[i]==digSumArray[j]) {
                    maxSum=Math.max(maxSum,nums[i]+nums[j]);
                }
            }
        }
        return maxSum;
    }
    public static int[] digitSums(int[] nums) {
        int arr[]=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitSum = 0;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
            arr[i] = digitSum;
        }
        return arr;
    }
}
