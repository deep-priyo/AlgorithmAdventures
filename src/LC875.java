//https://leetcode.com/problems/koko-eating-bananas/description/

import java.util.Arrays;

public class LC875 {
    public static void main(String[] args) {
    int[] piles={332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
    int hours=823855818;

        System.out.println(minEatingSpeed(piles,hours));
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


}
