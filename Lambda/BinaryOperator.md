Interface BinaryOperator<T>

### Type Parameters
> T - the type of the operands and result of the operator

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFUnction<T, T, T>
```

> 同一类型的两个操作数, 返回值类型与操作类型相同. 是BiFunction的一个特例.

```java
static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
```
##### Type Parameters:  
> T - 输入参数比较器类型  

##### Parameters:  
> comparator - 比较两个值的比较器

##### Returns:  
> 一个返回两个元素中更小的元素(通过给定的比较器比较)的BinaryOperator

##### Throws:  
> NullPointerException - 如果参数为null

```java
static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
```
> 类似minBy
