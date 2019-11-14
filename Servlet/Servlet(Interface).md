## Interface Servlet  
<b>定义了所有servlets都要实现的方法.  
servlet是一个运行在web服务器中的一个java小程序.Servlets从web客户端接收并返回请求, 通常是通过http, 即超文本传输协议.  
实现该接口, 可以继承自`javax.servlet.GenericServlet `, 或者`javax.servlet.http.HttpServlet`.  
该接口定义了以下方法: 初始化servlet, 服务请求, 从服务中移除请求. 这些被称为生命周期方法, 并且以以下顺序调用:  
  - servlet创建, 调用`init`方法
  - 任意客户端请求调用`service`方法
  - servlet退出service, 调用`destroy`方法进行销毁, 最终由gc进行销毁.  

除了生命周期方法外, 该接口还提供了`getServletConfig`方法: 用来获取任意的启动信息, `getServletInfo`方法: 允许servlet返回自身的基础信息, 例如: 作者, 版本, 版权(copyright)等.  </b>

---
### 方法概要

修饰符和类型 | 方法和描述
--- | ---
void | <p id='1'>[`destroy()`](#6)</p> 由servlet容器调用以指示该servlet正在推出服务  
ServletConfig | <p id='2'>[`getServletConfig()`](#7)</p>返回一个`ServletConfig`对象, 包含了该servlet的初始和启动参数  
String | <p id='3'>[`getServletInfo()`](#8)</p>返回servlet的信息, 例如: 作者, 版本, 版权等.
void | <p id='4'>[`init(ServletConfig config)`](#9)</p>由servlet容器调用用以指示该servlet正在被部署至服务中  
void | <p id='5'>[`service(ServletRequest req, ServletResponse res)`](#10)</p>由servlet容器调用允许servlet相应请求

--- 
### 方法详情
<span id='9'>[`init`](#4)</span>
``` java
void init(ServletConfig config) throws ServletException
```  
实例化servlet之后, servlet容器只调用`init`方法一次.`init`方法必须在servlet接收到任何请求之前完成.  
发生以下情况, servlet容器无法部署servlet至服务中:
- 抛出`ServletException`  
- 在web服务定义的时间周期内没有返回  

`Parameters`:  
>&ensp;&ensp;`config` - 包含了servlet配置及初始化参数的`ServletConfig`对象  

`Throws`:  
>&ensp;&ensp;`ServletException` - 如果正常的servlet操作发生异常  

---
<span id='7'>[`getServletConfig`](#2)</span>
```java
ServletConfig getServletConfig()
```
获得的ServletConfig对象就是传递给`init`方法的参数.  
这个接口的实现目的是存储`ServletConfig`对象以便这个方法可以返回它.类已经实现了该接口的类`GenericServlet`已经完成了这一点.  
`Returns`:  
> 初始化这个servlet的ServletConfig对象

<span id='10'>[`service`](#5)</span>
```java
void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
```
只有`init()`方法成功完成才会调用该方法  
当servlet抛出或者发送错误时, 必须设置回复的状态码  
Servlets通常在多线程servlet中执行, 以便同时处理多个请求. 开发者必须关心任何共享资源的同步, 例如: 文件, 网络连接, servlet's类以继实例变量.  
`Parameters:`
> req - 包含客户端请求的ServletRequest对象  
> res - 包含servlet's回复的ServletResponse对象  

`Throws:`  
> `ServletException` - 错误发生在接口servlet's正常操作时  
> `IOException` - 输入或输出错误发生时  

---
<span id='8'>[getServletInfo:](#3)</span>
```java
String getServletInfo()
```
该方法返回的字符串必须是普通的文本, 不能由任意类型的标记(像HTML, XML等)  
`Returns:`
> 包含servlet信息的String

---
<span id='6'>[destroy](#1)</span>
```java
void destroy()
```
该方法只在servlet的`service`方法已经退出或者一个超时周期已经过去后调用一次. 在servlet容器调用该方法后, 在该servlet中将不再调用`service`方法.  
该方法给予servlet清除所拥有资源的机会, 并确定任何的现有状态都与内存中的servlet的当前状态同步.  