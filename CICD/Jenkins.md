1. 下载 Jenkins docker
```shell
docker pull jenkins/jenkins
```

2. host 上建立 jenkins 文件夹,并授权
```shell
mkdir /var/jenkins
chmod 777 /var/jenkins
```

3. 启动docker run并把文件映射到 host 

```shell
docker run -d -p 10240:8080 -p 10241:50000 -v /var/jenkins:/var/jenkins_home -v /etc/localtime:/etc/localtime  -e JAVA_OPTS=-Duser.timezone=Asia/Shanghai --name jenkins jenkins/jenkins
```
- d：后台运行容器  
- p：指定容器的端口映射 -p 10240:8080 表示将容器的8080端口映射到宿主机的10240端口上 ，映射多个端口使用 -p 8082:8080  -p 8083:8081
- v：挂载宿主机目录和 docker容器中的目录 /var/jenkins 本地宿主机绝对目录;/var/jenkins_home    容器目录（将容器目录挂载到本地）
 - v：/etc/localtime:/etc/localtime 本地时间和容器时间同步
 - e JAVA_OPTS=-Duser.timezone=Asia/Shanghai     设置容器时间为上海时间（不然容器时间和本地时间相差8小时）
 - name jenkins  设置容器的名称
 - jenkins/jenkins  选择镜像名称启动容器

4. 配置SSH
5. 配置Allure