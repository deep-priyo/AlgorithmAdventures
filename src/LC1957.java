public class LC1957 {
    public static void main(String[] args) {


    }
    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int c=0;
        sb.append(s.charAt(0));
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i)==s.charAt(i-1)) {
                c++;
            }
            else
                c=0;
            if(c<3)
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
