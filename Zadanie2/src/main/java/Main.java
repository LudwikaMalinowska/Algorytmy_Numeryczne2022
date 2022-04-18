import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] m1 = new double[][]{
                {1,2,3,1},
                {4,5,6,2},
                {7,8,9,3}

        };
        double[][] m2 = new double[][]{
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},

        };

        double[][] m3 = new double[][]{
                {1.2, 2.6 ,-0.1, 1.5},
                {4.5, 9.8, -0.4, 5.7},
                {0.1, -0.1, -0.3, -3.5},
                {4.5, -5.2, 4.2, -3.4},
        };


        double[] vector = new double[]{
                1,2,3,4
        };

//        System.out.println(Arrays.deepToString(MojaMacierz.multiplyMatrix(m1, m2)));
//        System.out.println(Arrays.toString(MojaMacierz.multiplyMatrix(m1, vector)));
        double[] b = new double[]{13.15, 49.84, -14.08, -46.51};
//        double[][] m3a = MojaMacierz.eliminateX1(m3, b);
//        double[][] m3b = MojaMacierz.eliminateX2(m3a, b);
//        double[][] m3c = MojaMacierz.eliminateX3(m3b, b);
//        double[][] m3c = MojaMacierz.elGaussKrok1(m3, b);

//        for (double[] row : m3c){
//            System.out.println(Arrays.toString(row));
//        }


    }
}
