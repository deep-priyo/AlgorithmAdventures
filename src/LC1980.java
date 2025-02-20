import java.util.HashSet;

//https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2025-02-20
public class LC1980 {
    public static void main(String[] args) {
        String[] nums = {"00","10"};
        System.out.println(findDifferentBinaryString(nums));
    }
    public static String findDifferentBinaryString(String[] nums) {
        int n=nums[0].length();
        boolean[] arr=new boolean[1 << n];
        for(int i=0;i<nums.length;i++) {
            System.out.println(binaryToDecimal(nums[i]));
            arr[binaryToDecimal(nums[i])]=true;
        }
        for(int i=0;i<(2^n);i++) {
            if(!arr[i]) {
                String binary = Integer.toBinaryString(i);
                return String.format("%" + n + "s", binary).replace(' ', '0');
            }
        }
        return nums[0];

    }
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
