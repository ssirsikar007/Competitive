package com.sirsikar.competitve.backtracking;

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n=1;
        generateParanthesis(n,0,0, new StringBuilder());
    }

    private static void generateParanthesis(int n, int open, int closed, StringBuilder stringBuilder) {
        if (open == n && closed ==n) {
            System.out.println(stringBuilder.toString());
            return ;
        }

        if (open <= n) {
            stringBuilder.append("(");
            generateParanthesis(n,open+1,closed,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        if (closed < open) {
            stringBuilder.append(")");
            generateParanthesis(n,open,closed+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
