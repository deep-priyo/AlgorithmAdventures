public class LC2109 {
    public static void main(String[] args) {
        int[] a = {8,13,15};
        String s="LeetcodeHelpsMeLearn";
        System.out.println(addSpaces(s,a));
    }
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int j=0;
        for (int i = 0; i < s.length(); i++) {
            if(j<spaces.length && spaces[j]==i)
            {
                sb.append(" ");
                j++;
            }

            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
