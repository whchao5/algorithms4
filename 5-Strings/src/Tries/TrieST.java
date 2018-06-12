package Tries;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 单词查找树
 *
 *  不要使用处理来自于大型字母表的大量长键
 *
 *  ../algs4-data/shellsST.txt
 */

public class TrieST<Value> {

    private static int R = 256;
    private  Node root;
    private int n;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public TrieST() {
    }

    public Value get(String key) {
        Node x = get(root, key, 0);

        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {

        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);

        return get(x.next[c], key, d+1);
    }


    public void put(String key, Value val) {

        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {

        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == null)  // 确保 x.val 重复
                n++;
            x.val = val;
            return  x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);

        return x;
    }

    public int size() {
        return this.n;
    }

    // 获取说有的 key
    public Iterable<String> key() {
        return keysWithPrefix("");
    }

    // 返回前缀相同的key
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> q = new Queue<>();

        Node node = get(root, prefix, 0); // 获取指点的节点

//        collect(node,new StringBuilder(prefix), q);
        collectNo(node,prefix, q);
        return q;
    }

    private void collect(Node x, StringBuilder pre, Queue<String> q) {
        if (x == null)
            return;
        if (x.val != null)
            q.enqueue(pre.toString());

        for (char c = 0; c < R; c++) {
            pre.append(c);
            collect(x.next[c], pre, q);
            pre.deleteCharAt(pre.length() - 1);
        }
    }

    private void collectNo(Node x, String pre, Queue<String> q) {
        if (x == null)
            return;
        if (x.val != null)
            q.enqueue(pre);

        for (char c = 0; c < R; c++) {
            String s = pre + c;
            collectNo(x.next[c], s, q);
        }
    }


    public static void main(String[] args) {
        TrieST<Integer> st = new TrieST<Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        StdOut.println(st.get("key"));
        if (st.size() < 100) {
            for (String key : st.keysWithPrefix("io")) {
                StdOut.println(key + " " + st.get(key));
            }
            StdOut.println();
        }
    }
}
