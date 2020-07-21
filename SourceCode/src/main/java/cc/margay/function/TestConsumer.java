package cc.margay.function;

import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        Consumer<String> c = a -> System.out.println(a);
        c.accept("qwer");
        c.andThen(a -> System.out.println("after: " + a))
                .accept("qwer");
    }
}
