//public class Ulamek2 extends MyNumber{
//    private double licznik;
//    //    private double mianownik = Math.pow(2, 16);
//    private double mianownik = 1;
//
//    public Ulamek2(long licznik) {
//        this.licznik = (double) licznik;
//    }
//    public Ulamek2(double licznik) {
//        this.licznik = licznik;
//    }
//
//    public Ulamek2(String licznik) {
//        double l = Double.parseDouble(licznik);
//        this.licznik = l;
//    }
//
//    public long getLicznik() {
//        return (long) licznik;
//    }
//
//    public long getMianownik() {
//        return (long) mianownik;
//    }
//
//    public void setLicznik(double licznik) {
//        this.licznik = licznik;
//    }
//
//    public void setMianownik(double mianownik) {
//        this.mianownik = mianownik;
//    }
//
////    @Override
////    public MyNumber add(MyNumber n2) {
////        return null;
////    }
//
//    @Override
//    public int intValue() {
//        return (int) (licznik / mianownik);
//    }
//
//    @Override
//    public long longValue() {
//        return (long) (licznik / mianownik);
//    }
//
//    @Override
//    public float floatValue() {
//        return (float) (licznik / mianownik);
//    }
//
//    @Override
//    public double doubleValue() {
//        return (double) (licznik / mianownik);
//    }
//
//    @Override
//    public MyNumber getZero(){
//        Ulamek zero = new Ulamek(0);
//        zero.setMianownik(1);
//
//        return zero;
//    }
//
//    @Override
//    public MyNumber add(MyNumber n2){
//        Ulamek u2 = (Ulamek) n2;
//        double l1 = this.getLicznik();
//        double l2 = u2.getLicznik();
//        double m1 = this.getMianownik();
//        double m2 = u2.getMianownik();
//
//        double nww = NWW(m1, m2);
//        double new_licznik = l1 * (nww/m1) + l2 * (nww/m2);
//
//        Ulamek u3 = new Ulamek(new_licznik);
//        u3.setMianownik(nww);
////        this.setLicznik(new_licznik);
////        this.setMianownik(nww);
//
//        return u3;
//    }
//
//
//    @Override
//    public MyNumber subtract(MyNumber n2){
//        Ulamek u2 = (Ulamek) n2;
//        double l1 = this.getLicznik();
//        double l2 = u2.getLicznik();
//        double m1 = this.getMianownik();
//        double m2 = u2.getMianownik();
//
//        double nww = NWW(m1, m2);
//        double new_licznik = l1 * (nww/m1) - l2 * (nww/m2);
//
//        Ulamek u3 = new Ulamek(new_licznik);
////        this.setLicznik(new_licznik);
//        u3.setMianownik(nww);
//
//        return u3;
//    }
//
//
//    public MyNumber multiply(MyNumber n2){
//        Ulamek u2 = (Ulamek) n2;
//        double l1 = this.getLicznik();
//        double l2 = u2.getLicznik();
//        double m1 = this.getMianownik();
//        double m2 = u2.getMianownik();
//
//        double nwd = NWD_2(m1, m2);
//        double new_licznik = (l1 * l2) / nwd;
//        double new_mianownik = (m1 * m2) / nwd;
//
////        this.setLicznik(new_licznik);
//        Ulamek u3 = new Ulamek(new_licznik);
//        u3.setMianownik(new_mianownik);
//
//        return u3;
//    }
//
//    public MyNumber divide(MyNumber n2){
//        Ulamek u2 = (Ulamek) n2;
//        Ulamek u3 = new Ulamek(u2.mianownik);
//        u3.setMianownik(u2.getLicznik());
//
//        Ulamek this_copy = new Ulamek(this.licznik);
//        this_copy.setMianownik(this.mianownik);
//
//        return this_copy.multiply(u3);
//
////        return this;
//    }
//
//    //http://podstawyprogramowania.pl/java/przyklady/java-wyszukiwanie-nwd/
//    public static double NWD_2(double pierwsza, double druga)
//    {
//        if (druga == 0)
//        {
//            return pierwsza;
//        }
//        else // rekurencyjne wywołanie funkcji, gdzie kolejność parametrów
//        {   // została zamieniona, dodatkowo drugi parametr to operacja modulo
//            return NWD_2(druga, pierwsza%druga);  // dwóch liczb.
//        }
//    }
//
//    public static double NWW(double a, double b){
//        return a/NWD_2(a,b) * b;
//    }
//}
//
