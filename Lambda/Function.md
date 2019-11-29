Interface Function<T, R>

##### Type Parameters:
> T - the type of the input to the function
> R - the type of the result of the function

```java
@FunctionalInterface
public interface Function<T, R>
```
> 接收一个参数返回一个结果. 函数式方法`apply(Object)`.

```java
R apply(T t)
将给定的参数应用到该方法上
```
##### Parameters:
> t - 参数
##### Returns:
> 方法结果

```java
default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
```
> 返回一个组合函数接口, 即先调用`before`的apply()方法,再调用该该函数接口的apply方法
> 如果任意函数抛出异常, 该异常被传递给组合的函数.
>

```java
default <V> Function<T, V> andThen(Function<? super R, ? extends T> after)
```
> 接收一个转化R类型为T类型的函数式接口after, 在调用原接口`apply()`后调用after的`apply()`方法
