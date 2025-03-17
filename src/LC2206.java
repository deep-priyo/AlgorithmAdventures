import java.util.HashMap;

public class LC2206 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,2,2,2};
        System.out.println(divideArray(nums));
    }
    public static boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i:map.values())
        {
            if(i%2!=0)
                return false;
        }
        return true;
    }
}
