public class lc2894 {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(5,6));
    }
    public static int differenceOfSums(int n, int m) {
        int sumDivisible=0,sumNotdivisible=0;
        for (int i = 1; i <= n; i++) {
            if(i % m == 0)
                sumDivisible+=i;
            else
                sumNotdivisible+=i;
        }
        return sumNotdivisible-sumDivisible;
    }
}
