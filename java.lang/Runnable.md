### public interface Runnable(Functional Interface)

> 任何想要在线程中执行的类都应该实现Runnable接口. 这些类必须定义一个无参名为run的方法.

> 该接口旨为希望在活动状态下执行代码的对象提供通用协议. 例如, Tread类实现了Runnable接口. 保持活动意味着一个线程已经启动并且未被停止.

> 此外, Runnable提供了使类处于活动状态而不用继承Tread类. 实现了Runnable接口的类可以在不子类化Tread类的情况下, 实例化一个Thread实例并且使其自身作为目标传入. 在大多数情况下, 如果仅要重写Thread的run方法, 而不重写其他方法, 就使用Runnable接口. 这十分重要, 因为类不应该子类化, 除非程序员想要修改或增强类的基础行为.
---

```java 
void run()
```
> 当实现了Runnable接口的对象创建了一个线程, 开启该线程将导致在一个独立的线程中执行run方法.