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
        Ulamek u1 = new Ulamek(1);
        Ulamek u2 = new Ulamek(2);
        Ulamek u3 = new Ulamek(3);
        Ulamek u4 = new Ulamek(4);
//        System.out.println(u1.getLicznik());
//        System.out.println(u1.getMianownik());
        Ulamek[][] uu = new Ulamek[][]{
                {u1, u2},
                {u3, u4}
        };
//        Ulamek[][] uu = new Ulamek[][]{
//                {u}
//        };
//        System.out.println(uu[0][0].doubleValue());
//        MojaMacierz2<Ulamek> mu1 = new MojaMacierz2<Ulamek>(uu, Ulamek.class);
//        MojaMacierz2<Ulamek> mu2 = new MojaMacierz2<>(uu, Ulamek.class);
//        System.out.println(mu1.getValues()[0][0].doubleValue()); //ok
//        System.out.println(mu2.getValues()[0][0].doubleValue()); //ok
//        MojaMacierz2<Ulamek> mu3 = mu1.multiply(mu2);
//
//        System.out.println(mu3.getValues()[0][0].doubleValue()); //ok

//        MojaMacierz<Ulamek> mu4 = mu1.multiply(mu2);
//        System.out.println(mu4.getValues()[0][0].doubleValue()); //nie ok

//        Ulamek ul1 = new Ulamek(1);
//        Ulamek ul2 = new Ulamek(3);
//        Ulamek ul3 = (Ulamek) ul1.multiply(ul2);
//        System.out.println(ul3.getLicznik() + " / " + ul3.getMianownik());


        //---- ulamek gauss ---

        Ulamek[][] ul_arr1 = new Ulamek[][]{
                {new Ulamek(0.0), new Ulamek(1.0)},
                {new Ulamek(2.0), new Ulamek(3.0)}
        };
        Ulamek[][] ul_y1 = new Ulamek[][]{
                {new Ulamek(2.0)},
                {new Ulamek(8.0)}
        };

        MojaMacierz2<Ulamek> mu1 = new MojaMacierz2<>(ul_arr1, Ulamek.class);
        MojeRownanie3<Ulamek> ru1 = new MojeRownanie3<>(mu1, ul_y1, Ulamek.class);
        Ulamek[][] rozu = ru1.solveGaussFG();

//        for (Ulamek[] row : ru1.getB()){
//            System.out.print("[");
//         for (Ulamek u : row){
//             System.out.print(" " + u.getLicznik() + " / " + u.getMianownik() + " ");
//         }
//            System.out.println("]");
//        }



//        Ulamek[][] m6 = ru1.solveGaussFG();
//        for (Ulamek[] row : m6){
//            System.out.print("[");
//         for (Ulamek u : row){
//             System.out.print(" " + u.getLicznik() + " / " + u.getMianownik() + " ");
//         }
//            System.out.println("]");
//        }






        // ----- czemu FG nie działa ---------



        MojaMacierz<Double> m4 = new MojaMacierz<>(arr7, Double.class);
//        MojeRownanie<Double> r2 = new MojeRownanie<>(m4, b2, Double.class);
//        Double[][] m6 = r2.solveGaussFG();

//        for (Double[] row : m6){
//            System.out.println(Arrays.toString(row));
//        }



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


//        MojaMacierz<Double> m3 = new MojaMacierz<>(arr1, Double.class);
//        MojeRownanie<Double> r1 = new MojeRownanie<>(m3, y1, Double.class);
//        Double[][] m5 = r1.solveGaussFG();

//        for (Double[] row : m5){
//            System.out.println(Arrays.toString(row));
//        }
    }
}
