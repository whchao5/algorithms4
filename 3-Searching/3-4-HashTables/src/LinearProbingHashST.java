/**
 * Created by W on 2017/6/5.
 * 哈希表 ，基于线性探测法 散列表，
 * <p>
 * M > N, 依靠数组的空位 搞定 碰撞冲突， 开放地址散列表。
 * 有三种结果 ：
 * 1） 命中， 该位置的建和被查找相同
 * 2）未命中，建为空
 * 3）继续查找
 */
public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int     n;              // 符号表中的总数
    private int     m;              // 线性表的大小
    private Key[]   keys;         // key
    private Value[] vals;       // value


    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        this.m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }

    /*
    ** get
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /*
    ** 没有 key 新建 一个key value， 有key 覆盖 value
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            return;
        }

        if (n >= m / 2) resize(m * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }

        keys[i] = key;
        vals[i] = val;
        n++;
    }

    // 将 m 值扩大
    private void resize(int L) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(L);

        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        this.keys = temp.keys;
        this.vals = temp.vals;
        m = temp.m;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } // 获得非负整数
}
