package bg.tu_varna.sit.а1.f23621652.exceptions;

public final class NegativeValueChecker {
    public static final String message = "Values cannot be negative!";

    private NegativeValueChecker(){}

    public static boolean isValueNegative(double value){
        if(value < 0)
            return true;
        return false;
    }
}
