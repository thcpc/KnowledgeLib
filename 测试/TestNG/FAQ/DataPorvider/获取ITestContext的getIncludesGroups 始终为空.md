# 现象
![[屏幕快照 2021-11-06 下午5.31.56.png]]

# 原因
ITestContext 只能获取xml中的参数, 无法获取注解上的groups参数

# 解决办法
[参考](https://stackoverflow.com/questions/31130753/testng-itestcontext-getincludedgroups-returns-null)
使用ITestNGMethod 参数
![[屏幕快照 2021-11-06 下午5.43.45.png]]

