import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
public class LC884 {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";String s2 = "this apple is sour";
        System.out.println(Arrays.toString( uncommonFromSentences(s1, s2)));
    }
    public static String[] uncommonFromSentences(String s1, String s2) {
        s1+=" "+s2+" ";
        System.out.println(s1);


        HashMap<String,Integer> map = new HashMap<>();
        String word="";
        for(int i = 0; i < s1.length(); i++) {
        if(s1.charAt(i) == ' ') {

            map.put(word,map.getOrDefault(word,0) + 1);

            word="";
        }
        else
            word+=s1.charAt(i);


     }
//        for(int i = 0; i < s2.length(); i++) {
//            if(s2.charAt(i) == ' ') {
//
//                map.put(word,map.getOrDefault(word,0) + 1);
//                word="";
//            }
//            else
//                word+=s2.charAt(i);
//
//
//        }
        List<String> uncommonWords = new ArrayList<>();

        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                System.out.println(key);
                uncommonWords.add(key);
            }
            //System.out.println(key+" "+map.get(key));
        }
        return uncommonWords.toArray(new String[0]);


    }
    public static String[] uncommonFromSentences2(String s1, String s2) {
        List<String> output = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        s1+=" "+s2+" ";
        String[] s1Str = s1.split(" ");

        for(String word: s1Str) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }



        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                output.add(word);
            }
        }


        return output.toArray(new String[0]);

    }
}
