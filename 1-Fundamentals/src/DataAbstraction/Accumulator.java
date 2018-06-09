package DataAbstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Created by HJKLI on 2016/8/30.
 */
public class Accumulator {
    private int    n   = 0;
    private double mu  = 0.0;
    private double sum = 0.0;

    public Accumulator() {
    }

    public void addDataValue(double x) {
    // 添加值
        n++;
        double delta = x - mu;
        sum += (double) (n - 1) / n * delta * delta;
        mu  += delta / n;
    }

    public double mean() {
        return mu;
    }

    public double var() {
        return sum / (n - 1);
    }

    public int count() {
        return  n;
    }

    public double stddev() {
        return Math.sqrt(this.var());
    }

    public static void main(String[] args) {
        Accumulator stats = new Accumulator();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            stats.addDataValue(x);
        }

        StdOut.println(stats.count());
        StdOut.println(stats.mean());
        StdOut.println(stats.stddev());
        StdOut.println(stats.var());
    }
}
