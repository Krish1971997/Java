import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence { //LCS
    public static void main(String[] args) {
        //String s1 = "AGGTAB", s2 = "AEDFHR";
        String s1 = "ABCDGH", s2 = "GXTXAYB";
        char[] ch1 = duplicateRemover(s1.toCharArray()), ch2 = duplicateRemover(s2.toCharArray());
        int length = subSequenceLength(ch1,ch2);
        System.out.println("Result --> " + length);
    }

    public static char[] duplicateRemover(char[] ch) {
        Set<Character> set = new HashSet<>();
        for(Character ch3:ch)
            set.add(ch3);
        char[] ch2 = new char[set.size()];
        int i = 0;
        for (Character c : set)
            ch2[i++] = c;
        Arrays.sort(ch2);
        return ch2;
    }

    public static int subSequenceLength(char[] c1, char[] c2) {
        int count = 0;
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c1.length; j++) {
                if ((c1[i] == c2[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}
