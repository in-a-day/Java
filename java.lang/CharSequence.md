### public interface CharSequence

> CharSequence是一个可读的字符值序列. 该接口提供了统一的,只读方式获取不同类型的字符序列. char值代表了基本多语言平面的字符或替代.

> 该接口没有细化equals和hashCode方法的常规定义. 因此, 通常未定义实现了CharSequence的两个对象的比较结果. 每个对象可能由不同的类实现, 没有保证每个类有测试它的实例与其他实例是否相等的能力. 使用任意CharSequence的实例作为set的元素或是map的key是不合适的.
---

```java
int length()
```
##### Returns:
> 序列中char的数量
---

```java
char charAt(int index)
```
> 返回指定索引的char值. 如果该char值是`surrogate`的索引, 则surrogate值将被返回.
##### Parameters:
> index - the index of the char value to be returned
##### Returns:
> the specified char value
##### Throws:
> IndexOutOfBoundsException - 如果参数是负数, 或者大于length()
---

```java 
CharSequence subSequence(int satrt, int end)
```
> 返回该字符序列的子序列, 范围start - end-1, 如果start == end, 返回空序列
##### Parameters:
> start - the start index, inclusive
> end - the end index, exclusive
##### Returns:
> the specified subsequence
##### Throws:
> IndexOutOfBoundsExcption - 如果开始或结束索引为负数, 或结束索引大于length(), 或开始索引大于结束索引
---

```java 
String toString()
```
##### Returns:
> 由该字符序列组成的字符串, 长度与该序列长度相同
---

```java 
default IntStream chars()
```
> 返回该序列的char值的int型(zero-extending)流(stream).任何char值都是未经解释映射到代理码点的.
> 如果该stream正在读取时, 该sequence产生突变, 则结果是未经定义的.
##### Returns:
> 该序列的char值得IntStream
---

```java 
default IntStream codePoints()
```
> 类似于chars(), 需要注意java字符支持区别: unicode 与 utf-16的区别


