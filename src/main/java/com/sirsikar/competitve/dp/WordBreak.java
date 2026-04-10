package com.sirsikar.competitve.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] words = {"leet", "code"};

        System.out.println("Word break possible: "+ wordBreak(s, words));
    }

    private static boolean wordBreak(String s, String[] words) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(Arrays.stream(words).toList());
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
