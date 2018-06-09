package BalancedTrees;//import com.sun.org.apache.regexp.internal.RE;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HJKLI on 2017/5/8.
 * 红黑树 , 2-3 , 3-4 , 将 树 和 维护的 tree 分离
 *
 * ../algs4-data/tinyTale.txt
 * ../algs4-data/tale.txt
 * ../algs4-data/leipzig1M.txt
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int size;          // subtree count

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    public Value get(Key key) {
        Node items = get(root, key);
        if (items == null)
            return null;
        return items.val;
    }
    private Node get(Node h, Key key) {
        if (h == null)
            return null;

        int cmp = key.compareTo(h.key);
        if (cmp > 0)
            return get(h.right, key);
        else if (cmp < 0)
            return get(h.left, key);
        else
            return h;
    }

    /*
    ** 插入节点
    *   1) 如果 右节点 是red 而 左节点是 black 的， 进行左旋转
    *   2) 如果 左结点是 red 的且它的的左子结点 也是 red， 进行右旋转
    *   3) 如果左右结点均为 red ，进行颜色旋转
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            return;
        }

        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null)
            return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);
        if (cmp > 0)
            h.right = put(h.right, key, val);
        else if (cmp < 0)
            h.left = put(h.left, key, val);
        else
            h.val = val;

        if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }


    /*
    ** 红黑树的 帮助 函数
     */

    // 是 red return false
    public boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    // 左翻转 ，h -> left node， 小
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.right) + size(h.left) + 1;
        return x;
    }

    // 右翻转
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.right) + size(h.left) + 1;
        return x;
    }

    // 颜色交换
    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }


    /*
    ** 实用 function
     */

    private int size(Node x) {
        if (x == null)
            return 0;
        return x.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 验证 数组中是否有 key
    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /*
    ** 遍历数据 . 一种方式
     */

    public void print() {
        print(root);
    }


    private void print(Node x) {
        if (x == null)
            return;
        print(x.left);
        StdOut.println(x.key +"  " + x.val);
        print(x.right);
    }

    /*
    ** 主函数
     */
    public static void main(String[] args) {
        In arr = new In(args[0]);
        int i = 1;
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();

        Stopwatch timer = new Stopwatch();

        while (!arr.isEmpty()) {
            String key = arr.readString();

            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }
        }

        double time = timer.elapsedTime();
        StdOut.println(time);

//        st.print();
    }
}
