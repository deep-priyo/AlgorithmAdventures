public class LC2601 {
    public static boolean primeSubOperation(int[] nums) {
        int prev=0;
        for(int n:nums)
        {
            int upper_bound=n-prev;
            int largest_p=0;
            for (int i = upper_bound-1; i >=2 ; i--) {
                if(isPrime(i)) {
                    largest_p = i;
                    break;
                }
            }
            if (n-largest_p<=prev)
                return false;
            prev=n-largest_p;
        }
        return true;
    }
    private static boolean isPrime(int n)
    {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
