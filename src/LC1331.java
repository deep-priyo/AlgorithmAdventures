import java.util.Arrays;
import java.util.HashMap;

public class LC1331 {
    public static void main(String[] args) {
        int [] arr={40,10,20,30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
    public static int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sortedUnique[]=Arrays.stream(arr).distinct().sorted().toArray();
        for(int i=0;i<sortedUnique.length;i++){
            map.put(sortedUnique[i],i+1);
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
