1. 首先获取[[完美的获取ClassLoader | ClassLoader]]
2. 使用getResource(),获取URL
3. 使用getPath()获取到地址
4. 创建 File 对象
```java
## 这里获取ClassLoader只是示例
String path = this.getClass().getClassLoader().getResource("resource中的相对路径")).getPath();
File file = new File(path);

```