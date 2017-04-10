
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * this is 逆波兰表示法（Reverse Polish notation，RPN，或逆波兰记法）
 * wikipedia https://zh.wikipedia.org/wiki/%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E7%A4%BA%E6%B3%95
 * Created by HJKLI on 2016/9/1.
 *
 * 4
 * 2
 * *
 * 3
 * *

 * 24.0
 */
public class Ex_10_InfixToPostFix {

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches())
            return false;
        return true;
    }

    public static void main(String[] args) {

        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();

            if (isNumeric(str))
                vals.push(Double.parseDouble(str));
            else {
                double v = vals.pop();
                if (str.equals("+"))
                    v = vals.pop() + v;
                else if (str.equals("-"))
                    v = vals.pop() - v;
                else if (str.equals("*"))
                    v = vals.pop() * v;
                else if(str.equals("/"))
                    v = vals.pop() / v;
                else
                    ;
                vals.push(v);
            }
        }

        StdOut.println(vals.pop());
    }
}
