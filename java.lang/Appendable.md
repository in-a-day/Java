### public interface Appendable
> 表示可以添加字符序列和值的对象. 任何意图接收`Formatter`格式输出的类都需要实现该接口.

> 添加的字符必须是在`Unicode Character Reperesentation`中描述的合法字符.额外的字符可以由16位的字符值组成.

> 该接口不是线程安全的, 需要由实现该接口的类保证线程安全.

> 实现该接口的类可能有不同风格的错误处理方式, 因此不能保证错误会传递到调用者.
---

```java
Appendalbe append(CharSequence csq) throws TOException
```
> 添加给定的字符序列到该Appendable. 整个序列是否全部添加依赖于实现了character sequence csq的类. 例如, 如果csq是`CharBuffer`, 那么由buffer的位置和限制决定将要添加的子序列.
##### Parameters:
> csq - 添加的字符序列. 如果csq是null, 那么4个字符"null"将会添加到该Appendable.
##### Returns:
> 该Appendable的引用
##### Throws:
> IOException - 如果发生I/O错误
---

```java
AppendAble append(CharSequence scq, 
                  int start, int end)
                  throws IOException
```
> 当csq不是null时, 以out.append(csq, start, end)形式调用该函数, 等同于调用out.append(csq.subSequence(start, end))
##### Parameters:
> csq - 如果csq为null, 那么csq被当作"null
> start - 该子序列的开始索引
> end - 子序列的结束索引
##### Returns:
> 该Appendable的引用
##### Throws:
> IndexOutOfBoundsException - 如果开始或结束索引为负数, 或开始大于结束, 或结束索引大于csq.length()
> IOException - 如果产生I/O错误
---

```java
Appendable append(char c) throws IOException
```
> 添加给定的字符到Appendable
##### Parameters:
> c - 需要添加的字符
##### Returns:
> 该Appendable引用
##### Throws:
> IOException - 如果产生I/O错误
