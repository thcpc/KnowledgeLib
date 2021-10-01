# CentOS 源码编译
1. 下载安装包
```bash
wget https://nodejs.org/dist/v6.11.4/node-v6.11.4.tar.gz
tar -zxvf node-v6.11.4.tar.gz
```
2. 安装GCC
```bash
yum -y install gcc+ gcc-c++
./configure --prefix=/usr/local/node
make
make install
```
3. 配置变量
```bash
vim /etc/profile
添加：
#set for nodejs
export NODE_HOME=/usr/local/node
export PATH=$NODE_HOME/bin:$PATH
保存退出以后
source /etc/profile
```
4. 安装npm
```bash
node -v
// 更新
npm install –g n
n latest // 或者 npm stable 或者 npm 版本号
npm -v
// 升级
npm install npm -g 
```

5. 设置npm镜像

一、**临时使用**

**npm --registry https://registry.npm.taobao.org install express**

**二、永久使用**

**npm config set registry https://registry.npm.taobao.org**

**通过**

**npm config get registry 查看是否配置成功**

**`npm config list #查看npm当前配置`**

或者

编辑 ~/.npmrc 加入下面内容

registry= `https://registry.npm.taobao.org`

**三、通过cnpm使用**

npm install -g cnpm --registry=https://registry.npm.taobao.org

四、设置回官网

npm config set registry [https://registry.npmjs.org](https://registry.npmjs.org/)

五、强制清理npm的缓存

npm cache clear \--force