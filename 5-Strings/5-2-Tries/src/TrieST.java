

/**
 * 单词查找树
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

    }


    public void put(String key, String value) {

    }
}
