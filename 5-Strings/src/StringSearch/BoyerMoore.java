package StringSearch;


/**
 * 从右向左扫描字符串 和文本匹配，
 */
public class BoyerMoore {

    private final int R;
    private int[] right;
    private String pat;

    BoyerMoore(String pat) {
        this.pat = pat;
        this.R = 256;
        int M = pat.length();
        // 计算跳跃表
        right = new int[R];

        
    }
}
