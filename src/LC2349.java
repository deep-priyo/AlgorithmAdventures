import java.util.HashMap;
import java.util.TreeSet;

public class LC2349 {
    class NumberContainers {
        HashMap<Integer, TreeSet<Integer>> numberIdx;
        HashMap<Integer, Integer> idxNumber;

        public NumberContainers() {
            numberIdx = new HashMap<>();
            idxNumber = new HashMap<>();
        }

        public void change(int index, int number) {
            if (idxNumber.containsKey(index)) {
                int prev = idxNumber.get(index);
                numberIdx.get(prev).remove(index);
                if (numberIdx.get(prev).isEmpty()) {
                    numberIdx.remove(prev);
                }
            }
            idxNumber.put(index, number);
            if (!numberIdx.containsKey(number)) {
                numberIdx.put(number, new TreeSet<>());
            }
            numberIdx.get(number).add(index);
        }

        public int find(int number) {
            if (!numberIdx.containsKey(number)) {
                return -1;
            }
            return numberIdx.get(number).first();
        }
    }
}
