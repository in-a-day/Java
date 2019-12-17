### InheritableThreadLocal

```java
public class InheritableThreadLocal<T> extends ThreadLocal<T>
```
> 该类继承ThreadLocal类, 提供了从父线程继承到子线程的值: 当子线程创建时, 接收所有继承的thread-local变量的初始化值(这些变量在父线程中有值). 通常, 子线程值被标志为父线程的. 然而, 可以通过重写childValue方法来创建子线程的值.

> 当变量的每个线程属性必须自动传送到任何被创建的子线程中, 继承的thread-local变量将优于普通的thread-local变量.

---

```java
protected T childValue(T parentValue)
```
> 子线程创建的同时, 根据父线程值计算子线程继承的thread-local变量的初始化值.

> 该方法默认返回输入参数, 如果需要不同的行为则重写它.

##### Parameters:
> parentValue - the parent thread's value
##### Retruns:
> the child thread's initial value
