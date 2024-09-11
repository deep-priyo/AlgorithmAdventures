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
/*For string s = "abcabcbb":

Initial state: i=0, j=0, max=0, set={}.

j=0 (s.charAt(j) is 'a'):

'a' is not in set, so add 'a' to set and increment j.
Update max = 1 (set.size() is 1).
j=1 (s.charAt(j) is 'b'):

'b' is not in set, so add 'b' and increment j.
Update max = 2.
j=2 (s.charAt(j) is 'c'):

'c' is not in set, so add 'c' and increment j.
Update max = 3.
j=3 (s.charAt(j) is 'a'):

'a' is already in set, so we enter the else clause.
Remove characters from the beginning until 'a' is removed (i is moved to 1).
Continue the process and eventually j reaches the end of the string.
Final result: max = 3, since the longest substring without repeating characters is "abc".*/
