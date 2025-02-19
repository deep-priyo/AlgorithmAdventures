import java.util.ArrayList;

public class LC1415 {
    public static void main(String[] args) {
        int n=3,k=9;
        System.out.println(getHappyString(n,k));
    }
    public static String getHappyString(int n, int k) {
        StringBuilder curString = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        solve(curString,result,n);
        if(k>result.size())
            return "";
        return result.get(k-1);
    }
    public static void solve(StringBuilder curString,ArrayList<String> result,int n)
    {
        if(curString.length()==n)
        {
            result.add(curString.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++)
        {
            if (curString.length()>0 && curString.charAt(curString.length()-1)==ch)
                continue;
            curString.append(ch);
            solve(curString,result,n);
            curString.deleteCharAt(curString.length()-1);
        }

    }
}
