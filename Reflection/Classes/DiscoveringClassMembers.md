## Discovering Class Members

> `Class` 提供两类方法获取`字段, 方法和构造器:
枚举成员和搜索特殊成员的方法.同时有唯一的方法获取由类直接声明的方法,
而不是由父接口和父类继承而来的方法.

> 加载字段, 方法, 构造函数的类方法, 器中构造函数不被继承

Class API | List of members? | Inherited members? | Private members?
--- | --- | --- | ---
getDeclaredField() | no | no | yes
getField() | no | yes | no
getDeclaredFields | yes | no | yes
getFields | yes | yes |no

