
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
    public BST() {}

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

    public Value get() {

    }
}
