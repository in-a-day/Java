### public interface Iterable<T>

> 实现该接口允许对象作为for-each循环的目标

```java 
Iterator<T> iterator()
```
> 返回元素类型为T的Iterator
---

```java 
default void forEach(Consumer<? super T> action)
```
> 对Iterable的每个元素执行给定的操作, 直到所有元素都被执行或者抛出了异常. 除非实现类指定了执行顺序, 否则操作将以iteration的顺序执行(如果iteration的顺序指定了). 直到调用了操作才会抛出异常.
##### Implementation Requirements:
```java 
// 默认实现行为:
for (T t: this)
    action.accept(this)
```
##### Parameters:
> action - 每个元素将执行的动作
##### Throws:
NullPointerException - if the specified action is null
---

```java 
default Spliterator<T> spliterator()
```
> 通过Iterable描述的元素创建Spliterator

##### Implementation Requirements:
> 默认实现通过iterable的Iterator创建一个early-binding spliterator. 该spliterator从iterable的iterator继承了fail-fast 属性.

##### Implementation Note:
> 默认实现应该总是被重写. 默认实现的spliterator具有较差分割功能, 未指定大小, 并且不会报告任何spliterator特征. 实现类几乎总是可以提供一个更好的实现.

##### Returns:
> a Spliterator over the elements described by this Iterable.