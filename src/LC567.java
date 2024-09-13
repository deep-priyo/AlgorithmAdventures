import java.util.HashMap;

public class LC567 {
    public static void main(String[] args) {
 String s1="adc";
 String s2="dcda";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mapS1 = new HashMap<>();
        HashMap<Character, Integer> mapS2 = new HashMap<>();
        for(char c: s1.toCharArray()) {
            if(mapS1.containsKey(c)) {
                mapS1.put(c, mapS1.get(c) + 1);
            }
            else
                mapS1.put(c, 1);
        }
        int i=0;
        int j=s1.length();
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
