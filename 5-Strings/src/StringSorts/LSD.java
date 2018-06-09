
package StringSorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


/*
    1) LSD 是 低位优先的字符串排序， 使用数字 代替字符, 从右往左比较
    2) 比较的字符串 长度 必须相等

    ../algs4-data/words3.txt
 */

public class LSD {

    private LSD() {
    }

    public static void sort(String[] arr, int w) {

        int      N   = arr.length;
        int      R   = 256;
        String[] aux = new String[N];

        for (int d = w - 1; d >= 0; d--) {

            int[] count = new int[R + 1];   // 计算出现频率的次数
            for (int i = 0; i < N; i++) {
                count[arr[i].charAt(d) + 1]++;  // 必须向后移一位， aux 的索引从 0 开始算起
            }

            // 将频率转换为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // 将元素分类
            for (int i = 0; i < N; i++) {
                int index = arr[i].charAt(d);
                aux[count[index]++] = arr[i];
            }

            // 回写
            for (int i = 0; i < N; i++)
                arr[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        In       arr = new In(args[0]);
        String[] a   = arr.readAllStrings();

        int n = a.length;

        int w = a[0].length();

        // 验证 字符串 长度 ， 必须相等
        for (int i = 0; i < n; i++) {
            assert a[i].length() == w : "Strings must have fixed length";
        }

        sort(a, w);

        for (int i = 0; i< a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
