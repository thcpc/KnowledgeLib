1. 参数是字典的时候

```python
data = {'day':'Monday','office':'Home'}
print("One {day} I was working in {office}".format(**data))
```

2. 普通参数
```python
name = "cpc"
age = 10
print(f"Hi,i am {name} and i {age + 1} old")
```