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

        MojaMacierz<Double> m1 = new MojaMacierz<>(arr7, Double.class);


        Double[][] arr8 = new Double[][]{
                {2.0,4.0,2.0, 0.0},
                {1.0,0.0,-1.0,1.0},
                {0.0,1.0,3.0, -1.0},
                {2.0,1.0,2.0, 1.0},

        };
        Double[][] arr9 = new Double[][]{
                {2.0},
                {1.0},
                {-1.0},
                {2.0},

        };
//        MojaMacierz<Double> m3 = new MojaMacierz<>(arr9, Double.class);
//        MojaMacierz<Double> m4 = new MojaMacierz<>(arr9, Double.class);
//
//        MojaMacierz<Double> m2 = m3.subtract(m4);
//        for (Double[] row : m2.getValues()){
//            System.out.println(Arrays.toString(row));
//        }

        long rand = TestMacierz.randomLong();
        Ulamek u = new Ulamek(rand);
        System.out.println(u.getLicznik());
        System.out.println(u.getMianownik());
        Ulamek[][] uu = new Ulamek[][]{
                {u, u},
                {u, u}
        };
//        Ulamek[][] uu = new Ulamek[][]{
//                {u}
//        };
        System.out.println(uu[0][0].doubleValue());
        MojaMacierz<Ulamek> mu1 = new MojaMacierz<>(uu, Ulamek.class);
        MojaMacierz<Ulamek> mu2 = new MojaMacierz<>(uu, Ulamek.class);
        MojaMacierz<Ulamek> mu3 = mu1.add(mu2);
        System.out.println(mu3.getValues()[0][0].doubleValue()); //ok
        MojaMacierz<Ulamek> mu4 = mu1.multiply(mu2);
        System.out.println(mu4.getValues()[0][0].doubleValue()); //nie ok

    }
}
