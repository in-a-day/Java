# Members

> 反射定义了一个`java.lang.reflect.Member`接口, 有以下实现: `Field`, `Method`, `Constructor`, `Executable`. 

> public interface Member
> Member is an interface that reflects identifying information about a single member (a field or a method) or a constructor.

### Fields

Modifier and Type | Field and Description
--- | ---
static int | DECLARED </br> 类或接口中声明成员的集合的标识
static int | PUBLIC </br> 标识类或接口所有公有成员的集合, 包括继承的成员

### Method Summary

Modifier and Type | Field and Description
--- | ---
Class<?> | getDeclaringClass() </br> Returns the Class object representing the class or interface that declares the member or constructor represented by this Member.
int | getModifiers() </br> 以整数形式返回该成员表示的成员或构造器的java修饰符.
String | getName() </br> 返回由该成员表示的基本的成员或构造器的简单名称.
boolean | isSynthetic() 如果该成员由编译器引入返回true, 否则false



