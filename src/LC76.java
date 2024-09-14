import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/description/
public class LC76 {
    public static void main(String[] args) {
    minWindow("ADOBECODEBANC","ABC");
    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        System.out.println("Hashmap of t"+mapT);
        int i, j = 0;
        for ( i = 0; i < t.length(); i++)
        {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println("Hashmap of s"+mapS);
        while (i < s.length()) {
            char c = s.charAt(i);
            //System.out.println(c);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
            while (isSubset(mapT, mapS))
            {
                System.out.println(s.substring(j, i+1)+ " --- "+i);
                mapS.remove(s.charAt(j));//removing char from the j or slow pointer
                j++;

            }

            i++;
        }
        return "";
    }
    public static boolean isSubset(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        // Iterate through all the elements of map1
        for (Character key : map1.keySet()) {
            // If map2 doesn't contain the key or the count in map2 is less than map1, return false
            if (!map2.containsKey(key) || map2.get(key) < map1.get(key)) {
                return false;
            }
        }
        // If we never return false, map1 is a subset of map2
        return true;
    }
}
