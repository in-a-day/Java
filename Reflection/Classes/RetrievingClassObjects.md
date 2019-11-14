### Object.getClass()
> 如果对象的实例可用, 那么最简单的方法获取`Class`是调用`Object.getClass()`, 仅当继承于`Object`类的引用类型才可用.  
```java
// 数组类型继承于Object, 那么就可以调用getClass方法
byte[] bytes = new byte[1024];
Class c = bytes.getClass();
```

---

### .class语法
> 如果类型可用但是没有实例, 那么可以通过再类型名称后加.class获取`Class`, 这也是获取原型的`Class`的最简单的方法.  
```java
boolean b;
Class c = boolean.class;
Class c = b.getClass();
// 多维数组可以使用.class
Class c = int[][][].class;
```
---

### Class.forName()
> 如果可以获得一个类的全限定名称, 那么可以使用`Class.forName()`方法获取`Class`. 原型无法使用该方法. 数组类名语法由`Class.getName()`提供. 该方法适用于引用和原始类型.  
```java
Class c = Class.forName("club.margay.Test");
// double数组的Class
Class c = Class.forName("[D");
// 二维String数组的Class
Class c = Class.forName("[[Ljava.lang.String;");
```

---

### 原始类型包装器的类型字段
> 原始类型包装器的`TYPE`字段可以返回原型的`Class`  
```java
Class c = Double.TYPE;
Class c = Void.TYPE;
```

---

### 返回类的方法
> 有一系列的反射API可以返回类, 但是只有在直接或间接获得了`Class`的情况下才可以访问这些API.  
- `Class.getSuperclass()` 返回给定类的父类
- `Class.getClasses()` 返回属于该类成员的所有公有类, 接口, 枚举, 包括继承的成员.
- `Class.getDeclaredClasses()` 返回在该类中显示声明的类接口和枚举.
- `Class.getDeclaringClass()
  java.lang.reflect.Field.getDeclaringClass()
  java.lang.reflect.Method.getDeclaringClass()
  java.lang.reflect.Constructor.getDeclaringClass()` 返回声明成员的类. 匿名内部类声明没有声明的类, 但是有一个封闭的类.  
```java
public class MyClass {
    static Object o = new Object() {
        public void m() {} 
    };
    static Class<c> = o.getClass().getEnclosingClass();
}
```
- `Class.getEnclosingClass()` 返回当前类的直接封闭类
