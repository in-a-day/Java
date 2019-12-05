### public interface Comparable<T>

> 该接口规定了实现它的类执行全排序. 该排序被称为类的自然排序, 类的comparTo方法被称为自然排序方法.

> 实现了该接口的列表(和数组)可以由Colections.sort方法自动排序. 实现了该接口的对象可以作为sorted map的键或是sorted set的元素, 而不用实现特定的比较器.

> 当且仅当e1.compareTo(e2) == 0 和 e1.equals(e2)对每个C的实例e1和e2都有相同的值时, 才说C的自然排序与equals是相一致的. 需要注意null不是任何类的实例, e.compareTo(null)必须抛出NullPointerExcption, 即使e.equals(null) 返回false.

> 强烈建议自然排序与equals方法保持一致(尽管不是必须的). 没有显示比较器的sorted set(和 sorted map)的行为十分奇怪, 当他们使用自然排序与equals不一致的对象作为元素(或key). 