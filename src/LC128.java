import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LC128 {
    public static void main(String[] args) {
        int[] arr={100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=Integer.MIN_VALUE+1;
        int count=0;
        for(int num:set){
            if(!(set.contains(num-1))){
                 count=1;
                 num+=1;
                while(set.contains(num)){
                    count++;
                    num+=1;
                }
                max=Math.max(max,count);
                System.out.println(count);
            }

        }


        return max;
    }
}
