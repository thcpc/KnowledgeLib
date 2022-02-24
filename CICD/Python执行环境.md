1.  利用Dockerfile 下载 python
``` shell
FROM python:3.9.0
RUN pip install cjen && pip install pytest && pip install allure-pytest

# 安装Java,SSHD
RUN apt update && apt install openjdk-11-jdk && apt install openjdk-11-jdk
COPY allure-2.17.3.zip /opt
# 配置Allure
RUN unzip /opt/allure-2.17.3.zip && ln -s /allure-2.17.3/bin/allure /usr/bin/allure
```
2. [安装ssh](https://benpaodewoniu.github.io/2019/12/08/docker11/)
    [配置ssh](https://blog.csdn.net/niufw_qb/article/details/108120689)
   [ssh key](https://www.cnblogs.com/LoveShare/p/14312840.html)
   https://www.jianshu.com/p/bc8ccd9d63ba
4. 安装Java
```shell
apt install openjdk-11-jdk
```
5. 启动docker
```shell
docker run -d -it --name cjen cjen:1.0.0
```