指明打包方式
# 三种配置
- ``<packaging>pom</packaging>``
-  ``<packaging>jar</packaging>``
-  ``<packaging>war</packaging>``

# 1.pom
在父级项目中的pom.xml文件使用的packaging 配置一定位pom, 因为父级的pom文件只作项目的子模块的整合，在maven install时不会生成 jar/war 包
# 2.jar
打包位 jar 包，在target文件夹中
# 3.war
打成war包，并会把依赖都放在WEB-INF/lib中

[参考](https://blog.csdn.net/imaginehero/article/details/103706732)