1. 字典取值的时候设置一个默认值
```python
ages = dict(Mary=31,John=28)
# The Bad Way
if "Dick" in ages:
	age = ages["Dick"]
else:
	age = 'Unknown'

# The Good Way
age = ages.get("Dick","Unknown")
age = ages.get("Dick") or "Unknown"
```

2. 列表组合成字典
```python
cities = ["sh","cd","bj"]
populaitions = [1723,2333,4563]
# 不需要处理函数
dictory = dict(zip(cities,populaitions))
# 如果需要处理数据,例如小写转大写
dictory = { string.upper(city): populaition for city, populaition in zip(cities,populaitions)}

```

3. 创建一个有默认值的字典
```python
# 默认值为0
dictory = collections.defaultdict(lambda: 0)
```