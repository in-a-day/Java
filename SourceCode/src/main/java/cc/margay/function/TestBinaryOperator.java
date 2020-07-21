package cc.margay.function;

import java.util.function.BinaryOperator;

public class TestBinaryOperator {
    public static void main(String[] args) {
        BinaryOperator<String> b = (t1, t2) ->  t1 + t2;
        System.out.println(b.apply("1", "2"));

        BinaryOperator<String> c1 = BinaryOperator.maxBy(String::compareTo);
        System.out.println(c1.apply("1", "2"));

        BinaryOperator<String> c2 = BinaryOperator.minBy(String::compareTo);
        System.out.println(c2.apply("1", "2"));
    }
}
