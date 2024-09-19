public class LC35 {
    public static void main(String[] args) {
        int[] arr={1,3,5,6};
        System.out.println(searchInsert(arr,7));
    }
    public static int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return l;
    }
}
