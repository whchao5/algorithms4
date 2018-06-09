package DataAbstraction;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;


/**
 * .2 .5 .5 .6 10000
 * Created by HJKLI on 2016/8/28.
 */
public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;

    // 构造函数
    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
    }

    public boolean contains(Point2D p) {
        return x.contains(p.x()) && y.contains(p.x());
    }

    public double area() {
        return x.length() * y.length();
    }

    // 测试用例
    public static void main(String[] args) {
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int    T   = Integer.parseInt(args[4]);

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box       = new Interval2D(xinterval, yinterval);

        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double  x = Math.random();
            double  y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p))
                c.increment();
            else
                p.draw();
        }

        StdOut.println(c);
        StdOut.println(box.area());

    }
}
