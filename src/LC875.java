//https://leetcode.com/problems/koko-eating-bananas/description/

import java.util.Arrays;

public class LC875 {
    public static void main(String[] args) {
    int[] piles={332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
    int hours=823855818;

        System.out.println(minEatingSpeed2(piles,hours));
    }
    public static int minEatingSpeed(int[] piles, int hours) {
        int maxPile=Arrays.stream(piles).max().getAsInt();
        System.out.println(maxPile);
        for(int i=1;i<=maxPile;i++)
        {
            //System.out.println("For "+i+"th eating speed");
            int sum=0;
            for (int j:piles)
            {
                double k= (double) j /i;
                k=Math.ceil(k);
                sum+=(int)k;
            }
            if(sum<=hours)
                return i;
            //System.out.println();
        }
    return maxPile;
    }
    public static int minEatingSpeed2(int[] piles, int hours) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); // The maximum pile size
        int res = right; // Initialize result as the maximum possible eating speed

        while (left <= right) {
            int k = (left + right) / 2;
            int totalHours = 0;

            // Calculate the total hours required at current speed k
            for (int pile : piles) {
                totalHours += (int) Math.ceil((double) pile / k);
            }

            // If total hours required is less than or equal to the given hours
            if (totalHours <= hours) {
                res = k; // Update result to the current eating speed
                right = k - 1; // Search in the lower half for a possibly smaller valid speed
            } else {
                left = k + 1; // Search in the upper half for a higher eating speed
            }
        }

        return res;
    }


}
