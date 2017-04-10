import edu.princeton.cs.algs4.Transaction;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2017/2/20.
 * 使用优先队列的例子
 * 按金额 排序
 */

public class TopM {

    private TopM() {}

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(m +1);
        In in = new In(args[1]);
        int i = 0;

        while (in.hasNextLine()) {
            String line = in.readLine();
            Transaction transaction = new Transaction(line);
            ++i;
            pq.insert(transaction);

            if (pq.size() > m) {
                pq.delMin();
            }
        }


        Stack<Transaction> stack = new Stack<Transaction>();
        for (Transaction transaction : pq) {
            stack.push(transaction);
        }

        for (Transaction transaction : stack) {
            StdOut.println(transaction);
        }

        StdOut.println(i);
        StdOut.print(pq.size());
    }
}
