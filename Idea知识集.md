# 1. 配置Maven
![[maven set1.png]]

![[maven set2.png]]


# 2. 配置Tomcat

## 1. ideal中添加tomcat服务器配置


![[tomcat set1.png]]

![[tomcat set2.png]]

![[tomcat set3.png]]

![[tomcat set4.png]]

## 2.访问路径的配置

如果在Application context 中设置了路径如下图

![[tomcat set5.png]]

并且web.xml中配置

```
  <servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
  </servlet-mapping>
```

则最终访问路径

![[tomcat set6.png]]

