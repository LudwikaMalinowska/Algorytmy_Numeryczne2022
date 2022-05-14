import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Double[][] arr7 = new Double[][]{
//                {2.0,4.0,2.0, 0.0},
//                {1.0,0.0,-1.0,1.0},
//                {0.0,1.0,3.0, -1.0},
//                {2.0,1.0,2.0, 1.0},
//
//        };
//        Double[][] b2 = new Double[][]{
//                {4.0},{2.0},{0.0},{6.0}};

        Double[][] arr7 = new Double[][]{
                {2.0,4.0,2.0, 0.0, 1.0},
                {1.0,0.0,-1.0,1.0, 2.0},
                {0.0,1.0,3.0, -1.0, 0.0},
                {2.0,1.0,2.0, 1.0, -1.0},
                {1.0,1.0,-2.0, 2.0, -3.0},

        };
        Double[][] b2 = new Double[][]{
                {4.0},{2.0},{0.0},{6.0}, {5.0}};


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

        //--------- ulamki ----------
//        long rand = TestMacierz.randomLong();
//        Ulamek u = new Ulamek(rand);
//        System.out.println(u.getLicznik());
//        System.out.println(u.getMianownik());
//        Ulamek[][] uu = new Ulamek[][]{
//                {u, u},
//                {u, u}
//        };
//        Ulamek[][] uu = new Ulamek[][]{
//                {u}
//        };
//        System.out.println(uu[0][0].doubleValue());
//        MojaMacierz<Ulamek> mu1 = new MojaMacierz<>(uu, Ulamek.class);
//        MojaMacierz<Ulamek> mu2 = new MojaMacierz<>(uu, Ulamek.class);
//        MojaMacierz<Ulamek> mu3 = mu1.add(mu2);
//        System.out.println(mu3.getValues()[0][0].doubleValue()); //ok
//        MojaMacierz<Ulamek> mu4 = mu1.multiply(mu2);
//        System.out.println(mu4.getValues()[0][0].doubleValue()); //nie ok

        // ----- czemu FG nie działa ---------



        MojaMacierz<Double> m4 = new MojaMacierz<>(arr7, Double.class);
        MojeRownanie<Double> r2 = new MojeRownanie<>(m4, b2, Double.class);
        Double[][] m6 = r2.solveGaussFG();

        for (Double[] row : m6){
            System.out.println(Arrays.toString(row));
        }



//        Double[][] arr2 = new Double[][]{
//                {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//                {2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 1.0},
//                {3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 1.0, 2.0},
//                {4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//                {5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//                {6.0, 7.0, 8.0, 9.0, 10.0},
//                {5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//                {4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//                {3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//                {2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//        };
//        Double[][] arr2 = new Double[][]{
//                {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0},
//                {2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 9.0},
//                {3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 9.0, 8.0},
//                {4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 9.0, 8.0, 7.0},
//                {5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 9.0, 8.0, 7.0, 6.0},
//                {6.0, 7.0, 8.0, 9.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0},
//                {7.0, 8.0, 9.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0},
//                {8.0, 9.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0},
//                {9.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0},
//                {10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0},
//        };
//
//        Double[][] y3 = new Double[][]{
//                {1.0}, {6.0}, {3.0}, {1.0}, {5.0}, {2.0},
//                {7.0}, {8.0}, {9.0}, {10.0}
//        };

//        Double[][] arr2 = new Double[][]{
//                {0.0}
//        };
//
//
//        MojaMacierz<Double> m7 = new MojaMacierz<>(arr2, Double.class);
//        MojeRownanie<Double> r3 = new MojeRownanie<>(m7, y3, Double.class);
//        Double[][] m8 = r3.solveGaussFG();
//
//        for (Double[] row : m8){
//            System.out.println(Arrays.toString(row));
//        }


        Double[][] arr1 = new Double[][]{
                {0.0, 1.0},
                {2.0, 3.0}
        };
        Double[][] y1 = new Double[][]{
                {2.0},
                {8.0}
        };


        MojaMacierz<Double> m3 = new MojaMacierz<>(arr1, Double.class);
        MojeRownanie<Double> r1 = new MojeRownanie<>(m3, y1, Double.class);
//        Double[][] m5 = r1.solveGaussFG();

//        for (Double[] row : m5){
//            System.out.println(Arrays.toString(row));
//        }
    }
}
