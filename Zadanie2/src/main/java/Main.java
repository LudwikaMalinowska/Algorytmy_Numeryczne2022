import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Double[][] arr7 = new Double[][]{
                {2.0,4.0,2.0, 0.0},
                {1.0,0.0,-1.0,1.0},
                {0.0,1.0,3.0, -1.0},
                {2.0,1.0,2.0, 1.0},

        };
        Double[] b2 = new Double[]{4.0,2.0,0.0,6.0};

        MojaMacierz<Double> m1 = new MojaMacierz<>(arr7);
        MojeRownanie<Double> r1 = new MojeRownanie<>(m1, b2);
        Double[] solved1 = r1.solveGaussPG();

        System.out.println();
        for (Double[] row : m1.getValues()){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nb:" + Arrays.toString(solved1));



    }
}
