//import java.lang.reflect.Array;
//import java.util.Arrays;
//
////przyjmuje dowolny typ liczby, ale z uwagi na to jak zaimplementowane są liczby w
//// javie, oraz że typy generyczne nie są przystosowane do matematyki
//// metody zwracają double
//public class MojaMacierz2<T extends MyNumber> {
//    private final T[][] values;
//    private Class<T> clazz;
//
//    public MojaMacierz2(T[][] values, Class<T> clazz) {
//        this.values = values;
//        this.clazz = clazz;
//    }
//
//    public T[][] getValues() {
//        return values;
//    }
//
//    private MojaMacierz2<T> convert(T[][] m1){
//        return new MojaMacierz2<T>(m1, clazz);
//    }
//
//    private T convertToType(Class<T> clazz,String str) {
//        try {
//            return clazz.getConstructor(String.class).newInstance(str);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    // https://stackoverflow.com/a/36804604/10476860
//
//
//
//    public MojaMacierz2<T> add(MojaMacierz2<T> otherMatrix){
//        T[][] other = otherMatrix.getValues();
//        //takie same wymiary
//        if (values.length != other.length || values[0].length != other[0].length)
//            throw new RuntimeException();
//
////        Double[][] result = new Double[values.length][values.length];
//        T[][] result = (T[][]) Array.newInstance(clazz, other.length, other[0].length);
//
//        for (int i = 0; i < values.length; i++){
//            for (int j = 0; j < values[0].length; j++){
////                result[i][j] = convertToType(clazz,String.valueOf(values[i][j].doubleValue()
////                        + other[i][j].doubleValue()));
//                values[i][j].add(other[i][j]);
////                result[i][j] = convertToType(clazz,String.valueOf(values[i][j]));
//            }
//        }
//
////        return this.convert(result);
//        return this.convert(values);
//    }
//
//    public MojaMacierz2<T> subtract(MojaMacierz2<T> otherMatrix){  //działa
//        T[][] other = otherMatrix.getValues();
//        //takie same wymiary
//        if (values.length != other.length || values[0].length != other[0].length)
//            throw new RuntimeException();
//
//        T[][] result = (T[][]) Array.newInstance(clazz, values.length, values[0].length);
//
//        for (int i = 0; i < values.length; i++){
//            for (int j = 0; j < values[0].length; j++){
////                result[i][j] = convertToType(clazz, String.valueOf(values[i][j].doubleValue()
////                        - other[i][j].doubleValue()));
//                values[i][j].subtract(other[i][j]);
//            }
//        }
//
//        return this.convert(values);
//    }
//
//    public MojaMacierz2<T> abs(){
//        T[][] result = (T[][]) Array.newInstance(clazz, values.length, values[0].length);
//
//        for (int i = 0; i < values.length; i++){
//            for (int j = 0; j < values[0].length; j++){
//                result[i][j] = convertToType(clazz, String.valueOf(Math.abs(
//                        values[i][j].doubleValue())));
//            }
//        }
//
//        return this.convert(result);
//    }
//
//    static <T> T[][] deepCopy(T[][] matrix) {
//        return Arrays.stream(matrix)
//                .map(arr -> arr.clone())
//                .toArray(s -> matrix.clone());
//    }
//
//    public MojaMacierz2<T> multiply(MojaMacierz2<T> otherMatrix){
//        T[][] other = otherMatrix.getValues();
//
//        T[][] this_copy = deepCopy(this.getValues());
//        T[][] other_copy = deepCopy(otherMatrix.getValues());
//
//        if (values[0].length != other.length) throw new RuntimeException();
//        T[][] result = (T[][]) Array.newInstance(clazz, values.length, other[0].length);
////        String[][] result = new String[values.length][other[0].length];
//
//        for (int i = 0; i < result.length; i++){
//            for (int j = 0; j < result[0].length; j++){
//
////                double sum = 0;
////                Ulamek sum = new Ulamek(0);
//                MyNumber sum = values[0][0].getZero();
////                sum.setMianownik();
//
//                for (int p = 0; p < values[0].length; p++){
////                    sum += values[i][p].doubleValue() * other[p][j].doubleValue();;
////                    System.out.println(values[i][p].multiply(other[p][j]));
//
//                    Ulamek uu1 = (Ulamek) values[i][p];
//                    Ulamek uu2 = (Ulamek) other[p][j];
//                    System.out.print(uu1.getLicznik() + " / " + uu1.getMianownik() + " * "
//                    + uu2.getLicznik() + " / " + uu2.getMianownik());
//
//                    Ulamek to_add = (Ulamek) values[i][p].multiply(other[p][j]);
//                    System.out.println("= " + to_add.getLicznik() + " / " + to_add.getMianownik());
//                    sum.add(to_add);
//                    Ulamek ul_sum = (Ulamek) sum;
//                    System.out.println("sum: " + ul_sum.getLicznik() + " / " + ul_sum.getMianownik());
//                }
////                result[i][j] = convertToType(clazz, String.valueOf(sum));
//
//                result[i][j] = (T) sum;
//            }
//        }
//
//        return this.convert(result);
//    }
//
//    public Double[] multiply(Double[][] vector){
//        if (vector.length != values[0].length) throw new RuntimeException();
//
//        Double[] result = new Double[values.length];
//
//        for (int i = 0; i < result.length; i++){
//            double sum = 0;
//            for (int j = 0; j < values[0].length; j++){
//                sum += values[i][j].doubleValue() * vector[j][0];
//            }
//            result[i] = sum;
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Double[][] arr1 = new Double[][]{
//                {1.0, 1.0},
//                {1.0, 1.0},
//        };
//        Double[][] arr2 = new Double[][]{
//                {1.0, 1.0},
//                {1.0, 1.0},
//        };
//        Double[][] arr4 = new Double[][]{
//                {1.2, 2.6 ,-0.1, 1.5},
//                {4.5, 9.8, -0.4, 5.7},
//                {0.1, -0.1, -0.3, -3.5},
//                {4.5, -5.2, 4.2, -3.4},
//        };
//
//        Integer[][] arr5 = new Integer[][]{
//                {1,2,3,1},
//                {4,5,6,2},
//                {7,8,9,3}
//
//        };
//        Integer[][] arr6 = new Integer[][]{
//                {1,2,3,4,5},
//                {1,2,3,4,5},
//                {1,2,3,4,5},
//                {1,2,3,4,5},
//
//        };
//        Double[][] arr7 = new Double[][]{
//                {2.0,4.0,2.0, 0.0},
//                {1.0,0.0,-1.0,1.0},
//                {0.0,1.0,3.0, -1.0},
//                {2.0,1.0,2.0, 1.0},
//
//        };
//        Double[] b2 = new Double[]{4.0,2.0,0.0,6.0};
//
//        Double[][] arr8 = new Double[][]{
//                {0.0, 1.0},
//                {2.0, 3.0}
//
//        };
//        Double[] b3 = new Double[]{2.0, 8.0};
//
////        MojaMacierz<Double> m1 = new MojaMacierz<>(arr7, Double.class);
//    }
//}
