public class lc1662 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder word1Tot= new StringBuilder();
        StringBuilder word2Tot= new StringBuilder();
        for(String word:word1)
            word1Tot.append(word);
        for(String word:word2)
            word2Tot.append(word);

        return word1Tot.toString().contentEquals(word2Tot);
    }
    public static void main(String[] args) {
        String[] str={"ab", "c"};
        String[] str2={"a", "bc"};
        System.out.println(arrayStringsAreEqual(str, str2));
    }
}
