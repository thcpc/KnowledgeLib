# 现象
![[屏幕快照 2021-11-06 下午5.49.44.png]]

# 原因
我在自定义的Iterator中的next方法返回值错误
![[屏幕快照 2021-11-06 下午5.51.32.png]]

# 解决办法
[参考](https://stackoverflow.com/questions/45998857/data-provider-mismatch-in-selenium-with-testng)解决该问题主要是看懂TestNG的报错信息
直接返回covert结果，就是一个Object数组

![[屏幕快照 2021-11-06 下午5.55.02.png]]