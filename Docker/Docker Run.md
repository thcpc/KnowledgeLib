命令形式: docker run [OPTIONS] IMAGE [COMMAND] [ARG..]
选项说明
- -d, 后台运行容齐
- -e, 设置容器内环境变量
- --expose / -p , 宿主端口:容器端口
- --name, 指定容器的名称
- --link, 链接不同的容器
- -v 宿主目录：容器目录，挂载磁盘卷

例子
```
# 容器命名为mongo , 映射本机的端口27017到容器中的端口27017 , 映射本机的硬盘到容器中的/data/db , 设置用户名admin,设置密码admin,后台运行mongo
docker run --name mongo -p 27017:27017 -v ~/docker-data/mongo:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo
```