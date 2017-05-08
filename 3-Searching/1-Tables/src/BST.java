import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.NoSuchElementException;

/*
 * 二叉树 查找， 小 于的放 左 ， 大的放右,
 *
 * 二叉树 每个节点含有 一个键， 一个 值， 左右链接 和 节点计数器
 *
 *  ../algs4-data/tinyTale.txt
 *  ../algs4-data/tale.txt
 *  ../algs4-data/leipzig1M.txt
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

    public BST() {
    }

    public int size() {
        return size(root);
    }

    // 重载 size 的数据
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /*
     ** 返回与给定键关联的值。
      */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    private Value get(Node x, Key key) {

        if (key == null) throw new IllegalArgumentException("called get() with a null key");
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }


    /*
    **
    * 指定的键-值对插入到符号表中，并覆盖旧的值
    * 如果符号表已经包含指定的键，使用新值的值。
    * ·删除指定的关键字(及其关联值)这个符号表如果指定的值是。
     */
    public void put(Key key, Value val) {
        if (val == null) throw new IllegalArgumentException("calledput() with a null key");
        if (key == null) {

            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);
        if (cmp > 0)
            x.right = put(x.right, key, val);
        else if (cmp < 0)
            x.left = put(x.left, key, val);
        else
            x.val = val;
        x.size = 1 + size(x.left) + size(x.right);

        return x;
    }


    /*
    ** 删除 最小值
     */
    public void deleteMin() {
        deleteMin(root);
    }

    /*
    ** 递归实现 ： 首先， x 的 left 和 right 都小于 x 的父级， 所以使用right代替是对的，  哪怕 right is null
     */
    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;             // x.left = x.left.right; && x.lift = x.left.left
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /*
    ** 删除 最大值
     */
    public void deleteMax() {
        deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;          // x.right = x.right.left;
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    /*
    * 输入 key 删除   32.2.42 应对大规模数据
    */
    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");

        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;

            x = min(t.right);               // 获得 x.right 最小 node， node 代替 x
            x.right = deleteMin(x.right);       //  删除 x.right 最下的 node, 返回 node 加入 x.right
            x.left = t.left;
        }

        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }


    /*
    ** floor 小于等于 key 的最大值
    */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node itmes = floor(root, key);
        if (itmes == null)
            return null;
        return itmes.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);         // 添加 left 最小处理

        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node items = ceiling(root, key);

        return items.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);         // 添加 left 最小处理
            if (t != null)
                return t;
            else
                return x;
        }

        return ceiling(x.right, key);
    }

//    private Node floor_two(Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp == 0) return x;
//        if (cmp < 0) return floor_two(x.left, key);
//    }

    /*
    ** 返回符号表中的最小键
     */
    public Key min() {
        Node item = min(root);
        return item.key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    /*
    ** 返回符号表中的最大键
     */
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    /*
    ** 输入 排名， 放回 key 值
     */
    public Key select(int k) {
        if (k < 0 || k >= size())
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
//        int t = size(x);
        int t = size(x.left); // 验证 left 是否有值，
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);  // size 只记录 向下的数量， 不记录在第几位， so, k - t -1
        else
            return x;
    }

    /*
    ** 输入 key值， 返回 排名
     */
    public int rank(Key key) {
        if (key == null)
            throw new IllegalArgumentException("called rank() with invalid argument: ");

        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(x.left, key);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(x.right, key);       // left 的 size + right 的 size
        else
            return size(x.left);
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
        StdOut.println(x.key);
        print(x.right);
    }

    /*
    ** 遍历数据, 睇二种方式
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    /*
    ** 和print 理念一样，递归 left && right
     */
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);  // -1
        int cmphi = hi.compareTo(x.key);    // 1
        if (cmplo < 0) keys(x.left, queue, lo, hi);     // 有left 就迭代
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);   // 有right 就迭代
    }

    /*
    ** 测试 查询
     */
    public static void main(String[] args) {
        In arr = new In(args[0]);
        BST<String, Integer> st = new BST<String, Integer>();

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

        StdOut.println(st.min());
        StdOut.println(st.max());
//        StdOut.println(st.select(19));
//        StdOut.println(st.rank("worst"));
//        StdOut.println(st.floor("aga"));
//        StdOut.println(st.floor("worss"));
//        StdOut.println(st.ceiling("worss"));

//        st.delete("age");
//        StdOut.println(st.floor("aga"));
        StdOut.println(" ================================ ");
        st.print();
        StdOut.println(" ================================ ");

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
