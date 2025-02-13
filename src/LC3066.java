import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC3066 {
    public static void main(String[] args) {
        int[] nums={99,99,99};
        int k=100;
        System.out.println(minOperations(nums,k));
    }
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            minHeap.add((long)nums[i]);
        }
        int count = 0;
        while(minHeap.size()>1 &&  minHeap.peek()<k)
        {
            Long x=minHeap.poll();
            Long y=minHeap.poll();
            minHeap.add((Math.min(x, y)*2)+Math.max(x,y));
            count++;
        }
       while(!minHeap.isEmpty())
       {
           System.out.print(minHeap.poll()+"<");
       }
        System.out.print("END\n");
        return count;
    }

}
