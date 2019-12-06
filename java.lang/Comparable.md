### public interface Comparable<T>

> 该接口规定了实现它的类执行全排序. 该排序被称为类的自然排序, 类的comparTo方法被称为自然排序方法.

> 实现了该接口的列表(和数组)可以由Colections.sort方法自动排序. 实现了该接口的对象可以作为sorted map的键或是sorted set的元素, 而不用实现特定的比较器.

> 当且仅当e1.compareTo(e2) == 0 和 e1.equals(e2)对每个C的实例e1和e2都有相同的值时, 才说C的自然排序与equals是相一致的. 需要注意null不是任何类的实例, e.compareTo(null)必须抛出NullPointerExcption, 即使e.equals(null) 返回false.

> 强烈建议自然排序与equals方法保持一致(尽管不是必须的). 没有显示比较器的sorted set(和 sorted map)的行为十分奇怪, 当他们使用自然排序与equals不一致的对象作为元素(或key). 

> 例如, 如果添加a, b且 `!a.equals(b) && a.compareTo(b) == 0` (注: 即a.equals(b)产生false, 而comapreTo产生true, 行为不一致)到一个未使用显示的比较器的sorted set中, 那么第二次添加将会失败, 因为在sorted set看来a与b是等价的.

> 事实上, 所有实现了Comparable接口的java核心类的自然排序与equals都保持一致.只有`java.math.BigDecimal`例外, 它的自然排序等于BigDecimal对象(拥有相等的值但是精度不同)
---

```java 
int compareTo(T o)
```
> 将该对象与给定的对象比较排序. 当该对象小于,等于,大于给定对象时,分别返回负数,0,正数.

> 自反性: 实现者必须保证对所有的x和y, 都有sgn(x.compareTo(y)) == -sgn(y.compareTo(x)).(也就是说当y.compareTo(x)抛出异常时, x.compareTo(y)也必须抛出异常)

> 传递性: 实现者必须保证比较是可以传递的: 由x.compareTo(y)>0 && y.compareTo(z) > 0 可以得到 x.compareTo(z) > 0

> 最后实现这必须保证当x.compareTo(y) == 0时, 对所有的z来说 sgn(x.compareTo(z)) == sgn(y.compareTo(z))

> 强烈推荐但不是严格要求 (x.compareTo(y) == 0) == (x.equals(y)). 一般来说, 任何违反了该条件的Comparable实现类必须明确指出它. 推荐这样来写: "Note: this class has a natural ordering that is inconsistent with equals."

> 上述中, sgn(expression)符号指数学上的signum方法, 该方法定义了当表达式的职位负数,零,正数时, 分别返回-1, 0, 1

##### Parameters:
> o - the object to be compared.
##### Returns:
> 小于, 等于, 大于给定对象时, 返回负数, 零, 正数
##### Throws:
> NullPointerException - if the specified object is null

> ClassCastException - 如果指定对象类型无法与该对象比较.