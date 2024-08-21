import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//skip duplicate for first pointer
            int l = i + 1;//pointer l
            int r = nums.length - 1;//pointer r

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0)
                {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // Skip duplicates for the left pointer
                    while (l < r && nums[l] == nums[l + 1])
                        l++;//run until no duplicate

                    // Skip duplicates for the right pointer
                    while (l < r && nums[r] == nums[r - 1])
                        r--;//decrease until no duplicate

                    l++;
                    r--;
                }
                else if (sum < 0)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        return res;
    }
}
