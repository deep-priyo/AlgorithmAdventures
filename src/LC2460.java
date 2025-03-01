import java.util.Arrays;

public class LC2460 {
    public static void main(String[] args) {
        int[] arr={1,2,2,1,1,0};
        System.out.println(Arrays.toString(applyOperations(arr)));
    }
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int index=0;
        for (int i = 0; i < n ; i++) {
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while(index<n){
            nums[index++] = 0;
        }
        return nums;
    }
}
