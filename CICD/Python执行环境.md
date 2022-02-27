# 手动创建
1.  拉去Python Image
``` shell
docker pull python:3.9
```
2. 启动镜像
``` shell
docker run -d -it --name {container} python:3.9
# -it 是因为docker 启动 container 时需要一个前台进程，如果没有的话，则会自动结束
```
3. 拷贝需要的文件到启动的容器
```shell
docker cp requirement.txt {container}:/opt
docker cp /opt/openlogic-openjdk-8u262-b10-linux-x64.tar.gz {container_name}:/opt
docker cp allure-2.17.3.zip {container}:/opt

# 这一步可以通过2步启动镜像的时候，共享一个文件夹
```
4. 进入 container
```shell
docker exec -it {container} /bin/bash
```
5. 配置python
``` shell
cd opt
pip install --upgrade pip
pip install -r requirements.txt
```
6 . 配置ssh-server

```shell
docker exec -it {container} /bin/bash
apt update
apt install openssh-server
useradd -m jenkins #创建jenkins 用户
passwd jenkins # 设置密码:123456
service ssh start
ps -e | grep ssh # 查看ssh服务是否启动
"xxx? 00:00:00 sshd"#启动成功
```
参考：[安装ssh](https://benpaodewoniu.github.io/2019/12/08/docker11/)[配置ssh](https://blog.csdn.net/niufw_qb/article/details/108120689)[ssh key](https://www.cnblogs.com/LoveShare/p/14312840.html)https://www.jianshu.com/p/bc8ccd9d63ba
7. 配置Java
```shell
cd opt
tar zxvf openlogic-openjdk-8u262-b10-linux-x64.tar.gz -C /usr/local/
cd 用户\
touch .bash_profile
cat >>.bash_profile<<EOF
"
export JAVA_HOME=/usr/local/openlogic-openjdk-8u262-b10-linux-64
HN/jre/bin:$PATH

export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
"
source .bash_profile

```
8. 生成新的镜像
``` shell
docker commit {container} {new_image_name}
```
9. 启动容器
```shell
docker run -d -it -p{port}:22 -v /var/jenkins/{jobName}:/home/jenkins/ -v /etc/localtime:/etc/localtime  -e JAVA_OPTS=-Duser.timezone=Asia/Shanghai --name {container} {new_image_name}
```

# Dockerfile 自动创建

```shell
FROM python:3.9 as build
COPY requirements.txt /opt
RUN cd opt
RUN pip install --upgrade pip && \
	pip install -r requirements.txt
	
RUN mkdir -p /var/run/sshd

RUN apt update && \
	apt install -y openjdk-8-jdk && \
	apt install -y openssh-server

RUN useradd -m jenkins -s /bin/bash jenkins && \
	echo jenkins:123456 | chpasswd

RUN weget -P /opt https://github.91chi.fun//https://github.com//allure-framework/allure2/releases/download/2.17.3/allure-2.17.3.zip && \
	unzip /opt/allure-2.17.3.zip && \
	ln -s /allure-2.17.3/bin/allure /usr/bin/allure
```

docker build -t testing:python