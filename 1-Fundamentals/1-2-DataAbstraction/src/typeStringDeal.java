import edu.princeton.cs.algs4.StdIn;

/**
 * Created by HJKLI on 2016/8/28.
 */
public class typeStringDeal {

    // 判断是否是回文
    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (s.charAt(i) == s.charAt(N-i-1))
                return false;
        }
        return true;
    }

    //重文件名字提取文件名
    public static String baseFileName(String s) {
        int dot = s.indexOf(".");
        String base = s.substring(0, dot);

        return base;
    }

    //重文件名字提取文件的扩展名
    public static String extractFileName(String s) {
        int dot = s.indexOf(".");
        String extension = s.substring(dot+1, s.length());

        return extension;
    }

//    public static void main(String[] args) {
//        String query = args[0];
//
//        while (!StdIn.isEmpty()) {
//            String s = StdIn.readLine();
//            if (s.contains(query))
//                StdOut.println();
//        }
//    }

    String input = StdIn.readAll();

}
