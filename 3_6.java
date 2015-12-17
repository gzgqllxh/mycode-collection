int arborescence(V[] vs, V r) {
    int res = 0;
    for (V v : vs) for (E e : v.es) e.to.min = min(e.to.min, e.cost);
    for (V v : vs) if (v != r) {
	if (v.min == INF) return INF;
	res += v.min;
    }
    for (V v : vs) for (E e : v.es) if (e.to != r) {
	e.cost -= e.to.min;
	if (e.cost == 0) {
	    v.fs.add(e.to);
	    e.to.rs.add(v);
	}
    }
    int m = scc(vs);
    if (m == vs.length) return res;
    V[] us = new V[m];
    for (int i = 0; i < m; i++) us[i] = new V();
    for (V v : vs) for (E e : v.es) {
	if (v.comp != e.to.comp) us[v.comp].add(us[e.to.comp], e.cost);
    }
    return min(INF, res + arborescence(us, us[r.comp]));
}
