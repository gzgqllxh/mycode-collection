double mmc(int[] ss, int[] ts, double[] cs, int n) {
    int m = ss.length;
    double[][] dp = new double[n + 1][n];
    for (int i = 0; i < n; i++) {
	fill(dp[i + 1], INF);
	for (int j = 0; j < m; j++) {
            dp[i + 1][ts[j]] = min(dp[i + 1][ts[j]], dp[i][ss[j]] + cs[j]);
	}
    }
    double res = INF;
    for (int i = 0; i < n; i++) if (dp[n][i] < INF) {
	double max = -INF;
	for (int j = 0; j < n; j++) {
	    max = max(max, (dp[n][i] - dp[j][i]) / (n - j));
	}
	res = min(res, max);
    }
    return res;
}
