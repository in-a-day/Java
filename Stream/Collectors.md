# Collectors

> 实现了Collect接口(由Collectors内部静态类CollectorImpl实现), 提供了一系列`reduction operation`, 可在流中方便调用.

## Collector接口



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

