import java.util.Arrays;

public class LC2779 {
    public static void main(String[] args) {
        int[] nums={4,6,1,2};
        System.out.println(maximumBeauty(nums,2));
    }
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            while (nums[r]-nums[l]>(2*k)){
                l+=1;
            }
            res=Math.max(res,r-l+1);

        }
        return res;
    }
}
