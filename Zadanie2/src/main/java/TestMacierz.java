
import org.ejml.simple.SimpleMatrix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class TestMacierz {


    public void testAXFloat(int rows, int columns){
        Class<Float> clazz = Float.class;
        float[][] arr1 = this.fillMatrixFloat(rows, columns);
        float[][] vector = this.fillMatrixFloat(rows, 1);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = AXfloat(arr1, vector);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;

        start = System.currentTimeMillis();
        Float[][] arr2 = matrixfloatToFloat(arr1);
        Float[][] v1 = matrixfloatToFloat(vector);
        MojaMacierz<Float> mm1 = new MojaMacierz<Float>(arr2, clazz);
        MojaMacierz<Float> vector1 = new MojaMacierz<>(v1, clazz);
        MojaMacierz<Float> mm3 = mm1.multiply(vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(sm2);
        MojaMacierz<Float> mm4 = new MojaMacierz<>(data, clazz);
        System.out.println(Arrays.deepToString(mm4.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Float> roznice = mm3.subtract(mm4);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Float> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testAXDouble(int rows, int columns){
        Class<Double> clazz = Double.class;
        double[][] arr1 = this.fillMatrixDouble(rows, columns);
        double[][] vector = this.fillMatrixDouble(rows, 1);

        long start = System.currentTimeMillis();
        SimpleMatrix sm2 = AXdouble(arr1, vector);
        long finish = System.currentTimeMillis();
        long timeElapsed1 = finish - start;


        start = System.currentTimeMillis();
        Double[][] arr2 = matrixdoubleToDouble(arr1);
        Double[][] v1 = matrixdoubleToDouble(vector);
        MojaMacierz<Double> mm1 = new MojaMacierz<>(arr2, clazz);
        MojaMacierz<Double> vector1 = new MojaMacierz<>(v1, clazz);
        MojaMacierz<Double> mm3 = mm1.multiply(vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Double[][] data = simpleMatrixToDouble(sm2);
        MojaMacierz<Double> mm4 = new MojaMacierz<>(data, clazz);
        System.out.println(Arrays.deepToString(mm4.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Double> roznice = mm3.subtract(mm4);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Double> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCXfloat(int rows, int columns){
        Class<Float> clazz = Float.class;
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
        MojaMacierz<Float> mm1 = new MojaMacierz<>(my_arr1, clazz);
        MojaMacierz<Float> mm2 = new MojaMacierz<>(my_arr2, clazz);
        MojaMacierz<Float> mm3 = new MojaMacierz<>(my_arr3, clazz);
        MojaMacierz<Float> my_vector1 = new MojaMacierz<>(my_v1, clazz);
        MojaMacierz<Float> mm4 = mm1.add(mm2).add(mm3);
        MojaMacierz<Float> my_result_mm = mm4.multiply(my_vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(sm2);
        MojaMacierz<Float> sm_to_mm = new MojaMacierz<>(data, clazz);
        System.out.println(Arrays.deepToString(sm_to_mm.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Float> roznice = sm_to_mm.subtract(my_result_mm);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Float> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCXdouble(int rows, int columns){
        Class<Double> clazz = Double.class;
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
        MojaMacierz<Double> mm1 = new MojaMacierz<>(my_arr1, clazz);
        MojaMacierz<Double> mm2 = new MojaMacierz<>(my_arr2, clazz);
        MojaMacierz<Double> mm3 = new MojaMacierz<>(my_arr3, clazz);
        MojaMacierz<Double> my_vector1 = new MojaMacierz<>(my_v1, clazz);
        MojaMacierz<Double> mm4 = mm1.add(mm2).add(mm3);
        MojaMacierz<Double> my_result_mm = mm4.multiply(my_vector1);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Double[][] data = simpleMatrixToDouble(sm2);
        MojaMacierz<Double> sm_to_mm = new MojaMacierz<>(data, clazz);
        System.out.println(Arrays.deepToString(sm_to_mm.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Double> roznice = sm_to_mm.subtract(my_result_mm);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Double> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCfloat(int rows, int columns){
        Class<Float> clazz = Float.class;
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
        MojaMacierz<Float> mm1 = new MojaMacierz<>(my_arr1, clazz);
        MojaMacierz<Float> mm2 = new MojaMacierz<>(my_arr2, clazz);
        MojaMacierz<Float> mm3 = new MojaMacierz<>(my_arr3, clazz);
        MojaMacierz<Float> mm4 = mm2.multiply(mm3);
        MojaMacierz<Float> my_result_mm = mm1.multiply(mm4);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(sm2);
        MojaMacierz<Float> sm_to_mm = new MojaMacierz<>(data, clazz);
        System.out.println(Arrays.deepToString(sm_to_mm.getValues()));
        System.out.println(Arrays.deepToString(data));
        MojaMacierz<Float> roznice = sm_to_mm.subtract(my_result_mm);


        System.out.println(Arrays.deepToString(roznice.getValues()));
        MojaMacierz<Float> rozniceAbs = roznice.abs();
        System.out.println(Arrays.deepToString(rozniceAbs.getValues()));

        System.out.println("\ntime1: " + timeElapsed1 + "\ntime2: " + timeElapsed2);
    }

    public void testABCdouble(int rows, int columns){
        Class<Double> clazz = Double.class;
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
        MojaMacierz<Double> mm1 = new MojaMacierz<>(my_arr1, clazz);
        MojaMacierz<Double> mm2 = new MojaMacierz<>(my_arr2, clazz);
        MojaMacierz<Double> mm3 = new MojaMacierz<>(my_arr3, clazz);
        MojaMacierz<Double> mm4 = mm2.multiply(mm3);
        MojaMacierz<Double> my_result_mm = mm1.multiply(mm4);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Double[][] data = simpleMatrixToDouble(sm2);
        MojaMacierz<Double> sm_to_mm = new MojaMacierz<>(data, clazz);
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


    private double[][] matrixBigDoubleTodouble(Double[][] arr1){
        double[][] arr2 = new double[arr1.length][arr1[0].length];
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                arr2[i][j] = arr1[i][j];
            }
        }

        return arr2;
    }

    private Ulamek[][] matrixdoubleToUlamek(double[][] arr1){
        Ulamek[][] arr2 = new Ulamek[arr1.length][arr1[0].length];
        double pow2 = Math.pow(2, 16);
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                double val = (arr1[i][j] * pow2);
                arr2[i][j] = new Ulamek(val);
            }
        }

        return arr2;
    }

    private Double[][] matrixUlamekToDouble(Ulamek[][] arr1){
        Double[][] arr2 = new Double[arr1.length][arr1[0].length];
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                arr2[i][j] = arr1[i][j].doubleValue();
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

    public long randomGaussFloatTime(int size, String method){
        float[][] arr_a = this.fillMatrixFloat(size, size);
        float[][] arr_b = this.fillMatrixFloat(size, 1);
        Float[][] my_arr1 = matrixfloatToFloat(arr_a);
        Float[][] my_b = matrixfloatToFloat(arr_b);
        MojaMacierz<Float> mm_a = new MojaMacierz<>(my_arr1, Float.class);


        long start = System.currentTimeMillis();
        MojeRownanie<Float> mojeRownanie = new MojeRownanie<>(mm_a, my_b, Float.class);
        Float[][] my_result;
        if (method.equals("full"))
            my_result = mojeRownanie.solveGaussFG();
        else if (method.equals("partial"))
            my_result = mojeRownanie.solveGaussPG();
        else
            my_result = mojeRownanie.solveGaussG();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        return timeElapsed;
    }

    public long randomGaussDoubleTime(int size, String method){
        double[][] arr_a = this.fillMatrixDouble(size, size);
        double[][] arr_b = this.fillMatrixDouble(size, 1);
        Double[][] my_arr1 = matrixdoubleToDouble(arr_a);
        Double[][] my_b = matrixdoubleToDouble(arr_b);
        MojaMacierz<Double> mm_a = new MojaMacierz<>(my_arr1, Double.class);


        long start = System.currentTimeMillis();
        MojeRownanie<Double> mojeRownanie = new MojeRownanie<>(mm_a, my_b, Double.class);
        Double[][] my_result;
        if (method.equals("full"))
            my_result = mojeRownanie.solveGaussFG();
        else if (method.equals("partial"))
            my_result = mojeRownanie.solveGaussPG();
        else
            my_result = mojeRownanie.solveGaussG();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        return timeElapsed;
    }



    public void testGaussFloat(int rows, int columns, String method){
        Class<Float> clazz = Float.class;
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
        MojaMacierz<Float> mm_a = new MojaMacierz<>(my_arr1, clazz);

        System.out.println("Before: ");
        for (float[] row : arr_a){
            System.out.println(Arrays.toString(row));
        }

        start = System.currentTimeMillis();
        MojeRownanie<Float> mojeRownanie = new MojeRownanie<>(mm_a, bFloat, Float.class);
        Float[][] my_result;
        if (method.equals("full"))
            my_result = mojeRownanie.solveGaussFG();
        else if (method.equals("partial"))
            my_result = mojeRownanie.solveGaussPG();
        else
            my_result = mojeRownanie.solveGaussG();
        MojaMacierz<Float> my_result_mm = new MojaMacierz<>(my_result, clazz);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;

        Float[][] data = simpleMatrixToFloat(result_1);
        MojaMacierz<Float> sm_to_mm = new MojaMacierz<>(data, clazz);
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


    public void testGaussDouble(int rows, int columns, String method){
        Class<Double> clazz = Double.class;
        double[][] arr_a = this.fillMatrixDouble(rows, columns);
        double[][] arr_x = this.fillMatrixDouble(rows, 1);
        SimpleMatrix sm_a = new SimpleMatrix(arr_a);
        SimpleMatrix sm_x = new SimpleMatrix(arr_x);
        SimpleMatrix sm_b = sm_a.mult(sm_x);

        SimpleMatrix result_1 = sm_a.solve(sm_b);


        Double[][] bDouble = simpleMatrixToDouble(sm_b);
        Double[][] my_arr1 = matrixdoubleToDouble(arr_a);
        MojaMacierz<Double> mm_a = new MojaMacierz<>(my_arr1, clazz);

        MojeRownanie<Double> mojeRownanie = new MojeRownanie<>(mm_a, bDouble, Double.class);
        Double[][] my_result;
        if (method.equals("full"))
            my_result = mojeRownanie.solveGaussFG();
        else if (method.equals("partial"))
            my_result = mojeRownanie.solveGaussPG();
        else
            my_result = mojeRownanie.solveGaussG();

        MojaMacierz<Double> my_result_mm = new MojaMacierz<>(my_result, clazz);


        Double[][] data = simpleMatrixToDouble(result_1);
        MojaMacierz<Double> sm_to_mm = new MojaMacierz<>(data, clazz);
        MojaMacierz<Double> roznice = sm_to_mm.subtract(my_result_mm);

        MojaMacierz<Double> rozniceAbs = roznice.abs();
        //ale od x oryginalnej różnice

    }

    public String doubleGaussError(int size){
        Class<Double> clazz = Double.class;
        double[][] arr_a = this.fillMatrixDouble(size, size);
        double[][] arr_x = this.fillMatrixDouble(size, 1);
        SimpleMatrix sm_a = new SimpleMatrix(arr_a);
        SimpleMatrix sm_x = new SimpleMatrix(arr_x);
        SimpleMatrix sm_b = sm_a.mult(sm_x);

        Double[][] bDouble = simpleMatrixToDouble(sm_b);
        Double[][] my_arr1 = matrixdoubleToDouble(arr_a);
        MojaMacierz<Double> mm_a = new MojaMacierz<>(my_arr1, clazz);
        MojeRownanie<Double> mojeRownanie1 = new MojeRownanie<>(mm_a, bDouble, clazz);
        MojeRownanie<Double> mojeRownanie2 = new MojeRownanie<>(mm_a, bDouble, clazz);
        MojeRownanie<Double> mojeRownanie3 = new MojeRownanie<>(mm_a, bDouble, clazz);
        Double[][] my_result1 = mojeRownanie1.solveGaussG();
        Double[][] my_result2 = mojeRownanie2.solveGaussPG();
        Double[][] my_result3 = mojeRownanie3.solveGaussFG();

        Double[][] xDouble = this.matrixdoubleToDouble(arr_x);
//        MojaMacierz<Double> mm_x = new MojaMacierz<>(xDouble, clazz);

        double err1 = averageErrorInArrDouble(my_result1, xDouble);
        double err2 = averageErrorInArrDouble(my_result2, xDouble);
        double err3 = averageErrorInArrDouble(my_result3, xDouble);

        return err1 + "," + err2 + "," + err3 + "\n";
    }
//
    public String floatGaussError(int size){
        Class<Float> clazz = Float.class;
        float[][] arr_a = this.fillMatrixFloat(size, size);
        float[][] arr_x = this.fillMatrixFloat(size, 1);
        SimpleMatrix sm_a = new SimpleMatrix(arr_a);
        SimpleMatrix sm_x = new SimpleMatrix(arr_x);
        SimpleMatrix sm_b = sm_a.mult(sm_x);

        Float[][] bFloat = simpleMatrixToFloat(sm_b);
        Float[][] my_arr1 = matrixfloatToFloat(arr_a);
        MojaMacierz<Float> mm_a = new MojaMacierz<>(my_arr1, clazz);
        MojeRownanie<Float> mojeRownanie1 = new MojeRownanie<>(mm_a, bFloat, clazz);
        MojeRownanie<Float> mojeRownanie2 = new MojeRownanie<>(mm_a, bFloat, clazz);
        MojeRownanie<Float> mojeRownanie3 = new MojeRownanie<>(mm_a, bFloat, clazz);
        Float[][] my_result1 = mojeRownanie1.solveGaussG();
        Float[][] my_result2 = mojeRownanie2.solveGaussPG();
        Float[][] my_result3 = mojeRownanie3.solveGaussFG();

        Float[][] xFloat = this.matrixfloatToFloat(arr_x);
        MojaMacierz<Float> mm_x = new MojaMacierz<>(xFloat, clazz);

        float err1 = averageErrorInArrFloat(my_result1, mm_x);
        float err2 = averageErrorInArrFloat(my_result2, mm_x);
        float err3 = averageErrorInArrFloat(my_result3, mm_x);

        return err1 + "," + err2 + "," + err3 + ",";
    }

    public String ulamekGaussError(int size){
        Class<Ulamek> clazz = Ulamek.class;
        double[][] arr_a = this.fillMatrixDouble(size, size);
        double[][] arr_x = this.fillMatrixDouble(size, 1);
        SimpleMatrix sm_a = new SimpleMatrix(arr_a);
        SimpleMatrix sm_x = new SimpleMatrix(arr_x);
        SimpleMatrix sm_b = sm_a.mult(sm_x);

        Double[][] bDouble = simpleMatrixToDouble(sm_b);
        double[][] arr_b = matrixBigDoubleTodouble(bDouble);
        Ulamek[][] ulamek_b = matrixdoubleToUlamek(arr_b);
        Ulamek[][] ulamek_a = matrixdoubleToUlamek(arr_a);
        MojaMacierz<Ulamek> mm_a = new MojaMacierz<>(ulamek_a, clazz);
        MojeRownanie<Ulamek> mojeRownanie1 = new MojeRownanie<Ulamek>(mm_a, ulamek_b, clazz);
        MojeRownanie<Ulamek> mojeRownanie2 = new MojeRownanie<Ulamek>(mm_a, ulamek_b, clazz);
        MojeRownanie<Ulamek> mojeRownanie3 = new MojeRownanie<Ulamek>(mm_a, ulamek_b, clazz);
        Ulamek[][] my_result1 = mojeRownanie1.solveGaussG();
        Ulamek[][] my_result2 = mojeRownanie1.solveGaussPG();
        Ulamek[][] my_result3 = mojeRownanie1.solveGaussFG();


        Double[][] xDouble = this.matrixdoubleToDouble(arr_x);
        Double[][] res1_Double = this.matrixUlamekToDouble(my_result1);
        Double[][] res2_Double = this.matrixUlamekToDouble(my_result2);
        Double[][] res3_Double = this.matrixUlamekToDouble(my_result3);


        double err1 = averageErrorInArrDouble(res1_Double, xDouble);
        double err2 = averageErrorInArrDouble(res2_Double, xDouble);
        double err3 = averageErrorInArrDouble(res3_Double, xDouble);

        return err1 + "," + err2 + "," + err3 + "\n";
    }



    public double averageErrorInArrDouble(Double[][] my_result1, Double[][] xDouble){
        MojaMacierz<Double> mm_x = new MojaMacierz<>(xDouble, Double.class);
        MojaMacierz<Double> mm_res1 = new MojaMacierz<>(my_result1, Double.class);
        MojaMacierz<Double> rozniceAbs1 = mm_res1.subtract(mm_x).abs();

        Double[][] roz_double = rozniceAbs1.getValues();
        double sum = 0;
        for (Double[] doubles : roz_double)
            for (Double d : doubles)
                sum += d;

        double avg = sum / (roz_double.length * roz_double[0].length);
        return avg;
    }

    public float averageErrorInArrFloat(Float[][] my_result1, MojaMacierz<Float> mm_x){
        MojaMacierz<Float> mm_res1 = new MojaMacierz<>(my_result1, Float.class);
        MojaMacierz<Float> rozniceAbs1 = mm_res1.subtract(mm_x).abs();

        Float[][] roz_float = rozniceAbs1.getValues();
        float sum = 0;
        for (Float[] floats : roz_float)
            for (Float f : floats)
                sum += f;

        float avg = sum / (roz_float.length * roz_float[0].length);
        return avg;
    }



    public static float randomFloat(){
        Random r = new Random();
        float min = (float) (- Math.pow(2, 16));
        float max = (float) Math.pow(2, 16) - 1;
        float rand1 = min + r.nextFloat() * (max - min);
        float rand = (float) (rand1 / Math.pow(2, 16));

        return rand;
    }

    public static long randomLong(){
        Random r = new Random();
        long min = (long) (- Math.pow(2, 16));
        long max = (long) Math.pow(2, 16) - 1;
        float rand1 = min + r.nextFloat() * (max - min);
//        System.out.println((long )rand1);
        return (long) (rand1);
    }

    public static double randomDouble(){
        Random r = new Random();
        double min = - Math.pow(2, 16);
        double max = Math.pow(2, 16) - 1;
        double rand1 = min + r.nextDouble() * (max - min);
        double rand = rand1 / Math.pow(2, 16);

        return rand;
    }

    public double meanTimeOf10Gauss(int size, String method, String clazz){
        double sumTime = 0;
            if (clazz.toLowerCase().equals("double")){
                for (int i = 0; i < 10; i++)
                    sumTime += this.randomGaussFloatTime(size, method);
            } else {
                for (int i = 0; i < 10; i++)
                    sumTime += this.randomGaussDoubleTime(size, method);
            }

        return sumTime / 10.0;
    }

    public String allGaussTime(int size){
        TestMacierz testMacierz = new TestMacierz();
        double timeGaussGFloat = testMacierz.meanTimeOf10Gauss(size,"without", "float");
        double timeGaussPGFloat = testMacierz.meanTimeOf10Gauss(size, "partial", "float");
        double timeGaussFGFloat = testMacierz.meanTimeOf10Gauss(size,"full", "float");

        double timeGaussGDouble = testMacierz.meanTimeOf10Gauss(size,"without", "double");
        double timeGaussPGDouble = testMacierz.meanTimeOf10Gauss(size,"partial", "double");
        double timeGaussFGDouble = testMacierz.meanTimeOf10Gauss(size, "full", "double");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(size).append(",")
                .append(timeGaussGFloat).append(",")
                .append(timeGaussPGFloat).append(",")
                .append(timeGaussFGFloat).append(",")
                .append(timeGaussGDouble).append(",")
                .append(timeGaussPGDouble).append(",")
                .append(timeGaussFGDouble).append("\n");

        return stringBuilder.toString();
    }

    public void writeErrToCsv(){
        StringBuilder sb = new StringBuilder();
        sb.append("size").append(",")
                .append("errGaussGFloat").append(",")
                .append("errGaussPGFloat").append(",")
                .append("errGaussFGFloat").append(",")
                .append("errGaussGDouble").append(",")
                .append("errGaussPGDouble").append(",")
                .append("errGaussFGDouble").append("\n");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File("err_my_gauss.csv")))) {
            bw.write(sb.toString());
            sb.setLength(0);

            for (int i = 25; i <= 200; i+=25){
                String s1 = floatGaussError(i);
                String s2 = doubleGaussError(i);
                System.out.println(i);

                bw.write(i + "," + s1 + s2);
            }
        } catch (IOException e){
            System.out.println(e);
        }

    }

    public void writeUlamekErrToCsv(){
        StringBuilder sb = new StringBuilder();
        sb.append("size").append(",")
                .append("errGaussGUlamek").append(",")
                .append("errGaussPGUlamek").append(",")
                .append("errGaussFGUlamek").append("\n");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File("err_my_gauss_ulamek.csv")))) {
            bw.write(sb.toString());
            sb.setLength(0);

            for (int i = 25; i <= 500; i+=25){
                String s2 = ulamekGaussError(i);
                System.out.println(i);

                bw.write(i + "," + s2);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public void writeTimeToCsv(){
        StringBuilder sb = new StringBuilder();
        sb.append("size").append(",")
                .append("timeGaussGFloat").append(",")
                .append("timeGaussPGFloat").append(",")
                .append("timeGaussFGFloat").append(",")
                .append("timeGaussGDouble").append(",")
                .append("timeGaussPGDouble").append(",")
                .append("timeGaussFGDouble").append("\n");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("time_my_gauss.csv")))) {
            bw.write(sb.toString());
            sb.setLength(0);

            for (int i = 25; i < 500; i+=25){
                String s = allGaussTime(i);
                System.out.println(s);

                bw.write(s);
            }
        } catch (IOException e){
        System.out.println(e);
        }

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

        Double[][] arr1 = new Double[][]{
                {1.0,2.0,3.0},
                {4.0,5.0,6.0},
                {7.0,8.0,9.0}

        };
        Double[][] vector1 = new Double[][]{
                {1.0},
                {2.0},
                {3.0}
        };
        Float[][] arr2 = new Float[][]{
                {1.0f,2.0f,3.0f},
                {4.0f,5.0f,6.0f},
                {7.0f,8.0f,9.0f}

        };
        Float[][] vector2 = new Float[][]{
                {1.0f},
                {2.0f},
                {3.0f}
        };

        TestMacierz testMacierz = new TestMacierz();

        testMacierz.writeErrToCsv();
//        testMacierz.writeUlamekErrToCsv();
//        testMacierz.ulamekGaussError(10);

    }
}
