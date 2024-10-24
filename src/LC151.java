import java.util.Stack;

public class LC151 {
    public  static  String reverseWords(String s) {
      String []str=s.trim().split("\\s+");
      String answer="";
      for(int i=str.length-1;i>=0;i--){
          answer=answer+str[i]+" ";
      }
      return answer.trim();
    }
    public static void main(String[] args) {
    String s = "the sky is blue";
    System.out.println(reverseWords(s));
    }

}
