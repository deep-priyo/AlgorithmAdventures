import java.util.*;
public class LC3285 {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i < height.length ; i++) {
            if(height[i-1]>threshold)
                indices.add(i);
        }
        return indices;
    }
}
