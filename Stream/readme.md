[TOC]

# Stream

> stream 大体可分为三个操作: 
>
> 1. 生成stream
> 2. intermediate operation(中间操作)
> 3. terminal operatioin(终止操作), 只有在这个阶段, 流才正真执行.



---



##  生成Stream

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



---



## Intermediat operation

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
   // out: 1 2 3
   Stream.of(1, 1, 2, 3, 3).distinct().forEach(System.out::println);
   ```

5. sorted, 排序

   ```java
   // 流中元素未实现Comparable接口, 在执行终止操作时会抛出ClassCastException
   Stream<T> sorted();
   Stream<T> sorted(Comparator<? super T> comparator);
   
   // ---- demo ----
   // out: 1 2 3
   Stream.of(2, 1, 3).sorted(Integer::compare).forEach(System.out::println);
   ```

6. peek, 遍历流中元素(常用于调试)

   ```java
   Stream<T> peek(Consumer<? super T> action);
   
   ```



---



## Reductions

### 简单的终止操作

1. count, 统计流中的元素个数.

   ```java
   long count();
   
   // ---- demo ----
   // out: 8
   System.out.println(Stream.iterator(1, a -> a + 1).limit(8).count());
   ```

2. max

   ```java
   Optional<T> max(Comparator<? super T> comparator);
   
   // ---- demo ----
   Optional<String> max = Stream.of("1", "dfdsf", "dff").max(String::compareTo);
   // out: dff
   System.out.println(max.orElse(""));
   ```

3. min

   ```java
   Optional<T> min(Comparator<? super T> comparator);
   
   // ---- demo ----
   Optional<Integer> min = Stream.of(1, 2, 3).min(Integer::compareTo);
   // out: 1
   System.out.println(min.orElse(0));
   ```

4. findFirst, 获取第一个元素, 常与filter一起使用

   ```java
   Optional<T> findFirst();
   
   // ---- demo ----
   Optional<String> first = Stream.of("1", "12", "32").filter(s -> s.length() > 1).findFirst();
   // out: "12"
   System.out.println(first.orElse(""));
   ```

5. findAny, 寻找任意匹配, 通常用于多线程

   ```java
   Optional<T> findAny();
   
   // ---- demo ----
   // 可能是"12", 也可能是"32
   Optional<String> first = Stream.of("1", "12", "32").parallel().filter(s -> s.length() > 1).findAny();
   ```

   

6. anyMatch, allMatch, noneMatch

   ```java
   // 任一匹配返回true
   boolean anyMatch(Predicate<? super T> predicate);
   // 全部匹配返回true
   boolean allMatch(Predicate<? super T> predicate);
   // 全不匹配返回true
   boolean noneMatch(Predicate<? super T> predicate);
   
   // ---- demo ----
           String[] str = {"1", "23", "4"};
   // true
   System.out.println(Arrays.stream(str).parallel().anyMatch(a -> a.length() == 1));
   // false
   System.out.println(Arrays.stream(str).parallel().allMatch(a -> a.length() == 1));
   // false
   System.out.println(Arrays.stream(str).parallel().noneMatch(a -> a.length() == 1));
   ```



### 收集结果

1. forEach, 遍历流

   ```java
   // 任意顺序
   void forEach(Consumer<? super T> action);
   // 流中顺序
   void forEachOrdered(Consumer<? super T> action);
   ```

   

2. toArray, 生成Object[]数组, 或提供具体类型生成相应类型数组

   ```java
   Object[] toArray();
   <A> A[] toArray(IntFunction<A[]> generator);
   
   // ---- demo ----
   // 结果是Object[]数组
   Stream.iterate(1, a -> a + 1).limit(5).toArray();
   // 结果是Integer数组
   Stream.generate(a -> 1).limit(10).toArray(Integer[]::new);
   ```

   

3. collect, 可结合Collectors使用, 见下述Collectors常用方法.

   ```java
   <R, A> R collect(Collector<? super T, A, R> collector);
   
   // ---- demo ----
   Stream.of(1, 2, 3).collect(Collectors.toList());
   Stream.of(1, 2, 3).collect(Collectors.toSet());
   
   // 生成具体类型集合
   TreeSet<Integer> tree = Stream.of(1, 2, 3).collect(Collectors.toCollection(TreeSet::new));
   ArrayList<Integer> arr = Stream.of(1, 2, 3).collect(Collectors.toCollection(ArrayList::new));
   
   // 连接字符串
   // out: "12"
   String str = Stream.of("1", "2").collect(Collectors.joining());
   // out: "1,2"
   String str1 = Stream.of("1", "2").collect(Collectors.joining(","));
   
   // sum, count, average, max, min
   // 使用summarizing(Int|Long|Double)方法, 生成(Int|Long|Double)SummaryStatistics类型结果.
   IntSummaryStatistics summary = Stream.of("1", "df").collect(Collectors.summarizingInt(String::length));
   double average = summary.getAverage();
   double max = summary.getMax();
   ```


### Collectors常用方法

1. counting, 统计元素个数

   ```java
   public static <T> Collector<T, ?, Long>
   counting() {
       return summingLong(e -> 1L);
   }
   
   // ---- demo ----
   // 尽管这里可以使用stream.count()代替, 但是在接收Collector对象的函数中, 这个十分有用
   long res = Stream.of(1, 2, 3).collect(Collectors.counting);
   System.out.println(res);
   ```

2. summing(Int|Long|Double),  根据给定的属性求和

   ```java
   // mapper根据给定流中的属性进行求和
   public static <T> Collector<T, ?, Integer>
   summingInt(ToIntFunction<? super T> mapper);
   
   // ---- demo ----
   int res = Stream.of("1", "22", "333").collect(Collectors.summingInt(String::length));
   System.out.println(res);
   ```

3. averaging(Int|Long|Double), 求平均值, 与summing相似

4. summarizing(Int|Long|Double), 返回(Int|Long|Double)SummaryStatistics, 包含最大值, 平均值等.

   ```java
   Collector<T, ?, IntSummaryStatistics> summarizingInt(ToIntFunction<? super T> mapper);
   ```

5. joining, 连接流中元素

   ```java
   // 默认直接连接
   public static Collector<CharSequence, ?, String> joining();
   // 分隔符
   public static Collector<CharSequence, ?, String> joining(CharSequence delimiter);
   // 前后缀
   public static Collector<CharSequence, ?, String> joining(CharSequence delimiter,
                                                                CharSequence prefix,
                                                                CharSequence suffix);
   ```

6. maxBy, minBy

   ```java
   // 根据comparator返回最大值, 结果存储在Optional对象中
   public static <T> Collector<T, ?, Optional<T>>
   maxBy(Comparator<? super T> comparator);
   // 最小值
   public static <T> Collector<T, ?, Optional<T>>
   minBy(Comparator<? super T> comparator);
   ```

7. mapping

8. flatMapping

9. reducing

10. collectingAndThen

### 结果映射到map

1. Colletors.toMap()

   ```java
   // 根据keyMapper, valueMapper生成map的key和value, 返回Map类型
   Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper, 
                                   Function<? super T, ? extends U> valueMapper)
   // mergeFunction提供map的key冲突时解决方法
   Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                   Function<? super T, ? extends U> valueMapper,
                                   BinaryOperator<U> mergeFunction)
   // mapSupplier提供具体的map类型, 例: HashMap
   Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper, 
                            Function<? super T, ? extends U> valueMapper, 
                            BinaryOperator<U> mergeFunction, 
                            Supplier<M> mapSupplier)
   // 对于以上toMap方法, 都有一个对应的toConcurrentMap方法
     
     
    
   // ---- demo ----
   // out: {1=1, as=2, 2=1}
   Map<String, Integer> m1 = Stream.of("1", "2", "as")
     .collect(Collectors.toMap(Function.identity(), String::length));
   // out: {1=[1, 2], 2=[as]}
   Map<Integer, List<String>> m2 = Stream.of("1", "2", "as")
               .collect(Collectors.toMap(
                       String::length,
                       a -> {
                            ArrayList<String> val = new ArrayList<>();
                            val.add(a);
                            return val;
                       },
                       (str1, str2) -> {
                           str1.addAll(str2);
                           return str1;
                       }
               ));
   // out: {1=1-1-3, 2=22}
   HashMap<Integer, String> count = Stream.of("1", "1", "22", "3")
               .collect(Collectors.toMap(
                   		String::length,
                       Function.identity(),
                       (String a, String b) -> String.join("-", a, b), 
                       HashMap::new
               ));
   
   ```

   

2. Collectors.groupingBy()

   ```java
   // classifier返回值作为map的key, value为list, list中的元素为该元素本身, 默认为HashMap
   public static <T, K> Collector<T, ?, Map<K, List<T>>> 
   groupingBy(Function<? super T, ? extends K> classifier){
       return groupingBy(classifier, toList());
   }
   // 使用downstream生成map中的value, 可使用Collectors中的toList, toSet, toMap生成不同的集合
   // 也可使用counting, summing(Int|Long|Double), maxBy, minBy等
   public static <T, K, A, D> Collector<T, ?, Map<K, D>> 
   groupingBy(Function<? super T, ? extends K> classifier, 
     				 Collector<? super T, A, D> downstream) {
   		return groupingBy(classifier, HashMap::new, downstream);
   }
   // mapFactory指定map的类型
   public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> 
   groupingBy(Function<? super T, ? extends K> classifier,
     				 Supplier<M> mapFactory,
     				 Collector<? super T, A, D> downstream);
   
   ```

   

3. f

4. f

5. f

6. f

7. ff

8. f

9. f

10. f

11. f

12. f

13. f

14. f

15. f

16. f

17. f

18. f

19. f

20. f

21. f

22. f

23. 