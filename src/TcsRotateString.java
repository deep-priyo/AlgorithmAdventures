import java.util.HashMap;
import java.util.Scanner;

/*Question 2 . Rotate a given String in the specified direction by specified magnitude.
After each rotation make a note of the first character of the rotated String, After all rotation
are performed the accumulated first character as noted previously will form another string,
say FIRSTCHARSTRING.
Check If FIRSTCHARSTRING is an Anagram of any substring of the Original string.
If yes print "YES" otherwise "NO". Input
The first line contains the original string s. The second line contains a single integer q. The
ith of the next q lines contains character d[i] denoting direction and integer r[i] denoting the
magnitude.
Constraints
1 <= Length of original string <= 30
1<= q <= 10
Output
YES or NO
*/
public class TcsRotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input the original string
        System.out.println("Enter the original string:");
        String s = sc.nextLine();

        // Step 2: Input the number of queries
        System.out.println("Enter the number of queries:");
        int q = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        // Step 3: Create arrays to store directions and magnitudes
        char[] directions = new char[q];
        int[] magnitudes = new int[q];

        // Step 4: Input each query
        for (int i = 0; i < q; i++) {
            System.out.println("Enter direction (L/R) and magnitude for query " + (i + 1) + " (e.g., L 4):");
            String[] input = sc.nextLine().split(" ");

            // Parse the inputs
            directions[i] = input[0].charAt(0); // First part is the direction (L/R)
            magnitudes[i] = Integer.parseInt(input[1]); // Second part is the magnitude
        }

        // Step 5: Print the inputs for verification
        System.out.println("\nOriginal String: " + s);
        System.out.println("Number of Queries: " + q);
        System.out.println("Queries:");
        for (int i = 0; i < q; i++) {
            System.out.println("Direction: " + directions[i] + ", Magnitude: " + magnitudes[i]);
        }
        Solution(s,q,directions,magnitudes);
    }
    public static void Solution(String s,int q,char[] directions,int[] magnitude)
    {
        String rotatedLeft=s;
        String rotatedRight=s;
        StringBuilder FIRSTCHARSTRING= new StringBuilder();
        for (int i = 0; i < q; i++) {
            System.out.println("This direction is "+directions[i]);
            for (int j = 0; j < magnitude[i]; j++) {

                if (directions[i] == 'L') {

                    rotatedLeft=rotateLeft(rotatedLeft);
                    FIRSTCHARSTRING.append(rotatedLeft.charAt(0));
                    System.out.println(rotatedLeft);
                }
                if (directions[i] == 'R') {

                    rotatedRight=rotateRight(rotatedRight);
                    FIRSTCHARSTRING.append(rotatedRight.charAt(0));
                    System.out.println(rotatedRight);
                }
            }

        }
        System.out.println(FIRSTCHARSTRING);
        if(isAnagramOfSubstring(s,FIRSTCHARSTRING.toString()))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    public static boolean isAnagramOfSubstring(String originalStr, String firstCharStr) {
        int n = originalStr.length();
        int m = firstCharStr.length();

        if (m > n) return false; // If firstCharStr is longer, it can't be a substring.

        // Count characters in firstCharStr
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : firstCharStr.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window initialization
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char c = originalStr.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        // Compare the maps for the first window
        if (windowMap.equals(targetMap)) return true;

        // Slide the window across originalStr
        for (int i = m; i < n; i++) {
            // Remove the leftmost character from the window
            char leftChar = originalStr.charAt(i - m);
            if (windowMap.get(leftChar) == 1) {
                windowMap.remove(leftChar);
            } else {
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
            }

            // Add the new character to the window
            char newChar = originalStr.charAt(i);
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);

            // Compare maps
            if (windowMap.equals(targetMap)) return true;
        }

        return false;
    }

    public static String rotateLeft(String s)
    {
        s=s.substring(1)+s.charAt(0);
        return s;
    }
    public static String rotateRight(String s)
    {
        s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        return s;
    }
}
