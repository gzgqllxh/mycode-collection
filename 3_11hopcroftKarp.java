int hopcroftKarp(V[] vs) {
    for (int match = 0;;) {
	Queue<V> que = new LinkedList<V>();
	for (V v : vs) v.level = -1;
	for (V v : vs) if (v.pair == null) {
	    v.level = 0;
	    que.offer(v);
	}
	while(!que.isEmpty()){
	    V v = que.poll();
	    for (V u : v) {
		V w = u.pair;
		if (w != null && w.level < 0) {
		    w.level = v.level + 1;
		    que.offer(w);
		}
	    }
	}
	for (V v : vs) v.used = false;
	int d = 0;
	for (V v : vs) if (v.pair == null && dfs(v)) d++;
	if (d == 0) return match;
	match += d;
    }
}
boolean dfs(V v) {
    v.used = true;
    for (V u : v) {
	V w = u.pair;
	if (w == null || !w.used && v.level < w.level && dfs(w)) {
	    v.pair = u;
	    u.pair = v;
	    return true;
	}
    }
    return false;
}
