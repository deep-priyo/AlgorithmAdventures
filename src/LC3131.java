public class LC3131 {
    public static void main(String[] args) {

    }
    public int addedInteger(int[] nums1,int[] nums2)
    {
        int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int i:nums1)
        {
            min=Math.min(min,i);
        }
        for (int i:nums2)
        {
            min2=Math.min(min2,i);
        }
        return min2-min;
    }
}
