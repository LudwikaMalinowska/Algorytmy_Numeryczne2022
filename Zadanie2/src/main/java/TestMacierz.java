
import org.ejml.simple.SimpleMatrix;

import java.util.Random;

public class TestMacierz {



    public static SimpleMatrix testAXfloat(float[][] arr1, float[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m3 = m1.mult(vector1);
        return m3;
    }

    public static SimpleMatrix testABCXfloat(float[][] arr1, float[][] arr2,
                                     float[][] arr3, float[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m4 = m1.plus(m2).plus(m3);
        SimpleMatrix m5 = m4.mult(vector1);
        return m5;
    }

    public static SimpleMatrix testABCfloat(float[][] arr1, float[][] arr2,
                                    float[][] arr3){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);

        SimpleMatrix m4 = m2.mult(m3);
        SimpleMatrix m5 = m1.mult(m4);
//        m4.print();
        return m5;
    }

    public static SimpleMatrix testAXdouble(double[][] arr1, double[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m3 = m1.mult(vector1);

        return m3;
    }

    public static SimpleMatrix testABCXdouble(double[][] arr1, double[][] arr2,
                                     double[][] arr3, double[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m4 = m1.plus(m2).plus(m3);
        SimpleMatrix m5 = m4.mult(vector1);

        return m5;
    }

    public static SimpleMatrix testABCdouble(double[][] arr1, double[][] arr2,
                                    double[][] arr3){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);

        SimpleMatrix m4 = m2.mult(m3);
        SimpleMatrix m5 = m1.mult(m4);
        return m5;
    }

    public static float randomFloat(){
        Random r = new Random();
        float min = (float) (- Math.pow(2, 16));
        float max = (float) Math.pow(2, 16) - 1;
        float rand1 = min + r.nextFloat() * (max - min);
        float rand = (float) (rand1 / Math.pow(2, 16));

        return rand;
    }

    public static double randomDouble(){
        Random r = new Random();
        double min = - Math.pow(2, 16);
        double max = Math.pow(2, 16) - 1;
        double rand1 = min + r.nextDouble() * (max - min);
        double rand = rand1 / Math.pow(2, 16);

        return rand;
    }

    public static void main(String[] args) {
        float[][] arr4 = new float[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}

        };
        float[][] vector = new float[][]{
                {1},
                {2},
                {3}
        };

        System.out.println(randomFloat());




    }
}
