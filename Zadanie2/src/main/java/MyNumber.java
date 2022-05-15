public abstract class MyNumber extends Number {
    public abstract MyNumber add(MyNumber n2);
    public abstract MyNumber subtract(MyNumber n2);
    public abstract MyNumber multiply(MyNumber n2);
    public abstract MyNumber divide(MyNumber n2);
    public abstract MyNumber getZero();


    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
