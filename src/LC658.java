import java.util.*;

//https://leetcode.com/problems/find-k-closest-elements/description/
public class LC658 {
    public static void main(String[] args) {
        int []arr={1,1,1,10,10,10};
        int k=4;//it is the number of integer to return
        int x=10;//closest to x
        System.out.println(findClosestElements(arr,k,x));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = Arrays.binarySearch(arr, x);
        if(index<0){
            index = -index-1;
        }
        System.out.println("Index returned by binary search= "+index);
        int a=index-1,b=index;//two pointers

        for(int i=1;i<=k;i++) {


            if(a<0)//edge cases
            {
                result.add(arr[b]);
                b++;
            }
            else if(b>= arr.length)//edge cases
            {
                result.add(arr[a]);
                a--;
            }
            else if (Math.abs(arr[a] - x) < Math.abs(arr[b] - x)) {
                result.add(arr[a]);
                a--;
            }
            else if ((Math.abs(arr[a] - x) == Math.abs(arr[b] - x))&&(arr[a]<arr[b]))
            {
                result.add(arr[a]);
                a--;
            }
            else {
                result.add(arr[b]);
                b++;
            }
        }
        Collections.sort(result);
        return result;
    }
}
