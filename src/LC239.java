import java.util.Arrays;

public class LC239 {
    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString( maxSlidingWindow(arr,k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left=0;
        int right=k;
        int thirdPointer=0;
        int max=Integer.MIN_VALUE;
        System.out.println("No of steps: "+(nums.length-k+1));
        int arr[]=new int[nums.length-k+1];
        int arrIndex=0;
        while(right<nums.length+1)
        {
            while(thirdPointer<right )
            {
                System.out.print(" "+nums[thirdPointer]);
                max=Math.max(max,nums[thirdPointer]);
                thirdPointer++;
            }
            arr[arrIndex++]=max;
            System.out.println();
            System.out.println(max);
            max=Integer.MIN_VALUE;
            System.out.println();
            left+=1;
            right+=1;
            thirdPointer=left;
        }
        return arr;
    }
}
