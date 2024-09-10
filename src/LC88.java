import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class LC88 {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=new int[m+n];
        int i=0,k=0,j=0;
        while(j<m && k<n){
            if(nums1[i]<nums2[k]){
                temp[i]=nums1[j];
                j++;
            }
            else
            {
                temp[i]=nums2[k];
                k++;
            }
            i++;
        }
        while(j<m){
            temp[i]=nums1[j];
            i++;
            j++;
        }
        while(k<n)
        {
            temp[i]=nums2[k];
            i++;
            k++;
        }
        for(i=0;i<temp.length;i++)
            nums1[i]=temp[i];
        System.out.println(Arrays.toString(nums1));
    }
}
