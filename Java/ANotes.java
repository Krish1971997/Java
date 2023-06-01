
https://www.geeksforgeeks.org/zoho-interview-experience-set-36-software-developer/

https://www.geeksforgeeks.org/word-break-problem-dp-32/

https://krish1971997-psychic-broccoli-r94jqp4pwx62p6x.github.dev/?autoStart=false

//C output questions
https://www.geeksforgeeks.org/output-c-programs-set-59-loops-control-statements/


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakProblem {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // Create a set of words for efficient lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // Create a dynamic programming table to store intermediate results
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string is always valid

        // Iterate through each character in the string
        for (int i = 1; i <= s.length(); i++) {
            // Check all possible substrings starting from index 0 to i-1
            for (int j = 0; j < i; j++) {
                // If the substring from j to i-1 is a valid word and the substring from 0 to j-1 is also valid,
                // then the substring from 0 to i-1 is valid.
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // The original string is valid if the last element of the dp array is true
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        boolean result = wordBreak(s, wordDict);
        System.out.println(result); // Output: true
    }
}

