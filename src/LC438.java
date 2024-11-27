import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC438 {
    public static void main(String[] args) {

    }
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<Integer>();
        if(p.length()>s.length())return result;

        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        HashMap<Character,Integer> pCount=new HashMap<Character,Integer>();


        //population the pCount hashmap and also initialize the window hashmap
        for (int i = 0; i < p.length(); i++)
        {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i),0)+1);
        }
        if(window.equals(pCount))
            result.add(0);
        int left = 0;
        int right = p.length();
        while (right <s.length())
        {
            window.put(s.charAt(left), window.getOrDefault(s.charAt(left),0)-1);
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right),0)+1);
            if(window.get(s.charAt(left)) == 0)
                window.remove(s.charAt(left));
            if(window.equals(pCount))
                result.add(left+1);
            left++;
            right++;
        }
        return result;
    }
}
