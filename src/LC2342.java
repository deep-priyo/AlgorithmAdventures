import java.util.HashMap;

public class LC2342 {
    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7};
        System.out.println(maximumSum(nums));
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
    public static int maximumSum(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (map.containsKey(digitSum)) {
                int pair = map.get(digitSum);
                maxSum = Math.max(maxSum, pair + num);
                map.put(digitSum, Math.max(pair, num));
            } else {
                map.put(digitSum, num);
            }
        }
        return maxSum;
    }
    public  int maximumSum2(int[] nums)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] digSumArray=digitSums(nums);
        int maxSum=-1;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(digSumArray[i]))
            {
                int pair=map.get(digSumArray[i]);
                maxSum=Math.max(maxSum,pair+nums[i]);
                if (nums[i] > pair)
                    map.put(digSumArray[i], nums[i]);

            }
            else
            {
                map.put(digSumArray[i],nums[i]);
            }
        }
        return maxSum;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
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
