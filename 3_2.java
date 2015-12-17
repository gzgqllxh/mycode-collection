V[] topologicalSort(V[] vs) {
    n = vs.length;
    us = new V[n];
    for (V v : vs) {
	if (v.state == 0 && !dfs(v)) return null;
    }
    return us;
}
boolean dfs(V v) {
    v.state = 1;
    for (V u : v) {
	if (u.state == 1 || u.state == 0 && !dfs(u)) return false;
    }
    us[--n] = v;
    v.state = 2;
    return true;
}
