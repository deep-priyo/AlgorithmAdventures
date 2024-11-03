public class LC2490 {
    public static void main(String[] args) {
        String s="leetcodel";
        System.out.println(isCircularSentence(s));
    }
    public static boolean isCircularSentence(String sentence) {
        sentence=sentence.trim();
        if((sentence.charAt(0)) != (sentence.charAt(sentence.length()-1)))
            return false;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(c==' ')
            {
                if(sentence.charAt(i+1)!=sentence.charAt(i-1))
                    return false;
            }
        }
        return true;
    }
}
