import java.lang.reflect.Array;
import java.util.Arrays;
//
public class MojaMacierz2{

    public static double[][] addMatrix(double[][] m1, double[][] m2){
        //takie same wymiary
        if (m1.length != m2.length || m1[0].length != m2[0].length)
            throw new RuntimeException();

        double[][] result = new double[m1.length][m1.length];
//        double[][] result = (double[][]) Array.newInstance(Number.class, m1.length, m1.length);
        
        for (int i = 0; i < m1.length; i++){
            for (int j = 0; j < m1[0].length; j++){
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return result;
    }

    public static double[][] multiplyMatrix(double[][] m1, double[][] m2){
        if (m1[0].length != m2.length) throw new RuntimeException();
        double[][] result = new double[m1.length][m2[0].length];

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++){

                double sum = 0;
                for (int p = 0; p < m1[0].length; p++){
                    sum += m1[i][p] * m2[p][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static double[] multiplyMatrix(double[][] m1, double[] vector){
        if (vector.length != m1[0].length) throw new RuntimeException();

        double[] result = new double[m1.length];

        for (int i = 0; i < result.length; i++){
            double sum = 0;
            for (int j = 0; j < m1[0].length; j++){
                sum += m1[i][j] * vector[j];
            }
            result[i] = sum;
        }

        return result;
    }

    public static double[][] elGaussKrok1(double[][] A, double[] B){
        for (int k = 1; k <= A.length; k++){
            double[] m = new double[A.length -k];
            for (int i = 0; i < m.length; i++){
                System.out.println("-----");
                System.out.println(i-1);
                m[i] = A[i+k][k-1] / A[k-1][k-1];
            }

            System.out.println("m:" + Arrays.toString(m)); //ok

            int mi = 0;
            for (int i = k; i < A.length; i++){
                for (int j = k-1; j < A[0].length; j++){
                    System.out.printf("[%d][%d]", i, j);
//                    System.out.println(mi);
                    A[i][j] -= (A[k-1][j] * m[mi]);
                }
                mi++;
            }


            for (double[] row : A){
                System.out.println(Arrays.toString(row));
            }
            System.out.println("\n");
        }

        return A;
    }

    public static double[][] eliminateX1(double[][] A, double[] B){
        double[] m = new double[A.length-1];
        for (int i = 1; i < A.length; i++){
            m[i-1] = A[i][0] / A[0][0];
        }

        System.out.println("m:" + Arrays.toString(m)); //ok

        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < A[0].length; j++){
                A[i+1][j] -= (A[0][j] * m[i]);
            }
        }

        return A;
    }

    public static double[][] eliminateX2(double[][] A, double[] B){
//        System.out.println("A: " + Arrays.deepdoubleoString(A));
        double[] m = new double[A.length-2];
        for (int i = 0; i < m.length; i++){
//            System.out.println(A[i+1][1]);
            m[i] = A[i+2][1] / A[1][1];
        }

        System.out.println("m:" + Arrays.toString(m)); //ok

        int mi = 0;
        for (int i = 2; i < A.length; i++){
            for (int j = 1; j < A[0].length; j++){
//                System.out.printf("[%d][%d]", i, j);
//                System.out.println(mi);
                A[i][j] -= (A[1][j] * m[mi]);
            }
            mi++;
        }

        return A;
    }

    public static double[][] eliminateX3(double[][] A, double[] B){
        System.out.println("A: " + Arrays.deepToString(A));
        double[] m = new double[A.length-3];
        for (int i = 0; i < m.length; i++){
            System.out.println(A[i+1][1]);
            m[i] = A[i+3][2] / A[2][2];
        }

        System.out.println("m:" + Arrays.toString(m)); //ok

        int mi = 0;
        for (int i = 3; i < A.length; i++){
            for (int j = 2; j < A[0].length; j++){
                System.out.printf("[%d][%d]", i, j);
                System.out.println(mi);
                A[i][j] -= (A[2][j] * m[mi]);
            }
            mi++;
        }

        return A;
    }
}
