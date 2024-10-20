public class LC1071 {
    public static void main(String[] args) {

    }
    public static String gcdOfStrings(String str1, String str2)
    {
       if(!(str1+str2).equals(str2+str1))
           return "";
       int gcd=gcd(str1.length(),str2.length());
       return str1.substring(0,gcd);

    }

    private static int gcd(int a, int b)
    {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
