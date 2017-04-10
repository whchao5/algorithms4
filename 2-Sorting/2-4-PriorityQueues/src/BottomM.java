import edu.princeton.cs.algs4.Transaction;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by whaichao on 2017/2/21.
 * 优先队列 从小 到大
 * 使用优先队列的例子
 * 按金额 排序
 */
public class BottomM {
    private BottomM() {}

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(m +1);
        In in = new In(args[1]);
        int i = 0;

        while (in.hasNextLine()) {
            String line = in.readLine();
            Transaction transaction = new Transaction(line);
            ++i;
            pq.insert(transaction);

            if (pq.size() > m) {
                pq.delMax();
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
