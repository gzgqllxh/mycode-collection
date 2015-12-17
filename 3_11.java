int bipartiteMatching(V[] vs){
    int match = 0;
    for (V v : vs) if (v.pair == null) {
	for (V u : vs) u.used = false;
	if (dfs(v)) match++;
    }
    return match;
}
boolean dfs(V v) {
    v.used = true;
    for (V u : v) {
	V w = u.pair;
	if (w == null || !w.used && dfs(w)) {
	    v.pair = u;
	    u.pair = v;
	    return true;
	}
    }
    return false;
}
class V extends ArrayList<V> {
    V pair;
    boolean used;
    void connect(V v) {
	add(v);
	v.add(this);
    }
}
