import java.util.HashMap;
import java.util.HashSet;

public class LC3 {
    public static void main(String[] args) {
        String s= "pwwkew";
        System.out.println( lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int max=0;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length())
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
                max=Math.max(max,set.size());
            }
            else
            {   while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            }


        }
        return max;
    }
    public static int naive(String s) {
        HashSet set = new HashSet();
        int max = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j=i+1; j<s.length(); j++){
                boolean add= set.add(s.charAt(j));
                if(!add){
                    //System.out.println(set);

                    max= Math.max(max, set.size());
                    set.clear();
                }
            }
        }
        return max;
    }
}
