public class LC1790 {
    public static void main(String[] args) {
        String s1="bank";
        String s2="kanb";
        System.out.println(areAlmostEqual(s1,s2));
    }
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        int count=0;
        int[] indices=new int[2];
        for(int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count >= 2) return false; // More than two mismatches → impossible
                indices[count++] = i;
            }
        }
        // If exactly one mismatch, swap is impossible
        if (count != 2) return false;
        // Check if swapping makes the strings equal
        return s1.charAt(indices[0]) == s2.charAt(indices[1]) && s1.charAt(indices[1]) == s2.charAt(indices[0]);

    }
}
