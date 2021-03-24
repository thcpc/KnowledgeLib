# Cookie
## 一. 概念
Cookie意为"甜饼"，由W3C提出。
## 二. 实现原理
由于HTTP是一种无状态的协议，服务器单从网络连接上无从知道客户身份。怎么办呢？就==给客户端们颁发一个通行证吧，每人一个，无论谁访问都必须携带自己通行证。这样服务器就能从通行证上确认客户身份了。这就是Cookie的工作原理==。

Cookie实际上是一小段的文本信息。客户端请求服务器，如果服务器需要记录该用户状态，就使用response向`客户端浏览器`颁发一个Cookie。`客户端浏览器`会把Cookie保存起来。当`浏览器`再请求该网站时，`客户端浏览器`把请求的网址连同该Cookie一同提交给服务器。服务器检查该Cookie，以此来辨认用户状态。服务器还可以根据需要修改Cookie的内容。

## 三. 查看方式
### 1. 浏览器地址栏输入
`JavaScript:alert (document. cookie)`
![[cookie1.png]]

![[cookie2.png]]


### 2.chrome 浏览器中的Application
![[cookie3.png]]

## 四. Cookie的常用属性
| 属性名 | 类型 | 描述 |
| ---   | --|--- |
| name | String |该Cookie的名称。Cookie一旦创建，名称便不可更改     |
|Value |  Object |该Cookie的值。如果值为Unicode字符，需要为字符编码。如果值为二进制数据，则需要使用BASE64编码 |
|maxAge | int  |该Cookie失效的时间，单位秒。如果为正数，则该Cookie在maxAge秒之后失效。如果为负数，该Cookie为临时Cookie，关闭浏览器即失效，浏览器也不会以任何形式保存该Cookie。如果为0，表示删除该Cookie。默认为–1|
 | secure | boolean |该Cookie是否仅被使用安全协议传输。安全协议。安全协议有HTTPS，SSL等，在网络上传输数据之前先将数据加密。默认为false|
 |path | String |该Cookie的使用路径。如果设置为“/sessionWeb/”，则只有contextPath为“/sessionWeb”的程序可以访问该Cookie。如果设置为“/”，则本域名下contextPath都可以访问该Cookie。注意最后一个字符必须为“/”|
 |[[#1 Cookie的域名 domain]] | String | 可以访问该Cookie的域名。如果设置为“.google.com”，则所有以“google.com”结尾的域名都可以访问该Cookie。注意第一个字符必须为“.”|
 |comment | String | 该Cookie的用处说明。浏览器显示Cookie信息的时候显示该说明|
 |version | int | 该Cookie使用的版本号。0表示遵循Netscape的Cookie规范，1表示遵循W3C的RFC 2109规范|


### domain
#### ==Cookie具有不可跨域名性==
Cookie是不可跨域名的。域名 `www.google.com`颁发的Cookie不会被提交到域名`www.baidu.com`去。这是由Cookie的隐私安全机制决定的。隐私安全机制能够禁止网站非法获取其他网站的Cookie。
很多网站都会使用Cookie。例如，Google会向客户端颁发Cookie，Baidu也会向客户端颁发Cookie。那浏览器访问Google会不会也携带上Baidu颁发的Cookie呢？或者Google能不能修改Baidu颁发的Cookie呢？

答案是否定的。**Cookie具有不可跨域名性**。根据Cookie规范，浏览器访问Google只会携带Google的Cookie，而不会携带Baidu的Cookie。Google也只能操作Google的Cookie，而不能操作Baidu的Cookie。

Cookie在客户端是由浏览器来管理的。浏览器能够保证Google只会操作Google的Cookie而不会操作Baidu的Cookie，从而保证用户的隐私安全。浏览器判断一个网站是否能操作另一个网站Cookie的依据是域名。Google与Baidu的域名不一样，因此Google不能操作Baidu的Cookie。

需要注意的是，虽然网站`images.google.com`与网站`www.google.com`同属于Google，但是域名不一样，二者同样不能互相操作彼此的Cookie。
  

注意：用户登录网站`www.google.com`之后会发现访问`images.google.com`时登录信息仍然有效，而普通的Cookie是做不到的。这是因为Google做了特殊处理。本章后面也会对Cookie做类似的处理。

#### 解决办法
同一个一级域名下的两个二级域名如`www.helloweenvsfei.com`和`images.helloweenvsfei.com`也不能交互使用Cookie，因为二者的域名并不严格相同。如果想所有helloweenvsfei.com名下的二级域名都可以使用该Cookie，需要设置Cookie的domain参数.
[[JavaWeb编程#会话跟踪 1 Cookie的域名 domain 设置Domain | Java Servlet 实现]]
