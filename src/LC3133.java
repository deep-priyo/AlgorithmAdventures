import java.util.Arrays;

public class LC3133 {
    public static void main(String[] args) {
        System.out.println(minEnd(3,4));
    }
    public static long minEnd(int n, int x) {
        long[] arr = new long[n];
        arr[0] = x;
        int com=x;
        long j;
        for (int i = 1; i < n; i++) {
            for(j=x+1;;j++)
            {
                if((arr[i-1]&j)==com)
                {
                    arr[i] = j;
                    break;
                }
            }
            x= (int) (arr[i]);
        }
        //System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }
//    public static long minEnd(int n, int x) {
//        long[] arr = new long[n];
//        arr[0] = x;
//        int com=x;
//        long j;
//        for (int i = 1; i < n; i++) {
//            for(j=x+1;;j++)
//            {
//                if((arr[i-1]&j)==com)
//                {
//                    arr[i] = j;
//                    break;
//                }
//            }
//            x= (int) (arr[i]);
//        }
//        //System.out.println(Arrays.toString(arr));
//        return arr[n-1];
//    }
}
