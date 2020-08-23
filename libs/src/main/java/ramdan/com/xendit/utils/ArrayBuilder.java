package ramdan.com.xendit.utils;

public class ArrayBuilder {

    @SafeVarargs
    public static <T> T[] as(T... t) {
        return t;
    }
}
