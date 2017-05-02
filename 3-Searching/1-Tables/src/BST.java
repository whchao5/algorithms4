
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/*
 * 二叉树 查找， 小 于的放 左 ， 大的放右,
 *
 * 二叉树 每个节点含有 一个键， 一个 值， 左右链接 和 节点计数器
 *
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;           // 以该节点为根的子树中的节点总数

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {}

    public int size() {
        if (root == null)  return 0;
        else            return root.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    private Value get(Node x, Key key) {


        return x.val;
    }

    public static void main(String[] args) {
        In arr = new In(args[0]);
        BST<String, Integer> st = new BST<String, Integer>();

        Stopwatch timer = new Stopwatch();

        while (!arr.isEmpty()) {
            String key = arr.readString();
//
//            if (st.contains(key)) {
//                st.put(key, st.get(key) + 1);
//            } else {
//                st.put(key, 1);
//            }
        }

        double time = timer.elapsedTime();
        StdOut.println(time);
    }
}
