# 简单的Mapper.xml
```xml
<?xml version\="1.0" encoding\="UTF-8" ?>  
<!DOCTYPE mapper  
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd"\>  
<mapper namespace="com.kuang.dao.UserDao"> <!-- 对应映射的PoJO对象 -->
 	<select id="getListUser" resultType="com.kuang.pojo.User">  
 		select * from mybatis.user  
    </select>  
</mapper>
```
namespace: 对应映射的PoJO对象
resultType: 定义返回的对象