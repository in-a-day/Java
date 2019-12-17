### Object
```java
public class Object
```
> Object类是类继承的根部. 每个类都是Object的子类. 所有对象, 包括数组, 都实现了该类的方法.

---

```java
public final Class<?> getClass()
```
> 返回该对象的运行时类. 返回的类对象由表示的类的static synchronized方法锁定.

> 返回的实际类型是Class<? extends |X|>, |x|即为调用的类型. 举例来说, 该代码片段中不需要转换:
```java
Number n = 0;
Class<? extends Number> c = n.getClass();
```
##### Retruns:
> The Class object that represents the runtime class of this object.

---

```java
public int hashCode()
```
> 返回对象hash值. 支持此方法可以使hash tables受益(例如HashMap提供的).

- hashCode的通俗约定:
    - 不管何时调用, hashCode方法总是返回相同的数值.
    - 如果调用通过equals方法比较两个对象相同, 则这两个对象的hashCode方法必须返回相同的整数值.
    - 如果equals方法比较两个对象不同, 这两个对象不必一定返回两个不同的整数值. 但是返回不同的整数值会改善hash tables的行为.

> 在尽可能合理的实践内,Object类定义的hashCode方法确实为不同的对象返回不同的hash值(经典的实现是转换显示的地址为整数, 但java并不需要这样做).

##### Returns:
> a hash code value for this object.

---

```java
public boolean equals(Object obj)
```
> 表明是否其他对象"equal to"次对象

- equals方法在非空对象引用上实现了等价关系:
    - reflexive(自反性): 对任何的非空引用x来说, x.equals(x)必须返回true.
    - symmetric(对称性): 对任何的非空引用x, y, x.equals(y)为true当且仅当y.equals(x)返回true时成立.
    - transitive(传递性): 对任何的非空引用x, y, z, 如果x.equals(y)返回true并且y.equals(z)返回true, 那么x.equals(z)必须返回true.
    - consistent(一致性): 对任何非空引用x, y, 只要未修改equals比较中的信息, 那么多次调用x.equals(y)就一致返回true或是false.

> Object类的equals方法实现了对象最具分辨性的等价关系.对于任何的非空引用x, y来说, 当且仅当x和y指向同一对象时(即x == y返回true), x.equals(y)返回true.

> 注意, 当equals方法重写时, 通常情况下也需要重写hashCode方法, 以保持hashCode方法的通用规定, 即相等的对象必须有相同的hash值.

##### Parameters:
> obj - the reference object with which to compare.
##### Returns:
> true if this object is the same as the obj argument; false otherwise.

---

```java
protected Ojbect clone() throws CloneNotSupportedException
```
> 创建返回该对象的拷贝. "copy"的精确含义取决于该对象的类. 总的目的是, 对任何对象x, 表达式`x.clone() != x`返回true, 并且`x.clone().getClass() == x.getClass()`返回true, 但是这些也不是必须的. 尽管通常情况下`x.clone().equals(x)`返回true, 但也不是必须的.

> 按照约定, 返回的对象应该调用super.clone获得. 如果一个类和它所有的父类(除了object)违背了该约定, 那么将是x.clone().getClass == x.getClass()的一个例子.

> 按照约定, 此方法返回的对象必须独立于此对象(被克隆的对象). 为了获得独立性, 在调用super.clone方法前修改对象的一个或多个字段是有必要的. 通常, 这意味着复制包含内部深层结构的可变对象, 并替换替换这些对象的引用到复制的对象引用中. 如果类zhi有私有字段或者不可变的引用, 这就是super.clone返回不需要修改对象属性的例子.

> Object类的clone方法执行特殊的克隆操作. 如果该对象的类没有实现Cloneable接口, 就抛出CloneNotSupportedException异常. 注意, 所有的数组都被认为实现了Cloneable接口, 并T[]类型数组的clone方法返回的类型是T[], T可以是任意引用或原始类型. 否则, 该方法创建该对象所属类的一个新实例, 并用该对象对应的字段内容初始化所有字段, 就像赋值一样. 字段的内容自身并没有被复制. 一次该方法执行一个浅拷贝而不是深拷贝操作.

> Object类自生没有实现Cloneable接口, 所以调用Object对象实例的clone方法会抛出一个运行时异常.

##### Returns:
> a clone of this instance.
##### Throws:
> CloneNotSupportedException - if the object's class does not support the Cloneable interface. Subclasses that override the clone method can also throw this exception to indicate that an instance cannot be cloned.

---

```java
public String toString()
```
> 返回该对象的字符串表达式. 通常, toString方法返回该对象的文本形式字符串. 结果应该简洁并有足够的信息方便人阅读. 建议所有的子类都重写该方法.

> Objectl类的toString方法返回值由下组成: 该对象所属类名称, `@`符号, 该对象的无符号十六进制形式hash值. 换句话说, 该方法返回的字符串等价于以下值:
```
getClass().getName() + '@' + Interger.toHexString(hashCode())
```
##### Returns:
> a string representation of the object.

---

```java
public final void notify()
```
> 唤醒正在此对象监视器上等待的一个单线程. 如果任意线程在等待该对象, 他们中的一个将被唤醒. 唤醒的线程是随机选择的, 并发生在自由的实现上. 一个线程通过调用wait方法来加入一个对象的监视器.

> 直到当前线程释放了该对象的锁, 唤醒的线程才会执行. 唤醒的线程将用通常的方式与其他线程竞争, 这些线程可能竞争同步该对象.例如: 被唤醒的线程锁定该对象时, 没有任何的特权和劣势.

> 该方法应该只被对象监控器的拥有线程调用. 一个线程成为对象的监控器有三种方式:
    1. 通过执行此对象的一个同步实例方法.
    2. 通过执行在该对象上同步的同步声明主体.
    3. `Class`类型对象通过执行该类的同步静态方法.

##### Throws:
> IllegalMonitorStateException - if the current thread is not the owner of this object's monitor.

---

```java 
public final void notifyAll()
```
> 唤醒所有在此对象监控器上等待的线程.(其他与notify相同)

---

```java 
public final void wait(long timeout) throws InterruptedExcetion
```
> 调用当前线程等待直到没有其他线程调用notify()方法或notifyAll()方法, 或者给定的时间已经过去.

> 当前的线程必须属于此对象监控器.

> 该方法使当前线程(T代替)进入该对象的等待集合, 然后释放该对象上的一切同步声明.线程T不再被线程计划