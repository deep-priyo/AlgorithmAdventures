import java.util.Stack;

public class LC151 {
    public String reverseWords(String s) {
      String []str=s.trim().split("\\s+");
      String answer="";
      for(int i=str.length-1;i>=0;i--){
          answer=answer+str[i]+" ";
      }
      return answer.trim();
    }
}
