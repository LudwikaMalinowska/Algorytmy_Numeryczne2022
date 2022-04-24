
import org.ejml.simple.SimpleMatrix;

import java.util.Arrays;
import java.util.Random;

public class TestMacierz {


    public void testAXFloat(int rows, int columns){
        float[][] arr1 = this.fillMatrixFloat(rows, columns);
        float[][] vector = this.fillMatrixFloat(rows, 1);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = AXfloat(arr1, vector);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;

        start = System.currentTimeMillis();
        Float[][] arr2 = matrixfloatToFloat(arr1);
        Float[][] v1 = matrixfloatToFloat(vector);
        MojaMacierz<Float> mm1 = new MojaMacierz<>(arr2);
        MojaMacierz<Float> vector1 = new MojaMacierz<>(v1);
        MojaMacierz<Float> mm3 = mm1.multiply(vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(sm2);
        MojaMacierz<Float> mm4 = new MojaMacierz<>(data);
        System.out.println(Arrays.deepToString(mm4.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Float> roznice = mm3.subtract(mm4);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Float> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testAXDouble(int rows, int columns){
        double[][] arr1 = this.fillMatrixDouble(rows, columns);
        double[][] vector = this.fillMatrixDouble(rows, 1);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = AXdouble(arr1, vector);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;


        start = System.currentTimeMillis();
        Double[][] arr2 = matrixdoubleToDouble(arr1);
        Double[][] v1 = matrixdoubleToDouble(vector);
        MojaMacierz<Double> mm1 = new MojaMacierz<>(arr2);
        MojaMacierz<Double> vector1 = new MojaMacierz<>(v1);
        MojaMacierz<Double> mm3 = mm1.multiply(vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Double[][] data = simpleMatrixToDouble(sm2);
        MojaMacierz<Double> mm4 = new MojaMacierz<>(data);
        System.out.println(Arrays.deepToString(mm4.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Double> roznice = mm3.subtract(mm4);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Double> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCXfloat(int rows, int columns){
        float[][] arr1 = this.fillMatrixFloat(rows, columns);
        float[][] arr2 = this.fillMatrixFloat(rows, columns);
        float[][] arr3 = this.fillMatrixFloat(rows, columns);
        float[][] vector = this.fillMatrixFloat(rows, 1);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = ABCXfloat(arr1, arr2, arr3, vector);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;

        start = System.currentTimeMillis();
        Float[][] my_arr1 = matrixfloatToFloat(arr1);
        Float[][] my_arr2 = matrixfloatToFloat(arr2);
        Float[][] my_arr3 = matrixfloatToFloat(arr3);
        Float[][] my_v1 = matrixfloatToFloat(vector);
        MojaMacierz<Float> mm1 = new MojaMacierz<>(my_arr1);
        MojaMacierz<Float> mm2 = new MojaMacierz<>(my_arr2);
        MojaMacierz<Float> mm3 = new MojaMacierz<>(my_arr3);
        MojaMacierz<Float> my_vector1 = new MojaMacierz<>(my_v1);
        MojaMacierz<Float> mm4 = mm1.add(mm2).add(mm3);
        MojaMacierz<Float> my_result_mm = mm4.multiply(my_vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(sm2);
        MojaMacierz<Float> sm_to_mm = new MojaMacierz<>(data);
        System.out.println(Arrays.deepToString(sm_to_mm.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Float> roznice = sm_to_mm.subtract(my_result_mm);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Float> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCXdouble(int rows, int columns){
        double[][] arr1 = this.fillMatrixDouble(rows, columns);
        double[][] arr2 = this.fillMatrixDouble(rows, columns);
        double[][] arr3 = this.fillMatrixDouble(rows, columns);
        double[][] vector = this.fillMatrixDouble(rows, 1);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = ABCXdouble(arr1, arr2, arr3, vector);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;

        start = System.currentTimeMillis();
        Double[][] my_arr1 = matrixdoubleToDouble(arr1);
        Double[][] my_arr2 = matrixdoubleToDouble(arr2);
        Double[][] my_arr3 = matrixdoubleToDouble(arr3);
        Double[][] my_v1 = matrixdoubleToDouble(vector);
        MojaMacierz<Double> mm1 = new MojaMacierz<>(my_arr1);
        MojaMacierz<Double> mm2 = new MojaMacierz<>(my_arr2);
        MojaMacierz<Double> mm3 = new MojaMacierz<>(my_arr3);
        MojaMacierz<Double> my_vector1 = new MojaMacierz<>(my_v1);
        MojaMacierz<Double> mm4 = mm1.add(mm2).add(mm3);
        MojaMacierz<Double> my_result_mm = mm4.multiply(my_vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Double[][] data = simpleMatrixToDouble(sm2);
        MojaMacierz<Double> sm_to_mm = new MojaMacierz<>(data);
        System.out.println(Arrays.deepToString(sm_to_mm.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Double> roznice = sm_to_mm.subtract(my_result_mm);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Double> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCfloat(int rows, int columns){
        float[][] arr1 = this.fillMatrixFloat(rows, columns);
        float[][] arr2 = this.fillMatrixFloat(rows, columns);
        float[][] arr3 = this.fillMatrixFloat(rows, columns);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = ABCfloat(arr1, arr2, arr3);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;

        start = System.currentTimeMillis();
        Float[][] my_arr1 = matrixfloatToFloat(arr1);
        Float[][] my_arr2 = matrixfloatToFloat(arr2);
        Float[][] my_arr3 = matrixfloatToFloat(arr3);
        MojaMacierz<Float> mm1 = new MojaMacierz<>(my_arr1);
        MojaMacierz<Float> mm2 = new MojaMacierz<>(my_arr2);
        MojaMacierz<Float> mm3 = new MojaMacierz<>(my_arr3);
        MojaMacierz<Float> mm4 = mm2.multiply(mm3);
        MojaMacierz<Float> my_result_mm = mm1.multiply(mm4);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(sm2);
        MojaMacierz<Float> sm_to_mm = new MojaMacierz<>(data);
        System.out.println(Arrays.deepToString(sm_to_mm.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Float> roznice = sm_to_mm.subtract(my_result_mm);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Float> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCdouble(int rows, int columns){
        double[][] arr1 = this.fillMatrixDouble(rows, columns);
        double[][] arr2 = this.fillMatrixDouble(rows, columns);
        double[][] arr3 = this.fillMatrixDouble(rows, columns);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = ABCdouble(arr1, arr2, arr3);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;

        start = System.currentTimeMillis();
        Double[][] my_arr1 = matrixdoubleToDouble(arr1);
        Double[][] my_arr2 = matrixdoubleToDouble(arr2);
        Double[][] my_arr3 = matrixdoubleToDouble(arr3);
        MojaMacierz<Double> mm1 = new MojaMacierz<>(my_arr1);
        MojaMacierz<Double> mm2 = new MojaMacierz<>(my_arr2);
        MojaMacierz<Double> mm3 = new MojaMacierz<>(my_arr3);
        MojaMacierz<Double> mm4 = mm2.multiply(mm3);
        MojaMacierz<Double> my_result_mm = mm1.multiply(mm4);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Double[][] data = simpleMatrixToDouble(sm2);
        MojaMacierz<Double> sm_to_mm = new MojaMacierz<>(data);
        System.out.println(Arrays.deepToString(sm_to_mm.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Double> roznice = sm_to_mm.subtract(my_result_mm);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Double> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }


    private Float[][] simpleMatrixToFloat(SimpleMatrix matrix){
        Float[][] array = new Float[matrix.numRows()][matrix.numCols()];
        for (int r = 0; r < matrix.numRows(); r++) {
            for (int c = 0; c < matrix.numCols(); c++) {
                array[r][c] = (float) matrix.get(r, c);
            }
        }
        return array;
    }

    private Double[][] simpleMatrixToDouble(SimpleMatrix matrix){
        Double[][] array = new Double[matrix.numRows()][matrix.numCols()];
        for (int r = 0; r < matrix.numRows(); r++) {
            for (int c = 0; c < matrix.numCols(); c++) {
                array[r][c] = matrix.get(r, c);
            }
        }
        return array;
    }

    private float[][] fillMatrixFloat(int rows, int columns){
        float[][] arr1 = new float[rows][columns];
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[0].length; j ++){
                arr1[i][j] = randomFloat();
            }
        }

        return arr1;
    }

    private Float[][] matrixfloatToFloat(float[][] arr1){
        Float[][] arr2 = new Float[arr1.length][arr1[0].length];
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                arr2[i][j] = arr1[i][j];
            }
        }

        return arr2;
    }

    private Double[][] matrixdoubleToDouble(double[][] arr1){
        Double[][] arr2 = new Double[arr1.length][arr1[0].length];
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                arr2[i][j] = arr1[i][j];
            }
        }

        return arr2;
    }

    private double[][] fillMatrixDouble(int rows, int columns){
        double[][] arr1 = new double[rows][columns];
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[0].length; j ++){
                arr1[i][j] = randomDouble();
            }
        }

        return arr1;
    }



    private static SimpleMatrix AXfloat(float[][] arr1, float[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m3 = m1.mult(vector1);
        return m3;
    }

    private static SimpleMatrix ABCXfloat(float[][] arr1, float[][] arr2,
                                     float[][] arr3, float[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m4 = m1.plus(m2).plus(m3);
        SimpleMatrix m5 = m4.mult(vector1);
        return m5;
    }

    private static SimpleMatrix ABCfloat(float[][] arr1, float[][] arr2,
                                    float[][] arr3){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);

        SimpleMatrix m4 = m2.mult(m3);
        SimpleMatrix m5 = m1.mult(m4);
//        m4.print();
        return m5;
    }

    private static SimpleMatrix AXdouble(double[][] arr1, double[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m3 = m1.mult(vector1);

        return m3;
    }

    private static SimpleMatrix ABCXdouble(double[][] arr1, double[][] arr2,
                                     double[][] arr3, double[][] vector){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);
        SimpleMatrix vector1 = new SimpleMatrix(vector);

        SimpleMatrix m4 = m1.plus(m2).plus(m3);
        SimpleMatrix m5 = m4.mult(vector1);

        return m5;
    }

    private static SimpleMatrix ABCdouble(double[][] arr1, double[][] arr2,
                                    double[][] arr3){
        SimpleMatrix m1 = new SimpleMatrix(arr1);
        SimpleMatrix m2 = new SimpleMatrix(arr2);
        SimpleMatrix m3 = new SimpleMatrix(arr3);

        SimpleMatrix m4 = m2.mult(m3);
        SimpleMatrix m5 = m1.mult(m4);
        return m5;
    }

    private static SimpleMatrix simpleMatrix_gaussG_float(float[][] arr1, float[][] b){
        SimpleMatrix sm_a = new SimpleMatrix(arr1);
        SimpleMatrix sm_b = new SimpleMatrix(b);

        SimpleMatrix sm_x = sm_a.solve(sm_b);
        return sm_x;
    }


    public void testGaussGFloat(int rows, int columns){
        float[][] arr_a = this.fillMatrixFloat(rows, columns);
        float[][] arr_x = this.fillMatrixFloat(rows, 1);
        SimpleMatrix sm_a = new SimpleMatrix(arr_a);
        SimpleMatrix sm_x = new SimpleMatrix(arr_x);
        SimpleMatrix sm_b = sm_a.mult(sm_x);

        long start = System.currentTimeMillis();
        SimpleMatrix result_1 = sm_a.solve(sm_b);
        //time
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;




        Float[][] bFloat = simpleMatrixToFloat(sm_b);
        Float[][] my_arr1 = matrixfloatToFloat(arr_a);
        MojaMacierz<Float> mm_a = new MojaMacierz<>(my_arr1);

        System.out.println("Before: ");
        for (float[] row : arr_a){
            System.out.println(Arrays.toString(row));
        }

        start = System.currentTimeMillis();
        MojeRownanie<Float> mojeRownanie = new MojeRownanie<>(mm_a, bFloat, Float.class);
        Float[][] my_result = mojeRownanie.solveGaussG();
        MojaMacierz<Float> my_result_mm = new MojaMacierz<>(my_result);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(result_1);
        MojaMacierz<Float> sm_to_mm = new MojaMacierz<>(data);
        MojaMacierz<Float> roznice = sm_to_mm.subtract(my_result_mm);

        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Float> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
        System.out.println("After: ");
        for (Float[] row : mojeRownanie.getOriginalMatrix()){
            System.out.println(Arrays.toString(row));
        }
    }


    public void testGaussGDouble(int rows, int columns){
        double[][] arr_a = this.fillMatrixDouble(rows, columns);
        double[][] arr_x = this.fillMatrixDouble(rows, 1);
        SimpleMatrix sm_a = new SimpleMatrix(arr_a);
        SimpleMatrix sm_x = new SimpleMatrix(arr_x);
        SimpleMatrix sm_b = sm_a.mult(sm_x);

        long start = System.currentTimeMillis();
        SimpleMatrix result_1 = sm_a.solve(sm_b);
        //time
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;




        Double[][] bDouble = simpleMatrixToDouble(sm_b);
        Double[][] my_arr1 = matrixdoubleToDouble(arr_a);
        MojaMacierz<Double> mm_a = new MojaMacierz<>(my_arr1);

        System.out.println("Before: ");
        for (double[] row : arr_a){
            System.out.println(Arrays.toString(row));
        }

        start = System.currentTimeMillis();
        MojeRownanie<Double> mojeRownanie = new MojeRownanie<>(mm_a, bDouble, Double.class);
        Double[][] my_result = mojeRownanie.solveGaussG();
        MojaMacierz<Double> my_result_mm = new MojaMacierz<>(my_result);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Double[][] data = simpleMatrixToDouble(result_1);
        MojaMacierz<Double> sm_to_mm = new MojaMacierz<>(data);
        MojaMacierz<Double> roznice = sm_to_mm.subtract(my_result_mm);

        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Double> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
        System.out.println("After: ");
        for (Double[] row : mojeRownanie.getOriginalMatrix()){
            System.out.println(Arrays.toString(row));
        }
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

        TestMacierz testMacierz = new TestMacierz();
//        testMacierz.testAXFloat(10,10);
//        testMacierz.testAXDouble(10,10);
//        testMacierz.testABCXfloat(10,10);
//        testMacierz.testABCXdouble(10,10);
//        testMacierz.testABCfloat(10,10);
//        testMacierz.testABCdouble(10,10);
//        testMacierz.testGaussGDouble(4,4);
        testMacierz.testGaussGFloat(4,4);




    }
}
