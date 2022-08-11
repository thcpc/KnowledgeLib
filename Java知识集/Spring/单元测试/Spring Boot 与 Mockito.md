

# 如何注入 @Resource, @Autowired 控制的对象
## 问题描述
SpringBoot 中，service 会通过注解 @Resource 自动加载依赖类， 所以在单元测试代码中，直接mock的对象，无法注入到 service 中

## 解决方案
使用 @InjectMocks
该注解 会把 @Mock标注的对象自动注入到被@InjectMocks标注的对象中
[[Java知识集/Spring/单元测试/参考文章#Junit4 https www cnblogs com jpfss p 10973292 html | 参考]]
```java
@Service  
public class CrfItemServiceImpl{    
    @Resource  
    private CrfItemMapper crfItemMapper;
}
```

```java
public class CrfItemServiceImplTest {  
    @Mock  
    private CrfItemMapper crfItemMapper;  
    @InjectMocks  
    CrfItemServiceImpl crfItemService = new CrfItemServiceImpl();
}
```