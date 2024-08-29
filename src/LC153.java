//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class LC153 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] arr) {
        int res=arr[0];
        int l=0,r=arr.length-1;
        while(l<=r) {
            if(arr[l]<arr[r]) {
                res=Math.min(res,arr[l]);
                break;
            }
            int mid=(l+r)/2;
            res=Math.min(res,arr[mid]);
            if(arr[mid]>=arr[l] ){
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }


        }
        return res;
    }
}
