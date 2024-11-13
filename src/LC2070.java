import java.util.Arrays;
import java.util.HashMap;

public class LC2070 {
    public static void main(String[] args) {
        int [][]items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int [] queries = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(maximumBeauty(items,queries)));
    }
    public static  int[] maximumBeautyBrute(int[][] items, int[] queries) {
        int [] result = new int[queries.length];
        for(int k=0;k<queries.length;k++){
            int max_beauty = 0;
            for (int i=0; i < items.length; i++) {
                if(items[i][0]<=queries[k]){
                    max_beauty = Math.max(max_beauty, items[i][1]);
                }
            }
            result[k] = max_beauty;
        }
        return result;
    }
    public static  int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        return result;
    }
}
