class Solution {
    private static final int MOD = (int)1e9+7;

    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int[][] vec = new int[m][26]; // state freq array.

        for (String word : words) {
            for (int i = 0; i < m; i++) {
                vec[i][word.charAt(i) - 'a']++;
            }
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1);

        for (char ch : target.toCharArray()) {
            int x = ch - 'a';
            for (int j = m; j > 0; --j) {
                dp[j] = mul(dp[j - 1], vec[j - 1][x]);
            }

            dp[0] = 0;  // set dp[0] = 0, post processing curr char in target.
            for (int j = 1; j <= m; ++j) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        return dp[m];
    }

    private int mul(long x, long y) {
        return (int)((x * y) % MOD);
    }
}
