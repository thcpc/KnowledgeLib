故障
python升级后引发的执行yum的语法错误
原因：yum默认使用的是python2.7的语法，如果修改了环境变量指向python3后，语法不支持。所以可通过修改执行的bin文件解决
解决：修改两个文件
```bash
vi /usr/bin/yum
vi /usr/libexec/urlgrabber-ext-down
```
将"#!/usr/bin/python" 改为 "#!/usr/bin/python2" 