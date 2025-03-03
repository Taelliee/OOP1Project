package bg.tu_varna.sit.а1.f23621652;

public final class NegativeValueChecker {
    public static final String message = "";

    private NegativeValueChecker(){}

    public static boolean isValueNegative(double value){
        if(value < 0)
            return true;
        return false;
    }
}
