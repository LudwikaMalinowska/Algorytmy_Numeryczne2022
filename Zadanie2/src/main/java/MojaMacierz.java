import java.lang.reflect.Array;
import java.util.Arrays;

//przyjmuje dowolny typ liczby, ale z uwagi na to jak zaimplementowane są liczby w
// javie, oraz że typy generyczne nie są przystosowane do matematyki
// metody zwracają double
public class MojaMacierz<T extends Number> {
    private final T[][] values;

    public MojaMacierz(T[][] values) {
        this.values = values;
    }

    public T[][] getValues() {
        return values;
    }

    private MojaMacierz<T> convert(Double[][] m1){
        return new MojaMacierz<T>((T[][]) m1);
    }



    public MojaMacierz<T> add(MojaMacierz<T> otherMatrix){
        T[][] other = otherMatrix.getValues();
        //takie same wymiary
        if (values.length != other.length || values[0].length != other[0].length)
            throw new RuntimeException();

        Double[][] result = new Double[values.length][values.length];
//        T[][] result = (T[][]) Array.newInstance(Number.class, values.length, values.length);


        for (int i = 0; i < values.length; i++){
            for (int j = 0; j < values[0].length; j++){
                result[i][j] = (values[i][j].doubleValue() + other[i][j].doubleValue());
            }
        }

        return this.convert(result);
    }

    public MojaMacierz<T> multiply(MojaMacierz<T> otherMatrix){
        T[][] other = otherMatrix.getValues();
        if (values[0].length != other.length) throw new RuntimeException();
        Double[][] result = new Double[values.length][other[0].length];

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++){

                double sum = 0;
                for (int p = 0; p < values[0].length; p++){
                    sum += values[i][p].doubleValue() * other[p][j].doubleValue();
                }
                result[i][j] = sum;
            }
        }
        return this.convert(result);
    }

    public Double[] multiply(Double[] vector){
        if (vector.length != values[0].length) throw new RuntimeException();

        Double[] result = new Double[values.length];

        for (int i = 0; i < result.length; i++){
            double sum = 0;
            for (int j = 0; j < values[0].length; j++){
                sum += values[i][j].doubleValue() * vector[j];
            }
            result[i] = sum;
        }

        return result;
    }

    public T[] elGaussKrok1(T[] B){
        for (int k = 1; k <= values.length; k++){
            Double[] m = new Double[values.length -k];
            for (int i = 0; i < m.length; i++){
                System.out.println("-----");
                System.out.println(i-1);
                m[i] = values[i+k][k-1].doubleValue() / values[k-1][k-1].doubleValue();
            }

            System.out.println("m:" + Arrays.toString(m)); //ok


            int mi = 0;
            for (int i = k; i < values.length; i++){
                for (int j = k-1; j < values[0].length; j++){
                    System.out.printf("[%d][%d]", i, j);
//                    System.out.println(mi);
                    Double val = values[i][j].doubleValue() -
                            (values[k-1][j].doubleValue() * m[mi]);
                    values[i][j] = (T) val;
                }

                Double valB = B[i].doubleValue() - (m[mi] * B[k-1].doubleValue());
                B[i] = (T) valB;

                mi++;
            }


            System.out.println("\nB:" + Arrays.toString(B)); //ok
        }

        return B;
    }
//
//    public static <T> T[][] eliminateX1(T[][] A, T[] B){
//        T[] m = new T[A.length-1];
//        for (int i = 1; i < A.length; i++){
//            m[i-1] = A[i][0] / A[0][0];
//        }
//
//        System.out.println("m:" + Arrays.toString(m)); //ok
//
//        for (int i = 0; i < m.length; i++){
//            for (int j = 0; j < A[0].length; j++){
//                A[i+1][j] -= (A[0][j] * m[i]);
//            }
//        }
//
//        return A;
//    }
//
//    public static <T> T[][] eliminateX2(T[][] A, T[] B){
////        System.out.println("A: " + Arrays.deepToString(A));
//        T[] m = new T[A.length-2];
//        for (int i = 0; i < m.length; i++){
////            System.out.println(A[i+1][1]);
//            m[i] = A[i+2][1] / A[1][1];
//        }
//
//        System.out.println("m:" + Arrays.toString(m)); //ok
//
//        int mi = 0;
//        for (int i = 2; i < A.length; i++){
//            for (int j = 1; j < A[0].length; j++){
////                System.out.printf("[%d][%d]", i, j);
////                System.out.println(mi);
//                A[i][j] -= (A[1][j] * m[mi]);
//            }
//            mi++;
//        }
//
//        return A;
//    }
//
//    public static <T> T[][] eliminateX3(T[][] A, T[] B){
//        System.out.println("A: " + Arrays.deepToString(A));
//        T[] m = new T[A.length-3];
//        for (int i = 0; i < m.length; i++){
//            System.out.println(A[i+1][1]);
//            m[i] = A[i+3][2] / A[2][2];
//        }
//
//        System.out.println("m:" + Arrays.toString(m)); //ok
//
//        int mi = 0;
//        for (int i = 3; i < A.length; i++){
//            for (int j = 2; j < A[0].length; j++){
//                System.out.printf("[%d][%d]", i, j);
//                System.out.println(mi);
//                A[i][j] -= (A[2][j] * m[mi]);
//            }
//            mi++;
//        }
//
//        return A;
//    }

    public static void main(String[] args) {
        Double[][] arr1 = new Double[][]{
                {1.0, 1.0},
                {1.0, 1.0},
        };
        Double[][] arr2 = new Double[][]{
                {1.0, 1.0},
                {1.0, 1.0},
        };
        Double[][] arr4 = new Double[][]{
                {1.2, 2.6 ,-0.1, 1.5},
                {4.5, 9.8, -0.4, 5.7},
                {0.1, -0.1, -0.3, -3.5},
                {4.5, -5.2, 4.2, -3.4},
        };
//        MojaMacierz<Double> m1 = new MojaMacierz<>(arr1);
//        MojaMacierz<Double> m2 = new MojaMacierz<>(arr2);
        MojaMacierz<Double> m4 = new MojaMacierz<>(arr4);
//        MojaMacierz<Double> m3 = m1.add(m2);

        Double[] b = new Double[]{13.15, 49.84, -14.08, -46.51};
        Double[] b1 = m4.elGaussKrok1(b);

        Double[][] m4d = m4.getValues();
        for (Double[] row : m4d){
            System.out.println(Arrays.toString(row));
        }
        System.out.println(Arrays.toString(b1));

    }
}
