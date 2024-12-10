import java.util.HashMap;
import java.util.Map;

public class LC2981 {
    public static void main(String[] args) {
        String s="abcaba";
        System.out.println( maximumLength(s));
    }
    public static int maximumLength(String s) {
        HashMap<String, Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String substring="";
            for (int j = i ; j < s.length(); j++) {
                substring +=s.charAt(j);
                if(hasSameCharacters(substring))
                    map.put(substring, map.getOrDefault(substring, 0) + 1);
            }


        }
        int max=-1;
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            if(value>=3)
            {
                max=Math.max(max,(key.length()));
            }

        }
        System.out.println(map);
        return max;
    }
    public static boolean hasSameCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        char firstChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}
