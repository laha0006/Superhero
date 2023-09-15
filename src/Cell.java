public class Cell {
    private int intValue;
    private String stringValue;
    private double doubleValue;
    private boolean bool;
    private final boolean IS_INT;
    private final boolean IS_STRING;
    private final boolean IS_DOUBLE;
    private final int size;

    public Cell(int intValue) {
        this.intValue = intValue;
        IS_INT = true;
        IS_STRING = false;
        IS_DOUBLE = false;
        size = (int) (Math.log10(intValue) + 1);
    }

    public Cell(String stringValue) {
        this.stringValue = stringValue;
        IS_INT = false;
        IS_STRING = true;
        IS_DOUBLE = false;
        size = stringValue.length();
    }

    public Cell(boolean bool) {
        this.bool = bool;
        IS_INT = false;
        IS_STRING = false;
        IS_DOUBLE = false;
        size = 4;
    }

    public Cell(double doubleValue) {
        this.doubleValue = doubleValue;
        IS_INT = false;
        IS_STRING = false;
        IS_DOUBLE = true;
        size = (int) (Math.log10(doubleValue) + 1);

    }
    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public int getSize(){
        return size;
    }
    public boolean getBool() {
        return bool;
    }
}
