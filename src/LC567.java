import java.util.HashMap;
//https://leetcode.com/problems/permutation-in-string/description/
public class LC567 {
    public static void main(String[] args) {
 String s1="adc";
 String s2="dcda";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false; // s1 is bigger so cannot get a permutation ever

        HashMap<Character, Integer> mapS1 = new HashMap<>();
        HashMap<Character, Integer> mapS2 = new HashMap<>();
        // Create a frequency map for s1
        for(char c: s1.toCharArray()) {
            mapS1.put(c, mapS1.getOrDefault(c, 0) + 1);
        }
        int i=0;
        int j=s1.length();// the location of the second pointer = length of s1 the sub-strings should be of equal length
        while(j<=s2.length()) {
            String s=s2.substring(i,j);
            System.out.println(s);
            for(char c: s.toCharArray()) {
                if(mapS2.containsKey(c)) {
                    mapS2.put(c, mapS2.get(c) + 1);
                }
                else
                    mapS2.put(c, 1);
            }
            if(mapS1.equals(mapS2)) {
                return true;
            }
            else
            {
                mapS2.clear();
                i++;
                j++;
            }
        }

        System.out.println(mapS1);
        return false;
    }

}
