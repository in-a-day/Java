## interface ServletConfig
### public interface ServletConfig
<b>servlet配置对象, 被用于servlet容器初始化时传递信息给servlet</b>

---
### 方法概要
| 类型 | 方法及描述 |
| ---- | ---------- |
String | [getInitParameter(String name)](#3)</br>获取指定名称的初始化参数值
Enumeration<String> | [getInitParameterNames()](#4)</br>返回servlet初始话对象, 对象类型为Enumeation, 如果没有参数则返回空的Enumeratioin
ServletContext | [getServletContext()](#2)<br>返回调用的servlet上下文的引用
String | [getServletName()](#1)<br>返回servlet名称

---
### 方法详情
<b id='1'>[getServletName](#%e6%96%b9%e6%b3%95%e6%a6%82%e8%a6%81)</b>
```java
String getServletName()
```
> 返回这个servlet实例名称

---
<b id='2'>[getServletContext](#%e6%96%b9%e6%b3%95%e6%a6%82%e8%a6%81)</b>
```java
ServletContext getServletContext()
```
> 返回ServletContext对象, 调用者使用它与servlet容器交互

---
<b id='3'>[getInitParameter](#%e6%96%b9%e6%b3%95%e6%a6%82%e8%a6%81)</b>
```java
String getInitParameter(String name)
```
`Parameters:`  
> name - 需要返回的初始化参数的名称  

`Returns:`  
> 返回指定名称的servlet初始化参数值

---
<b id='4'>[getInitParameterNames](#%e6%96%b9%e6%b3%95%e6%a6%82%e8%a6%81)</b>
```java
Enumeration<String> getInitParameterNames()
```
`Returns:`  
> 字符串对象的枚举, 包含了所有servlet初始化参数的名称