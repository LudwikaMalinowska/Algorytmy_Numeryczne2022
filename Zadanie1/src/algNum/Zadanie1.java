package algNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Zadanie1 {


    public static void main(String[] args) {

        double[] arr2 = new double[200];
        double a = -1;
        for (int i = 0; i < arr2.length; i++){
            arr2[i] = Math.round(a * 100.0) /100.0;
            a += 0.01;
        }
        System.out.println(Arrays.toString(arr2));


        double[] sinArr = countArraySinTaylor(arr2);
        double[] arctgArr = new double[200];

//        double[] sinArctgArr = new double[200];
        //+ tablice błędów dla SinArctg

        for (int i = 0; i < arr2.length; i++){
//            sinArr[i][0] = arr2[i];
//            sinArr[i][1] = sin
        }



    }

    public static double[] countArraySinTaylorBackwards(double[] args){
        double[] sinArr = new double[args.length];

//        ArrayList<Double> ar = new ArrayList<>(Arrays.asList(args));
//        ar.stream().map(e -> e*e).filter(e -> e < 10).collect(Collectors.toList());

        for (int i = 0; i < sinArr.length; i++){
            sinArr[i] = sinTaylorReverse(args[i]);
        }

        return sinArr;
    }

    public static double[] countArraySinTaylor(double[] args){
        double[] sinArr = new double[args.length];

        for (int i = 0; i < sinArr.length; i++){
            sinArr[i] = sinTaylor(args[i]);
        }

        return sinArr;
    }

    public static double[] countArraySinTaylorFromPrev(double[] args){
        double[] sinArr = new double[args.length];

        for (int i = 0; i < sinArr.length; i++){
            sinArr[i] = sinTaylor2(args[i]);
        }

        return sinArr;
    }

    public static double[] countArraySinTaylorFromPrevBackwards(double[] args){
        double[] sinArr = new double[args.length];

        for (int i = 0; i < sinArr.length; i++){
            sinArr[i] = sinTaylorReverse2(args[i]);
        }

        return sinArr;
    }

    public static double[] countArrayAtanTaylor(double[] args){
        double[] atanArr = new double[args.length];

        for (int i = 0; i < atanArr.length; i++){
            atanArr[i] = arctgTaylor(args[i]);
        }

        return atanArr;
    }

    public static double[] countArrayAtanTaylorBackwards(double[] args){
        double[] atanArr = new double[args.length];

        for (int i = 0; i < atanArr.length; i++){
            atanArr[i] = arctgTaylorReverse(args[i]);
        }

        return atanArr;
    }

    public static double[] countArrayAtanTaylorFromPrev(double[] args){
        double[] atanArr = new double[args.length];

        for (int i = 0; i < atanArr.length; i++){
            atanArr[i] = arctgTaylor2(args[i]);
        }

        return atanArr;
    }

    public static double[] countArrayAtanTaylorFromPrevBackwards(double[] args){
        double[] atanArr = new double[args.length];

        for (int i = 0; i < atanArr.length; i++){
            atanArr[i] = arctgTaylorReverse2(args[i]);
        }

        return atanArr;
    }

    public static void printSampleData(){

        double[] arr = {0.5, Math.PI/4, 1.5, -1.5, 2, 0.1};
//        double[] arr = {0.5};
        for (double val: arr) {
            double sinT = sinTaylor2(val);
            double arctgT = arctgTaylor2(val);
            double sinTarctgT = sinT * arctgT;
            double mathSinMathAtan = Math.sin(val) * Math.atan(val);
            double diff = Math.abs(sinTarctgT - mathSinMathAtan);
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
            double sinT_rev = sinTaylorReverse2(val);
            double arctgT_rev = arctgTaylorReverse2(val);
            double sinTarctgT_rev = sinT_rev * arctgT_rev;
            double diff_2 = Math.abs(sinTarctgT_rev - mathSinMathAtan);
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


            System.out.println("diff_2 < diff: " + (diff_2 < diff));


        }
    }

    public static double sinTaylor(double x){
        double sum = x;
        for (int i = 1; i <= 10; i++){
            int y = i*2+1;
            double licznik = pow(x, y);
            long mianownik = silnia(y);
//            double mianownik = 1;
//            for (int j = 1; j <= i*2 + 1; j++){
//                mianownik *= j;
//            }

//            System.out.println("x^" + y + " / " + y + "!  =  " + licznik + "/" + mianownik);

            if (i % 2 == 0) {
                sum += licznik/mianownik;
            } else {
                sum -= licznik/mianownik;
            }
        }

        return sum;
    } //end method

    public static double sinTaylor2(double x){ //ok
        double sum = x;
        double prev = x;
        for (int i = 1; i <= 10; i++){
            if (i == 1){
                double licznik = pow(x, 3);
                double mianownik = 2 * 3;
                sum -= licznik/mianownik;
                prev = licznik/mianownik;
            } else {
                int y = i*2+1;
                double delta = pow(x, 2) / (y * (y-1));
                double curr = prev * delta;
                if (i % 2 == 0){
                    sum += curr;
                } else {
                    sum -= curr;
                }
                prev = curr;
            }
        }

        return sum;
    } //end method


    public static double sinTaylorReverse(double x){
        double sum = x;
        for (int i = 10; i > 0; i--){
            int y = i*2+1;
            double licznik = pow(x, y);
            double mianownik = 1;
            for (int j = 1; j <= i*2 + 1; j++){
                mianownik *= j;
            }

            if (i % 2 == 0) {
                sum += licznik/mianownik;
            } else {
                sum -= licznik/mianownik;
            }
        }

        return sum;
    } //end method

    public static double sinTaylorReverse2(double x){ //ok
        double sum = 0;
        double prev = 0;
        for (int i = 9; i >= 0; i--){
            if (i == 9){
                int y = 2*i +1;
                double licznik = pow(x, y);
                long mianownik = silnia(y);
                System.out.println(licznik);
                System.out.println(mianownik);
//                System.out.println("silnia " + y + " = " + mianownik);
                sum += pow(-1, y) *  (licznik/mianownik);
                prev = licznik/mianownik;
//                System.out.println(prev);
            } else {
                int y = i*2+1;
                double delta = ((y+2) * (y+1)) / pow(x, 2);
                double curr = prev * delta;
//                System.out.println(curr);
                if (i % 2 == 0){
                    sum += curr;
                } else {
                    sum -= curr;
                }
                prev = curr;
            }
        }

        return sum;
    } //end method


    public static double arctgTaylor(double x){
        double sum = 0;
        if (-1 < x && x < 1){
            for (int i = 0; i < 10; i++){
                double licznik = pow(x, 2*i + 1);
                double mianownik = 2*i + 1;
//                System.out.println("pow = " + pow(-1, i));
                sum += pow(-1, i) * licznik / mianownik;
            }
        } else {
            for (int i = 0; i <= 10; i++){
                double licznik = 1;
                double mianownik = (2*i + 1) * pow(x, 2*i + 1);
                sum += pow(-1, i) * licznik / mianownik;
            }

            if (x <= -1) {
                sum =  (-1) * Math.PI / 2 - sum;
            } else if (x >= 1){
                sum = Math.PI / 2 - sum;
            }

        }

        return sum;
    } //end method

    public static double arctgTaylor2(double x){
        double sum;
        double prev;
        if (-1 < x && x < 1){
            sum = x;
            prev = x;
            for (int i = 1; i < 10; i++){
                double prevMian = 2*(i-1)+1;
                double currMian = 2*i+1;
                double delta = pow(x, 2) * prevMian / currMian;
                double curr = prev * delta;
                sum += pow(-1, i) * curr;
                prev = curr;
            }
        } else {
            sum = 0;
            prev = 0;
            for (int i = 0; i <= 10; i++){
                if (i == 0) {
//                    double mianownik = (2*i + 1) * pow(x, 2*i + 1);
                    double curr = 1 / x;
                    sum += curr;
                    prev = curr;
//                    System.out.println(curr);
                } else {
                    double currY = 2*i + 1;
                    double prevY = 2*(i-1) + 1;
                    double delta = prevY / (currY * pow(x, 2));
                    double curr = prev * delta;
                    sum += pow(-1, i) * curr;
//                    System.out.println(pow(-1, i+1)* curr);
//                    System.out.println("prev = " + prev + "\n delta = " + delta);
                    prev = curr;
                }

            }

            if (x <= -1) {
//                System.out.println("pi: " + (-1) * Math.PI / 2);
                sum =  ((-1) * Math.PI / 2) - sum;
            } else if (x >= 1){
                sum = (Math.PI / 2) - sum;
            }

        }

        return sum;
    } //end method


    public static double arctgTaylorReverse(double x){
        double sum = 0;
        if (-1 < x && x < 1){
            for (int i = 9; i >= 0; i--){
                int y = 2*i + 1;
                double licznik = pow(x, y);
                double mianownik = 2*i + 1;
                sum += pow(-1, i) * (licznik / mianownik);
            }
        }
        else {
            for (int i = 9; i >= 0; i--){
                double licznik = 1;
                int y = 2*i + 1;
                double mianownik = (2*i + 1) * pow(x, y);
                sum += pow(-1, i) * (licznik / mianownik);
            }

            if (x <= -1) {
                sum =  (-1) * Math.PI / 2 - sum;
            } else if (x >= 1){
                sum = Math.PI / 2 - sum;
            }

        }

//        return sum+1;
        return sum;
    } //end method

    public static double arctgTaylorReverse2(double x){
        double sum;
        double prev;
        if (-1 < x && x < 1){
            sum = 0;
            prev = 0;
            for (int i = 4; i > 0; i--){
                if (i == 4) {
                    int y = 2*i + 1;
                    double licznik = pow(x, y);
                    double mianownik = 2*i + 1;
                    sum += pow(-1, i) * (licznik / mianownik);
                    prev = licznik / mianownik;
//                    System.out.println(licznik / mianownik);
                }
                else {
                    double prevMian = 2*(i+1)+1;
                    double currMian = 2*i+1;
                    double delta = prevMian / (currMian * pow(x, 2));
                    double curr = prev * delta;
                    sum += pow(-1, i) * curr;
                    prev = curr;
//                    System.out.println(curr);
                }

            }

            sum += x;
        }
        else {
            sum = 0;
            prev = 0;
            for (int i = 4; i >= 0; i--){
                if (i == 4) {
                    int y = 2*i +1;
                    double curr = 1 / (y * pow(x, y));
                    sum += pow(-1, i) * curr;
                    prev = curr;
//                    System.out.println(curr);
                } else {
                    double currY = 2*i + 1;
                    double prevY = 2*(i+1) + 1;
                    double delta = (prevY / currY) * pow(x, 2);
                    double curr = prev * delta;
                    sum += pow(-1, i) * curr;
//                    System.out.println(curr);
//                    System.out.println("prev = " + prev + "\n delta = " + delta);
                    prev = curr;
                }

            }

            if (x <= -1) {
//                System.out.println("pi: " + (-1) * Math.PI / 2);
                sum =  ((-1) * Math.PI / 2) - sum;
            } else if (x >= 1){
                sum = (Math.PI / 2) - sum;
            }

        }

        return sum;
    } //end method


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

    public static long silnia(int n){
        long result = 1;
        for (int i = n; i > 0; i--){
            result *= i;
        }
        return result;
    }
} //end class
