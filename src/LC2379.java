public class LC2379 {
    public static void main(String[] args) {
        String blocks="WBBWWBBWBW";
        int k=7;
        System.out.println(minimumRecolors(blocks,k));
    }
    public static int minimumRecolors(String blocks, int k) {
        int w=0;
        int i;
        for(i=0;i<k;i++)
        {
            if(blocks.charAt(i)=='W')
                w++;
        }
        int minW = w;
        for (i = k; i < blocks.length(); i++) {

            if (blocks.charAt(i - k) == 'W') {
                w--;
            }

            if (blocks.charAt(i) == 'W') {
                w++;
            }
            minW = Math.min(minW, w);
        }

        return minW;
    }
}
