import java.util.Arrays;

public class LC2838 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(Arrays.toString( productExceptSelf(arr)));
    }
    public static int[] productExceptSelf(int[] arr) {
        int [] preFix = new int[arr.length];
        int [] postFix = new int[arr.length];
        int [] result = new int[arr.length];
        preFix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preFix[i]=preFix[i-1]*arr[i];
        }
        postFix[arr.length-1]=arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            postFix[i]=postFix[i+1]*arr[i];
        }
        result[0]=postFix[1];
        result[arr.length-1]=preFix[arr.length-2];
        for (int i = 1; i < arr.length-1; i++) {
            result[i]=postFix[i+1]*preFix[i-1];
        }
        System.out.println(Arrays.toString(preFix));
        System.out.println(Arrays.toString(postFix));
     return result;
    }
}
