import java.util.Scanner;

public class TCSChakravyuhaMatrixTraversal {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int N = ob.nextInt();
        Solution(N);

    }

    public static void Solution(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int powerPoint=1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count;
                count++;
                if(count%11==0)
                {
                    System.out.println(top+","+i);
                    count++;
                }
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = count;
                    count++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = count;
                    count++;
                }
                left++;
            }
        }
        int[] iARR=new int[n];
        int[] jARR=new int[n];
        int k=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
                if(matrix[i][j]%11==0)
                {
                    iARR[k]=i;
                    jARR[k]=j;
                    k++;

                    powerPoint++;
                }
            }

            System.out.println();
        }
        System.out.println("(0,0)");
        for (int i = 0; i < k; i++) {
            System.out.println("("+iARR[i]+","+jARR[i]+")");
        }
        System.out.println("Total Power points: "+powerPoint);
    }
}
