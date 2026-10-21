import java.util.*;

class LRU {
    class Node {
        int k,v;
        Node p,n;
        Node(int k,int v) {
            this.k=k;
            this.v=v;
        }
    }

    int cap;
    Map<Integer,Node> m=new HashMap<>();
    Node h=new Node(0,0),t=new Node(0,0);

    LRU(int c) {
        cap=c;
        h.n=t;
        t.p=h;
    }

    void del(Node x) {
        x.p.n=x.n;
        x.n.p=x.p;
    }

    void add(Node x) {
        x.n=h.n;
        x.p=h;
        h.n.p=x;
        h.n=x;
    }
    int get(int k) {
        if(!m.containsKey(k)) return -1;
        Node x=m.get(k);
        del(x);
        add(x);
        return x.v;
    }
    void put(int k,int v) {
        if(cap<=0) return;
        if(m.containsKey(k)) {
            Node x=m.get(k);
            x.v=v;
            del(x);
            add(x);
            return;
        }
        if(m.size()==cap) {
            Node x=t.p;
            del(x);
            m.remove(x.k);
        }
        Node x=new Node(k,v);
        add(x);
        m.put(k,x);
    }
}
