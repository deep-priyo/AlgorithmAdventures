//1800. Maximum Ascending Subarray Sum
//https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04
public class LC1800 {
    public static void main(String[] args) {
        int[] arr={10,20,30,5,10,50};
        System.out.println("\n"+maxAscendingSum(arr));
    }
    public static int maxAscendingSum(int[] arr) {
        int maxSum=arr[0];
        int sum=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]<arr[i])
            {
                System.out.print(arr[i-1]);
                sum+=arr[i];
                System.out.println("SUm : "+sum);
            }
            else
            {
                maxSum=Math.max(maxSum,sum);
                System.out.println();
                sum=arr[i];
            }
        }
        return Math.max(maxSum,sum);
    }
}
