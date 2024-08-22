//https://leetcode.com/problems/container-with-most-water/description/
public class LC11 {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(arr));

    }
    public static int maxArea(int[] height) {
        int max=0;
    for (int i = 0; i < height.length; i++) {
        for (int j = i+1; j < height.length; j++) {
            int min = Math.min(height[i], height[j]);
            int area = min * (j - i);
            max = Math.max(max, area);

        }
    }
    return max;
    }
    public static int maxArea2(int[] height) {
        int max=0;
        int i=0;
        int j=height.length-1;
        while(i<j){

            int area = Math.min(height[i],height[j]) * (j - i);
            max = Math.max(max, area);
            if(height[i]<height[j]){
                i++;
            }
            else
            {
                j--;
            }

        }
        return max;
    }
}

