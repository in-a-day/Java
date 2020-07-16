# Collector及Collectors

> Collectors实现了Collect接口(由Collectors内部静态类CollectorImpl实现), 提供了一系列`reduction operation`, 可在流中方便调用.

## Collector接口

> Collector提供了四个方法累积元素到可变的结果容器中, 并且可选的对结果执行最终转换.

---

1. `supplier()`, 创建新的结果容器
2. `accumulator()`, 将新的数据元素加入到结果容器中
3. `combiner()`, 合并两个结果容器为一个
4. `finisher()`, 在容器上执行可选的最终转换

> Collector提供了characteristics集合

1. `Characteristics.CONCURRENT`, 表明collector是并行的.
2. `Characteristics.UNORDERED`, 表明集合操作保留遇到输入元素的顺序.
3. `Characteristics.IDENTITY_FINISH`, 表明`finisher`函数是相同函数, 可以省略.

### Collector定义

```java
/**
* T - 输入reduction操作的元素类型
* A - reduction操作的可变累积类型
* R - reduction操作结果的类型
*/
public interface Collector<T, A, R> {
    /**
     * A function that creates and returns a new mutable result container.
     *
     * @return a function which returns a new, mutable result container
     */
    Supplier<A> supplier();

    /**
     * A function that folds a value into a mutable result container.
     *
     * @return a function which folds a value into a mutable result container
     */
    BiConsumer<A, T> accumulator();

    /**
     * A function that accepts two partial results and merges them.  The
     * combiner function may fold state from one argument into the other and
     * return that, or may return a new result container.
     *
     * @return a function which combines two partial results into a combined
     * result
     */
    BinaryOperator<A> combiner();

    /**
     * Perform the final transformation from the intermediate accumulation type
     * {@code A} to the final result type {@code R}.
     *
     * <p>If the characteristic {@code IDENTITY_TRANSFORM} is
     * set, this function may be presumed to be an identity transform with an
     * unchecked cast from {@code A} to {@code R}.
     *
     * @return a function which transforms the intermediate result to the final
     * result
     */
    Function<A, R> finisher();

    /**
     * Returns a {@code Set} of {@code Collector.Characteristics} indicating
     * the characteristics of this Collector.  This set should be immutable.
     *
     * @return an immutable set of collector characteristics
     */
    Set<Characteristics> characteristics();

    /**
     * Returns a new {@code Collector} described by the given {@code supplier},
     * {@code accumulator}, and {@code combiner} functions.  The resulting
     * {@code Collector} has the {@code Collector.Characteristics.IDENTITY_FINISH}
     * characteristic.
     *
     * @param supplier The supplier function for the new collector
     * @param accumulator The accumulator function for the new collector
     * @param combiner The combiner function for the new collector
     * @param characteristics The collector characteristics for the new
     *                        collector
     * @param <T> The type of input elements for the new collector
     * @param <R> The type of intermediate accumulation result, and final result,
     *           for the new collector
     * @throws NullPointerException if any argument is null
     * @return the new {@code Collector}
     */
    public static<T, R> Collector<T, R, R> of(Supplier<R> supplier,
                                              BiConsumer<R, T> accumulator,
                                              BinaryOperator<R> combiner,
                                              Characteristics... characteristics) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        Objects.requireNonNull(characteristics);
        Set<Characteristics> cs = (characteristics.length == 0)
                                  ? Collectors.CH_ID
                                  : Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH,
                                                                           characteristics));
        return new Collectors.CollectorImpl<>(supplier, accumulator, combiner, cs);
    }

    /**
     * Returns a new {@code Collector} described by the given {@code supplier},
     * {@code accumulator}, {@code combiner}, and {@code finisher} functions.
     *
     * @param supplier The supplier function for the new collector
     * @param accumulator The accumulator function for the new collector
     * @param combiner The combiner function for the new collector
     * @param finisher The finisher function for the new collector
     * @param characteristics The collector characteristics for the new
     *                        collector
     * @param <T> The type of input elements for the new collector
     * @param <A> The intermediate accumulation type of the new collector
     * @param <R> The final result type of the new collector
     * @throws NullPointerException if any argument is null
     * @return the new {@code Collector}
     */
    public static<T, A, R> Collector<T, A, R> of(Supplier<A> supplier,
                                                 BiConsumer<A, T> accumulator,
                                                 BinaryOperator<A> combiner,
                                                 Function<A, R> finisher,
                                                 Characteristics... characteristics) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        Objects.requireNonNull(finisher);
        Objects.requireNonNull(characteristics);
        Set<Characteristics> cs = Collectors.CH_NOID;
        if (characteristics.length > 0) {
            cs = EnumSet.noneOf(Characteristics.class);
            Collections.addAll(cs, characteristics);
            cs = Collections.unmodifiableSet(cs);
        }
        return new Collectors.CollectorImpl<>(supplier, accumulator, combiner, finisher, cs);
    }

    /**
     * Characteristics indicating properties of a {@code Collector}, which can
     * be used to optimize reduction implementations.
     */
    enum Characteristics {
        /**
         * Indicates that this collector is <em>concurrent</em>, meaning that
         * the result container can support the accumulator function being
         * called concurrently with the same result container from multiple
         * threads.
         *
         * <p>If a {@code CONCURRENT} collector is not also {@code UNORDERED},
         * then it should only be evaluated concurrently if applied to an
         * unordered data source.
         */
        CONCURRENT,

        /**
         * Indicates that the collection operation does not commit to preserving
         * the encounter order of input elements.  (This might be true if the
         * result container has no intrinsic order, such as a {@link Set}.)
         */
        UNORDERED,

        /**
         * Indicates that the finisher function is the identity function and
         * can be elided.  If set, it must be the case that an unchecked cast
         * from A to R will succeed.
         */
        IDENTITY_FINISH
    }
}

```



---


## Collectors接口
### 常用方法
1. counting, 统计元素个数

   ```java
   public static <T> Collector<T, ?, Long>
   counting() {
       return summingLong(e -> 1L);
   }
   
   // ---- demo ----
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

4. summarizing(Int|Long|Double), 返回(Int|Long|Double)SummaryStatistics, 包含最大, 最小值,  总和, 平均值等.

   ```java
   Collector<T, ?, IntSummaryStatistics> summarizingInt(ToIntFunction<? super T> mapper);
   Collector<T, ?, LongSummaryStatistics> summarizingLong(ToLongFunction<? super T> mapper);
   Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(ToDoubleFunction<? super T> mapper);
   
   // ---- demo ----
   IntSummaryStatistics res = Stream.of(1, 2, 3).collect(Collectors.summarizingInt(a -> a));
   System.out.println(res.getMax());
   System.out.println(res.getAverage());
   System.out.println(res.getCount());
   System.out.println(res.getMin());
   System.out.println(res.getSum());
   ```

5. joining, 连接流中元素

   ```java
   // 默认直接连接
   public static Collector<CharSequence, ?, String> joining();
   // 分隔符
   public static Collector<CharSequence, ?, String> joining(CharSequence delimiter);
   // 连接完成后添加前后缀
   public static Collector<CharSequence, ?, String> joining(
       CharSequence delimiter,
   	CharSequence prefix,
   	CharSequence suffix);
   
   // ---- demo ----
   Stream.of("1", "2").collect(Collectors.joining("-", "^", "$"));
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

7. mapping, 处理输入元素, 将输入元素转换成想要保留的信息(eg. 接收人类型, 仅保留人的名称)

   ```java
   // mapper处理输入元素(与Stream中的map函数类似), downstream接收mapper处理后的值
   Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper,
                              Collector<? super U, A, R> downstream);
   
   // ---- demo ----
   // 以字符长度分组, 并将字符转为int类型存储在list中
   Stream<String> str = Stream.of("1", "22", "33", "444");
   Map<Integer, List<Integer>> res = str.collect(Collectors.groupingBy(
       String::length, 
       Collectors.mapping(Integer::parseInt, Collectors.toList())
   ));
   ```

8. collectingAndThen

   ```java
   // downstream, a collector
   // finisher, 处理downstream产生的结果
   public static<T,A,R,RR> Collector<T,A,RR> 
       collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher);
   
   // ---- demo ----
   List<String> res = Stream.of("1", "2").collect(
   	Collectors.collectingAndThen(Collectors.toList(), a -> {
           a.add("after collector");
           return a;
       })
   );
   // out: [1, 22, 33, 444, after collector]
   System.out.println(res);
   ```

9. reducing

   ```java
   public static <T> Collector<T, ?, Optional<T>>
   	reducing(BinaryOperator<T> op);
   // 流为空返回identity, identity作为流中的元素调用op进行处理
   public static <T> Collector<T, ?, T>
   	reducing(T identity, BinaryOperator<T> op);
   // 
   public static <T, U> Collector<T, ?, U> 
       reducing(U identity,
                Function<? super T, ? extends U> mapper,
                BinaryOperator<U> op);
   
   ```

10. flatMapping(java9后)

11. filtering(java9后)

> 以上方法常用在Collectors.groupingBy等方法中. 在Stream中一般都有相应的方法对应以上方法.



### 重要方法

1. toList, 将输入元素放入List中

   ```java
   public static <T>
   Collector<T, ?, List<T>> toList() {
       return new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
                                  (left, right) -> { 
                                      left.addAll(right); return left; },
                               	CH_ID);
   }
   
   // ---- demo ---
   Stream.of(1, 2, 3).collect(Collectors.toList());
   ```

2. toSet, 将输入元素放入set中

   ```java
   public static <T>
   Collector<T, ?, Set<T>> toSet() {
       return new CollectorImpl<>((Supplier<Set<T>>) HashSet::new, Set::add,
                                  (left, right) -> { 
                                      left.addAll(right); return left; },
                                  CH_UNORDERED_ID);
   }
   
   // ---- demo ----
   Stream.of(1, 2, 3).collect(Collectors.toSet());
   ```

3. toMap, 将输入元素放入map中

   ```java
   // 根据keyMapper, valueMapper生成map的key和value, 返回Map类型
   Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper, 
                                   Function<? super T, ? extends U> valueMapper){
   	return toMap(keyMapper, valueMapper, throwingMerger(), HashMap::new);
   }
   // mergeFunction提供map的key冲突时解决方法
   Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                   Function<? super T, ? extends U> valueMapper,
                                   BinaryOperator<U> mergeFunction){
   	return toMap(keyMapper, valueMapper, mergeFunction, HashMap::new);
   }
   // mapSupplier提供具体的map类型, 例: HashMap
   Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper, 
                            Function<? super T, ? extends U> valueMapper, 
                            BinaryOperator<U> mergeFunction, 
                            Supplier<M> mapSupplier) {
   	BiConsumer<M, T> accumulator
               = (map, element) -> map.merge(keyMapper.apply(element),
                                             valueMapper.apply(element), 												  mergeFunction);
       return new CollectorImpl<>(mapSupplier, accumulator, mapMerger(mergeFunction), CH_ID);
   }
   // 对于以上toMap方法, 都有一个对应的toConcurrentMap方法
   
   // ---- demo ----
   // out: {33=2, 22=2, 1=1}
   Stream.of("1", "22", "33").collect(Collectors.toMap(Function.identity(), String::length));
   // out: {1=1, 2=33}
   Stream.of("1", "22", "33").collect(Collectors.toMap(
       String::length, Function.identity(), String::join));
   // out: {1=[1], 2=[22, 33]}
   Stream.of("1", "22", "33").collect(Collectors.toMap(
   	String::length, a -> {
           List<String> res = new ArrayList<>();
           res.add(a);
           return res;
       }, (left, right) -> {
           left.addAll(right);
           return left;
       }, TreeMap::new
   ));
   ```

   

4. toCollection, 将输入元素放入指定集合

   ```java
   public static <T, C extends Collection<T>>
   Collector<T, ?, C> toCollection(Supplier<C> collectionFactory) {
       return new CollectorImpl<>(collectionFactory, Collection<T>::add,
                                  (r1, r2) -> { r1.addAll(r2); return r1; },
                                  CH_ID);
   }
   
   // ---- demo ----
   Stream.of(1, 2, 3).collect(Collectors.toCollection(LinkedList::new));
   ```

5. groupingBy, 用于分组

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
   
   // ---- demo ----
   TreeMap<Integer, Set<String>> collect = Stream.of("1", "1", "fdas", "ffa").
                   collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
   
   ```

   

6. partitionBy, 以true/false进行条件分组.

   ```java
   // 根据predicate进行分组, 默认分组结果存在List中.
   Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
       return partitioningBy(predicate, toList());
   }
   Collector<T, ?, Map<Boolean, D>> partitioningBy(
       Predicate<? super T> predicate,
   	Collector<? super T, A, D> downstream);
   
   // ---- demo ----
   // out: {false=[1], true=[2, 3]}
   Stream.of(1, 2, 3).collect(Collectors.partitioningBy(a -> a > 1));
   // out: {false=1, true=2}
   Stream.of(1, 2, 3).collect(Collectors.partitioningBy(
   	a -> a > 1,
       Collectors.counting()
   ));
   ```

