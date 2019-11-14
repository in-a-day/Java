- 一个类可能被一个或多个修饰符声明, 这些声明影响它运行时的行为:
    a. 访问修饰符: public, protected, private
    b. 重写修饰符: abstract
    c. 限制一个实例的修饰符: static
    d. 禁止修改值修饰符: final
    e. 强制严格的浮点行为修饰符: strictfp
    f. 注解
> `java.lang.reflect.Modifier`包含了所有可能的修饰符声明.它也包含可能被用于解码`Class.getModifiers()`方法返回的修饰符集合的方法.


