public class LC605 {
    public static void main(String[] args) {

   }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int c=0;
        if(flowerbed.length==1&&flowerbed[0]==0)
            return true;
        if(flowerbed.length==1&&flowerbed[0]==1)
            return false;
        if(flowerbed[0]==0 && flowerbed[1]==0 ) c++;
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0 ) c++;
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i-1] ==0 && flowerbed[i+1] == 0 )
            {  flowerbed[i]=1;
                c++;}
        }
        System.out.println(c);
        return n<=c;
    }

}


