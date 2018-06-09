package AnalysisOfAlgorithm;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.ThreeSum;


/*
** 计时器  P110
*
*   100000000
 */

public class Stopwatch {

    private final long start;


    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {       //经过时间；
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];

//        for (int i = 0; i < N; i++)
//            a[i] = StdRandom.uniform(-1000000, 1000000);
//        Stopwatch timer = new Stopwatch();
//        int cnt = ThreeSum.count(a);
//        double time = timer.elapsedTime();
//        StdOut.println(cnt + " triples " + time + " seconds");

        Stopwatch timer1 = new Stopwatch();
        double sum1 = 0.0;
        for (int i = 1; i <= N; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        Stopwatch timer2 = new Stopwatch();
        double sum2 = 0.0;
        for (int i = 1; i <= N; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
    }
}
