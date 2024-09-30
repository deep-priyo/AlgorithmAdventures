import java.util.*;

public class LC2610 {
    public static void main(String[] args) {
        int[] arr={1,3,4,1,2,3,1};

    }
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int n : nums) {
            int row = count.getOrDefault(n, 0);
            if (res.size() == row)
                res.add(new ArrayList<>());
            res.get(row).add(n);
            count.put(n, row + 1);
        }
        return res;
    }
}
