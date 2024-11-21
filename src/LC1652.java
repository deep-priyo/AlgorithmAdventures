import java.util.Arrays;

public class LC1652 {
    public static void main(String[] args) {
        int[] code={2,4,9,3};
        System.out.println(Arrays.toString(decrypt(code,2)));
    }
    public static int[] decrypt2(int[] code, int k) {

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
    } public static int[] decrypt(int[] code, int k) {
        int[] res =new int[code.length];
        int i;
        int sum=0;
        for (i = 0; i < k; i++) {
            sum+=code[i%code.length];
        }
        if(k>0)res[res.length-1]=sum;
        if(k<0)res[res.length-k]=sum;

        int j=0;
        for (; i < code.length+k; i++) {

            sum=sum+code[i% code.length]-code[j%code.length];
            res[j% code.length]=sum;
            System.out.println(sum);
            j++;
        }
        return res;
    }

}
