# 数组的拷贝
1. 如果用=
```java
int[] luckNumbers = smallPrimes;
luckNumbers[5] = 12;// smallprimes[5] is also 12
```
![[屏幕快照 2021-07-10 下午5.10.45.png]]

2. 拷贝应该用Arrays.copyOf

```java
int[] copied = Arrays.copyOf(luckNumbers,luckNumbers.length);
// 如果拷贝的超过原有的长度，
// number类型将会默认赋值为0，
// boolean类型将会默认赋值为false


```