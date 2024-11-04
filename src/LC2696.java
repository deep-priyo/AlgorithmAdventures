public class LC2696 {
    public static void main(String[] args) {
        String s= "ABFCACDBABAB";
        System.out.println(minLength(s));
    }
    public static int minLength(String s) {

        String prev="";
        while (!prev.equals(s)) {
            prev = s;
            s = s.replaceAll("AB", ""); // Remove all occurrences of "AB"
            s = s.replaceAll("CD", "");
        }

        System.out.println(s);
        return s.length();
    }
}
