ArrayList<E> connection(V[] vs) {
    bridge = new ArrayList<E>();
    for (V v : vs) if (v.num < 0) {
	dfs(v, 0);
	if (v.count > 0) v.count--;
    }
    return bridge;
}
int dfs(V v, int c) {
    v.num = c;
    int low = c;
    boolean rev = false;
    for (V u : v) {
	if (u.num < 0) {
	    int t = dfs(u, c + 1);
	    low = min(low, t);
	    if (v.num <= t) v.count++;
	    if (v.num < t) bridge.add(new E(v, u));
	}else if (u.num != v.num - 1 || rev) low = min(low, u.num);
	else rev = true;
    }
    return low;
}
