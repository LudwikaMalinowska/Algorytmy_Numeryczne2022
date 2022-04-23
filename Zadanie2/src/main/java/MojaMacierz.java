

//przyjmuje dowolny typ liczby, ale z uwagi na to jak zaimplementowane są liczby w
// javie, oraz że typy generyczne nie są przystosowane do matematyki
// metody zwracają double
public class MojaMacierz<T extends Number> {
    private final T[][] values;

    public MojaMacierz(T[][] values) {
        this.values = values;
    }

    public T[][] getValues() {
        return values;
    }

    private MojaMacierz<T> convert(Double[][] m1){
        return new MojaMacierz<T>((T[][]) m1);
    }



    public MojaMacierz<T> add(MojaMacierz<T> otherMatrix){
        T[][] other = otherMatrix.getValues();
        //takie same wymiary
        if (values.length != other.length || values[0].length != other[0].length)
            throw new RuntimeException();

        Double[][] result = new Double[values.length][values.length];

        for (int i = 0; i < values.length; i++){
            for (int j = 0; j < values[0].length; j++){
                result[i][j] = (values[i][j].doubleValue() + other[i][j].doubleValue());
            }
        }

        return this.convert(result);
    }

    public MojaMacierz<T> multiply(MojaMacierz<T> otherMatrix){
        T[][] other = otherMatrix.getValues();
        if (values[0].length != other.length) throw new RuntimeException();
        Double[][] result = new Double[values.length][other[0].length];

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++){

                double sum = 0;
                for (int p = 0; p < values[0].length; p++){
                    sum += values[i][p].doubleValue() * other[p][j].doubleValue();
                }
                result[i][j] = sum;
            }
        }
        return this.convert(result);
    }

    public Double[] multiply(Double[] vector){
        if (vector.length != values[0].length) throw new RuntimeException();

        Double[] result = new Double[values.length];

        for (int i = 0; i < result.length; i++){
            double sum = 0;
            for (int j = 0; j < values[0].length; j++){
                sum += values[i][j].doubleValue() * vector[j];
            }
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        Double[][] arr1 = new Double[][]{
                {1.0, 1.0},
                {1.0, 1.0},
        };
        Double[][] arr2 = new Double[][]{
                {1.0, 1.0},
                {1.0, 1.0},
        };
        Double[][] arr4 = new Double[][]{
                {1.2, 2.6 ,-0.1, 1.5},
                {4.5, 9.8, -0.4, 5.7},
                {0.1, -0.1, -0.3, -3.5},
                {4.5, -5.2, 4.2, -3.4},
        };

        Integer[][] arr5 = new Integer[][]{
                {1,2,3,1},
                {4,5,6,2},
                {7,8,9,3}

        };
        Integer[][] arr6 = new Integer[][]{
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},

        };
        Double[][] arr7 = new Double[][]{
                {2.0,4.0,2.0, 0.0},
                {1.0,0.0,-1.0,1.0},
                {0.0,1.0,3.0, -1.0},
                {2.0,1.0,2.0, 1.0},

        };
        Double[] b2 = new Double[]{4.0,2.0,0.0,6.0};

        Double[][] arr8 = new Double[][]{
                {0.0, 1.0},
                {2.0, 3.0}

        };
        Double[] b3 = new Double[]{2.0, 8.0};

        MojaMacierz<Double> m1 = new MojaMacierz<>(arr7);
    }
}
