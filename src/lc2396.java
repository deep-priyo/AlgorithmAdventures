public class lc2396 {
    public static void main(String[] args) {
        System.out.println( isStrictlyPalindromic(9));
    }
    public static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n -2 ; i++) {
            int convertedBase=convertToBase(n,i);
            if(!isPalindrome(convertedBase))
                return false;
        }
        return true;

    }
    public static int convertToBase(int n, int b) {
        // Base case: when n is 0, return 0
        if (n == 0) {
            return 0;
        }

        // Calculate the remainder and recursively calculate the rest of the number
        int remainder = n % b;
        n /= b;

        // Combine the result from recursive calls and remainders
        // We multiply the result of the recursive call by 10 to "shift" the digits
        return convertToBase(n, b) * 10 + Math.abs(remainder);
    }
    public static boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;  // Append the last digit of x to reversedHalf
            x /= 10;  // Remove the last digit of x
        }

        // Check if the original number (x) is equal to the reversed half
        // or if x is equal to the reversedHalf divided by 10 (handles odd-length cases)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
