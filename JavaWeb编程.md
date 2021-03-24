# [[Cookie|Cookie]]常用操作

## [[Cookie#domain| 设置Domain]]

^be9050

```java
Cookie cookie = new Cookie("time","20080808"); // 新建Cookie
cookie.setDomain(".helloweenvsfei.com");           // 设置域名
cookie.setPath("/");                              // 设置路径
cookie.setMaxAge(Integer.MAX\_VALUE);               // 设置有效期
response.addCookie(cookie);                       // 输出到客户端
```




```java
Cookie[] cookies = req.getCookies();//从请求中获取Cookie
cookie.getName();//获取cookie名
cookie.getVaule();//获取cookie的值


Cookie cookie = new Cookie(String name,String value)//新建一个Cookie
cookie.setMaxAge(int seconds);//设置cookie过期时间
cookie.setMaxAge(0);//立即过期
resp.addCookie(cookie);//响应中增加cookie



```

# Sessin常用操作

# JSP
jsp本质上就是一个servlet, 因为jsp 的基类为 HttpJspBase, 而HttpJspBase 又继承自Servlet
9大内置对象
* PageContext
* Request
* Response
* Session
* Application 【ServletContext】
* config 【SerlverConfig】
* out
* page
* exception

# MVC
Model
 * 业务处理：业务逻辑(Service)
 * 数据持久层：CRUD (DAO)
 
View
* 展示数据
* 提供链接发起Servlet(a,form,img..)

Controller
* 接收用户的请求: (req:请求参数，Session参数)
* 交给业务层处理对应的代码


# 过滤器
## 作用：过滤网站的数据
常用场景
* 处理中文的乱码
* 登陆验证

## 代码实例
```java
import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter{
	//初始化:web服务器启动，就已经初始化。
	public void init(FilterConfig) throws ServletException{}
	
	public void doFilter(ServletRequest request,Servlet Response,FilterChain chain) throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;character=UTF-8");
		
		chain.doFilter(request,response);//让请求继续走，如果没有，程序会被拦截
	}
	
	//Web服务器关闭的时候，会销毁
	public void destory(){}
}
```

## web.xml配置

```xml
<filter>
	<filter-name>CharacterEncodingFilter</filter-name>
	<filter-class>CharacterEncodingFilter</filter-class>
<filter>
<filter-mapping>
	<filter-name>CharacterEncodingFilter</filter-name>
	<url-pattern>/path/*</url-pattern>
</filter-mapping>
```

注意
1. 过滤器中的所有代码，在过滤器特定请求时都要执行
2. 必须要让过滤器继续通行，因为多个过滤器时通过chain.doFilter连接执行


# 监听器
以HttpSessionListener为例
## Java代码
```java
package com.kuang
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessoinListener;
import javax.servlet.ServletContext;

public class OnlineCountListener implements HttpSessionListener{
	public void sessionCreated(HttpSessionEvent se){
	
	}
	public void sessionDestroyed(HttpSessionEvent se){
	
	}
}

```

## Web.xml配置
```xml
<listener>
	<listener-class>com.kuang.OnlineCountListener</listener-class>
</listener>
```


## 文件上传
 - 保证服务器安全，上传文件应该放在外界无法直接访问的目录下，比如WBE-INF下
 - 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件
 	
	- 时间戳
	- uuid
	- md5
	- 位运算 
- 限制文件上传的最大值
- 可以限制上传文件的类型，在收到上传文件名，判断后缀名是否合法

