Interface Predicate<T>

> 代表一个参数的值(布尔值函数)  
> 函数式方法: `test(Object)`

```java
boolean test(T t)
```
##### Parameters:
> t - the input argument
##### Returns:
> true if the input argument matches the predicate, otherwise false

```java
default Predicate<T> and(Predicate<? super T> other)
```
> 返回该函数的test()与other的test()逻辑与
> NullPointerException - if other is null

```java
default Predicate<T> negate()
```
> 返回test()的相反结果

```java
default Predicate<T> or(Predicate<? super T> other)
```
> 逻辑或结果(与and相似)

```java
static <T> Predicate<T> isEqual(Object targetRef)
```
> 返回使用Objects.equals(Object, Object)比较的`Predicate`
