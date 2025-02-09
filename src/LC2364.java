import java.util.HashMap;

public class LC2364 {
    public static void main(String[] args) {
      int[] nums = {4,1,3,3};
      System.out.println(countBadPairs(nums));
    }
    public static long countBadPairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long result = 0;

        for (int j = 0; j < nums.length; j++) {
            int value = nums[j] - j;
            int totalNumsBeforej = j;
            int freqOfNumsj = map.getOrDefault(value, 0);
            int badPairs = totalNumsBeforej - freqOfNumsj;
            result += badPairs;
            map.put(value, freqOfNumsj + 1); // Correctly update the map
        }

        return result;
    }
}
