import java.util.Arrays;

public class lc283 {
    public static void main(String[] args) {
    int[] arr={0,1,0,3,12};
    moveZeroes(arr);
    }
    public static void moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
