//1752. Check if Array Is Sorted and Rotated
//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/?envType=daily-question&envId=2025-02-02
public class LC1752 {
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        System.out.println(check(arr));
    }
    public static boolean check(int[] nums) {
        int i;
        for ( i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
        }
        if(i == nums.length-1){return true;}// handling already sorted array
        int j;
        for (j = i+1; j < nums.length-1; j++) {
            if(nums[j]>nums[j+1])
                return false;
            System.out.println(nums[j]);
        }
        System.out.println("seconf loop");
        if(nums[j]>nums[0]){return false;}
        for (j = 0; j < i ; j++) {
            if(nums[j]>nums[j+1])
                return false;
            System.out.println(nums[j]);
        }
        return true;
    }
}
