package BasicProgModel;

/**
 * Created by HJKLI on 2016/8/27.
 */
public class Ex_1_1_35_dist {

    public static void main(String[] args) {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];

        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        }

        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= 35.0;
    }
}
