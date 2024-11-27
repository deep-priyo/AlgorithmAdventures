import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public static void main(String[] args) {
       int[][] arr={{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(arr));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        if(n == 0 || m == 0) return res;
        int left=0;
        int right=m-1;
        int top=0;
        int bottom=n-1;

        while(top<=bottom && left<=right){
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
