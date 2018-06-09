package BagsQueuesStacks;

import edu.princeton.cs.algs4.StdOut;


/**
 * Created by HJKLI on 2016/11/8.
 */
public class Ex_37_Josephus {

    // BUG 33353732363438
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < m-1; i++)
                queue.enqueue(queue.dequeue());
            StdOut.print(queue.dequeue() + " ");
        }

        StdOut.println();
    }
}

/*
 *题解
 * 0 1 2 3 4 5 6
 * 1 -> 2 3 4 5 6 0
 * 1 3 -> 4 5 6 0 2
 * 1 3 5 -> 6 0 2 4
 */

