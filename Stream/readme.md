[TOC]

# Stream

> stream 大体可分为三个操作: 
>
> 1. 生成stream
> 2. intermediate operation(中间操作)
> 3. terminal operatioin(终止操作), 只有在这个阶段, 流才正真执行.

---

## 1. 生成Stream

1. Arrays接口

   ```java
   static <T> Stream<T> stream(T[] array);
   static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive);
   // 除此之外还有LongStream和DoubleStream
   static IntStream stream(int[] array);
   static IntStream stream(int[] array, int startInclusive, int endExclusive);
   
   // ---- demo ----
   Stream<String> strStream = Arrays.stream(new String[]{"1", "2", "3"});
   IntStream intStream = Arrays.stream(new int[]{1, 2, 3});
   ```

2. Collection接口

   ```java
   default Stream<E> stream();
   default Stream<E> parallelStream();
   
   // ---- demo ----
   ArrayList<String> str = new ArrayList<String>();
   Stream<String> strStream = str.stream();
   ```

3. Stream接口

   ```java
   static <T> Stream<T> of(T... values);
   static <T> Stream<T> of(T t);
   // 生成空Stream
   public static<T> Stream<T> empty();
   // 生成无限流
   public static<T> Stream<T> generate(Supplier<T> s);
   // 第一个元素为seed, 第二个f(seed), 第三个f(f(seed))...
   public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f);
   
   // ---- demo ----
   Stream<Integer> intStream = Stream.of(1, 2, 3);
   // 输出11111
   Stream.generate(() -> 1).limit(5).forEach(System.out::print);
   // 输出12345
   Stream.iterate(1, a -> a+1).limit(5).forEach(System.out::print);
   ```

4. IntStream接口

   ```java
   // 从start到end, 每次步长为1
   static IntStream range(int startInclusive, int endExclusive);
   static IntStream rangeClosed(int startInclusive, int endInclusive);
   
   // ---- demo ----
   IntStream intStream = IntStream.range(1, 100);
   ```

5. Pattern类

   ```java
   public Stream<String> splitAsStream(final CharSequence input);
   
   // ---- demo ----
   Stream<String> strStream = Pattern.compile("\\d+").splitAsStream("fd123fda45");
   ```

   

6. StreamSupport提供了一系列生成stream方法, 查看官方api

7. 

---

## intermediat operation

### filter, map, flatMap

1. filter, 保留符合条件的流

   ```java
   Stream<T> filter(Predicate<? super T> predicate);
   
   // ---- demo ----
   // 输出1
   Stream.of(1, 2, 3).filter(a -> a == 1).forEach(System.out::println);
   ```

2. map, 转化流中的数据

   ```java
   <R> Stream<R> map(Function<? super T, ? extends R> mapper);
   // 此外还有long, double
   IntStream mapToInt(ToIntFunction<? super T> mapper);
   
   // ---- demo ----
   // 输出AB
   Stream.of("a", "b").map(String::toUpperCase).forEach(System.out::print);
   // 输出2 1
   Stream.of("as", "s").map(String::length).forEach(System.out::println);
   ```

3. flatMap, 如果产生的结果是流, 使用flatMap将这些流变为一个流

   ```java
   // mapper对流中每个元素调用mappe.apply(), 返回新值的流
   <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
   // long, double
   IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
   
   // --- demo ----
   Stream src = Stream.of("ab", "cd", "ef");
   // 只是展示用法, flatMap将这些流重新展开为1个流
   Stream dst = src.flatMap(el -> Stream.of(el + "-new")).forEach(System.out::println);
   ```

### 提取流, 混合流

1. limit(n), 返回n个元素的新流

   ```java
   Stream<T> limit(long maxSize);
   
   // ---- demo ----
   IntStream.range(1, 100).limit(20).forEach(System.out::println);
   ```

2. skip(n) 与limit相反

   ```java
   Stream<T> skip(long n);
   
   // ---- demo ----
   IntStream.range(1, 100).skip(80).forEach(System.out::println);
   ```

3. concat, 连接stream

   ```java
   public static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b);
   
   // ---- demo ----
   // out: 1 2
   Stream.concat(Stream.of(1), Stream.of(2)).forEach(System.out::println);
   ```

4. distinct, 去掉stream中相同元素

   ```java
   Stream<T> distinct();
   
   // ---- demo ----
   // out: 1, 2, 3
   Stream.of(1, 1, 2, 3, 3).distinct().forEach(System.out::println);
   ```

5. sorted, 排序

   ```java
   // 流中元素未实现Comparable接口, 在执行终止操作时会抛出ClassCastException
   Stream<T> sorted();
   Stream<T> sorted(Comparator<? super T> comparator);
   
   // ---- demo ----
   // out: 1, 2, 3
   Stream.of(2, 1, 3).sorted(Integer::compare).forEach(System.out::println);
   ```

6. peek, 遍历流中元素(常用于调试)

   ```java
   Stream<T> peek(Consumer<? super T> action);
   
   ```