public class LC3163 {
    public static void main(String[] args) {
        String s="aaaaaaaaaaaaaabb";
        System.out.println(compressedString(s));
    }
    public static String compressedString(String word) {
        StringBuilder res = new StringBuilder();
        char prev = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == prev && count < 9) {
                count++;
            }
            else
            {
                res.append(count).append(prev);
                System.out.println(prev+"->"+count);
                count=1;
            }
            prev = word.charAt(i);
        }
        System.out.println(prev+"->"+count);
        res.append(count).append(prev);
        return res.toString();
    }
}
