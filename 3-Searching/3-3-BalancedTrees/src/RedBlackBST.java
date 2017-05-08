/**
 * Created by HJKLI on 2017/5/8.
 * 红黑树 , 2-3 , 3-4
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

    public boolean isRea(Node x) {
        if (x == null) return false;
//        if (x.color == RED)
//            return RED;
        return x.color == RED;
    }


}
