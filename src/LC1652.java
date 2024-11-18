import java.util.Arrays;

public class LC1652 {
    public static void main(String[] args) {
        int[] code={5,7,1,4};
        System.out.println(Arrays.toString(decrypt(code,3)));
    }
    public static int[] decrypt(int[] code, int k) {

        int n=code.length;
        int[] res =new int[n];
        if(k==0)
            return res;

        if(k>0)
        {
            for(int i=0; i<n; i++)
//                int l=i+1;
//                for (int j = 1; j <= k; j++) {
//
//                res[i]+=code[l%n];
//                l++;
//                }
                for (int j = i+1; j <= i+k; j++)
                    res[i]+=code[j%n];
        }
        if(k<0)
        {
            for (int i = 0; i < n; i++) {
//                int l = i - 1;
//                for (int j = 1; j <= -k; j++) {
//                    res[i] += code[(l + n) % n];
//                    l--;
//                }
                for (int j = i-1; j >= i-Math.abs(k); j--)
                {
                    res[i] += code[(j+n )%n];
                }
            }
        }
        return res;
    }

}
