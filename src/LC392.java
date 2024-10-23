public class LC392 {
    public static void main(String[] args) {
        String s = "adbc"; String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        if (s.isEmpty()) return true;

        int j=0;
        String ans="";
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(c==s.charAt(j))
            {
                ans+=c;
                j++;
                if(j==s.length()) break;
            }

        }
        return ans.equals(s);
    }
}
