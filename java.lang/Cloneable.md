### public interface Cloneable

> 类实现了Cloneable接口向Object.clone()方法表明: 该类的实例逐域复制是合法的.

> 调用一个未实现Cloneable接口的Object.clone()方法, 会抛出CloneNotSupportedException异常.

> 方便起见, 实现了该接口的类需要重写Object.clone(protected)方法, 并设为public.

> 该接口并不含有clone方法. 因此, 不能仅凭对象实现该接口去克隆对象. 即使