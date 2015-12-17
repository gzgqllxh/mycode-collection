int[] stableMatching(int[][] orderM, int[][] preferW) {
    int n = orderM.length;
    int[] pairM = new int[n], pairW = new int[n], p = new int[n];
    fill(pairM, -1);
    fill(pairW, -1);
    for (int i = 0; i < n; i++) {
	while (pairM[i] < 0) {
	    int w = orderM[i][p[i]++], m = pairW[w];
	    if (m == -1) {
		pairM[i] = w;
		pairW[w] = i;
	    }
	    else if (preferW[w][i] < preferW[w][m]) {
		pairM[m] = -1;
		pairM[i] = w;
		pairW[w] = i;
		i = m;
	    }
	}
    }
    return pairM;
}
