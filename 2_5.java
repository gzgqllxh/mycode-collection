class Seg {
    int N;
    Seg(int n) {
	N = Integer.highestOneBit(n) << 1;
    }

    void query(int k) {
	for (int i = N + k; i > 0; i >>= 1) {
	    // ...
	}
    }
    void query(int s, int t) {
	while (0 < s && s + (s & -s) <= t) {
	    int i = (N + s) / (s & -s);
	    s += s & -s;
	}
	while (s < t) {
	    int i = (N + t) / (t & -t) -1;
	    //...
	    t -= t & -t;
	}
    }
}
