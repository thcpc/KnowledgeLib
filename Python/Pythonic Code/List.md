1. 访问List的索引同时访问List元素
```python
cities = ["CD","SH","GZ"]
for i ,city in enumerate(cities):
	print(i,city)
```

2. 同时访问两个List的元素
```python
china = ["CD","SH","GZ"]
usa = ["WS","LS","LAS"]
for china_city ,usa_city in zip(china,usa)
```

3. 两个List比较大小
```python
# 成功条件
# 1. list1 的所有元素都比都要比 list2 大
# 2. 如果长度不一致，list1的长度要比list2大，且每个元素都要比list2 都大
list1 = [3,5,2,0]
list2 = [2,5,2]
msg = 'update avaliable' if list1>list2 else "Up to date"
```

4. 取指定的值
```python
cities = ["CD","GZ","SH","BJ"]
#第一个 和 最后一个
first,*rest,last = cities
#最后一个
*rest,last = cities
#第一个
first,*rest,last = cities
#取1，2，4
first,second,*rest,last = cities
```