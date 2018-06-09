package BasicProgModel;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HJKLI on 2016/8/26.
 */
public class Ex_1_1_13_reverseArray {
    public static void main(String[] args) {

        int m = 5;
        int n = 5;

        int[][] a = new int[m][n];
        int[][] b = new int[m][n];
        migrateRamon(a, m);
        MigrateSwich(a, b);
        MigratePrint(b);
    }

    private static void MigratePrint(int[][] a) {
        StdOut.println("装置二维数组");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                StdOut.print(a[i][j] + "  "); 
            }
        }
        StdOut.println();
    }

    private static void MigrateSwich(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][i] = a[i][j];
            }
        }
    }

    public static void migrateRamon(int[][] a, int N) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = StdRandom.uniform(N);
                StdOut.print(a[i][j] + "  ");
            }
        }
        StdOut.println();
    }
}
