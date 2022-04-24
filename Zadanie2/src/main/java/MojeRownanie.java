import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MojeRownanie<T extends Number> {
    private final T[][] originalMatrix;
    private final T[][] originalB;
    private final T[][] values;
    private final T[][] b;

    public MojeRownanie(MojaMacierz<T> values, T[][] b) {
        this.originalMatrix = values.getValues();
        this.originalB = b;
        this.values = values.getValues();
        this.b = b;
    }

    public T[][] getOriginalMatrix() {
        return originalMatrix;
    }

    public T[][] getOriginalB() {
        return originalB;
    }

    public T[][] getValues() {
        return values;
    }

    public T[][] getB() {
        return b;
    }

    public Double[] solveGaussFG(){
        Integer[] Q = this.gaussFGkrok1();
//        T[] b1 = (T[]) r[0];
//        Integer[] Q = (Integer[]) r[1];

        Double[] result = this.gaussKrok2();
        System.out.println("Q: " + Arrays.toString(Q));

        Double[] res1 = new Double[values[0].length];
        List<Integer> Qlist = Arrays.asList(Q);
        for (int i = 0; i < values[0].length; i++){
            int idx = Qlist.indexOf(i);
            res1[i] = result[idx];
        }

        System.out.println("res:" + Arrays.toString(result));
        System.out.println("res1:" + Arrays.toString(res1));
        return res1;
    }


    private T[][] elGaussKrok1(){
        T[][] b1 = b;
        for (int k = 1; k <= values.length; k++){
            b1 = this.k1(k);
        }

        return b;
    }

    private Double[] gaussKrok2(){
        Double[] x = new Double[b.length];
        int i = values.length;
        int j = values[0].length;
        double Bn = b[b.length-1][0].doubleValue();
        double Ann = values[i-1][j-1].doubleValue();
        //Xn
        x[x.length-1] = Bn / Ann;
        for (int k = x.length-2; k >= 0 ; k--){
            System.out.println(k);
            double bk = b[k][0].doubleValue();
            double akk = values[k][k].doubleValue();
            double sum = 0;
            for (int n = k; n < values[0].length-1; n++){
                double ak = values[k][n+1].doubleValue();
                sum += ak * x[n+1];
            }

            x[k] = (bk - sum) / akk;
        }

        return x;
    }

    public Double[] solveGaussG(){
        T[][] b2 = this.elGaussKrok1();
        Double[] result = this.gaussKrok2();

        return result;
    }

    private T[][] k1(int k){
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

            Double valB = b[i][0].doubleValue() - (m[mi] * b[k-1][0].doubleValue());
            b[i][0] = (T) valB;

            mi++;
        }

        return b;
    }


    private T[][] gaussPGkrok1(){

        T[][] b1 = b;
        for (int k = 0; k < values.length-1; k++){
            int p = maxCol(k);
            if (k != p){
                //zamień miejscami
                T[] rowK = values[k];
                T[] rowP = values[p];
                values[k] = rowP;
                values[p] = rowK;
                T temp_bk = b1[k][0];
                b1[k][0] = b1[p][0];
                b1[p][0] = temp_bk;
            }
            b1 = this.k1(k+1);
        }

        return b1;
    }

    public Double[] solveGaussPG(){
        T[][] b1 = this.gaussPGkrok1();
        Double[] result = this.gaussKrok2();

        return result;
    }

    private int maxCol(int col){
        int maxCol = col;
        double max = values[0][0].doubleValue();
        for (int i = col; i < values[0].length; i++){
            if (Math.abs(values[i][col].doubleValue()) > max){
                maxCol = i;
            }
        }

        return maxCol;
    }

    private Integer[] gaussFGkrok1(){
        T[][] b1 = b;
        int[] Q = new int[]{0,1,2,3}; //values.len

        for (int k = 0; k < values.length; k++){
            int[] t = maxInRange(values, k);
            int p = t[0];
            int kol = t[1];

            b1 = switchRow(b1, k, p);

            if (!Arrays.equals(t, new int[]{k, k})){
                switchCol(k, kol);

                int temp = Q[k];
                Q[k] = Q[kol];
                Q[kol] = temp;
            }


            b1 = k1(k+1);
        }

        Integer[] q = IntStream.of( Q ).boxed().toArray( Integer[]::new );
//        Number[][] d = new Number[][]{b1, q};

        return q;
    }



    private T[][] switchRow(T[][] B, int k, int p){
        T[] rowK = values[k];
        T[] rowP = values[p];
        values[k] = rowP;
        values[p] = rowK;
        T temp_bk = B[k][0];
        B[k][0] = B[p][0];
        B[p][0] = temp_bk;

        return B;
    }

    private void switchCol(int k, int kol){
        Double[] col1 = new Double[values.length];
        Double[] col2 = new Double[values.length];

        for (int i = k; i < values.length; i++){
            col1[i] = values[i][k].doubleValue();
            col2[i] = values[i][kol].doubleValue();
        }
        for (int i = k; i < values.length; i++){
            values[i][k] = (T) col2[i];
            values[i][kol] = (T) col1[i];
        }
    }

    private int[] maxInRange(T[][] vals, int k){
        Double max = vals[k][k].doubleValue();
        int[] maxCords = new int[]{k,k};

        for (int i = k; i < vals.length; i++){
            for (int j = k; j < vals[0].length; j++){
                if (vals[i][j].doubleValue() > max){
                    max = vals[i][j].doubleValue();
                    maxCords = new int[]{i, j};
                }
            }
        }

        return maxCords;
    }



}
