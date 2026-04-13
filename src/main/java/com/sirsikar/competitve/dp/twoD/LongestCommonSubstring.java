package com.sirsikar.competitve.dp.twoD;

public class LongestCommonSubstring {
    public static void main(String[] args) {
       String s1= "GeeksforGeeks";
       String s2 = "GeeksQuiz";
       System.out.println("Longest common substring: "+ lcs(s1,s2));
    }

    private static int lcs(String s1, String s2) {
        int[][] dp = new  int[s1.length()][s2.length()];
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i==0 || j==0) {
                        dp[i][j]=1;
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    max= Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}
