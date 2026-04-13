package com.sirsikar.competitve.dfs;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";
        boolean isFound = exist(board, word);

        System.out.println("Is word found: " + isFound);
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }

        // boundary + mismatch + visited check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                visited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }

        visited[i][j] = true;

        // explore all 4 directions
        boolean found =
                dfs(board, word, i + 1, j, idx + 1, visited) || // down
                        dfs(board, word, i - 1, j, idx + 1, visited) || // up
                        dfs(board, word, i, j + 1, idx + 1, visited) || // right
                        dfs(board, word, i, j - 1, idx + 1, visited);   // left

        // 🔁 backtrack
        visited[i][j] = false;

        return found;
    }
}