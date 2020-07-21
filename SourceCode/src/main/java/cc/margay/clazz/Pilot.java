package cc.margay.clazz;

public class Pilot<T> {
    public static <T> Pilot<T> instance(T clazz) {
        return new Pilot<T>();
    }
}
