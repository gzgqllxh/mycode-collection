int scc(V[] vs) {
    n = vs.length;
    us = new V[n];
    for (V v : vs) if (!v.visit) dfs(v);
    for (V v : vs) v.visit = false;
    for (V u : us) if (!u.visit) dfsrev(u, n++);
    return n;
}
void dfs(V v) {
    v.visit = true;
    for (V u : v.fs) if (!u.visit) dfs(u);
    us[--n] = v;
}
void dfsrev(V v, int k) {
    v.visit = true;
    for (V u : v.rs) if (!u.visit) dfsrev(u, k);
    v.comp = k;
}
