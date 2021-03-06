//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.IntStream;
//
//public class MojeRownanie3<T extends MyNumber> {
//    private final T[][] originalMatrix;
//    private final T[][] originalB;
//    private final T[][] values;
//    private final T[][] b;
//    private Class<T> clazz;
//
//    public MojeRownanie3(MojaMacierz2<T> values, T[][] b, Class<T> clazz) {
//        this.originalMatrix = deepCopy(values.getValues());
//        this.originalB = deepCopy(b);
//        this.values = deepCopy(values.getValues());
//        this.b = deepCopy(b);
//        this.clazz = clazz;
//    }
//
//    private T convertToType(Class<T> clazz,String str) {
//        if (clazz.equals(Ulamek.class)){
//
//        }
//        else {
//            try {
//                return clazz.getConstructor(String.class).newInstance(str);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }
//    // https://stackoverflow.com/a/36804604/10476860
//
//    private T[][] convertArrayToType(Class<T> clazz, Double[][] arr) {
//        T[][] arr2 = (T[][]) Array.newInstance(clazz, arr.length, arr[0].length);
//        try {
//            for (int i = 0; i < arr2.length; i++){
//                for (int j = 0; j < arr2[0].length; j++){
//                    arr2[i][j] = convertToType(clazz, String.valueOf(arr[i][j]));
//                }
//            }
//
//            return arr2;
//
////            return clazz.getConstructor(String.class).newInstance(str);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    static <T> T[][] deepCopy(T[][] matrix) {
//        return Arrays.stream(matrix)
//                .map(arr -> arr.clone())
//                .toArray(s -> matrix.clone());
//    }
//    // https://stackoverflow.com/questions/1564832/how-do-i-do-a-deep-copy-of-a-2d-array-in-java
//
//    public T[][] getOriginalMatrix() {
//        return originalMatrix;
//    }
//
//    public T[][] getOriginalB() {
//        return originalB;
//    }
//
//    public T[][] getValues() {
//        return values;
//    }
//
//    public T[][] getB() {
//        return b;
//    }
//
//    public T[][] solveGaussFG(){
//        System.out.println("FG");
////        for (T[] row : values){
////            System.out.print("[");
////            for (T t : row){
////                Ulamek u = (Ulamek) t;
////                System.out.print(" " + u.getLicznik() + " / " + u.getMianownik() + " ");
////            }
////            System.out.println("]");
////        }
//
//        Integer[] Q = this.gaussFGkrok1();
////        for (T[] row : values){
////            System.out.println(Arrays.toString(row));
////        }
////        T[] b1 = (T[]) r[0];
////        Integer[] Q = (Integer[]) r[1];
//
//        T[][] result = this.gaussKrok2();
////        System.out.println("Q: " + Arrays.toString(Q));
////        System.out.println("result1:" + Arrays.deepToString(result));
////        System.out.println("Q: " + Arrays.toString(Q));
//        T[][] res1 = (T[][]) Array.newInstance(clazz, values.length, 1);
//        List<Integer> Qlist = Arrays.asList(Q);
//        for (int i = 0; i < values[0].length; i++){
//            int idx = Qlist.indexOf(i);
//            res1[i][0] = result[idx][0];
//        }
//
////        System.out.println("res:" + Arrays.toString(result));
////        System.out.println("res1:" + Arrays.toString(res1));
//        return res1;
//    }
//
//
//    private T[][] elGaussKrok1(){
//        T[][] b1 = b;
//        for (int k = 1; k <= values.length; k++){
//            b1 = this.k1(k);
//        }
//
//        return b;
//    }
//
//    private T[][] gaussKrok2(){
////        Double[][] x = new Double[b.length][1];
//        T[][] x = (T[][]) Array.newInstance(clazz, b.length, 1);
//        int i = values.length;
//        int j = values[0].length;
//        double Bn = b[b.length-1][0].doubleValue();
//        double Ann = values[i-1][j-1].doubleValue();
//        //Xn
//        x[x.length-1][0] = convertToType(clazz, String.valueOf(Bn / Ann));
//        for (int k = x.length-2; k >= 0 ; k--){
////            System.out.println(k);
//            double bk = b[k][0].doubleValue();
//            double akk = values[k][k].doubleValue();
//            double sum = 0;
//            for (int n = k; n < values[0].length-1; n++){
//                double ak = values[k][n+1].doubleValue();
//                sum += ak * x[n+1][0].doubleValue();
//            }
//
//            double val = (bk - sum) / akk;
//            if (!clazz.equals(Ulamek.class))
//                x[k][0] = convertToType(clazz, String.valueOf(val));
//            else{
//                Ulamek u = (Ulamek) x[k][0];
//                x[k][0] = (T) u;
//            }
//
//        }
//
////        T[][] x_t = convertArrayToType(clazz, x);
////        T[][] x_t = (T[][]) x;
//        return x;
//    }
//
////
////    private T[][] gaussKrok2(){
////        T[][] x = (T[][]) new Object[b.length][1];
////        int i = values.length;
////        int j = values[0].length;
////        double Bn = b[b.length-1][0].doubleValue();
////        double Ann = values[i-1][j-1].doubleValue();
////        //Xn
////        x[x.length-1][0] = convertToType(clazz, String.valueOf(Bn / Ann));
////        for (int k = x.length-2; k >= 0 ; k--){
////            System.out.println(k);
////            double bk = b[k][0].doubleValue();
////            double akk = values[k][k].doubleValue();
////            double sum = 0;
////            for (int n = k; n < values[0].length-1; n++){
////                double ak = values[k][n+1].doubleValue();
////                sum += ak * x[n+1][0].doubleValue();
////            }
////
////            double val = (bk - sum) / akk;
////            x[k][0] = convertToType(clazz, String.valueOf(val));
////        }
////
//////        T[][] x_t = convertArrayToType(clazz, x);
//////        T[][] x_t = x;
////        return x;
////    }
//
//    public T[][] solveGaussG(){
//
//        T[][] b2 = this.elGaussKrok1();
//        T[][] result = this.gaussKrok2();
//
//        return result;
//    }
//
//    private T[][] k1(int k){
//        System.out.println("k1");
//        Double[] m = new Double[values.length -k];
//
//        for (int i = 0; i < m.length; i++){
////            System.out.println("-----");
////            System.out.println(i-1);
//            System.out.println(values[i+k][k-1]);
//            System.out.println(values[k-1][k-1]);
//            System.out.println("tu err");
//
//            for (T[] row : values){
//                System.out.print("[");
//             for (T t : row){
//                 Ulamek u = (Ulamek) t;
//                 System.out.print(" " + u.getLicznik() + " / " + u.getMianownik() + " ");
//             }
//                System.out.println("]");
//            }
//
//            m[i] = values[i+k][k-1].doubleValue() / values[k-1][k-1].doubleValue();
//        }
//
////        System.out.println("m:" + Arrays.toString(m)); //ok
//
//
//        int mi = 0;
//        for (int i = k; i < values.length; i++){
//            for (int j = k-1; j < values[0].length; j++){
////                System.out.printf("[%d][%d]", i, j);
////                    System.out.println(mi);
//                Double val = values[i][j].doubleValue() -
//                        (values[k-1][j].doubleValue() * m[mi]);
//                T val_t = convertToType(clazz, String.valueOf(val));
//                values[i][j] = val_t;
//            }
//
//            Double valB = b[i][0].doubleValue() - (m[mi] * b[k-1][0].doubleValue());
//            b[i][0] = convertToType(clazz, String.valueOf(valB));
//
//            mi++;
//        }
//
//        return b;
//    }
//
//
//    private T[][] gaussPGkrok1(){
//
//        T[][] b1 = b;
//        for (int k = 0; k < values.length-1; k++){
//            int p = maxCol(k);
//            if (k != p){
//                //zamie?? miejscami
//                T[] rowK = values[k];
//                T[] rowP = values[p];
//                values[k] = rowP;
//                values[p] = rowK;
//                T temp_bk = b1[k][0];
//                b1[k][0] = b1[p][0];
//                b1[p][0] = temp_bk;
//            }
//            b1 = this.k1(k+1);
//        }
//
//        return b1;
//    }
//
//    public T[][] solveGaussPG(){
//        T[][] b1 = this.gaussPGkrok1();
//        T[][] result = this.gaussKrok2();
//
//        return result;
//    }
//
//    private int maxCol(int col){
//        int maxCol = col;
//        double max = values[0][0].doubleValue();
//        for (int i = col; i < values[0].length; i++){
//            if (Math.abs(values[i][col].doubleValue()) > max){
//                maxCol = i;
//            }
//        }
//
//        return maxCol;
//    }
//
//    private Integer[] gaussFGkrok1(){
//        System.out.println("FGkrok1");
//
//        T[][] b1 = b;
//        int[] Q = IntStream.rangeClosed(0, values.length-1).toArray(); //values.len
//
//
//        for (int k = 0; k < values.length; k++){
//            int[] t = maxInRange(values, k);
//            int p = t[0];
//            int kol = t[1];
//
//
//
//            b1 = switchRow(b1, k, p);
//
//
//
//            for (int l = 0; l < values.length; l++){
//
//
//                if (!Arrays.equals(t, new int[]{k, l})){
//                    int temp = Q[k];
//                    Q[k] = Q[kol];
//                    Q[kol] = temp;
//
//
//                    switchCol(k, kol);
//
//                    for (T[] row : values){
//                        System.out.print("[");
//                        for (T tt : row){
//                            Ulamek u = (Ulamek) tt;
//                            System.out.print(" " + u.getLicznik() + " / " + u.getMianownik() + " ");
//                        }
//                        System.out.println("]");
//                    }
//
//                    break;
//                }
//            }
//
//
//            System.out.println("tu zaraz k1");
//
//            for (T[] row : values){
//                System.out.print("[");
//                for (T tt : row){
//                    Ulamek u = (Ulamek) tt;
//                    System.out.print(" " + u.getLicznik() + " / " + u.getMianownik() + " ");
//                }
//                System.out.println("]");
//            }
//            b1 = k1(k+1);
//        }
//
////        Integer[] q = IntStream.of( Q ).boxed().toArray( Integer[]::new );
//        Integer[] q = new Integer[Q.length];
//        for (int i = 0; i < Q.length; i++) q[i] = Q[i];
////        Number[][] d = new Number[][]{b1, q};
//
//        return q;
//    }
//
//
//
//    private T[][] switchRow(T[][] B, int k, int p){
//        T[] rowK = values[k];
//        T[] rowP = values[p];
//        values[k] = rowP;
//        values[p] = rowK;
//        T temp_bk = B[k][0];
//        B[k][0] = B[p][0];
//        B[p][0] = temp_bk;
//
//        return B;
//    }
//
//    public void switchCol(int k, int kol){
////        Double[] col1 = new Double[values.length];
////        Double[] col2 = new Double[values.length];
////
////        for (int i = k; i < values.length; i++){
////            col1[i] = values[i][k].doubleValue();
////            col2[i] = values[i][kol].doubleValue();
////        }
////        for (int i = k; i < values.length; i++){
////            values[i][k] = convertToType(clazz, String.valueOf(col2[i]));
////            values[i][kol] = convertToType(clazz, String.valueOf(col1[i]));
////        }
////        T[] col1 = new T[values.length];
////        T[] col2 = new T[values.length];
//        T[] col1 = (T[]) Array.newInstance(clazz, values.length);
//        T[] col2 = (T[]) Array.newInstance(clazz, values.length);
//
//        for (int i = 0; i < values.length; i++){
//            col1[i] = values[i][k];
//            col2[i] = values[i][kol];
//        }
//        if (clazz.equals(Ulamek.class)){
//            for (int i = 0; i < values.length; i++){
//                values[i][k] = col2[i];
//                values[i][kol] = col1[i];
//            }
//        }else {
//            for (int i = 0; i < values.length; i++){
//                values[i][k] = convertToType(clazz, String.valueOf(col2[i]));
//                values[i][kol] = convertToType(clazz, String.valueOf(col1[i]));
//            }
//        }
//
//    }
//
//    private int[] maxInRange(T[][] vals, int k){
////        Double max = vals[k][k].doubleValue();
//        double max = vals[k][k].doubleValue();
//
//        int[] maxCords = new int[]{k,k};
//
//        for (int i = k; i < vals.length; i++){
//            for (int j = k; j < vals[0].length; j++){
//                if (vals[i][j].doubleValue() > max){
//                    max = vals[i][j].doubleValue();
//                    maxCords = new int[]{i, j};
//                }
//            }
//        }
//
//        return maxCords;
//    }
//
//    public static void main(String[] args) {
//        Double[][] arr1 = new Double[][]{
//                {1.0, 2.0, 3.0, 4.0, 5.0},
//                {0.0, 1.0, 2.0, 3.0, 4.0},
//                {0.0, 0.0, 2.0, 2.0, 3.0},
//                {0.0, 0.0, 0.0, 3.0, 2.0},
//                {0.0, 0.0, 0.0, 0.0, 4.0},
//        };
//        Double[][] y1 = new Double[][]{
//                {2.0},
//                {8.0},
//                {8.0},
//                {8.0},
//                {8.0},
//        };
//
//
////        MojaMacierz<Double> m3 = new MojaMacierz<>(arr1, Double.class);
////        MojeRownanie<Double> r1 = new MojeRownanie<>(m3, y1, Double.class);
////        r1.switchCol(3,4);
////        for (Double[] row : r1.getValues()){
////            System.out.println(Arrays.toString(row));
////        };
//    }
//
//
//}
