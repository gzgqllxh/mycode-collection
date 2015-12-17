int steiner(int[][] g, int[] ts) {
    int n = g.length, m = ts.length;
    if (m < 2) return 0;
    int[][] dp = new int1 << m][n];
    for (int k = 0; k < n; k++) {
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		g[i][j] = min(g[i][j], g[i][k] + g[k][j]);
	    }
	}
    }
    for (int i = 0; i < m; i++) {
	for (int j = 0; j < n; j++) {
	    dp[1 << i][j] = g[ts[i]][j];
	}
    }
    for (int i = 1; i < 1 << m; i++) if (((i - 1) & i) != 0) {
	for (int j = 0; j < n; j++) {
	    dp[i][j] = INF;
	    for (int k = (i - 1) & i; k > 0; k = (k - 1) & i) {
		dp[i][j] = min(dp[i][j], dp[k][j] + dp[i ^ k][j]);
	    }
	}
	for (int j = 0; j < n; j++) {
	    for (int k = 0; k < n; k++) {
		dp[i][j] = min(dp[i][j], dp[i][k] + g[k][j]);
	    }
	}
    }
    return dp[(1 << m) - 1][ts[0]];
}
