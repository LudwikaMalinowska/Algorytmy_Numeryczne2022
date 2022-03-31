package algNum;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Zadanie1 {

    private static int elements = 10;


    public static void main(String[] args) {

        double[] arrayX = new double[1_000_000];
        double start = - Math.PI ;
        double end = Math.PI;
        double len = Math.PI;
        arrayX[0] = start;
        double df = (end - start) / arrayX.length;
        System.out.println(arrayX[0]);
        for (int i = 1; i < arrayX.length; i++){
            arrayX[i] = start + i * df;
        }


        double[] arr1 = countMistakeSinTAtanT(arrayX);
        double[] arr2 = countMistakeSinTAtanTBackwards(arrayX);
        double[] arr3 = countMistakeSinTAtanTFromPrev(arrayX);
        double[] arr4 = countMistakeSinTAtanTFromPrevBackwards(arrayX);

        double avgErr1 = countAvg(arr1);
        double avgErr2 = countAvg(arr2);
        double avgErr3 = countAvg(arr3);
        double avgErr4 = countAvg(arr4);

        System.out.println("Sredni blad dla metody 1 (sumowanie od początku): " + avgErr1);
        System.out.println("Sredni blad dla metody 2 (sumowanie od końca): " + avgErr2);
        System.out.println("Sredni blad dla metody 3: " + avgErr3);
        System.out.println("Sredni blad dla metody 4: " + avgErr4);

        saveToCsv(arrayX, arr1, arr2, arr3, arr4);

        printSampleData();
        pytanieQ2();
    }

    public static void pytanieQ2(){
        double[] arr = {0.05, 0.1, 0.15, 0.2};
        for (double val : arr){
            double sinT = sinTaylor(val);
            double arctgT = arctgTaylor(val);
            double sinTarctgT = sinT * arctgT;
            double mathSinMathAtan = Math.sin(val) * Math.atan(val);
            double diff = Math.abs(sinTarctgT - mathSinMathAtan);
            System.out.println(String.format("Argument: %.2f. Różnica: %.16f", val, diff));
        }
    }

    public static void saveToCsv(double[] arrX, double[] arr1, double[] arr2,
                                 double[] arr3, double[] arr4){
        StringBuilder sb = new StringBuilder();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.csv")))) {

            sb.append("x").append(",").append("sinArctg")
                    .append(",").append("sinArctg Backwards")
                    .append(",").append("sinArctg From Prev")
                    .append(",").append("sinArctg From Prev Backwards")
                    .append("\n");

            bw.write(sb.toString());
            sb.setLength(0);


            for (int i = 0; i < arr1.length; i++){
                sb.append(arrX[i]);
                sb.append(",");
                sb.append(arr1[i]);
                sb.append(",");
                sb.append(arr2[i]);
                sb.append(",");
                sb.append(arr3[i]);
                sb.append(",");
                sb.append(arr4[i]);

                bw.write(sb.toString() + "\n");
                sb.setLength(0);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static double countAvg(double[] arr){
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        double avg = sum / arr.length;
        return avg;
    }




    //1.
    public static double[] countMistakeSinTAtanT(double[] args){
        double[] sinAtanMistakeArr = new double[args.length];

        for (int i = 0; i < sinAtanMistakeArr.length; i++){
            double val = args[i];
            double sinT = sinTaylor(val);
            double arctgT = arctgTaylor(val);
            double sinTarctgT = sinT * arctgT;
            double mathSinMathAtan = Math.sin(val) * Math.atan(val);

            double diff = Math.abs(sinTarctgT - mathSinMathAtan);

            sinAtanMistakeArr[i] = diff;
        }

        return sinAtanMistakeArr;
    }

    //2.
    public static double[] countMistakeSinTAtanTBackwards(double[] args){
        double[] sinAtanMistakeArr = new double[args.length];

        for (int i = 0; i < sinAtanMistakeArr.length; i++){
            double val = args[i];
            double sinT = sinTaylorReverse(val);
            double arctgT = arctgTaylorReverse(val);
            double sinTarctgT = sinT * arctgT;
            double mathSinMathAtan = Math.sin(val) * Math.atan(val);

            double diff = Math.abs(sinTarctgT - mathSinMathAtan);

            sinAtanMistakeArr[i] = diff;
        }

        return sinAtanMistakeArr;
    }

    //3.
    public static double[] countMistakeSinTAtanTFromPrev(double[] args){
        double[] sinAtanMistakeArr = new double[args.length];

        for (int i = 0; i < sinAtanMistakeArr.length; i++){
            double val = args[i];
            double sinT = sinTaylorFromPrev(val);
            double arctgT = arctgTaylorFromPrev(val);
            double sinTarctgT = sinT * arctgT;
            double mathSinMathAtan = Math.sin(val) * Math.atan(val);

            double diff = Math.abs(sinTarctgT - mathSinMathAtan);

            sinAtanMistakeArr[i] = diff;
        }

        return sinAtanMistakeArr;
    }

    //4.
    public static double[] countMistakeSinTAtanTFromPrevBackwards(double[] args){
        double[] sinAtanMistakeArr = new double[args.length];

        for (int i = 0; i < sinAtanMistakeArr.length; i++){
            double val = args[i];
            double sinT = sinTaylorFromPrevReverse(val);
            double arctgT = arctgTaylorFromPrevReverse(val);
            double sinTarctgT = sinT * arctgT;
            double mathSinMathAtan = Math.sin(val) * Math.atan(val);

            double diff = Math.abs(sinTarctgT - mathSinMathAtan);

            sinAtanMistakeArr[i] = diff;
        }

        return sinAtanMistakeArr;
    }

    public static double[] countArraySinTaylor(double[] args){
        double[] sinArr = new double[args.length];

        for (int i = 0; i < sinArr.length; i++){
            sinArr[i] = sinTaylor(args[i]);
        }

        return sinArr;
    }


    public static void printSampleData(){

//        double[] arr = {0.5, Math.PI};
        double[] arr = {0.5};
        for (double val: arr) {
            double sinT = sinTaylor(val);
            double arctgT = arctgTaylorFromPrev(val);
            double sinTarctgT = sinT * arctgT;
            double mathSinMathAtan = Math.sin(val) * Math.atan(val);
            double diff = Math.abs(sinTarctgT - mathSinMathAtan);
            double diff2 = Math.abs(arctgT - Math.atan(val));
            System.out.println(String.format("---------\nval = %.4f", val));
            System.out.println(String.format("sinTaylor(%.4f) = %.16f, Math.sin(%.4f) = %.16f",
                    val, sinT,
                    val, Math.sin(val)));
            System.out.println(String.format("arctgTaylor(%.4f) = %.16f, Math.atan(%.4f) = %.16f",
                    val, arctgT,
                    val, Math.atan(val)));
            System.out.println(String.format("sinT(%.4f) * arctgT(%.4f) = %.16f \n" +
                            "Math.sin(%.4f) * Math.atan(%.4f) = %.16f\n",
                    val, val, sinTarctgT,
                    val, val, mathSinMathAtan));
            System.out.println(String.format("Różnica: %.16f", diff));
            System.out.println(String.format("Różnica: %.16f", diff2));

            double sinT_rev = sinTaylorReverse(val);
            double arctgT_rev = arctgTaylorFromPrevReverse(val);
            double sinTarctgT_rev = sinT_rev * arctgT_rev;
            double diff_2 = Math.abs(sinTarctgT_rev - mathSinMathAtan);
            double diff3 = Math.abs(arctgT_rev - Math.atan(val));
            System.out.println(String.format("***Reverse***\nval = %.4f", val));
            System.out.println(String.format("sinTaylorRev(%.4f) = %.16f, Math.sin(%.4f) = %.16f",
                    val, sinT_rev,
                    val, Math.sin(val)));
            System.out.println(String.format("arctgTaylorRev(%.4f) = %.16f, Math.atan(%.4f) = %.16f",
                    val, arctgT_rev,
                    val, Math.atan(val)));
            System.out.println(String.format("sinTRev(%.4f) * arctgTRev(%.4f) = %.16f \n" +
                            "Math.sin(%.4f) * Math.atan(%.4f) = %.16f\n",
                    val, val, sinTarctgT_rev,
                    val, val, mathSinMathAtan));
            System.out.println(String.format("Różnica: %.16f", diff_2));
            System.out.println(String.format("Różnica: %.16f", diff3));


            System.out.println("diff_2 < diff: " + (diff_2 < diff));


        }
    }

    public static double[] sinTaylorTab(double x){
        double[] sinTab = new double[elements]; //10
        sinTab[0] = x;
        for (int i = 1; i < elements; i++){
            int y = i*2+1;
            double licznik = pow(x, y);
            double mianownik = silnia(y);

            if (i % 2 == 0) {
                sinTab[i] = licznik/mianownik;
            } else {
                sinTab[i] = (-1) * (licznik/mianownik);
            }
        }

        return sinTab;
    }

//    public static double sinTaylor(double x){
//        double sum = x;
//        for (int i = 1; i < 10; i++){
//            int y = i*2+1;
//            double licznik = pow(x, y);
//            double mianownik = silnia(y);
//
//            if (i % 2 == 0) {
//                sum += licznik/mianownik;
//            } else {
//                sum -= licznik/mianownik;
//            }
//        }
//
//        return sum;
//    } //end method

    public static double sinTaylor(double x){
        double[] sinTab = sinTaylorTab(x);
        double sum = 0;
        for (double val : sinTab){
            sum += val;
        }

        return sum;
    }

    public static double sinTaylorReverse(double x){
        double[] sinTab = sinTaylorTab(x);
        double sum = 0;
        for (int i = elements - 1; i >= 0; i--){
            sum += sinTab[i];
        }

        return sum;
    }

    public static double[] sinTaylorFromPrevTab(double x){ //ok
        double[] sinTaylor = new double[elements];
        sinTaylor[0] = x;
        double prev = x;
        for (int i = 1; i < 10; i++){
            if (i == 1){
                double licznik = pow(x, 3);
                double mianownik = 2 * 3;
                sinTaylor[i] = (-1) * licznik/mianownik;
                prev = licznik/mianownik;
            } else {
                int y = i*2+1;
                double delta = pow(x, 2) / (y * (y-1));
                double curr = prev * delta;
                if (i % 2 == 0){
                    sinTaylor[i] = curr;
                } else {
                    sinTaylor[i] = (-1) * curr;
                }
                prev = curr;
            }
        }

        return sinTaylor;
    } //end method

    public static double sinTaylorFromPrev(double x){
        double[] sinTab = sinTaylorFromPrevTab(x);
        double sum = 0;
        for (double val : sinTab){
            sum += val;
        }

        return sum;
    }

    public static double sinTaylorFromPrevReverse(double x){
        double[] sinTab = sinTaylorFromPrevTab(x);
        double sum = 0;
        for (int i = elements-1; i >= 0; i--){
            sum += sinTab[i];
        }

        return sum;
    }

//    public static double sinTaylorFromPrev(double x){ //ok
//        double sum = x;
//        double prev = x;
//        for (int i = 1; i < 10; i++){
//            if (i == 1){
//                double licznik = pow(x, 3);
//                double mianownik = 2 * 3;
//                sum -= licznik/mianownik;
//                prev = licznik/mianownik;
//            } else {
//                int y = i*2+1;
//                double delta = pow(x, 2) / (y * (y-1));
//                double curr = prev * delta;
//                if (i % 2 == 0){
//                    sum += curr;
//                } else {
//                    sum -= curr;
//                }
//                prev = curr;
//            }
//        }
//
//        return sum;
//    } //end method

//
//    public static double sinTaylorReverse(double x){
//        double sum = x;
//        for (int i = 9; i > 0; i--){
//            int y = i*2+1;
//            double licznik = pow(x, y);
//            double mianownik = 1;
//            for (int j = 1; j <= i*2 + 1; j++){
//                mianownik *= j;
//            }
//
//            if (i % 2 == 0) {
//                sum += licznik/mianownik;
//            } else {
//                sum -= licznik/mianownik;
//            }
//        }
//
//        return sum;
//    } //end method

//    public static double sinTaylorFromPrevReverse(double x){ //ok
//        if (x == 0.0) return 0.0;
//        double sum = 0;
//        double prev = 0;
//        for (int i = 9; i >= 0; i--){
//            if (i == 9){
//                int y = 2*i +1;
//                double licznik = pow(x, y);
//                double mianownik = silnia(y);
//                sum += pow(-1, y) *  (licznik/mianownik);
//                prev = licznik/mianownik;
//            } else {
//                int y = i*2+1;
//                double delta = ((y+2) * (y+1)) / pow(x, 2);
//                double curr = prev * delta;
//                if (i % 2 == 0){
//                    sum += curr;
//                } else {
//                    sum -= curr;
//                }
//                prev = curr;
//            }
//        }
//
//        return sum;
//    } //end method

    public static double[] arcTaylorTab(double x){
        double[] arcTgTab = new double[elements];
        if (-1 < x && x < 1){
            for (int i = 0; i < elements; i++){
                double licznik = pow(x, 2*i + 1);
                double mianownik = 2*i + 1;
                arcTgTab[i] = pow(-1, i) * licznik / mianownik;
            }
        } else {
            for (int i = 0; i < elements; i++) {
                double licznik = 1;
                double mianownik = (2 * i + 1) * pow(x, 2 * i + 1);
                arcTgTab[i] = pow(-1, i) * licznik / mianownik;
            }
        }

        return arcTgTab;
    }

    public static double arctgTaylor(double x){
        double[] arctgTab = arcTaylorTab(x);
        double sum = 0;
        for (double val : arctgTab){
            sum += val;
        }

        if (x <= -1){
            sum =  (-1) * Math.PI / 2 - sum;
        }
        if (x >= 1) {
            sum = Math.PI / 2 - sum;
        }

        return sum;
    }

    public static double arctgTaylorReverse(double x){
        double[] arctgTab = arcTaylorTab(x);
        double sum = 0;
        for (int i = elements-1; i >= 0; i--){
            sum += arctgTab[i];
        }

        if (x <= -1){
            sum =  (-1) * Math.PI / 2 - sum;
        }
        if (x >= 1) {
            sum = Math.PI / 2 - sum;
        }

        return sum;
    }

    public static double[] arcTaylorTabFromPrev(double x){
        double[] arcTgTab = new double[elements];
        double prev;
        if (-1 < x && x < 1){
            arcTgTab[0] = x;
            prev = x;
            for (int i = 1; i < elements; i++){
                double prevMian = 2*(i-1)+1;
                double currMian = 2*i+1;
                double delta = pow(x, 2) * prevMian / currMian;
                double curr = prev * delta;
                arcTgTab[i] = pow(-1, i) * curr;
                prev = curr;
            }
        } else {
            prev = 0;
            for (int i = 0; i < elements; i++){
                if (i == 0) {
                    double curr = 1 / x;
                    arcTgTab[i] = curr;
                    prev = curr;
                } else {
                    double currY = 2*i + 1;
                    double prevY = 2*(i-1) + 1;
                    double delta = prevY / (currY * pow(x, 2));
                    double curr = prev * delta;
                    arcTgTab[i] = pow(-1, i) * curr;
                    prev = curr;
                }
            }
        }

        return arcTgTab;
    }

    public static double arctgTaylorFromPrev(double x){
        double[] arctgTab = arcTaylorTabFromPrev(x);
        double sum = 0;
        for (double val : arctgTab){
            sum += val;
        }

        if (x <= -1){
            sum =  (-1) * Math.PI / 2 - sum;
        }
        if (x >= 1) {
            sum = Math.PI / 2 - sum;
        }

        return sum;
    }

    public static double arctgTaylorFromPrevReverse(double x){
        double sum = 0;
        double[] arctgTab = arcTaylorTabFromPrev(x);
        for (int i = elements-1; i >= 0; i--){
            sum += arctgTab[i];
        }

        if (x <= -1){
            sum =  (-1) * Math.PI / 2 - sum;
        }
        if (x >= 1) {
            sum = Math.PI / 2 - sum;
        }

        return sum;
    }

//    public static double arctgTaylor(double x){
//        double sum = 0;
//        if (-1 < x && x < 1){
//            for (int i = 0; i < 10; i++){
//                double licznik = pow(x, 2*i + 1);
//                double mianownik = 2*i + 1;
//                sum += pow(-1, i) * licznik / mianownik;
//            }
//        } else {
//            for (int i = 0; i < 10; i++){
//                double licznik = 1;
//                double mianownik = (2*i + 1) * pow(x, 2*i + 1);
//                sum += pow(-1, i) * licznik / mianownik;
//            }
//
//            if (x <= -1) {
//                sum =  (-1) * Math.PI / 2 - sum;
//            } else if (x >= 1){
//                sum = Math.PI / 2 - sum;
//            }
//
//        }
//
//        return sum;
//    } //end method
//
//    public static double arctgTaylorFromPrev(double x){
//        double sum;
//        double prev;
//        if (-1 < x && x < 1){
//            sum = x;
//            prev = x;
//            for (int i = 1; i < 10; i++){
//                double prevMian = 2*(i-1)+1;
//                double currMian = 2*i+1;
//                double delta = pow(x, 2) * prevMian / currMian;
//                double curr = prev * delta;
//                sum += pow(-1, i) * curr;
//                prev = curr;
//            }
//        } else {
//            sum = 0;
//            prev = 0;
//            for (int i = 0; i < 10; i++){
//                if (i == 0) {
//                    double curr = 1 / x;
//                    sum += curr;
//                    prev = curr;
//                } else {
//                    double currY = 2*i + 1;
//                    double prevY = 2*(i-1) + 1;
//                    double delta = prevY / (currY * pow(x, 2));
//                    double curr = prev * delta;
//                    sum += pow(-1, i) * curr;
//                    prev = curr;
//                }
//
//            }
//
//            if (x <= -1) {
//                sum =  ((-1) * Math.PI / 2) - sum;
//            } else if (x >= 1){
//                sum = (Math.PI / 2) - sum;
//            }
//
//        }
//
//        return sum;
//    } //end method


//    public static double arctgTaylorReverse(double x){
//        double sum = 0;
//        if (-1 < x && x < 1){
//            for (int i = 9; i >= 0; i--){
//                int y = 2*i + 1;
//                double licznik = pow(x, y);
//                double mianownik = 2*i + 1;
//                sum += pow(-1, i) * (licznik / mianownik);
//            }
//        }
//        else {
//            for (int i = 9; i >= 0; i--){
//                double licznik = 1;
//                int y = 2*i + 1;
//                double mianownik = (2*i + 1) * pow(x, y);
//                sum += pow(-1, i) * (licznik / mianownik);
//            }
//
//            if (x <= -1) {
//                sum =  (-1) * Math.PI / 2 - sum;
//            } else if (x >= 1){
//                sum = Math.PI / 2 - sum;
//            }
//
//        }
//
//        return sum;
//    } //end method

//    public static double arctgTaylorFromPrevReverse(double x){
//        if (x == 0.0) return 0.0;
//        double sum;
//        double prev;
//        if (-1 < x && x < 1){
//            sum = 0;
//            prev = 0;
//            for (int i = 9; i > 0; i--){
//                if (i == 9) {
//                    int y = 2*i + 1;
//                    double licznik = pow(x, y);
//                    double mianownik = 2*i + 1;
//                    sum += pow(-1, i) * (licznik / mianownik);
//                    prev = licznik / mianownik;
//                }
//                else {
//                    double prevMian = 2*(i+1)+1;
//                    double currMian = 2*i+1;
//                    double delta = prevMian / (currMian * pow(x, 2));
//                    double curr = prev * delta;
//                    sum += pow(-1, i) * curr;
//                    prev = curr;
//                }
//
//            }
//
//            sum += x;
//        }
//        else {
//            sum = 0;
//            prev = 0;
//            for (int i = 9; i >= 0; i--){
//                if (i == 9) {
//                    int y = 2*i +1;
//                    double curr = 1 / (y * pow(x, y));
//                    sum += pow(-1, i) * curr;
//                    prev = curr;
//                } else {
//                    double currY = 2*i + 1;
//                    double prevY = 2*(i+1) + 1;
//                    double delta = (prevY / currY) * pow(x, 2);
//                    double curr = prev * delta;
//                    sum += pow(-1, i) * curr;
//                    prev = curr;
//                }
//
//            }
//
//            if (x <= -1) {
//                sum =  ((-1) * Math.PI / 2) - sum;
//            } else if (x >= 1){
//                sum = (Math.PI / 2) - sum;
//            }
//
//        }
//
//        return sum;
//    } //end method


    public static double pow(double num, int pow){
        if (pow == 0){
            return 1.0;
        } else {
            double wynik = 1;
            for (int j = 1; j <= pow; j++){
                wynik *= num;
            }

            return wynik;
        }
    }

    public static double silnia(int n){
        double result = 1;
        for (int i = n; i > 0; i--){
            result *= i;
        }
        return result;
    }
} //end class
