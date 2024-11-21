import java.util.Arrays;

public class LC2516 {
    public static void main(String[] args) {
        String s="aabaaaacaabc";
        System.out.println(takeCharacters(s,2));
    }
    public static int takeCharacters(String s, int k) {
        int[] arr=new int[3];
        //arr[0]= count of a
        //arr[1]= count of b
        //arr[2]= count of c
        for(char c:s.toCharArray())
            arr[c-'a']++;

        // if the entire string doesn't have atleast k of each characters then there is no point of checking
        if(! minCount(arr,k))
            return -1;

        System.out.println(Arrays.toString(arr));
        int left=0,right=0;
        int res=Integer.MAX_VALUE;
        int[] windowArr=new int[3];
        for(right=0;right<s.length();right++)
        {
          arr[s.charAt(right) - 'a']--; // now these charcter has been included in my window so the count of arr be deacreased for these character
          while (! minCount(arr,k))
          {
            arr[s.charAt(left) - 'a']++;
            left++;
          }
          res=Math.min(res,s.length()-(right-left+1));
        }
        return res;
    }
    public static boolean minCount(int arr[],int k)
    {
        if(arr[0]<k || arr[1]<k || arr[2]<k)
            return false;
        return true;
    }
}
