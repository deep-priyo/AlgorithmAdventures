import java.util.HashMap;

public class LC76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (t == null || t.isEmpty() || s == null || s.isEmpty()) {
            return "";
        }

        // Step 1: Build the frequency map for string t
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Step 2: Sliding window variables
        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0;
        int need = countT.size(); // Number of unique characters in t
        int leftPointer = 0;
        int resLen = Integer.MAX_VALUE;
        String res = "";

        // Step 3: Expand and contract the window
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char ch = s.charAt(rightPointer);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // If the character count in the window matches that in t
            if (countT.containsKey(ch) && window.get(ch).intValue() == countT.get(ch).intValue()) {
                have++;
            }

            // Step 4: Try to shrink the window when all characters are matched
            while (have == need) {
                // Update the result if the current window is smaller
                if ((rightPointer - leftPointer + 1) < resLen) {
                    resLen = rightPointer - leftPointer + 1;
                    res = s.substring(leftPointer, rightPointer + 1);
                }

                // Remove the leftmost character and shrink the window
                char leftChar = s.charAt(leftPointer);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                leftPointer++;
            }
        }

        return res;
    }
}
