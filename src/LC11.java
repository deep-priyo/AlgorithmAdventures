//https://leetcode.com/problems/container-with-most-water/description/
public class LC11 {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));

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
}

