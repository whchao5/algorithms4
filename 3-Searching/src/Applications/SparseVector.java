package Applications;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
//import sun.security.pkcs11.Secmod;


/**
 * Created by W on 2017/6/25.
 * 稀疏向量 ....
 *
 * 矩阵 和 向量的乘法
 */
public class SparseVector {
    private int d;
    private ST<Integer, Double> st;

    public SparseVector(int d) {
        this.d = d;
        this.st = new ST<Integer, Double>();


    }

    public void put(int i, double value) {
        if (0 > i || i >= d )
            throw new IndexOutOfBoundsException("Illegal index");

        if (value == 0.0)
            st.delete(i);
        else
            st.put(i, value);
    }

    /*
    ** 返回这个向量的第i个坐标。
     */
    public double get(Integer i) {
        if (0 > i || i >= d )
            throw new IndexOutOfBoundsException("Illegal index");
        if (st.contains(i))
            return st.get(i);
        else
            return 0.0;
    }

    /*
    ** 返回非零向量中的条目的数量。
     */
    public int nnz() {
        return st.size();
    }

    public int size() {
        return d;
    }

    /**
     * 返回这个向量的维度。
     */
    public int dimension() {
        return d;
    }

    /*
    ** 返回此向量的内积与指定向量。
     */
    public double dot(SparseVector that) {
        if (that.d != this.d)
            throw new IllegalArgumentException("Vector lengths disagree");

        double sum = 0.0;
        if (this.st.size() <= that.st.size()) {
            for (int i : this.st.keys()) {
                if (that.st.contains(i))
                    sum += this.get(i) * that.get(i);
            }
        } else {
            for (int i : that.st.keys()) {
                if (this.st.contains(i))
                    sum += this.get(i) * that.get(i);
            }
        }

        return sum;
    }


    /*
    ** 返回此向量与指定向量的总和。
     */
    public SparseVector plus(SparseVector that) {
        if (this.d != that.d)
            throw new IllegalArgumentException("Vector lengths disagree");

        SparseVector c = new SparseVector(d);
        for (int i : this.st.keys())
            c.put(i, this.get(i));
        for (int i : that.st.keys())
            c.put(i, that.get(i) + c.get(i));

        return c;
    }

    /*
    ** 返回这个向量的大小。 这是也称为L2的规范或欧几里得范数。
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public double norm() {
        return Math.sqrt(this.dot(this));
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i : st.keys()) {
            s.append("(" + i + ", " + st.get(i) + ") ");
        }
        return s.toString();
    }



    public static void main(String[] args) {

        SparseVector a = new SparseVector(10);
        SparseVector b = new SparseVector(10);
        a.put(3, 0.50);
        a.put(9, 0.75);
        a.put(6, 0.11);
        a.put(6, 0.00);
        b.put(3, 0.60);
        b.put(4, 0.90);
        StdOut.println("a = " + a);
        StdOut.println("b = " + b);
        StdOut.println("a dot b = " + a.dot(b));
        StdOut.println("a + b   = " + a.plus(b));

    }
}
