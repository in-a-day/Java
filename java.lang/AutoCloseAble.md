### public interface AutoCloseable

> 可以保留资源直到关闭的对象(文件,socket处理等). 当退出try-with-resources块时(对象在该资源首部声明),将会自动调用AutoColseable对象的close()方法.

#### API Note:
>一个基础类可以实现AutoColseable接口(事实上大多如此), 尽管并不是所有的子类或实例都保有可释放资源. 如果代码必须以完全通用性操作, 或者已知AutoCloseable实例需要资源释放, 那么推荐使用try-with-resources来构造. 然而, 当使用像是Stream这种支持I/O-based和non-I/O-based形式的工具时, try-with-resources块就不必在non-I/O-based形式中使用了.
---

```java
void close() throws Exception
```
> 关闭资源, 让出所有底层的资源. 该方法由try-with-resources声明管理的对象自动调用.

> 尽管该接口声明抛出异常, 还是强烈推荐实现者声明明确的close方法抛出更特殊的异常, 或者什么异常都不要抛出(如果关闭操作不会失败).

> 实现者必须注意关闭操作失败的情况. 在抛出异常之前, 强烈建议释放底层资源, 并在内部标记资源为关闭状态. close方法仅会调用一次, 所以此方法确保资源及时被释放. 此外, 它减少了资源包装或被另一资源包装时, 引起的问题.

> 强烈建议实现了该接口的close方法不要抛出InterruptedException. 该异常接口有线程阻塞状态, 如果InterruptedException被抑制了, 可能会发生运行时异常行为. 通俗来说, 如果它引起的异常被抑制了, AutoCloseable.close方法不应该抛出它.

> 不像Closeable中的close方法, 此接口的close方法不必是幂等的. 用其他的话来说, 调用该不止一次调用该close方法可能产生可见的副作用, 而 Closeable.close方法不会产生任何影响. 然而, 强烈推荐实现者将close方法实现为幂等的方法.

##### Throws:
> Exception: 如果资源无法关闭
