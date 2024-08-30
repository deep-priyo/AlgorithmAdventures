import java.util.Arrays;

//https://leetcode.com/problems/convert-the-temperature/description/
public class lc2469 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertTemperature(36.50)));
    }
    public static double[] convertTemperature(double celsius) {
        double[] arr=new double[2];
        arr[0]=celsius+273.15;
        arr[1]=(celsius*1.80)+32.00;
        return arr;
    }
}
