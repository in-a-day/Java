### Interface Supplier

#### 源码:

```java

/**
 * Represents a supplier of results.
 * 每次调用不一定要生成一个新的或不同的结果
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
```

#### demo

```java
public class TestSupplier {
    public static void main(String[] args) {
        Supplier<String> s = () -> "1";
        System.out.println(s.get());
        Supplier<Integer> i = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(i.get());
    }
}
```

