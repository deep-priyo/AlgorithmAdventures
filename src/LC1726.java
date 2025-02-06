import java.util.HashMap;

//https://leetcode.com/problems/tuple-with-same-product/description/?envType=daily-question&envId=2025-02-06
public class LC1726 {
    public static void main(String[] args) {
        int[] arr={2,3,4,6,8,12};
        tupleSameProduct(arr);
    }
    public static int tupleSameProduct(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                System.out.println("i="+arr[i]+",j="+arr[j]+", i*j="+arr[i]*arr[j]);


            }
        }
        int c=0;
        for(Integer i:map.keySet()) {
            if(map.get(i)>1) {
                c+= (int) (map.get(i)*Math.pow(2,i));
            }
        }
        System.out.println(map);
        return c;
    }
}
