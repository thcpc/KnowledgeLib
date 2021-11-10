# 现象
无法读取Jar 包内的资源文件

# 原因
1. 资源资源文件是在src文件中，不是在Resource文件中，例如mybatis中的mapper.xml文件，如何保证Maven编译时会把资源文件打进target文件中
2. 代码中需从[[完美的获取ClassLoader | ClassLoader]]获取Resource
3. 路径必须写成"/"的形式，如果是"//"虽然在IDE中可以获取，但是打包后仍无法获取

# 解决

1. pom增添配置

```xml
<build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```
