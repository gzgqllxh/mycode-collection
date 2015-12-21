V[] eulerianWalk(V v) {
    Stack<V> res = new Stack<V>(), stack = new Stack<V>();
    stack.push(v);
    while(!stack.isEmpty()){
	v = stack.pop();
	while(v.p < v.size()) {
	    stack.push(v);
	    v = v.get(v.p++);
	}
	res.push(v);
    }
    return res.toArray(new V[0]);
}
