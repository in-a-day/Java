package cc.margay.function;

import java.util.function.UnaryOperator;

public class TestUnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<Integer> u = t -> t + 1;
        System.out.println(u.apply(1));

        UnaryOperator<String> p = UnaryOperator.identity();
        System.out.println(p.apply("1"));
    }
}
