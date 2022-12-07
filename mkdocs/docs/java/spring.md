spring.md

## FAQ
### 1.使用@SpringBootApplication注解，但是不使用数据库无法，程序无法启动
需要排除DataSoruce，因为@SpringBootApplication包含@EnableAutoConfiguration，它会自动加载"DataSourceAutoConfiguration"
```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
```