import java.util.Arrays;
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class LC33 {
    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,5,6,7,8,9};
        System.out.println(search(arr,0));
    }
    public static int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        // Find the rotation point
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // l is the index of the smallest element (rotation point)
        int rotationPoint = l;

        // Determine which part of the array to search
        l = 0;
        r = arr.length - 1;

        if (target >= arr[rotationPoint] && target <= arr[r]) {
            l = rotationPoint;
        } else {
            r = rotationPoint - 1;
        }

        // Binary search in the chosen part
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}
