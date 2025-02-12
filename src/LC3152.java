import java.util.Arrays;

public class LC3152 {



        public static void main(String[] args) {
            int nums[]={2,1,4,4,4,1};
            int[][] queries={{0,4}};
            isArraySpecial(nums,queries);
        }
        public static boolean[] isArraySpecial(int[] nums,int[][] queries) {
            boolean[] res = new boolean[queries.length];

            int checker=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]%2==0)
                {
                    if(checker==1)nums[i]=0;
                    else{
                        checker=1;
                        nums[i]=1;}
                }
                else {
                    if (checker == 2) nums[i] = 0;
                    else{
                        checker = 2;
                        nums[i]=1;}
                }
            }
            System.out.println(Arrays.toString(nums));
            for (int i = 0; i < queries.length; i++) {
                for (int j = queries[i][0]; j <= queries[i][1] ; j++) {
                    if(nums[j]==0){
                        res[i]=false;
                        break;}
                    res[i]=true;
                }

            }
            return res;

        }
    }

