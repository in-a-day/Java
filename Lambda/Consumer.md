Interface Consumer

> 表示接收一个参数并且没有返回值得操作. 不像其他得函数式接口, Consumer带有副作用  
> functional interface: accept()

```java
void accept(T t)
```
##### Parameters:
> 输入参数

```java
defualt Consumer(T t) andThen(Consumer<? super T> after)
```
##### Parameters:
> after - 执行当前操作后需要执行得操作
##### Returns:
> 先执行该accept()在执行after的accept()的组合Consumer
##### Exception
> NullPointerException - if after is null

