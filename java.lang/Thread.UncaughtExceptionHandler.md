### Interface Thread.UncaughtExceptionHandler
#### Enclosing class:
> Thread

```java 
@FunctionalInterface
public static interface Thread.UncaughtExceptionHandler
```
> Tread因未捕获的异常终止时调用的处理接口.

> 当一个线程因未捕获的异常想要终止时, JVM将使用Thread.getUncaughtExceptionHandler()方法去查找线程的UncaughtHandlerException, 并调用该处理器的uncaughtException方法, 将该线程和异常当作参数传递. 如果一个线程未显示地设置UncaughtExceptionHandler, 那么它的ThreadGroup就作为它的UncaughtExceptionHandler. 如果ThreadGroup没有特定的要求处理异常, 它可以将调用转发给默认未捕获异常处理器.
---

```java 
void uncaughtException(Thread t, Throwable e)
```
> 当给定的线程因未捕获的异常终止时调用该方法.

> JVM会忽略由该方法抛出的异常.
##### Parameters:
> t - the thread
> e - the exception


