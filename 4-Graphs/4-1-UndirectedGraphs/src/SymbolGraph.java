/*
* 符号图 st
*
* 用到三种数据结构
* 符号表 st ， 键为 String， 值 int
* 数组 keys[]   反向索引，保持每个顶点索引对于的顶点名
* Graph 图 G ， 使用索引引用图中的顶点
 */

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.In;

public class SymbolGraph {

    private ST<String, Integer> st;     // 符号名 -- 索引
    private String[] keys;              // 索引 -- 符号名
    private Graph G;                    // 图


    public SymbolGraph(String stream, String sp) {
        st = new ST<String, Integer>();
        In in = new In(stream);                         // 第一遍

        while (in.hasNextLine()) {
           String[] a = in.readLine().split(sp);        // 读取字符串

            for (int i = 0; i< a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());              // st.size() 表示索引
                }
            }
        }

    }
}
