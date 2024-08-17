//https://leetcode.com/problems/top-k-frequent-elements/description/
import java.util.*;

public class LC347 {
    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3};
        int k=2;
        System.out.println("\n\nTop K Frequent Elements: "+Arrays.toString(topKFrequent(arr,k)));
    }

    private static int[] topKFrequent(int[] arr, int k)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr)
        {
//            if(map.containsKey(i))
//                map.put(i,map.get(i)+1);
//            else
//                map.put(i,1);
            map.put(i,map.getOrDefault(i,0)+1);
        }

        List<Integer>[] arrayOfLists = new ArrayList[arr.length+1];
        for(int i=0;i<arrayOfLists.length;i++)
            arrayOfLists[i]=new ArrayList<>();
        for(int i:map.keySet()) {
//            System.out.println(i);

            arrayOfLists[map.get(i)].add(i);
        }
        System.out.println("The array list is: "+Arrays.toString(arrayOfLists));
        int[] res = new int[k];
        int idx = 0;
        for (int i = arrayOfLists.length - 1; i >= 0; i--) {
            for (int num : arrayOfLists[i]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }

        return new int[0];


    }
}
