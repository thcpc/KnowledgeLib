1.  利用Dockerfile 下载 python
``` shell
FROM python:3.9 as build

COPY allure-2.17.3.zip /opt

COPY openlogic-openjdk-8u262-b10-linux-x64.tar.gz /usr/local

RUN unzip /opt/allure-2.17.3.zip && ln -s /allure-2.17.3/bin/allure /usr/bin/allure && tar -zxvf /usr/local/openlogic-openjdk-8u262-b10-linux-x64.tar.gz
```
2. [安装ssh](https://benpaodewoniu.github.io/2019/12/08/docker11/)
    [配置ssh](https://blog.csdn.net/niufw_qb/article/details/108120689)
   [ssh key](https://www.cnblogs.com/LoveShare/p/14312840.html)
   https://www.jianshu.com/p/bc8ccd9d63ba
4. 配置Java
```shell
cd 用户
touch .bash_profile
cat >>.bash_profile<<EOF
"
export JAVA_HOME=/usr/local/openlogic-openjdk-8u262-b10-linux-64

export PATH=$PATH:$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH

export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
"
source .bash_profile

```
5. 启动docker
```shell
docker run -d -it --name cjen cjen:1.0.0
```