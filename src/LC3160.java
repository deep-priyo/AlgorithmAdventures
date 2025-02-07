import java.util.HashMap;

//https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/
//3160. Find the Number of Distinct Colors Among the Balls
public class LC3160 {
    public static void main(String[] args) {}
    public static int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = queries[i][0]; //ball label
            int y = queries[i][1]; //updating color

            //when map1 doesn't contain ball labeled x
            if (!map1.containsKey(x)) {
                map1.put(x, y);
                map2.put(y, map2.getOrDefault(y, 0) + 1);
                ans[i] = map2.size();
                continue;
            }

            // when map1 contains ball labeled x
            int c = map1.get(x); // getting the previous color
            if (c == y) // updating color is same as previous color
            {
                // no need to make any changes to any map
                ans[i] = ans[i - 1];
                continue;
            }
            // c != y
            int f = map2.get(c); // getting frequency for color c
            if (f == 1)
                map2.remove(c);// since f will become 0, no need to keep c in map2
            else
                map2.put(c, f - 1);// else just reduce the frequency of color c
            map2.put(y, map2.getOrDefault(y, 0) + 1); // updating map2 and map1
            map1.put(x, y);
            ans[i] = map2.size();
        }
        return ans;
    }
}
