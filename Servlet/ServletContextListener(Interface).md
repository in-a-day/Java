javax.servlet
## Interface ServletContextListener
`public interface ServletContextListener extends EventListener`
Interface for receiving notification events about ServletContext lifecycle changes.
> 用于接收ServletContext生命周期更改通知事件的接口

In order to receive these notification events, the implementation class must be either declared in the deployment descriptor of the web application, annotated with WebListener, or registered via one of the addListener methods defined on ServletContext.
> 为了接收这些通知事件, 实现类必须在web应用程序部署器中声明, 并以WebListener注解, 或由ServletContext中的`addListener`方法注册.

Implementations of this interface are invoked at their contextInitialized(javax.servlet.ServletContextEvent) method in the order in which they have been declared, and at their contextDestroyed(javax.servlet.ServletContextEvent) method in reverse order.
> 该接口的实现被`contextInitialized(javax.servlet.ServletContextEvent)`方法按声明的顺序调用, `contextDestroyed(javax.servlet.ServletContextEvent)`方法以相反的顺序调用.

### 方法概要
修饰及类型 | 方法及描述
default void | `contextDestroyed(ServletContextEvent sce)`</br>接收ServletContext将要被关闭的通知
default void | `contextInitialized(ServletContextEvent sce)`</br>接收web应用程序初始化程序正在开始的通知

### 方法详情
```
default void contextInitialized(ServletContextEvent sec)
```
Receives notification that the web application initialization process is starting.

All ServletContextListeners are notified of context initialization before any filters or servlets in the web application are initialized.
> 在web应用程序的任何filter或servlet初始化之前, 上下文初始化通知所有的ServletContextListener.

`Parameters`:  
sce - the ServletContextEvent containing the ServletContext that is being initialized
> 包含将被初始化的ServletContext的ServletContextEvent
Implementation Specification:
The default implementation takes no action.

```
default void contextDestroyed(ServletContextEvent sce)
```
Receives notification that the ServletContext is about to be shut down.

All servlets and filters will have been destroyed before any ServletContextListeners are notified of context destruction.
> 在上下文销毁通知任何ServletContextListener之前, 所有的servlet和filter将被销毁.

`Parameters:`  
sce - the ServletContextEvent containing the ServletContext that is being destroyed

`Implementation Specification:`  
The default implementation takes no action.
