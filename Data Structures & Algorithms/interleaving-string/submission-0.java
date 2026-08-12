class Solution {
    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int p1, int p2) {
        if (p1 == s1.length() && p2 == s2.length()) return true;
        if (memo[p1][p2] != null) return memo[p1][p2];

        int p3 = p1+p2;
        char target = s3.charAt(p3);

        boolean canMatch = false;
        if (p1 < s1.length() && s1.charAt(p1) == target)
            canMatch = dfs(s1, s2, s3, p1 + 1, p2);

        if (!canMatch && p2<s2.length() && s2.charAt(p2)==target) 
            canMatch = dfs(s1, s2, s3, p1, p2 + 1);
        return memo[p1][p2] = canMatch;
    }
}