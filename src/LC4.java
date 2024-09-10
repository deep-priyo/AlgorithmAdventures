import java.util.Arrays;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class LC4 {
    public static void main(String[] args) {
            int arr1[]={1,3};
            int[] arr2={2};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
    // naive approach
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedArr[]=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                mergedArr[k++]=nums1[i++];
            }
            else
            {
                mergedArr[k++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            mergedArr[k++]=nums1[i++];
        }
        while(j<nums2.length){
            mergedArr[k++]=nums2[j++];
        }
        System.out.println(Arrays.toString(mergedArr));
        if(mergedArr.length%2!=0)
            return (double)mergedArr[mergedArr.length/2];
        else
        {
            return (double)((mergedArr[mergedArr.length/2]+mergedArr[mergedArr.length/2-1])/2.0);
        }

    }
}
