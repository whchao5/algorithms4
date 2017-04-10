/**
 * Created by HJKLI on 2016/8/26.
 */
public class Ex_1_1_12 {

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
            System.out.print(a[i]+"  ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
            System.out.print(a[i]+"  ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++)
            System.out.print(i+"  ");
    }

}

//9  8  7  6  5  4  3  2  1  0
//0  1  2  3  4  4  3  2  1  0
//0  1  2  3  4  5  6  7  8  9