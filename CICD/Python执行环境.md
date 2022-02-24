1.  利用Dockerfile 下载 python
``` shell
FROM python:3.9.0
RUN pip install cjen && pip install pytest && pip install allure-pytest
# 配置Allure
# 打开SSHD
```

2. 启动docker
```shell
docker run -d -it --name cjen cjen:1.0.0
```