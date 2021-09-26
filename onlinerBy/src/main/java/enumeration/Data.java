package enumeration;

/**
 * Test data for verification and comparison.
 */
public enum Data {

    PRICE(100),
    COST("8000 $"),
    BRAND("24"),
    MIN_YEARE("2012"),
    NUMBER_MOTORBIKES(20);

    private int dataInt;

    private String dataString;

    Data(int dataInt) {
        this.dataInt = dataInt;
    }

    Data(String dataString) { this.dataString = dataString; }

    public int getDataInt() {
        return dataInt;
    }

    public String getDataString() { return dataString; }
}