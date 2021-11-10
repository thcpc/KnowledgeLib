配置有两种方式
1. [[#1 全注解|全注解]]
2. [[#2 XML配置方式|XML配置方式]]
3. 混用

# 1. 全注解
## 适用场景
单数据源，查询简单
## 配置
### application.properties
```sql
# 配置数据库连接地址
spring.datasource.url=jdbc:mysql://100.10.102.25:3306/yan?
# 配置用户名密码
spring.datasource.username=root  
spring.datasource.password=123456
# 配置适用的数据库连接池
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
```

### 添加@MapperScan
mapperScan的传入的值为你的mapper 的package名
![[屏幕快照 2021-11-11 上午12.14.03.png]]

### 增加@Mapper注解
![[屏幕快照 2021-11-11 上午12.16.50.png]]

# 2. XML配置方式
## 适用场景
数据源可变, SQL 复杂

### application.properties
```sql
# 指定mapper文件路径
mybatis.mapper-locations=classpath:mybaits/*.xml  
# 指定config文件路径
mybatis.config-location=classpath:mybatis-config.xml
```

### 编写mybatis-config.xml
### 添加@MapperScan
![[屏幕快照 2021-11-11 上午12.25.16.png]]
### 增加@Mapper注解
![[屏幕快照 2021-11-11 上午12.24.42.png]]
### 编写映射的xml文件
名字要于对应的mapper文件相同
![[屏幕快照 2021-11-11 上午12.26.54.png]]

# 3.混用
2种方式的区别:
实际上是在于是把数据库和mybaits的配置是写在application.properties 还是在mybatis-config.xml中

# FAQ
1. mybatis-config.xml 文件无法找到
![[屏幕快照 2021-11-11 上午12.33.40.png]]
主要原因是mybaits-config.xml文件只能存放在resoruces的根目录下(可能有其它办法，但是我没有找到)
修改到根目录下即可
![[屏幕快照 2021-11-11 上午12.37.08.png]]

2. mybaits的configuration不能混用
application.properties 和 mybaits-config.xml中不能同时存在
在mybaits-config中
![[屏幕快照 2021-11-11 上午12.41.45.png]]
在application.properties中
![[屏幕快照 2021-11-11 上午12.42.23.png]]
都设置了configuration，则提示如下错误
![[屏幕快照 2021-11-11 上午12.43.21.png]]
修正，把application.properties中的configuration注释即可