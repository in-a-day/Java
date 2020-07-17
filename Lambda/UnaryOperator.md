### Interface UnaryOperator<T>

#### 源码

```java
/**
 * 接受一个参数产生相同类型的结果, 继承自Function接口, 函数式方法是apply.
 * Represents an operation on a single operand that produces a result of the
 * same type as its operand.  This is a specialization of {@code Function} for
 * the case where the operand and result are of the same type.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object)}.
 *
 * @param <T> the type of the operand and result of the operator
 *
 * @see Function
 * @since 1.8
 */
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {

    /**
     * 返回自身
     * Returns a unary operator that always returns its input argument.
     *
     * @param <T> the type of the input and output of the operator
     * @return a unary operator that always returns its input argument
     */
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
}
```

#### demo

```java
public class TestUnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<Integer> u = t -> t + 1;
        System.out.println(u.apply(1));  // 2

        UnaryOperator<String> p = UnaryOperator.identity();
        System.out.println(p.apply("1")); // 1
    }
}
```

