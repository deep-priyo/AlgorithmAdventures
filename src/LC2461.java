import java.util.HashSet;

public class LC2461 {
    public static void main(String[] args) {
        int[] a={1,5,4,2,9,9,9};
        int k=3;
        System.out.println(maximumSubarraySum(a,k));
    }
    public static  long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int left=1;
        int right=k;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            System.out.print(nums[i]+" ");
            if(set.contains(nums[i])){
                System.out.println("Duplicate found");
            }
            else {
                set.add(nums[i]);
                sum+=nums[i];
            }
            }
        System.out.println();
        while (right<nums.length){
            set.remove(nums[left-1]);
            sum-=nums[left-1];
            if(set.contains(nums[right])){

                System.out.println("Duplicate found");
                for (int i = left; i <=right ; i++) {
                    System.out.print(" "+nums[i]);
                }
                System.out.println();
            }
            else {
                set.add(nums[right]);
                sum+=nums[right];
            }
            max=Math.max(max,sum);
            System.out.println(nums[left]+" "+nums[right]);
            right++;
            left++;
        }
        return max;
    }
    public long maximumSubarraySum2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        long sum = 0, maxSum = 0;

        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                set.add(nums[right]);
                sum += nums[right];
                right++;

                if (right - left == k) {
                    maxSum = Math.max(maxSum, sum);
                    set.remove(nums[left]);
                    sum -= nums[left];
                    left++;
                }
            } else {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
