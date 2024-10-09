//https://leetcode.com/problems/score-of-a-string/submissions/1416702693/
public class lc3110 {
    public static void main(String[] args) {
        String s="hello";
        System.out.println(scoreOfString(s));
    }
    public static int scoreOfString(String s) {
        int prev=(int)s.charAt(0);
        if(s.length()==1)
            return prev;
        int ans=0;
        for (int i = 1; i <s.length() ; i++) {
            ans+=Math.abs(prev-(int)s.charAt(i));
            prev=(int)s.charAt(i);
        }
        return ans;

    }
}
