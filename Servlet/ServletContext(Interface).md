javax.servlet
## Interface ServletContext

---
### public Interface ServletContext
定义一个servlet用于与servlet容器交流的方法的集合, 例如, 获取文件类型, 发送请求, 写入日志文件.  
每个web程序每个java虚拟机有一个context(上下文), (一个web应用是服务器命名空间下安装的servlet和content的集合, 例如/catalog下并且可能是由.war文件安装的).  
在一个web应用在它的部署环境下被标记为分布式应用的情况下, 对每个虚拟机来说都有一个context. 对于这种情况, 本地context不能被用来共享全局信息(因为本地信息不完全是全局信息). 使用额外的资源, 像是数据库替代它.  
ServletConfig对象包含ServleContext对象, web服务器提供servlet当servlet被初始化时.  

---
### 字段概要:
修饰符及类型 | 字段及描述
--- | ---
static String | <p>[ORDERED_LIBS](#orderedlibs)</p>ServletContext属性名称的值, 包含了WEB-INF/lib下JAR包文件的名称, 以web碎片名称排序, 或者是空如果没有绝对或者是关联的排序被声明.  
static String | <p id=''>[TEMPDIR](#tempdir)</p> ServletContext属性名称, 存储由servlet容器为这个ServletContext私有临时文件  

---
### 方法概要:  
修饰符及类型 | 方法及说明
--- | ---
FilterRegistration.Dynamic | [addFilter(String filterName, Class<? extends Filter> filterClass)](#addFilter1)</br>添加给定名称和类型的过滤器到servlet上下文中
FilterRegistration.Dynamic | [addFilter(String filterName, Filter filter)](#addFilter2)</br>以给定的过滤器名称在servlet上下文中注册
FilterRegistration.Dynamic | [addFilter(String filterName, String className)](#addFilter3)</br>以给定的过滤器名称和类名称注册到servlet上下文中
ServletRegistration.Dynamic | [addJspFile(String servletName, String jspFile)](#addJspFile)</br>将给定的jsp文件加入servlet上下文中
void | [addListener(Class<? extends EventListener> listenerClass)](#addListener1)</br>将给定类型的监听器加入servlet上下文中
void | [addListener(String name)](#addListener2)</br>将给定类名称的监听器加入servlet上下文中  
\<T extends EventListener\> void | [addListener(T t)](#addListener3)</br>将给定的监听器加入servlet上下文
ServletRegistration.Dynamic	| [addServlet(String servletName, Class<? extends Servlet> servletClass)](#addServlet1)</br>将给定类型和名称的servlet加入servlet上下文
ServletRegistration.Dynamic | [addServlet(String servlet, Servlet servlet)](#addServlet2)</br>在上下文中以给定的servlet名称注册servlet
ServletRegistration.Dynamic | [addServlet(String servletName, String className)](#addServlet3)</br>将servlet以给定的名称和类名加入servlet上下文中
\<T extends Filter> T | [createFilter(Class\<T> clazz)](#createFilter1)</br>实例化给定的过滤器
\<T extends EventListener> T | [createListener(Class\<T> claszz)](#createListener)</br>实例化给定的监听器
\<T extends Servlet> T | [createServlet(Class\<T> clazz)](#createServlet)</br>实例化给定的servlet
void | [declareRoles(String... roleNames)](#declareRoles)</br>声明用`isUserInRole`测试的role名称
Object | [getAttribute(String name)](#getAttribute)</br>返回给定名称的servlet属性, 如果不存在返回null
Enumeration<String> | [getAttributeNames()](#getAttributeNames)</br>返回一个枚举, 包含在servlet上下文中可获得的属性名称
ClassLoader | [getClassLoader()](#getClassLoader)</br>获得由该servlet上下文代表的web应用的类加载器
ServletContext | [getContext(String uripath)](#getContext)</br>返回服务器上响应该特定url的servlet上下文对象
String | [getContextPath()](#getContextPath)</br>返回web应用的上下文路径
Set<SessionTrackingMode> | [getDefalutSessionTrackingModes()](#getDefualtSessionTrackingModes)</br>获得该servlet上下文默认支持的session追踪方法
int | [getEffectiveMajoVesion()](#getEffectiveMajoVersion)</br>获得由该servlet上下文代表的应用的主版本号
int | [getEffectiveMinorVesion](#getEffectiveMinorVersion)</br>获得由该servlet上下文代表的应用的次版本号
Set<SessionTrackingMode> | [getEffectiveSessionTrackingModes()](#getEffectiveSessionTrackingModes)</br>获取该servlet上下文实际上的session追踪方法
FilterRegistration | [getFilterRegistration(String filerName)](#getFilterRegistration)</br>已给定的filter名称获取相当于过滤器的过滤器注册器
Map<String, ? extends FilterRegistration> | [getFilterRegistrations()](#getFilterRegistrations)</br>获得使用该servlet上下文注册的所有过滤器的注册器, (可能是空map), key为过滤器名称, value是`FilterRegistration`
String | [getInitParameter(String name)](#getInitParameter)</br>返回包含命名的上下文初始化参数, 参数不存在返回null
Enumeration<String> | [getInitParameterNames()](#getInitParameterNames)</br>
JspConfigDescriptor | [getJspConfigDescriptor()](#getJspConfigDesciptor)</br>获取\<jsp-config>关联由servlet上下文代表的web.xml和web.fragment.xml描述文件汇总配置信息
int | [getMajorVersion()](#getMajorVersion)</br>返回servlet容器支持的Servlet API的主版本
String | [getMimeType(String file)](#getMimeType)</br>返回给定文件的类型, 未知返回null
int | [getMinorVersion()](#getMinorVersion)</br>返回servlet容器支持的Servlet API的次版本
RequestDispatcher | [getNamedDispatcher(String name)](#getNamedDispathcer)</br>返回一个`RequestDispatcher`对象作为给定名称servlet的装饰器
String | [getRealPath(String path)](#getRealPath)</br>获取给定虚拟地址的真实地址
String | [getRequestCharacterEncoding()](#getRequestCharacterEncoding)</br>获得servlet上下文默认支持的请求字符编码
RequestDispatcher | [getRequestDispatcher(String path)](#getRequestDispatcher)</br> 返回一个`RequestDispatcher`对象作为以给定路径加载的资源的装饰器
URL | [getResource(String path)](#getResource)</br>返回映射到给定路径的资源的URL
InputStream | [getResourceAsStream(String path)](#getResourceAsStream)</br>返回指定名称路径加载的资源作为一个InputStream
Set\<String> | [getResourcePaths(String path)](#getResourcePaths)</br>返回一个web服务器中的所有path的目录式列表, path最长子路径匹配提供的path参数
String | [getResponseCharacterEncoding()](#getResponseCharacterEncoding)</br>servlet上下文默认支持的响应字符编码
String | [getServerInfo()]#(getServerInfo)</br>获得运行中的servlet容器的名称和版本
Servlet | [getServlet(String name)](#getServlet)
String | [getServletContextName()](#getServletContextName)</br>
Enumeration<String> | [getServletNames()](#getServletNames)
ServletRegistion | [getServletRegistion(String servletName)](#getServletRegistion)</br>获得给定servlet名称的servlet相关的`ServletRegistion`
Map<String, ? extends ServletRegistion> | [getServletRegistions()](#getServletRegistions)获得所有关联到在该servlet上下文中注册的servlet的ServletRegistion的map, key为servlet名称, value为`ServletRegistion`
Enumeration<Servlet> | [getServlets()](#getServlets)
SessionCookieConfig | [getSessionCookieConfig()](#getSessionCookieConfig)</br>获取`SessionCookieConfig`对象, 通过不同的配置session追踪cookie为了该servlet上下文可能配置
int | [getSessionTimeout()](#getSessionTimeout)</br>获取该servlet上下文默认支持的session超时时间(单位为分钟)
String | [getVirtualServerName()](#getVirtualServerName)</br>返回servlet上下文部署的逻辑host的配置名称
void | [log(Exception exception, String msg)](#log1)</br>使用`log(String message, Throwable throwable)`代替, 起初被定义用来写入异常栈和错误信息到日志文件中
void | [log(String msg)](#log2)</br>写入指定信息到servlet日志文件中, 一般是事件日志
void | [log(String message, Throwable throwable)](#log3)</br>将给定的Throwable异常的解释信息和栈追踪写入servlet日志文件中
void | [removeAttribute(String name)](#removeAttribute)</br>在servelt上下文中移除给定名称的属性
void | [setAttribute(String name, Object object)](#setAttribute)</br>在servlet上下文中以给定名称绑定一个对象
boolean | [setInitParameter(String name, String value)](#setInitParameter)在servlet上下文中已给定的name和value设置上下文初始化参数
void | [setRequestCharacterEncoding(String encoding)](#setRequestCharacterEncoding)</br>为servlet上下文设置请求字符编码
void | [setResponseCharacterEncoding(String encoding)](#setCharacterResponseEncoding)</br>为servlet上下文设置响应字符编码
void | [setSessionTimeout(int sessionTimeout)](#setSessionTimeout)</br>为servlet上下文设置session过时时间(以分钟为单位)
void | [setSessionTrackingModes(Set<SessionTrackingMode> SessionTrackingModes)](#setSessionTrackingModes)</br>为上下文设置有用的session追踪方法

---
### 字段详情  
<b id='tempdir'>[`static final String TEMPDIR`](#字段概要)</b>  
servlet上下文属性名称, 存储在servlet容器为servlet上下文提供的私有临时目录(java.io.File类型)  

--- 
<b id='orderedlibs'>[`static final String TEMPDIR`](#字段概要)</b>  
servlet上下文属性名称, value(List<String>类型)包含WEB-INF/lib下jar文件名称列表, 以他们web片段名称排序(可能的除了如果\<absolute-ordering> 没有任何\<others/> 被使用), 或者null如果没有绝对或相对排序被指出.  

---
### 方法详情
<b id='getcontextpath'>[getContextPath](#方法概要)</b>  
```java 
String getContextPath()
```
返回web应用的上下文路径.  
上下文路径是请求URI的位置, 被用来选择请求的上下文. 在一个请求URI中, 上下文路径总是在前面. 如何这个上下文是"root"上下文位于web应用URL命名空间的基本部分的根部, 该路径将会是一个空字符串. 否则, 如果这个上下文不在服务器命名空间根部, 该路径以 / 字符开始, 但是不以 / 字符结束.  
一个servlet容器通过多个上下文路径可能匹配一个上下文. 在这种情况下, `HttpServletRequest.getContextPath()`将会使用请求返回真实的上下文路径并且他可能不同于使用这个方法返回的值. 这个方法返回的上下文路径作为该应用的基本或首选路径.  
`Returns`:  
The context path of the web application, or "" for the root context
web应用的上下文路径, 或空对于根上下文

---
<b id='getcontext'>[getContext](#方法概要)</b>  
```java
ServletContext getContext(String uripath)
```
返回服务器响应给定的url的`ServletContext对象`.
This method allows servlets to gain access to the context for various parts of the server, and as needed obtain RequestDispatcher objects from the context. The given path must be begin with /, is interpreted relative to the server's document root and is matched against the context roots of other web applications hosted on this container.  
这个方法允许servlets为服务器不同部分添加方法到上下文中, 并且作为需要从上下文中获取`RequestDispatcher`对象. 给定的路径必须以 / 开始, 解释相关服务根文档, 并且匹配其他web应用的上下文根.  
为了环境安全, servlet容器应该为给定的URL返回空.  

`Parameters`:
uripath - 一个指定上下文路径, 容器中的其他web应用
`Returns`:
响应给定的URL的`ServletContext`对象, 或空如果不存在, 或者容器想要直接这个请求  

---
<b id='getmajorversion'>[getMajorVesion](#方法概要)</b>  
```java
int getMajorVersion()
```
返回该servlet容器支持的servlet API的主版本. 所有实现4.0版本的必须返回4.  
`Returns`:  
4

---
<b id='getminorversion'>[getMinorVersion](#方法概要)</b>  
```java
int getMinorVersion()
```
返回servlet容器支持的次版本servlet API. 所有实现4.0版本必须返回0.  
`Returns:`  
0

---
<b id='geteffectivemajorversion'>[getEffectiveMajorVersion](#方法概要)</b>  
```java
int getEffectiveMajorVersion()
```
获取servlet特定的主版本(应用代表的servlet上下文所基于). 返回的值可能不同于`getMajorVersion()`.

`Returns:`  
获取servlet特定的主版本(应用代表的servlet上下文所基于).  
`Throws`:  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='geteffectiveminorversion'>[getEffectiveMinorVersion](#方法概要)</b>  
```java 
int getEffectiveMinorVersion()
```
`Returns`:  
the minor version of the Servlet specification that the application represented by this ServletContext is based on  
`Throws`:  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='getmimetype'>[getMimeType](#方法概要)</b>  
```java
String getMimeType(String file)
```
返回给定文件的类型, 文件类型不可知返回null. 文件类型是由servlet容器的配置文件决定的, 并且在web应用部署器中被指定.普通文件类型包括: text/html, image/gif.  
`Parameters`:  
file - 指定文件名称(String类型)
`Returns`:  
指定文件类型(String类型)

---
<b id='getresourcepaths'>[getResourcePaths](#方法概要)</b>  
```java
Set<String> getResourcePaths(String path)
```
返回web服务器中所有资源路径的目录类列表, 路径的最长子路径需要匹配提供的路径.
表示子目录路径的路径以一个 / 结束.

返回的所有路径都关联到web服务器的根部, 或者关联到web服务器的 `/WEB-INF/lib`目录内一个JAR文件的 `/META-INF/resources`, 并且以 / 开头.

The returned set is not backed by the ServletContext object, so changes in the returned set are not reflected in the ServletContext object, and vice-versa.
返回的set不被`ServletContext`对象支持, 所以返回的set的改变不会反射到`ServletContext`对象, 反之亦然.

例如, 一个web服务器包含:

   /welcome.html
   /catalog/index.html
   /catalog/products.html
   /catalog/offers/books.html
   /catalog/offers/music.html
   /customer/login.jsp
   /WEB-INF/web.xml
   /WEB-INF/classes/com.acme.OrderServlet.class
   /WEB-INF/lib/catalog.jar!/META-INF/resources/catalog/moreOffers/books.html
 
getResourcePaths("/") 将返回 {"/welcome.html", "/catalog/", "/customer/", "/WEB-INF/"}, and getResourcePaths("/catalog/") would return {"/catalog/index.html", "/catalog/products.html", "/catalog/offers/", "/catalog/moreOffers/"}.  

`Parameters`:  
path - the partial(局部的, 部分) path used to match the resources, which must start with a /

`Returns:`  
a Set containing the directory listing, or null if there are no resources in the web application whose path begins with the supplied path.

---
<b id='getresource'>[getResource](#方法概要)</b>  
```java
URL getResource(String path)
        throws MalformedURLException
```
Returns a URL to the resource that is mapped to the given path.
返回获得资源的由给定路径映射的url.

// TODO  
该路径必须以一个 / 开始并被解释为相当于当前的上下文根部, 或相当于在web应用/WEB-INF/lib目录内部一个JAR文件的/META-INF/resources目录. 在搜索任何在 /WEB-INF/lib下JAR文件之前, 这个方法首先搜索web应用文档根目录去查找请求的资源. /WEB-INF/resources下JAR文件没有定义搜索顺序.  

这个方法允许servlet容器创建从任何源创建资源到servlets. 资源可以被本地或者远程文件系统加载, 在数据库或是一个.war文件.  

servlet容器必须实现了URL handlers和URLConnection对象, 这些都是获取资源的必要条件.  

这个方法返回空如果没有资源映射到这个路径名称

Some containers may allow writing to the URL returned by this method using the methods of the URL class.
一些容器可能允许返回使用URL类的方法写入的URL

The resource content is returned directly, so be aware that requesting a .jsp page returns the JSP source code. Use a RequestDispatcher instead to include results of an execution.
资源内容直接返回, 所以小心请求一个jsp页面将返回JSp源代码. 使用一个`RequestDispathcer`代替一个可执行的结果

This method has a different purpose than java.lang.Class.getResource, which looks up resources based on a class loader. This method does not use class loaders.
这个方法和`java.lang.Class.getResource`有不同的用途, 其是基于类加载器去寻找资源的. 该方法并不使用类加载器.

`Parameters:`  
path - a String specifying the path to the resource(表示资源路径的字符串)

`Returns`:  
the resource located at the named path, or null if there is no resource at that path(以给定名称加载的资源, null如果该路径没有资源)

`Throws:`  
MalformedURLException - if the pathname is not given in the correct form(如果路径名称未使用正确的形式)

---
<b id='getresourceasstream'>[getResourceAsStream](#方法概要)</b>  
```java
InputStream getResourceAsStream(String path)
```
Returns the resource located at the named path as an InputStream object.(以`InputStream`对象返回给定名称路径加载的资源)

The data in the InputStream can be of any type or length. The path must be specified according to the rules given in getResource. This method returns null if no resource exists at the specified path.(`InputStream`中的数据可以是任何类型和长度. 该路径必须指明与在getResource给定的规则一致. 如果给定路径不存在资源该方法将返回null)

Meta-information such as content length and content type that is available via getResource method is lost when using this method.(可以由`getResource`方法获得的元数据(像是内容长度和内容类型), 在使用该方法后会消失)

The servlet container must implement the URL handlers and URLConnection objects necessary to access the resource.(servlet容器必须实现URL处理器和URLConnection对象, 这些是得到资源的必要条件)

// TODO  
This method is different from java.lang.Class.getResourceAsStream, which uses a class loader. This method allows servlet containers to make a resource available to a servlet from any location, without using a class loader.(该方法不同于`java.lang.Class.getResourceAsStream`, 其使用类加载器. 这个方法允许servlet容器获得资源从任意的地方, 而不使用类加载器)

`Parameters`:  
path - a String specifying the path to the resource(指定资源路径的字符串)

`Returns:`  
the InputStream returned to the servlet, or null if no resource exists at the specified path(servlet返回的InputStream, 或是null如果指定路径不存在资源)

---
<b id='getrequestdispatcher'>[getRequestDispatcher](#方法概要)</b>  
```java
RequestDispatcher getRequestDispatcher(String path)
```
Returns a RequestDispatcher object that acts as a wrapper for the resource located at the given path. A RequestDispatcher object can be used to forward a request to the resource or to include the resource in a response. The resource can be dynamic or static.
>(返回一个`RequestDispatcher`对象作为给定路加载资源的装饰器. `RequestDisPatcher`对象可以用于转发请求到资源, 或是包含资源的响应. 这些资源可以是动态或是静态的)

The pathname must begin with a / and is interpreted as relative to the current context root. Use getContext to obtain a RequestDispatcher for resources in foreign contexts.
> 路径名称必须是以 / 开使并解释未相当于当前内容的根部. 使用`getContext`在不相关内容中获取资源的`RequestDispatcher

This method returns null if the ServletContext cannot return a RequestDispatcher.
>(该方法返回null如果ServletContext不能返回`RequestDispatcher`)

`Parameters:`  
path - a String specifying the pathname to the resource
>(指定资源路径的字符串)

`Returns:`  
a RequestDispatcher object that acts as a wrapper for the resource at the specified path, or null if the ServletContext cannot return a RequestDispatcher
>(一个`RequestDispatcher`对象作为指定路径资源的装饰器, 或null如果`ServletContext`无法返回一个`RequestDispatcher)

---
<b id='getnameddispatcher'>[getNamedDispatcher](#方法概要)</b>  
```java
RequestDispatcher getNamedDispatcher(String name)
```
Returns a RequestDispatcher object that acts as a wrapper for the named servlet.
>(返回一个`RequestDispatcher对象作为命名的servlet的装饰器)

Servlets (and JSP pages also) may be given names via server administration or via a web application deployment descriptor. A servlet instance can determine its name using ServletConfig.getServletName().
>(Servlets(JSP页面相同)可能由服务器管理员或web应用部署器给名称. 一个servlet实例可以使用ServletConfig.getServletName()方法获取它的名称)

This method returns null if the ServletContext cannot return a RequestDispatcher for any reason.
>(该方法返回空如果servlet上下文因任意原因不能返回`RequestDispatcher)

`Parameters:`  
name - a String specifying the name of a servlet to wrap
>(servlet给定装饰名称字符串)

`Returns:`  
a RequestDispatcher object that acts as a wrapper for the named servlet, or null if the ServletContext cannot return a RequestDispatcher
>(一个`RequestDispatcher`对象作为命名的servlet装饰器, 或者null如果servlet上下文不能返回`RequestDispatcher)

---
<b id='getservlet'>[getServlet](#方法概要)</b>  
```java
@Deprecated
Servlet getServlet(String name)
                        throws ServletException
```
Deprecated. As of Java Servlet API 2.1, with no direct replacement.
>(弃用.)

---
<b id='getservlets'>[getServlets](#方法概要)</b>  
```java
@Deprecated
Enumeration<Servlet> getServlets()
```
Deprecated. As of Java Servlet API 2.0, with no replacement.
>(弃用)
<b id='getservletnames'>[getServlets](#方法概要)</b>  

---
```java
@Deprecated
Enumeration<String> getServletNames()
```
Deprecated. As of Java Servlet API 2.1, with no replacement.
>(弃用)

---
<b id='log1'>[log](#方法概要)</b>  
```java
void log(String msg)
```
Writes the specified message to a servlet log file, usually an event log. The name and type of the servlet log file is specific to the servlet container.
>(写入给定的消息到servlet日志文件, 通常是事件日志. servlet日志文件的名称和类型由servlet容器指定)

`Parameters:`  
msg - a String specifying the message to be written to the log file
>(指定写入日志的消息的字符串)

---
<b id='log2'>[log](#方法概要)</b>  
```java
@Deprecated
void log(Exception exception,
                     String msg)
```
Deprecated. As of Java Servlet API 2.1, use log(String message, Throwable throwable) instead.
>弃用. 从Java Servlet API2.1起,使用 `log(String message, Throwable throwable)`代替

---
<b id='log3'>[log](#方法概要)</b>  
```java
void log(String message,
         Throwable throwable)
```
Writes an explanatory message and a stack trace for a given Throwable exception to the servlet log file. The name and type of the servlet log file is specific to the servlet container, usually an event log.
>(将给定的异常的解释信息和栈追踪日志文件. servlet日志文件的名称和类型由servlet容器指定, 通常是事件日志)

`Parameters:`  
message - a String that describes the error or exception
>(描述错误或异常的字符串)
throwable - the Throwable error or exception
>(抛出的错误或异常)

---
<b id='getrealpath'>[getRealPath](#方法概要)</b>  
```java 
String getRealPath(String path)
```
Gets the real path corresponding to the given virtual path.
For example, if path is equal to /index.html, this method will return the absolute file path on the server's filesystem to which a request of the form http://<host>:<port>/<contextPath>/index.html would be mapped, where <contextPath> corresponds to the context path of this ServletContext.
>获取相当于给定虚拟路径的真实地址. 例如: 如果路径等于 /index.html, 该方法将会返回服务器文件系统映射到请求的格式是 `http://<host>:<port>/<contexPath>/index.html`的绝对路径, `<contextPath>` 相当于该servlet上下文的路径

The real path returned will be in a form appropriate to the computer and operating system on which the servlet container is running, including the proper path separators.
>返回的真实路径将格式化为适用于servlet容器运行的计算机操作系统, 包括适当的路径分隔符

Resources inside the /META-INF/resources directories of JAR files bundled in the application's /WEB-INF/lib directory must be considered only if the container has unpacked them from their containing JAR file, in which case the path to the unpacked location must be returned.
>在/WEB-INF/lib目录下的JAR文件的/META-INF/resources目录下的资源必须考虑只有容器已经从包含他们的JAR文件中解压了, 在这种情况下, 解压位置的路径必须被返回.

This method returns null if the servlet container is unable to translate the given virtual path to a real path.
>方法返回空如果servlet容器不能将给定的虚拟地址转换为真实地址.

`Parameters:`  
path - the virtual path to be translated to a real path
>要被转换为真实地址的虚拟地址
`Returns:`  
the real path, or null if the translation cannot be performed
>真实地址, 或null如果无法完成转换

---
<b id='getserverinfo'>[getServerInfo](#方法概要)</b>  
```java 
String getServerInfo()
```
Returns the name and version of the servlet container on which the servlet is running.
>返回运行中的servlet容器的版本名称

The form of the returned string is servername/versionnumber. For example, the JavaServer Web Development Kit may return the string JavaServer Web Dev Kit/1.0.
>返回值格式: servername/versionnumber. 例: JavaServer Web Development Kit将返回JavaServer Web Dev Kit/1.0

The servlet container may return other optional information after the primary string in parentheses, for example, JavaServer Web Dev Kit/1.0 (JDK 1.1.6; Windows NT 4.0 x86).
>servlet容器可能返回其他选项信息在主信息之后的括号内, 例: Java Server Web Dev Kit/1.0 (JDK 1.1.6; Windows NT 4.0 x86)

`Returns:`  
a String containing at least the servlet container name and version number
>至少包含servlet容器名称和版本号的字符串

---
<b id='getinitparameter'>[getInitParameter](#方法概要)</b>  
```java 
String getInitParameter(String name)
```
Returns a String containing the value of the named context-wide initialization parameter, or null if the parameter does not exist.
>返回一个字符串: 命名的context-wide初始化参数, 或null如果参数不存在

This method can make available configuration information useful to an entire web application. For example, it can provide a webmaster's email address or the name of a system that holds critical data.
>该方法能够使可获得的配置信息有益于完成的web应用. 例: 它可以提供网站管理员的邮件地址或保存重要数据的系统名称

``Parameters:`  
name - a String containing the name of the parameter whose value is requested
>参数名称

`Returns:`  
a String containing the value of the context's initialization parameter, or null if the context's initialization parameter does not exist.
>上下文初始化参数的值, 或空如果不存在该参数

`Throws:`  
NullPointerException - if the argument name is null
>参数为空

---
<b id='getinitparameternames'>[getInitParameterNames](#方法概要)</b>  
```java 
Enumeration<String> getInitParameterNames()
```
Returns the names of the context's initialization parameters as an Enumeration of String objects, or an empty Enumeration if the context has no initialization parameters.
>返回上下文初始化参数作为String对象的枚举, 或者为如果上下文无初始化参数

`Returns:`  
an Enumeration of String objects containing the names of the context's initialization parameters
>上下文初始化参数的字符串的枚举

---
<b id='setinitparameter'>[setInitParameter](#方法概要)</b>  
```java 
boolean setInitParameter(String name,
                         String value)
```
Sets the context initialization parameter with the given name and value on this ServletContext.
>以给定名称和值设置上下文的初始化参数

`Parameters:`  
name - the name of the context initialization parameter to set
>初始化参数名称
value - the value of the context initialization parameter to set
>初始化参数值

`Returns:`  
true if the context initialization parameter with the given name and value was set successfully on this ServletContext, and false if it was not set because this ServletContext already contains a context initialization parameter with a matching name
>true如果设置成功, false设置失败因为servlet上下文已经存该初始化参数

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized
>如果servlet上下文已经初始化完成  
NullPointerException - if the name parameter is null
>如果参数名称为空  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
>如果servlet上下文被传递给`ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent)`方法, 即没有在`web.xml`或`web-fragment.xml`中声明, 也未在WebListener中声明

---
<b id='getattribute'>[getAttribute](#方法概要)</b>  
```java 
Object getAttribute(String name)
```
Returns the servlet container attribute with the given name, or null if there is no attribute by that name.
>返回servlet容器属性以给定的名称, 或null如果没有对应的属性

An attribute allows a servlet container to give the servlet additional information not already provided by this interface. See your server documentation for information about its attributes. A list of supported attributes can be retrieved using getAttributeNames.
>属性允许servlet容器给与servlet该接口未提供的额外信息. 关于它的属性查看server文档信息. 支持的属性列表可以通过`getAttributeNames`方法获得.

The attribute is returned as a java.lang.Object or some subclass. 
>返回的属性使java.lang.Object类或是一些子类

Attribute names should follow the same convention as package names. The Java Servlet API specification reserves names matching java.\*, javax.\*, and sun.\* 
> 属性名需要遵循和包名称相同的转换. Java Servlet API规格保留名称匹配 java.\*, javax.\*, sun.\*

`Parameters:`  
name - a String specifying the name of the attribute 
> 指定属性名称的字符串
`Returns:`  
an Object containing the value of the attribute, or null if no attribute exists matching the given name. 
> 包含属性值的对象, 或null如果没有匹配的属性
`Throws:`  
NullPointerException - if the argument name is null
>如果参数为空

---
<b id='getattributenames'>[getAttributeNames](#方法概要)</b>  
```java 
Enumeration<String> getAttributeNames()
```
Returns an Enumeration containing the attribute names available within this ServletContext. 
> servlet上下文可获得的属性名称的枚举

Use the getAttribute(java.lang.String) method with an attribute name to get the value of an attribute.  
> 使用`getAttribute(java.lang.String)`方法获取属性的值

`Returns:`  
an Enumeration of attribute names 
> 属性名称的枚举
<b id='setattribute'>[setAttribute](#方法概要)</b>  
```java 
void setAttribute(String name,
                  Object object)
```
Binds an object to a given attribute name in this ServletContext. If the name specified is already used for an attribute, this method will replace the attribute with the new to the new attribute. 
> 在servlet上下文中绑定给定的属性名和对象. 如果属性名已经被占用, 该方法将替换旧属性为新属性.

If listeners are configured on the ServletContext the container notifies them accordingly. 
> 如果servlet上下文配置了监听器, servlet容器相应的会通知它们.

If a null value is passed, the effect is the same as calling removeAttribute(). 
> 如果值为空, 那么结果和调用`removeAttribute`相同.

Attribute names should follow the same convention as package names. The Java Servlet API specification reserves names matching java.\*, javax.\*, and sun.\*. 
> 属性名称需要遵循包名转换. Java Servlet API 特定的存储名称匹配java.\*, javax.\*, sum.\*

``Parameters:`  
name - a String specifying the name of the attribute 
> 给定的属性名称字符串  
object - an Object representing the attribute to be bound 
> 属性对象

`Throws:``  
NullPointerException - if the name parameter is null 
> 如果name参数为空

---
<b id='removeattribute'>[removeAttribute](#方法概要)</b>  
```java 
void removeAttribute(String name)
```
Removes the attribute with the given name from this ServletContext. After removal, subsequent calls to getAttribute(java.lang.String) to retrieve the attribute's value will return null. 
> 从servlet上下文中删除给定名称的属性. 删除之后, 随后调用`getAttribute(java.lang.String)获取属性值将会返回null.

If listeners are configured on the ServletContext the container notifies them accordingly. 
> 如果servlet上下文配置了监听器, 容器随之通知它们

`Parameters:`  
name - a String specifying the name of the attribute to be removed 
> 移除属性的名称字符串

---
<b id='getservletcontextname'>[getServletContextName](#方法概要)</b>  
```java 
String getServletContextName()
```
Returns the name of this web application corresponding to this ServletContext as specified in the deployment descriptor for this web application by the display-name element. 
> 返回这个web应用的名称, 相当于web应用`display-name`元素的值

`Returns:`  
The name of the web application or null if no name has been declared in the deployment descriptor. 
> web应用的名称或者null如果在部署器中没有声明名称.

---
<b id='addservlet1'>[addServlet](#方法概要)</b>  
```java 
ServletRegistration.Dynamic addServlet(String servletName,
                                       String className)
```
Adds the servlet with the given name and class name to this servlet context. 
> 以给定名称和类名添加servlet到servlet上下文

The registered servlet may be further configured via the returned ServletRegistration object. 
> 注册的servlet应该由返回的`ServletRegistration`对象配置

The specified className will be loaded using the classloader associated with the application represented by this ServletContext. 
> 给定的类名使用类加载器与servlet上下文代表的应用一起加载

If this ServletContext already contains a preliminary ServletRegistration for a servlet with the given servletName, it will be completed (by assigning the given className to it) and returned. 
> 如果servlet上下文已经包含了给定servlet名称的预备`ServletRegistion`, 它将被完成并返回.

This method introspects the class with the given className for the ServletSecurity, MultipartConfig, javax.annotation.security.RunAs, and javax.annotation.security.DeclareRoles annotations. In addition, this method supports resource injection if the class with the given className represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection. 
> 该方法自省类以给定的类名称为了servletSercurity, MultipartConnfig, javax.annotation.sercurity.RunAs, 和javax.annotaion.sercurity.DeclareRoles注解. 除此之外, 该方法支持资源注入, 如果给定的类名代表的是`Managed Bean`. 

`Parameters:`  
servletName - the name of the servlet --> servlet名称  

className - the fully qualified class name of the servlet --> servlet的全限定类名

`Returns:`  
a ServletRegistration object that may be used to further configure the registered servlet, or null if this ServletContext already contains a complete ServletRegistration for a servlet with the given servletName --> `ServletRegistration`对象可以被用来进一步配置注册的servlet, 或null如果servlet上下文已经包含了给定servlet名称的`ServletRegistraion`对象

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized --> 如果servlet上下文已经被初始化  

IllegalArgumentException - if servletName is null or an empty String --> 如果servlet名称为空或是空字符串  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener --> 如果servlet上下文被传递给`ServletContextListener`的`ServletContexListener.contextInitialized(javax.servlet.ServletContextEvent)`方法, 且即未在`web.xml`或`web-fragment.xml`中声明, 也未以WebListener注解.

---
<b id='addservlet2'>[addServlet](#方法概要)</b>  
```java 
ServletRegistration.Dynamic addServlet(String servletName,
                                       Servlet servlet)
```
Registers the given servlet instance with this ServletContext under the given servletName. --> 以给定的servlet名称在上下文中注册给定servlet实例.

The registered servlet may be further configured via the returned ServletRegistration object. --> 注册的servlet可以由返回的`ServletRegistration`对象进一步配置

If this ServletContext already contains a preliminary ServletRegistration for a servlet with the given servletName, it will be completed (by assigning the class name of the given servlet instance to it) and returned. --> 如果servlet上下文已经包含了给定servlet名称的预备`ServletRegistration`对象, 它将完成(通过给定servlet的类名实例化它)并返回

`Parameters:`  
servletName - the name of the servlet --> servlet的名称  

servlet - the servlet instance to register --> 要注册的servlet实例  

`Returns:`  
a ServletRegistration object that may be used to further configure the given servlet, or null if this ServletContext already contains a complete ServletRegistration for a servlet with the given servletName or if the same servlet instance has already been registered with this or another ServletContext in the same container --> 一个`ServletRegistration`对象可被用来进一步配置给定的servlet, 或者null如果该servlet上下文已经包含了完成的给定的servlet名称的`ServletRegistration` 或者是servlet实例已经被同一个容器中的另一个servlet上下文注册了.

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized --> 如果servlet上下文已经被初始化了  

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener  --> 见上函数解释

IllegalArgumentException - if the given servlet instance implements SingleThreadModel, or servletName is null or an empty String  --> 如果给定的servlet实例实现了`SingleThreadModel`或servlet名称是null或是空字符串

---
<b id='addservlet3'>[addServlet](#方法概要)</b>  
```java 
ServletRegistration.Dynamic addServlet(String servletName,
                                       Class<? extends Servlet> servletClass)
```
Adds the servlet with the given name and class type to this servlet context. 
> 添加给定名称和类型的servlet到servlet上下文中.

The registered servlet may be further configured via the returned ServletRegistration object.
> 注册的servlet可以通过`ServletRegistration`对象进一步配置

If this ServletContext already contains a preliminary ServletRegistration for a servlet with the given servletName, it will be completed (by assigning the name of the given servletClass to it) and returned.
> 见上

This method introspects the given servletClass for the ServletSecurity, MultipartConfig, javax.annotation.security.RunAs, and javax.annotation.security.DeclareRoles annotations. In addition, this method supports resource injection if the given servletClass represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.
> 该方法自省给定的servlet类, 为了ServletSecurity, MultipartConfig, javax.annotation.security.RunAs, 和javax.annotation.security.DeclareRoles anootations.除此之外, 该方法支持资源注入, 如果给定的servlet代表一个Managed Bean.

`Parameters:`  
servletName - the name of the servlet
> servlet名称

servletClass - the class object from which the servlet will be instantiated
> 将被初始化的servlet的类对象

`Returns:`  
a ServletRegistration object that may be used to further configure the registered servlet, or null if this ServletContext already contains a complete ServletRegistration for the given servletName
> `ServletRegistration`对象可以被用来进一步配置注册的servlet, 或null如果servlet上下文已经包含了给定servlet名称的完成的`ServletRegistration`

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized
> 如果servlet上下文已经被初始化

IllegalArgumentException - if servletName is null or an empty String
> 如果servlet名称是null或空字符串

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 见上

---
<b id='addjspfile'>[addJspFile](#方法概要)</b>  
```java 
ServletRegistration.Dynamic addJspFile(String servletName,
                                       String jspFile)
```
Adds the servlet with the given jsp file to this servlet context.
> 添加给定的jsp文件到servlet上下文

The registered servlet may be further configured via the returned ServletRegistration object.
> 注册的servlet可被返回的ServletRegistration对象进一步配置

If this ServletContext already contains a preliminary ServletRegistration for a servlet with the given servletName, it will be completed (by assigning the given jspFile to it) and returned.
> 如果servlet上下文已经包含了给定名称的servlet的初始`ServletRegistration`, 它将完成(通过分配给定的jsp文件给他)并返回

`Parameters:`  
servletName - the name of the servlet
> servlet名称
jspFile - the full path to a JSP file within the web application beginning with a `/'.
> web应用中jsp文件的完整路径, 以 / 开头

`Returns:`  
a ServletRegistration object that may be used to further configure the registered servlet, or null if this ServletContext already contains a complete ServletRegistration for a servlet with the given servletName
> `ServletRegistration`对象可能用于进一步配置注册的servlet, 或null如果servlet上下文已经包含给定servlet名称的完成的`ServletRegistration`

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized
> 如果servlet上下文已经初始化了
IllegalArgumentException - if servletName is null or an empty String
> 如果servlet名称为null或是空字符串

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果servlet上下文被传递到一个`ServletContextListener`的ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent)方法, 且并未在`web.xml`或`web-fragment.xml`中声明, 也未以WebListener注解

---
<b id='createservlet'>[createServlet](#方法概要)</b>  
```java 
<T extends Servlet> T createServlet(Class<T> clazz)
                             throws ServletException
```
Instantiates the given Servlet class.
> 实例化给定的servlet类

The returned Servlet instance may be further customized before it is registered with this ServletContext via a call to addServlet(String,Servlet).
> 返回的servlet实例可能被进一步定制, 在使用servlet上下文调用addServlet(String, Servlet)注册之前

The given Servlet class must define a zero argument constructor, which is used to instantiate it.
> 给定的servlet类必须定义一个无参构造器, 用于实例化它.

This method introspects the given clazz for the following annotations: ServletSecurity, MultipartConfig, javax.annotation.security.RunAs, and javax.annotation.security.DeclareRoles. In addition, this method supports resource injection if the given clazz represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.
> 此方法会针对给定的clazz进行以下注解的内省:ServletSecurity, MultipartConfig, javax.annotation.security.RunAs, and javax.annotation.security.DeclareRoles. 除此之外, 此方法支持资源注入如果给定的clazz代表Managed Bean.

`Type Parameters:`  
T - the class of the Servlet to create
> servlet创建的类

`Parameters:`  
clazz - the Servlet class to instantiate
> servlet类实例化

`Returns:`  
the new Servlet instance
新的servlet实例

`Throws:`  
ServletException - if the given clazz fails to be instantiated
> 如果给定的clazz实例化失败

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 见上

---
<b id='getservletregistration'>[getServletRegistration](#方法概要)</b>  
```java 
ServletRegistration getServletRegistration(String servletName)
```
Gets the ServletRegistration corresponding to the servlet with the given servletName.
> 以给定servlet名称获取servlet对应的`ServletRegistration`

`Parameters:`  
servletName - the name of a servlet
> servlet名称

`Returns:`  
the (complete or preliminary) ServletRegistration for the servlet with the given servletName, or null if no ServletRegistration exists under that name
> 具有给定的servlet名称的servlet的(完整或初步)的ServletRegistration,如果该名称不存在`ServletRegistration`则为null

Throws:
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent)方法, 且该方法即未在`web.xml`或`web-fragment.xml`注册, 也未使用WebListener注解.

---
<b id='getservletregistrations'>[getServletRegistrations](#方法概要)</b>  
```java 
Map<String,? extends ServletRegistration> getServletRegistrations()
```
Gets a (possibly empty) Map of the ServletRegistration objects (keyed by servlet name) corresponding to all servlets registered with this ServletContext.
> 获得此ServletContext注册的servlet的相应的ServletRegistration对象的Map(key是servlet名称, 可能为空)

The returned Map includes the ServletRegistration objects corresponding to all declared and annotated servlets, as well as the ServletRegistration objects corresponding to all servlets that have been added via one of the addServlet and addJspFile methods.
> 返回的Map包括所有声明和注解的servlet相应的ServletRegistration, 就像所有由`addServlet`和`addJspFile`方法添加的servlets对应的ServletRegistration对象.

If permitted, any changes to the returned Map must not affect this ServletContext.
> 如果允许, 返回的Map的任何改变都不影响此ServletContext.

`Returns:`  
Map of the (complete and preliminary) ServletRegistration objects corresponding to all servlets currently registered with this ServletContext
> 所有以此ServletContext注册的servlet对应的(完整或初步)ServletRegistration对象的Map.

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext被传递到ServletContextListener的ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent)方法, 且该方法即未在`web.xml`或`web-fragment.xml`中声明, 也未使用WebListener注解.

---
<b id='addfilter1'>[addFilter](#方法概要)</b>  
```java 
FilterRegistration.Dynamic addFilter(String filterName,
                                     String className)
```
Adds the filter with the given name and class name to this servlet context.
> 以给定名称和类名添加过滤器到servlet上下文

The registered filter may be further configured via the returned FilterRegistration object.
> 注册的filter可能由返回的FilterRegistration对象进一步配置.

The specified className will be loaded using the classloader associated with the application represented by this ServletContext.
> 指定的className将使用此ServletContext代表的应用所关联的类加载器加载

If this ServletContext already contains a preliminary FilterRegistration for a filter with the given filterName, it will be completed (by assigning the given className to it) and returned.
> 如果ServletContext已经包含一个给定filterName的filter的初步的FilterRegistration, 它将被完成(通过分配给定的className给他)并返回.

This method supports resource injection if the class with the given className represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.
> 如果给定className的类表示Managed Bean, 那么此方法支持资源注入.

**`Parameters:`**  
filterName - the name of the filter
> 过滤器名称

className - the fully qualified class name of the filter
> 过滤器全限定类名

**`Returns:`**  
a FilterRegistration object that may be used to further configure the registered filter, or null if this ServletContext already contains a complete FilterRegistration for a filter with the given filterName
> 一个FilterRegistration对象可以被用来进一步配置注册的过滤器, 如果此ServletContext已经具有指定filterName的filter的完整的FilterRegistration, 则为null

`Throws:`**  
IllegalStateException - if this ServletContext has already been initialized
> 如果该ServletContext已经被初始化

IllegalArgumentException - if filterName is null or an empty String
> 如果filterName是null或空字符串
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener 
> 如果ServletContext传递给ServletContextListener的contextInitialized(javax.servlet.ServletContext)方法, 且该方法即未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='addfilter2'>[addFilter](#方法概要)</b>  
```java 
FilterRegistration.Dynamic addFilter(String filterName,
                                     Filter filter)
```
Registers the given filter instance with this ServletContext under the given filterName.
> 在此ServletContext中注册给定的filter实例以给定的filterName

The registered filter may be further configured via the returned FilterRegistration object.
> 注册的过滤器可以由返回的`FilterRegistration`对象进一步配置

If this ServletContext already contains a preliminary FilterRegistration for a filter with the given filterName, it will be completed (by assigning the class name of the given filter instance to it) and returned.
> 如果ServletContext已经存在给定名称的过滤器的初步的FilterRegistration, 他将完成(通过分配给定过滤器实例名称给他)并返回.

**`Parameters:`**  
filterName - the name of the filter
> 过滤器名称

filter - the filter instance to register
> 要注册的过滤器实例

**`Returns:`**  
a FilterRegistration object that may be used to further configure the given filter, or null if this ServletContext already contains a complete FilterRegistration for a filter with the given filterName or if the same filter instance has already been registered with this or another ServletContext in the same container
> 一个`FilterRegistration`对象可能被用来进一步配置给定的过滤器, 如果此ServletContext已经包含给定filterName的filter的完整的FilterRegsitration, 或如果相同的过滤器实例已经被此或这其他相同容器下的ServletContext注册了.

`Throws:`**  
IllegalStateException - if this ServletContext has already been initialized
> 如果该ServletContext已经被初始化

IllegalArgumentException - if filterName is null or an empty String
> 如果filterName是null或空字符串

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServeltContext传递到ServletContextListener的contexInitialized(javax.servlte.ServletContextEvent)方法, 且该方法即未在`web.xml`或`web-fragment.xml`中配置, 也未用WebListener注解.

---
<b id='addfilter3'>[addFilter](#方法概要)</b>  
```java 
FilterRegistration.Dynamic addFilter(String filterName,
                                     Class<? extends Filter> filterClass)
```
Adds the filter with the given name and class type to this servlet context.
> 添加给定名称和类型的过滤器到sevlet上下文中
The registered filter may be further configured via the returned FilterRegistration object.

If this ServletContext already contains a preliminary FilterRegistration for a filter with the given filterName, it will be completed (by assigning the name of the given filterClass to it) and returned.

This method supports resource injection if the given filterClass represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.

`Parameters:`  
filterName - the name of the filter

filterClass - the class object from which the filter will be instantiated

`Returns:`  
a FilterRegistration object that may be used to further configure the registered filter, or null if this ServletContext already contains a complete FilterRegistration for a filter with the given filterName

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized

IllegalArgumentException - if filterName is null or an empty String

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='createfilter'>[createFilter](#方法概要)</b>  
```java 
<T extends Filter> T createFilter(Class<T> clazz)
                           throws ServletException
```
Instantiates the given Filter class.
> 实例化给定的过滤器类

The returned Filter instance may be further customized before it is registered with this ServletContext via a call to addFilter(String,Filter).
> 返回的过滤器可以在用ServletContext注册之前调用addFilter(String, Filter)方法进一步定制.

The given Filter class must define a zero argument constructor, which is used to instantiate it.
> 给定的过滤器类必须定义无参构造函数, 用来实例化它

This method supports resource injection if the given clazz represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.
> 如果给定的clazz表示Managed Bean, 则该方法支持资源注入.

`Type Parameters:`  
T - the class of the Filter to create
> 要创建的过滤器类
`Parameters:`  
clazz - the Filter class to instantiate
> 要初始化的过滤器类

`Returns:`  
the new Filter instance
> 新的过滤器实例

`Throws:`  
ServletException - if the given clazz fails to be instantiated
> 如果给定的类实例化失败

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果ServletContext传递给ServletContextListener的contextInitialized(javax.servlet.ServlteContextEvent)方法, 且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='getfilterregistration'>[getFilterRegistration](#方法概要)</b>  
```java 
FilterRegistration getFilterRegistration(String filterName)
```
Gets the FilterRegistration corresponding to the filter with the given filterName.
> 获取以给定名称的filter对应的`FilterRegistration`.

`Parameters:`  
filterName - the name of a filter
> 过滤器名称

`Returns:`  
the (complete or preliminary) FilterRegistration for the filter with the given filterName, or null if no FilterRegistration exists under that name
> 给定filterName的filter的(完整的或初步的)`FilterRegistration`

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent)方法, 且该方法没有在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='getfilterregistrations'>[getFilterRegistrations](#方法概要)</b>  
```java 
Map<String,? extends FilterRegistration> getFilterRegistrations()
```
Gets a (possibly empty) Map of the FilterRegistration objects (keyed by filter name) corresponding to all filters registered with this ServletContext.
> 获得此ServletContex注册的所有过滤器对应的`FilterRegistration`对象的Map(过滤器名称当当作key) (可能为空)

The returned Map includes the FilterRegistration objects corresponding to all declared and annotated filters, as well as the FilterRegistration objects corresponding to all filters that have been added via one of the addFilter methods.
> 返回的Map具有所有声明和注解的过滤器相对应的`FilterRegistration`对象, 就像由`addFilter`方法加入的所有的过滤器对应的FilterRegistration对象

Any changes to the returned Map must not affect this ServletContext.
> 返回的Map的任何改变都不能影响此ServletContext

`Returns:`  
Map of the (complete and preliminary) FilterRegistration objects corresponding to all filters currently registered with this ServletContext
当前注册到ServletContext的所有过滤器相对应的(完成或初步的)FilterRegistration对象的Map

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent)方法中, 且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='getsessioncookieconfig'>[getSessionCookieConfig](#方法概要)</b>  
```java 
SessionCookieConfig getSessionCookieConfig()
```
Gets the SessionCookieConfig object through which various properties of the session tracking cookies created on behalf of this ServletContext may be configured.
> 获取SessionCookieConfig对象, 可以通过该对象配置代表ServletContext创建的session追踪cookies的各种属性.

Repeated invocations of this method will return the same SessionCookieConfig instance.
> 重复调用该方法将返回同一个`SessionCookieConfig`对象

`Returns:`  
the SessionCookieConfig object through which various properties of the session tracking cookies created on behalf of this ServletContext may be configured
> SessionCookieConfig对象, 通过该对象可以配置代表ServletContext创建的session追踪cookie的各种属性.

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果ServletContext传递给ServletContextListener的contextInitialized(javax.servlet.ServlteContextEvent)方法, 且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='setsessiontrackingmodes'>[setSessionTrackingModes](#方法概要)</b>  
```java 
void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes)
```
Sets the session tracking modes that are to become effective for this ServletContext.
> 未ServletContext设置有用的会话追踪模式

The given sessionTrackingModes replaces any session tracking modes set by a previous invocation of this method on this ServletContext.
> 在此ServletContext中, 给定的sessionTrackingModes替换先前调用设置的任何会话追踪模式.

`Parameters:`  
sessionTrackingModes - the set of session tracking modes to become effective for this ServletContext
> 对此ServletContext有效的会话追踪模式的set

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized
> 如果ServletContext已经被实例化

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent)方法中, 且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

IllegalArgumentException - if sessionTrackingModes specifies a combination of SessionTrackingMode.SSL with a session tracking mode other than SessionTrackingMode.SSL, or if sessionTrackingModes specifies a session tracking mode that is not supported by the servlet container
> 如果sessionTrackingModes指定SessionTrackingMode.SSL和不是SessiontrackingMode.SSL的会话追踪模式的组合, 或如果sessionTrackingModes指定servlet容器不支持的会话追踪模式

---
<b id='getdefaultsessiontrackingmodes'>[getDefaultSessionTrackingModes](#方法概要)</b>  
```java 
Set<SessionTrackingMode> getDefaultSessionTrackingModes()
```
Gets the session tracking modes that are supported by default for this ServletContext.
> 获取此ServletContext默认支持的session追踪方法

The returned set is not backed by the ServletContext object, so changes in the returned set are not reflected in the ServletContext object, and vice-versa
> 返回的set不被ServletContext对象支持, 所以返回的set的改变不会反射到ServletContext对象, 反之亦然.

`Returns:`  
set of the session tracking modes supported by default for this ServletContext
> 此ServletContext默认支持的会话会话追踪模式

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent)方法中, 且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='geteffectivesessiontrackingmodes'>[getEffectiveSessionTrackingModes](#方法概要)</b>  
```java 
Set<SessionTrackingMode> getEffectiveSessionTrackingModes()
```
Gets the session tracking modes that are in effect for this ServletContext.
> 返回对ServletContext有效的会话追踪模式

The session tracking modes in effect are those provided to setSessionTrackingModes.
> setSessionTrackingModes提供的是有效的会话追踪模式.

The returned set is not backed by the ServletContext object, so changes in the returned set are not reflected in the ServletContext object, and vice-versa.
> 返回的set不被ServletContext对象支持, 所以返回set的改变不会映射到ServletContext对象, 反之亦然.

`Returns:`  
set of the session tracking modes in effect for this ServletContext
> 对ServerletContext有效的会话追踪模式的set

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent)方法中, 且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='addlistener1'>[addListener](#方法概要)</b>  
```java 
void addListener(String className)
```
Adds the listener with the given class name to this ServletContext.
> 添加给定类名的监听器到ServletContext.

The class with the given name will be loaded using the classloader associated with the application represented by this ServletContext, and must implement one or more of the following interfaces:
> 给定名称的类将使用ServletContext表示的应用程序关联的类加载器加载, 并且必须实现一个或多个以下接口:  
ServletContextAttributeListener  
ServletRequestListener  
ServletRequestAttributeListener  
HttpSessionAttributeListener  
HttpSessionIdListener  
HttpSessionListener  

If this ServletContext was passed to ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext), then the class with the given name may also implement ServletContextListener, in addition to the interfaces listed above.
> 如果此ServletContext传递到ServletContainerInitializer.onStartup(javax.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext),除了上面列出的接口以外, 给定名称的类也可以实现ServletContextListener.

As part of this method call, the container must load the class with the specified class name to ensure that it implements one of the required interfaces.
> 作为方法调用的一部分, 容器必须以给定的类名称加载类以确保它实现了所需接口的其中一个.

If the class with the given name implements a listener interface whose invocation order corresponds to the declaration order (i.e., if it implements ServletRequestListener, ServletContextListener, or HttpSessionListener), then the new listener will be added to the end of the ordered list of listeners of that interface.
> 如果给定名称的类实现了声明顺序与调用顺序相对应的监听器接口(即, 如果它实现了`ServletRequestListener`, `ServletContextListener`, 或`HttpSessionListener`), 则该新监听器将被加入监听器的有序列表的尾部.

This method supports resource injection if the class with the given className represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.
> 如果给定className的类表示一个Managed Bean, 则该接口支持资源注入.

`Parameters:`  
className - the fully qualified class name of the listener
> 监听器的全限定类名

`Throws:`  
IllegalArgumentException - if the class with the given name does not implement any of the above interfaces, or if it implements ServletContextListener and this ServletContext was not passed to ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext)
> 如果给定名称的类未实现任意上述接口, 或者实现了`ServletContextListener`接口, 但是该ServletContext没有传递到ServltContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext)方法.

IllegalStateException - if this ServletContext has already been initialized
> 如果该ServletContext已经被初始化

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent)方法中, 且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='addlistener2'>[addListener](#方法概要)</b>  
```java 
<T extends EventListener> void addListener(T t)
```
Adds the given listener to this ServletContext.
> 添加给定的监听器到 ServletContext.

The given listener must be an instance of one or more of the following interfaces:
> 给定的监听器必须是以下一个或多个接口的实例:
ServletContextAttributeListener  
ServletRequestListener  
ServletRequestAttributeListener  
HttpSessionAttributeListener  
HttpSessionIdListener  
HttpSessionListener  

If this ServletContext was passed to ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext), then the given listener may also be an instance of ServletContextListener, in addition to the interfaces listed above.
> 如果此ServletContext传递到ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext), 除了以上列出的接口, 给定的监听器也可以是`ServletContextListener`接口的实例.

If the given listener is an instance of a listener interface whose invocation order corresponds to the declaration order (i.e., if it is an instance of ServletRequestListener, ServletContextListener, or HttpSessionListener), then the listener will be added to the end of the ordered list of listeners of that interface.
> 如果给定的监听器是listener接口的实例, 且该listener接口调用的顺序相当于声明的顺序(即, 如果是`ServletRequestListener`, `ServletContextListener`, 或`HttpSessionListener`的实例), 则该监听器将被添加到实现的接口的监听器有序列表的末尾.

`Type Parameters:`  
T - the class of the EventListener to add
> 要添加的`EventListener`的类

`Parameters:`  
t - the listener to be added
> 要被添加的监听器

`Throws:`  
IllegalArgumentException - if the given listener is not an instance of any of the above interfaces, or if it is an instance of ServletContextListener and this ServletContext was not passed to ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext)
> 如果给定的监听器不是以上接口的任一实例, 或如果是`ServletContextListener`实例, 但是此ServletContext未传递到ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext)

IllegalStateException - if this ServletContext has already been initialized
> 如果此ServletContext已经初始化了

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果此ServletContext传递到ServletContextListener的ServletContextListener.contextInitailized(javax.servlet.ServletContextEvent) 方法, 并且该方法既未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='addlistener3'>[addListener](#方法概要)</b>  
```java 
void addListener(Class<? extends EventListener> listenerClass)
```
Adds a listener of the given class type to this ServletContext.
> 添加给定类类型的监听器到ServletContext

The given listenerClass must implement one or more of the following interfaces:
> 给定的listenerClass必须实现以下接口中的一个或多个:
ServletContextAttributeListener  
ServletRequestListener  
ServletRequestAttributeListener  
HttpSessionAttributeListener  
HttpSessionIdListener  
HttpSessionListener  

If this ServletContext was passed to ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext), then the given listenerClass may also implement ServletContextListener, in addition to the interfaces listed above.
> 如果此ServletContext传递到ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext), 则除了以上列出的接口外, 给定的listenerClass也可以实现ServletContextListener.

If the given listenerClass implements a listener interface whose invocation order corresponds to the declaration order (i.e., if it implements ServletRequestListener, ServletContextListener, or HttpSessionListener), then the new listener will be added to the end of the ordered list of listeners of that interface.
> 如果给定的listenerClass实现了一个listener接口, 且该接口的调用顺序与声明的接口相对应(即, 如果它实现了`ServletRequestListener`, `ServletContextListener`或`HttpSessionListener`), 则该新的监听器将添加到接口的监听器有序列表的尾部.

This method supports resource injection if the given listenerClass represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.
> 如果给定的listenerClass表示Managed Bean, 则该方法支持资源注入.

`Parameters:`  
listenerClass - the listener class to be instantiated
> 将被实例化的接口类

`Throws:`  
IllegalArgumentException - if the given listenerClass does not implement any of the above interfaces, or if it implements ServletContextListener and this ServletContext was not passed to ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext)
> 如果给定的listenerClass没有实现以上接口的任意一个, 或者实现了ServletContextListener, 但是该ServletContext未被传递到ServletContainerInitializer.onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext)

IServletContextListenerllegalStateException - if this ServletContext has already been initialized
> 如果此ServeltContext已经初始化

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果ServletContext传递到ServletContextListener的ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) 方法, 且该方法即未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='createListener'>[createListener](#方法概要)</b>  
```java 
<T extends EventListener> T createListener(Class<T> clazz)
                                    throws ServletException
```
Instantiates the given EventListener class.
> 实例化给定的EventListener类

The specified EventListener class must implement at least one of the
> 指定的EvnetListener必须至少实现一个以下的接口:  
ServletContextListener, ServletContextAttributeListener, ServletRequestListener, ServletRequestAttributeListener, HttpSessionAttributeListener, HttpSessionIdListener, or HttpSessionListener interfaces.

The returned EventListener instance may be further customized before it is registered with this ServletContext via a call to addListener(EventListener).
> 返回的EventListener实例在ServletContext注册之前可以调用`addListener(EventListener)`方法进一步定制.

The given EventListener class must define a zero argument constructor, which is used to instantiate it.
> 给定的EventListener类必须定义一个无参构造函数, 用来实例化它.

This method supports resource injection if the given clazz represents a Managed Bean. See the Java EE platform and JSR 299 specifications for additional details about Managed Beans and resource injection.
> 如果给定的类表示Managed Bean, 则该方法支持资源注入.

`Type Parameters:`  
T - the class of the EventListener to create
> 将要创建的EventListener类

`Parameters:`  
clazz - the EventListener class to instantiate
> 要初始化的EventListener类

`Returns:`  
the new EventListener instance
> 新的EventListener实例

`Throws:`  
ServletException - if the given clazz fails to be instantiated
> 如果给定的clazz实例化失败
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果ServletContext传递到ServletContextListener的ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) 方法, 且该方法即未被`web.xml`或`web-fragment.xml`声明, 也未用WebListener 注解.

IllegalArgumentException - if the specified EventListener class does not implement any of the ServletContextListener, ServletContextAttributeListener, ServletRequestListener, ServletRequestAttributeListener, HttpSessionAttributeListener, HttpSessionIdListener, or HttpSessionListener interfaces.
> 如果指定的EventListener类未实现上述接口中的任意一个.

---
<b id='getjspconfigdescriptor'>[getJspConfigDescriptor](#方法概要)</b>  
```java 
JspConfigDescriptor getJspConfigDescriptor()
```
Gets the \<jsp-config> related configuration that was aggregated from the web.xml and web-fragment.xml descriptor files of the web application represented by this ServletContext.
> 获取\<jsp-config>相关的配置, 该配置由ServletContext表示的web应用程序的`web.xml`和`web-fragment.xml`描述文件汇总而来.

`Returns:`  
the \<jsp-config> related configuration that was aggregated from the web.xml and web-fragment.xml descriptor files of the web application represented by this ServletContext, or null if no such configuration exists
> 由ServletContext表示的web应用程序的`web.xml`和`web-fragment.xml`的描述文件汇总的\<jsp-config>相关配置, 如果没有这样的配置存在则返回null.

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果ServLetContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent) 方法, 且该方法即未在`web.xml`或`web-fragment.xml`中声明, 也未用WebListener注解.

---
<b id='getclassloader'>[getClassLoader](#方法概要)</b>  
```java 
ClassLoader getClassLoader()
```
Gets the class loader of the web application represented by this ServletContext.
> 获取ServletContext表示的web应用程序的类加载器.

// TODO
If a security manager exists, and the caller's class loader is not the same as, or an ancestor of the requested class loader, then the security manager's checkPermission method is called with a RuntimePermission("getClassLoader") permission to check whether access to the requested class loader should be granted.
> 如果存在安全管理器, 且调用者的类加载器与请求类加载器不同, 或是请求的类加载器的祖先, 则使用RuntimePermission("getClassLoader")权限调用安全管理器的RuntimePermission("getClassLoader")方法检查是否请求访问类加载器应该被授权.

`Returns:`  
the class loader of the web application represented by this ServletContext
> ServletContext表示的web应用程序的类加载器

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener
> 如果ServletContext传递到ServletContextListener的contextInitialized(javax.servlet.ServletContextEvent)方法, 且该方法既未在`web.xml`或`web-fragment`中声明, 也未用WebListener注解.

SecurityException - if a security manager denies access to the requested class loader
> 如果安全管理器拒绝访问请求的类加载器

---
<b id='declareroles'>[declareRoles](#方法概要)</b>  
```java 
void declareRoles(String... roleNames)
```
Declares role names that are tested using isUserInRole.
> 声明使用`isUserInRole`测试的角色名称

Roles that are implicitly declared as a result of their use within the setServletSecurity or setRunAsRole methods of the ServletRegistration interface need not be declared.
> 不需要声明因在ServletRegistration的`setServletSecurity`或`setRunAsRole`方法中使用而隐式声明的角色.

`Parameters:`  
roleNames - the role names being declared
> 将被声明的角色名称

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

IllegalArgumentException - if any of the argument roleNames is null or the empty string
> 如果任意的roleNames是null或是空字符串.

IllegalStateException - if the ServletContext has already been initialized
> 如果ServletContext已经初始化了.

---
<b id='getVirtualServerName'>[getVirtualServerName](#方法概要)</b>  
```java 
String getVirtualServerName()
```
Returns the configuration name of the logical host on which the ServletContext is deployed. Servlet containers may support multiple logical hosts. This method must return the same name for all the servlet contexts deployed on a logical host, and the name returned by this method must be distinct, stable per logical host, and suitable for use in associating server configuration information with the logical host. The returned value is NOT expected or required to be equivalent to a network address or hostname of the logical host.
> 返回ServletContext部署的逻辑主机的配置名称. Servlet容器可能支持多个逻辑主机. 该方法必须返回为部署在同一个逻辑主机上的servlet上下文返回相同名称, 该方法返回的每个逻辑主机名称必须是唯一的, 稳定的, 方便用于逻辑主机关联服务器配置信息. 该返回值不应该或不需要是与网络地址或逻辑主机名称相同名称.

`Returns:`
a String containing the configuration name of the logical host on which the servlet context is deployed.
> servlet上下文部署在的逻辑主机的配置名称的字符串

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='getsessiontimeout'>[getSessionTimeout](#方法概要)</b>  
```java 
int getSessionTimeout()
```
Gets the session timeout in minutes that are supported by default for this ServletContext.
> 获取此ServletContext默认支持的session超时时间(以分钟为单位)

`Returns:`  
the session timeout in minutes that are supported by default for this ServletContext
> 此ServletContext默认支持的session过期时间(分钟为单位)

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='setsessiontimeout'>[setSessionTimeout](#方法概要)</b>  
```java 
void setSessionTimeout(int sessionTimeout)
```
Sets the session timeout in minutes for this ServletContext.
> 为ServletContext设置session超时时间(分钟单位)

`Parameters:`  
sessionTimeout - session timeout in minutes
> session超时时间(分钟单位)

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized
> ServletContext已经初始化

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='getrequestcharacterencoding'>[getRequestCharacterEncoding]()</b>  
```java 
String getRequestCharacterEncoding()
```
Gets the request character encoding that are supported by default for this ServletContext. This method returns null if no request encoding character encoding has been specified in deployment descriptor or container specific configuration (for all web applications in the container).
> 获取ServletContext默认支持的请求字符编码. 如果部署器或容器指定配置没有指定请求字符编码则返回null(为容器中的所有web应用程序).

`Returns:`  
the request character encoding that are supported by default for this ServletContext
> ServletContext默认支持字符编码

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='setRequestCharacterEncoding'>[setRequestCharacterEncoding](#方法概要)</b>  
```java 
void setRequestCharacterEncoding(String encoding)
```
Sets the request character encoding for this ServletContext.
> 为ServletContext设置请求字符编码

`Parameters:`  
encoding - request character encoding
> 请求字符编码

`Throws:`  
IllegalStateException - if this ServletContext has already been initialized
> ServletContext已经被初始化

UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='getresponsecharacterencoding'>[getResponseCharacterEncoding](#方法概要)</b>  
```java 
String getResponseCharacterEncoding()
```
Gets the response character encoding that are supported by default for this ServletContext. This method returns null if no response encoding character encoding has been specified in deployment descriptor or container specific configuration (for all web applications in the container).
> 获取ServletContext默认支持的相应字符编码. 如果部署器或容器指定配置没有指定相应编码则返回null(对所有的容器中的web应用程序)

`Returns:`  
the response character encoding that are supported by default for this ServletContext
> 返回ServletContext默认支持的相应字符编码

`Throws:`  
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---
<b id='setresponsecharacterencoding'>[setResponseCharacterEncoding](#方法概要)</b>  
```java 
void setResponseCharacterEncoding(String encoding)
```
Sets the response character encoding for this ServletContext.
> 为ServletContext设置响应字符编码
`Parameters:`  
encoding - response character encoding
> 响应字符编码

Throws:
IllegalStateException - if this ServletContext has already been initialized
UnsupportedOperationException - if this ServletContext was passed to the ServletContextListener.contextInitialized(javax.servlet.ServletContextEvent) method of a ServletContextListener that was neither declared in web.xml or web-fragment.xml, nor annotated with WebListener

---