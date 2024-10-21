import java.util.*;

public class LC1431 {
    public static void main(String[] args) {

    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int max=Integer.MIN_VALUE;
        for (int j : candies) {
            max = Math.max(max, j);
        }
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;

    }
}
