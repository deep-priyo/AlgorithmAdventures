
public class LC3151 {
    public static void main(String[] args) {
        int[] nums ={2,1,4,4,4,1};
        System.out.println(isArraySpecial(nums));
    }
    public static boolean isArraySpecial(int[] nums) {
        if(nums.length==1)return true;
        int checker=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                if(checker==1)return false;
                checker=1;
            }
            else {
                if (checker == 2) return false;
                checker = 2;
            }
        }
        return true;
    }
}
