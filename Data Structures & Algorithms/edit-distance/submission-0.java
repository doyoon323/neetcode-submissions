class Solution {
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }


        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String w1, String w2, int p1, int p2) {
        if (p1 == w1.length()) return w2.length()-p2;
        if (p2 == w2.length()) return w1.length()-p1;

        if (memo[p1][p2] != -1) return memo[p1][p2];

        if (w1.charAt(p1) == w2.charAt(p2)) 
            return memo[p1][p2] = dfs(w1, w2, p1 + 1, p2 + 1);

        int replace = dfs(w1, w2, p1 + 1, p2 + 1);
        int delete  = dfs(w1, w2, p1 + 1, p2);
        int insert  = dfs(w1, w2, p1, p2 + 1);

        int minCost = Math.min(replace, Math.min(delete, insert)) + 1;
        return memo[p1][p2] = minCost;
    }
}