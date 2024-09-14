//https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
public class lc3190 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(minimumOperations(arr));
    }
    public static int minimumOperations(int[] nums) {
        int operation=0;
        for(int n:nums)
        {
            if((n+1)%3==0||(n-1)%3==0)
                operation++;
        }
        return operation;
    }
}
