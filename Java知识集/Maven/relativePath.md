设定一个空值默认值为../pom.xml 表示将始终从父级仓库中获取，不从本地路径获取

```xml
<parent>  
 <artifactId>thinking-in-spring</artifactId>  
 <groupId>org.geekbang</groupId>  
 <version>1.0-SNAPSHOT</version>  
 <relativePath>../pom.xml</relativePath>  
</parent>
```

MAVEN构建jar包时候查找顺序：relativePath元素中的地址–本地仓库–远程仓库