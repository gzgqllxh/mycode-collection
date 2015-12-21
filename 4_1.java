double disSP(P p1, P p2, P q) {
    if (p2.sub(p1).dot(q.sub(p1)) < EPS) return q.sub(p1).abs();
    if (p1.sub(p2).dot(q.sub(p2)) < EPS) return q.sub(p2).abs();
    return disLP(p1, p2, q);
}

double disLP(P p1, P p2, P q) {
    return abs(p2.sub(p1).det(q.sub(p1))) / p2.sub(p1).abs();
}

boolean crsSS(P p1, P p2, P q1, P q2) {
    if (max(p1.x, p2.x) + EPS < min(q1.x, q2.x)) return false;
    if (max(q1.x, q2.x) + EPS < min(p1.x, p2.x)) return false;
    if (max(p1.y, p2
