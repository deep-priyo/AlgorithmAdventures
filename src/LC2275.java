public class LC2275 {
    public static int largestCombination(int[] candidates) {
        int[] count = new int[32];
        for (int n : candidates) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        int m = 0;
        for (int c : count) {
            m = Math.max(m, c);
        }
        return m;
    }
}
