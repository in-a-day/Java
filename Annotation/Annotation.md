## Annotation

> 不包含任何元素的注解称为标记注解(mark annotation)

### 元注解

> 用于定义注解

| 注解        | 解释                                                         |
| ----------- | ------------------------------------------------------------ |
| @Target     | 表示注解可以用于哪些地方。可能的 **ElementType** 参数包括： **CONSTRUCTOR**：构造器的声明 <br>**FIELD**：字段声明（包括 enum 实例）<br/>**LOCAL_VARIABLE**：局部变量声明 <br/>**METHOD**：方法声明<br/>**PACKAGE**：包声明 <br/>**PARAMETER**：参数声明 <br/>**TYPE**：类、接口（包括注解类型）或者 enum 声明 |
| @Retention  | 表示注解信息保存的时长。可选的 **RetentionPolicy** 参数包括： <br>**SOURCE**：注解将被编译器丢弃 <br/>**CLASS**：注解在 class 文件中可用，但是会被 VM 丢弃。 <br/>**RUNTIME**：VM 将在运行期也保留注解，因此可以通过反射机制读取注解的信息。 |
| @Documented | 将此注解保存在 Javadoc 中                                    |
| @Inherited  | 允许子类继承父类的注解                                       |
| @Repeatable | 允许一个注解可以被使用一次或者多次（Java 8）。               |

- java提供的5中标准注解
  - @Override: 表示当前方法定义覆盖父类方法, 如果覆盖错误, 编译器发出错误提示
  - @Deprecated: 表示该元素被舍弃, 如果调用该元素, 编译器发出警告信息
  - 
  - @SuppressWarnings: 关闭不当的编译器警告信息
  - @SafeVarargs: 禁止对具有泛型varargs参数的方法或构造器调用发出警告
  - @FunctionalInterface: 表示接口是函数式接口

---

### 创建注解



#### 注解元素

- 可用注解元素
  - 所有基本类型
  - String
  - Class
  - enum
  - Annotation
  - 以上所有类型数组

> 注: 不可使用包装类型.
>
> 元素必须有值(可以使用默认值, 或者使用注解时传入值), 非基本类型的元素不能使用null作为默认值

> 如果元素名称为value, 且是唯一一个需要赋值的元素, 那么在赋值时不需要写出value名称

#### 注解不支持继承

> 即一个注解无法继承另一个注解, 只能在在注解中使用另一个注解.