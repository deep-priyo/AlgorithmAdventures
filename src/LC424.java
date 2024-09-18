import java.util.HashMap;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LC424 {
    public static void main(String[] args) {
        characterReplacement("ABABBAB",2);
    }
    public static int characterReplacement(String s, int k) {
        int max=0;
        HashMap <Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }
        System.out.println(map);
        return max;
    }
  
}
