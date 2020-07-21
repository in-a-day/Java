package cc.margay.function;

import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        Predicate<String> p = s -> s != null && s.length() > 1;
        System.out.println(p.test("11"));
        System.out.println(p.negate().test("11"));
        System.out.println(p.and(str -> str.length() > 3).test("11"));
        System.out.println(p.or(str -> str.length() > 3).test("11"));

        Predicate<String> q = Predicate.isEqual("11");
        System.out.println(q.test("11"));
        System.out.println(q.test("1"));
    }
}
