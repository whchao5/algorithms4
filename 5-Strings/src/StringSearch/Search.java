package StringSearch;


/**
 *  暴力查询
 */

public class Search {

    public static void main(String[] args) {

    }

    public int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (pat.charAt(j) != txt.charAt(i + j))  // 移位
                    break;
            }

            if (j == M)
                return i;
        }
        return N;
    }

    public int searchZero(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0, j = 0; i < N && j < M; i++) {

            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {

                // 回退 txt
                i -= j;
                j = 0;
            }

            if (j == M)
                return i - M;
        }
        return N;
    }
}
