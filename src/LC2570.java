import java.util.Arrays;

public class LC2570 {
    public static void main(String[] args) {
        int[][] nums1_1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2_1 = {{1, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.deepToString(mergeArrays(nums1_1, nums2_1)));

        int[][] nums1_2 = {{2, 4}, {3, 6}, {5, 5}};
        int[][] nums2_2 = {{1, 3}, {4, 3}};
        System.out.println(Arrays.deepToString(mergeArrays(nums1_2, nums2_2)));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0, k = 0;
        int[][] res = new int[nums1.length + nums2.length][2];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                res[k][0] = nums1[i][0];
                res[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                res[k][0] = nums1[i][0];
                res[k][1] = nums1[i][1];
                i++;
            } else {
                res[k][0] = nums2[j][0];
                res[k][1] = nums2[j][1];
                j++;
            }
            k++;
        }


        while (i < nums1.length) {
            res[k][0] = nums1[i][0];
            res[k][1] = nums1[i][1];
            i++;
            k++;
        }


        while (j < nums2.length) {
            res[k][0] = nums2[j][0];
            res[k][1] = nums2[j][1];
            j++;
            k++;
        }


        return Arrays.copyOf(res, k);
    }
}
