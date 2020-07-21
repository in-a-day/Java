package cc.margay.function;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
        Supplier<String> s = () -> "1";
        System.out.println(s.get());
        Supplier<Integer> i = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(i.get());
    }
}
