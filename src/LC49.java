//https://leetcode.com/problems/group-anagrams/description/
import java.util.*;
public class LC49 {
 
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupedAnagrams = new HashMap<>();
        for(String s : strs) {
            char[] charArray = s.toCharArray();// convert each word to its equivalent character array
            Arrays.sort(charArray);//sort the character arrya
            String sortedStr = new String(charArray);
            //check if this sorted string already exists as key in map
            if(!groupedAnagrams.containsKey(sortedStr)) {
                groupedAnagrams.put(sortedStr, new ArrayList<>());
            }
            groupedAnagrams.get(sortedStr).add(s);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }


}
