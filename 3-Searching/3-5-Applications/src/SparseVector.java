import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import sun.security.pkcs11.Secmod;


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
        this.st = new ST<Integer, Double>()    ;
    }
}
