package BasicProgModel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用 In 代替 StdIn 获取数据
 * Created by HJKLI on 2016/8/27.
 */
public class Average {
    public static void main(String[] args) {
        double sum = 0;
        int cut = 0;
        In  arr = new In(args[1]);
        while (!arr.isEmpty()) {
            sum += arr.readDouble();
            cut++;
        }

//        while (!StdIn.isEmpty()) {
//            sum += StdIn.readDouble();
//            cut++;
//        }

        double avg = sum / cut;
        StdOut.print(avg);
    }
}
