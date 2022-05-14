public class Ulamek extends Number{
    private double licznik;
    private final double mianownik = Math.pow(2, 16);

    public Ulamek(long licznik) {
        this.licznik = licznik;
    }

    public Ulamek(String licznik) {
        double l = Double.parseDouble(licznik);
        this.licznik = (long) l;
    }

    public long getLicznik() {
        return (long) licznik;
    }

    public long getMianownik() {
        return (long) mianownik;
    }

    @Override
    public int intValue() {
        return (int) (licznik / mianownik);
    }

    @Override
    public long longValue() {
        return (long) (licznik / mianownik);
    }

    @Override
    public float floatValue() {
        return (float) (licznik / mianownik);
    }

    @Override
    public double doubleValue() {
        return (double) (licznik / mianownik);
    }

}
