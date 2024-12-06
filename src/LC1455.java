public class LC1455 {
    public static void main(String[] args) {

    }
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int count=0;
        for(String word : words) {
            if(word.startsWith(searchWord)) {
               return count;
            }
            count++;
        }
        return count;
    }
}
