import java.util.PriorityQueue;

public class LC2558 {
    public static void main(String[] args) {

    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for(int i:gifts){
            pq.add(i);
        }
        while(k-->0){
            pq.add((int)Math.sqrt(pq.poll()));
        }
        long sum=0;
        while(pq.size()!=0){
            sum=sum+pq.poll();
        }
        return sum;
    }

}
