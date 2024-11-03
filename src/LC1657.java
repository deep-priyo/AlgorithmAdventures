import java.util.Arrays;

public class LC1657 {
    public static void main(String[] args) {
        String word1="uau";
        String word2="ssx";
        System.out.println( closeStrings(word1,word2));

    }
    public static boolean closeStrings(String word1, String word2) {
        int[] word1CharCount=new int[26];
        int[] word2CharCount=new int[26];
        for (int i = 0; i < word1.length(); i++) {
            word1CharCount[word1.charAt(i)-'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            word2CharCount[word2.charAt(i)-'a']++;
        }
        System.out.println("before sort "+Arrays.toString(word1CharCount));
        System.out.println("before sort "+Arrays.toString(word2CharCount));
        for (int i = 0; i < 26; i++) {
            if (word1CharCount[i]>0)
            {
                if(word2CharCount[i]==0)
                    return false;
            }
            if(word2CharCount[i]>0)
            {
                if(word1CharCount[i]==0)
                    return false;
            }

        }
        word1CharCount= Arrays.stream(word1CharCount).sorted().toArray();
        word2CharCount= Arrays.stream(word2CharCount).sorted().toArray();
        for (int i = 0; i < 26; i++) {
            if (word1CharCount[i]!=word2CharCount[i]) {
                return false;
            }
        }

        System.out.println(Arrays.toString(word1CharCount));
        System.out.println(Arrays.toString(word2CharCount));
        return true;
    }
}
