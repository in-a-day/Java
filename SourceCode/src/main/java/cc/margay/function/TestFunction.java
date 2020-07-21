package cc.margay.function;

import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
        Function<Integer, String> f = a -> String.valueOf(a);
        System.out.println(f.apply(12));

        Function<Integer, String> g = f.compose(a -> a - 1);
        System.out.println(g.apply(12));

        Function<Integer, Integer> h = f.andThen(String::length);
        System.out.println(h.apply(12));
    }
}
